package com.example.galdino.appbemestaresaude.BaseAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.galdino.appbemestaresaude.R;
import com.example.galdino.appbemestaresaude.R.id;
import com.example.galdino.appbemestaresaude.Dominio.Endereco;

import java.util.ArrayList;

/**
 * Created by Galdino on 15/10/2016.
 */
public class BaseAdapterListaEndereco  extends BaseAdapter {
    private static ArrayList<Endereco> EnderecoArrayList;
    private LayoutInflater l_Inflater;
    private Context context;

    // Construtor 2
    public BaseAdapterListaEndereco()
    {

    }
    // Construtor 1
    public BaseAdapterListaEndereco(Context context, ArrayList<Endereco> results)
    {
        EnderecoArrayList = results;

        l_Inflater = LayoutInflater.from(context);
        this.context = context;

    }

    // Conta quantos registros tem no array
    public int getCount()
    {
        return EnderecoArrayList.size();
    }

    // Encontra a pocição no array
    public Object getItem(int position)
    {
        return EnderecoArrayList.get(position);
    }

    // Devolve a posição
    public long getItemId(int position)
    {
        return position;
    }

    // Cria os elementos para receber o conteudo da tela
    static class ViewHolder {
        TextView txtEndereco;
        TextView txtCliente;
    }

    // Vai converter um view para aparecer dentro de outro
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder;
        if(convertView == null) // A lista ainda não foi criada
        {
            // cria o inflater que servira para converter para um xml ficar dentro do outro
            convertView = l_Inflater.inflate(R.layout.xml_lista_endereco, null);
            holder = new ViewHolder();

            holder.txtEndereco = (TextView) convertView.findViewById(id.txtEndereco);
            holder.txtCliente = (TextView)convertView.findViewById(id.txtCliente);
            convertView.setTag(holder); // devolve os conteudos
        }
        else // se já foi criada
        {
            holder = (ViewHolder) convertView.getTag(); // Pega o conteudo que já foi enviado
        }
        holder.txtEndereco.setText(EnderecoArrayList.get(position).getRua());
        holder.txtCliente.setText(EnderecoArrayList.get(position).getCliente().getNome());

        return convertView;
    }

}