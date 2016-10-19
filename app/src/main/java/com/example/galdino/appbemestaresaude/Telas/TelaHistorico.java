package com.example.galdino.appbemestaresaude.Telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.galdino.appbemestaresaude.BaseAdapter.BaseAdapterListaItensPedidoVenda;
import com.example.galdino.appbemestaresaude.Dominio.PedidoVenda;
import com.example.galdino.appbemestaresaude.Dominio.Produto;
import com.example.galdino.appbemestaresaude.R;

import java.util.ArrayList;

public class TelaHistorico extends AppCompatActivity implements View.OnClickListener {
    private ImageButton iBtnVoltar;
    private ListView lvItens;
    private Button btnPesquisar;
    private Spinner spProduto,
                    spServico;
    //
    private static String tela;
    private static boolean fgTelaLista;
    private BaseAdapterListaItensPedidoVenda baListaItensPedidoVenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_historico);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        tela= "";
        fgTelaLista = false;
        //
        associarObjetos();
        carregarControles();
        //carregarEnderecos();
    }

    private void associarObjetos()
    {

        btnPesquisar = (Button)findViewById(R.id.btnPesquisar );
        spProduto = (Spinner)findViewById(R.id.spProduto );
        spServico = (Spinner)findViewById(R.id.spServico );
        lvItens = (ListView)findViewById(R.id.lvItens);
        iBtnVoltar = (ImageButton)findViewById(R.id.iBtnVoltar);

        iBtnVoltar.setOnClickListener(this);
        btnPesquisar.setOnClickListener(this);
    }

    private void carregarControles() {
        Intent intent = getIntent();
        tela = intent.getStringExtra("tela");
        String telaLista = intent.getStringExtra("lista");

        if (telaLista != null)
            if (telaLista.equals("1"))
                fgTelaLista = true;
        else
            tela = "";
    }

    @Override
    public void onClick(View v) {
        if (v == iBtnVoltar)
            onBackPressed();
        if (v == btnPesquisar) {
            carregarItensPedidoVenda();
        }
    }

    private void carregarItensPedidoVenda()
    {
        ArrayList<PedidoVenda> alPedidoVenda = GetSearchResults();
        baListaItensPedidoVenda = new BaseAdapterListaItensPedidoVenda(this, alPedidoVenda);

        lvItens .setAdapter(baListaItensPedidoVenda );
        lvItens .setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                String ponto = "",
                        dtInclusao = "",
                        vlrTotal = "",
                        idProduto = "",
                        descricaoProduto = "";

                Object o = lvItens.getItemAtPosition(position);

                PedidoVenda obj_itemDetails = (PedidoVenda) o;
                ponto = obj_itemDetails.getNrPonto().toString();
                dtInclusao = obj_itemDetails.getsDtInclusao();
                vlrTotal = obj_itemDetails.getVlr_total().toString();
                idProduto = obj_itemDetails.getProduto().getID();
                descricaoProduto = obj_itemDetails.getProduto().getDescricao();

                Intent intent = new Intent();

                // Para chamar a próxima tela tem que dizer qual e a tela atual, e depois a próxima tela( a que vai ser chamada)
                intent.putExtra("ponto", ponto);
                intent.putExtra("dtInclusao", dtInclusao);
                intent.putExtra("vlrTotal", vlrTotal);
                intent.putExtra("idProduto", idProduto);
                intent.putExtra("descricaoProduto", descricaoProduto);
                chamarProximaTela(TelaDetalhesVenda.class, intent,false);
            }
        });

    }

    private ArrayList<PedidoVenda> GetSearchResults()
    {
        int i, qtdRegistro;
        ArrayList<PedidoVenda> results = new ArrayList<PedidoVenda>();
        qtdRegistro = 6;
        // Aux
        String[] nrPonto={"10","9", "12", "3", "0","0"};
        String[] dtInclusao={"10/10/2016","05/04/2016", "22/03/2016", "03/01/2016", "07/07/2016","08/08/2016"};
        String[] vlrTotal={"30","45", "10.5", "6", "5.5","4"};
        String[] indice={"11","21", "14", "4", "50","21"};
        String[] descricao={"Aspirina","Oftalmologista", "Acebrofilina", "Aciclovir", "Dor Flex","Acebrofilina"};
        for(i = 0; i < qtdRegistro; i++)
        {
            PedidoVenda pv = new PedidoVenda();
            pv.setProduto(new Produto());
            pv.setNrPonto(Double.parseDouble(nrPonto[i]));
            pv.setsDtInclusao(dtInclusao[i]);
            pv.setVlr_total(Double.parseDouble (vlrTotal[i]));
            pv.getProduto().setID(indice[i]);
            pv.getProduto().setDescricao(descricao[i]);
            results.add(pv);
        }// for
        return results;
    }


    private void chamarProximaTela(Class proximaTela, Intent intent, boolean fgNovaTela)
    {
        if(intent == null)
            intent = new Intent();
        intent.setClass(this, proximaTela);
        startActivity(intent);
        if(fgNovaTela)
            finish();
    }

    public void onBackPressed()
    {
        Intent intent = new Intent();
        intent.putExtra("tela",tela);
        String sfgTelaLista = "0";
        if(fgTelaLista)
            sfgTelaLista = "1";
        intent.putExtra("fgTelaLista",sfgTelaLista);
        chamarProximaTela(TelaCliente.class, intent, true);
    }
}
