package com.example.galdino.appbemestaresaude.BaseAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.galdino.appbemestaresaude.R;
import com.example.galdino.appbemestaresaude.Dominio.PedidoVenda;

import java.util.ArrayList;

/**
 * Created by Galdino on 17/10/2016.
 */
public class BaseAdapterListaItensPedidoVenda extends BaseAdapter {
    private static ArrayList<PedidoVenda> ItensArrayList;
    private LayoutInflater l_Inflater;
    private Context context;

    // Construtor 2
    public BaseAdapterListaItensPedidoVenda()
    {

    }
    // Construtor 1
    public BaseAdapterListaItensPedidoVenda(Context context, ArrayList<PedidoVenda> results)
    {
        ItensArrayList = results;

        l_Inflater = LayoutInflater.from(context);
        this.context = context;

    }

    // Conta quantos registros tem no array
    public int getCount()
    {
        return ItensArrayList.size();
    }

    // Encontra a pocição no array
    public Object getItem(int position)
    {
        return ItensArrayList.get(position);
    }

    // Devolve a posição
    public long getItemId(int position)
    {
        return position;
    }

    // Cria os elementos para receber o conteudo da tela
    static class ViewHolder {
        TextView txtID
                ,txtDescricao
                ,txtData
                ,txtValor
                ,txtPontuacao;
    }

    // Vai converter um view para aparecer dentro de outro
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder;
        if(convertView == null) // A lista ainda não foi criada
        {
            // cria o inflater que servira para converter para um xml ficar dentro do outro
            convertView = l_Inflater.inflate(R.layout.xml_lista_itens_pedido_venda, null);
            holder = new ViewHolder();

            holder.txtID = (TextView) convertView.findViewById(R.id.txtID);
            holder.txtDescricao = (TextView) convertView.findViewById(R.id.txtDescricao);
            holder.txtData = (TextView) convertView.findViewById(R.id.txtData);
            holder.txtValor = (TextView) convertView.findViewById(R.id.txtValor);
            holder.txtPontuacao = (TextView) convertView.findViewById(R.id.txtPontuacao );

            convertView.setTag(holder); // devolve os conteudos
        }
        else // se já foi criada
        {
            holder = (ViewHolder) convertView.getTag(); // Pega o conteudo que já foi enviado
        }
        holder.txtID.setText(ItensArrayList.get(position).getProduto().getID());
        holder.txtDescricao.setText(ItensArrayList.get(position).getProduto().getDescricao());
        holder.txtData.setText(ItensArrayList.get(position).getsDtInclusao());
        holder.txtValor.setText(String.valueOf(ItensArrayList.get(position).getVlr_total()));
        holder.txtPontuacao.setText(String.valueOf(ItensArrayList.get(position).getNrPonto()));

        return convertView;
    }

}
