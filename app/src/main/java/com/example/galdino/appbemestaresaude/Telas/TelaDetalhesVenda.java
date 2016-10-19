package com.example.galdino.appbemestaresaude.Telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.galdino.appbemestaresaude.R;

public class TelaDetalhesVenda extends AppCompatActivity implements View.OnClickListener {
    private ImageButton iBtnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_detalhes_venda);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        //
        associarObjetos();
        carregarControles();

    }

    private void associarObjetos()
    {

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
