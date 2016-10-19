package com.example.galdino.appbemestaresaude.Telas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.galdino.appbemestaresaude.R;

import java.util.ArrayList;
import java.util.List;

public class TelaPontos extends AppCompatActivity implements View.OnClickListener {
    private ImageButton iBtnVoltar;
    private ListView lvPontos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pontos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        //
        associarObjetos();
        carregarControles();

    }

    private void associarObjetos()
    {
        lvPontos = (ListView)findViewById(R.id.lvPontos);
        iBtnVoltar = (ImageButton)findViewById(R.id.iBtnVoltar);

        iBtnVoltar.setOnClickListener(this);
    }

    private void carregarControles() {
//        Intent intent = getIntent();
//        intent.putExtra("ponto", ponto);
//        intent.putExtra("dtInclusao", dtInclusao);
//        intent.putExtra("vlrTotal", vlrTotal);
//        intent.putExtra("idProduto", idProduto);
//        intent.putExtra("descricaoProduto", descricaoProduto);
        List<String> nrPonto = new ArrayList<String>();
        nrPonto.add("500 20/05/2016");
        nrPonto.add("725 10/10/2016");

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                nrPonto );

        lvPontos.setAdapter(arrayAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v == iBtnVoltar)
            onBackPressed();
    }

    public void onBackPressed()
    {
        finish();
    }
}
