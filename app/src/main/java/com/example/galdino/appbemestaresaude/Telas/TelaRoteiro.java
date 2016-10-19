package com.example.galdino.appbemestaresaude.Telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.galdino.appbemestaresaude.R;
import com.example.galdino.appbemestaresaude.BaseAdapter.BaseAdapterListaEndereco;
import com.example.galdino.appbemestaresaude.Dominio.Cliente;
import com.example.galdino.appbemestaresaude.Dominio.Endereco;

import java.util.ArrayList;

public class TelaRoteiro extends AppCompatActivity implements View.OnClickListener
{
    private ImageButton iBtnVoltar;
    private ListView lvEnderecos;
    //
    private BaseAdapterListaEndereco baListaEnderecos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_roteiro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        //
        associarObjetos();
        carregarEnderecos();
    }

    private void associarObjetos()
    {
        lvEnderecos = (ListView)findViewById(R.id.lvEnderecos);
        iBtnVoltar = (ImageButton)findViewById(R.id.iBtnVoltar);

        iBtnVoltar.setOnClickListener(this);
    }

    private void carregarEnderecos()
    {
        ArrayList<Endereco> alEndereco = GetSearchResults();
        baListaEnderecos = new BaseAdapterListaEndereco(this, alEndereco);

        lvEnderecos.setAdapter(baListaEnderecos);
        lvEnderecos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                String rua = "",
                        cliente = "";

                Object o = lvEnderecos.getItemAtPosition(position);

                Endereco obj_itemDetails = (Endereco) o;
                rua = obj_itemDetails.getRua();
                cliente = obj_itemDetails.getCliente().getNome();
                Intent intent = new Intent();

                // Para chamar a próxima tela tem que dizer qual e a tela atual, e depois a próxima tela( a que vai ser chamada)
                intent.putExtra("nmRua", rua);
                intent.putExtra("nmCliente", cliente);
                chamarProximaTela(TelaCheckIn.class,intent);
            }
        });

    }

    private ArrayList<Endereco> GetSearchResults()
    {
        int i, qtdRegistro;
        ArrayList<Endereco> results = new ArrayList<Endereco>();
        qtdRegistro = 5;
        // Aux
        String[] clientes={"Mario Silva","Bruna Rodrigues", "João Bitencur", "José de Oliveira", "Maria das Dores"};
        for(i = 0; i < qtdRegistro; i++)
        {
            Endereco e = new Endereco();
            e.setCliente(new Cliente());
            e.setRua("End: Rua " + i+1 + " N° 1 Centro");
            e.getCliente().setNome("Cliente: " + clientes[i]);
            results.add(e);
        }// for
        return results;
    }

    @Override
    public void onClick(View v)
    {
        if(v == iBtnVoltar)
            onBackPressed();
    }

    private void chamarProximaTela(Class proximaTela, Intent intent)
    {
        if(intent == null)
            intent = new Intent();
        intent.setClass(this, proximaTela);
        startActivity(intent);
        finish();
    }

    public void onBackPressed()
    {
        chamarProximaTela(TelaInicial.class, null);
    }
}
