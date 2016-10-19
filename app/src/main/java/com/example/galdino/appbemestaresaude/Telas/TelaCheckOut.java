package com.example.galdino.appbemestaresaude.Telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.galdino.appbemestaresaude.R;

import java.util.ArrayList;
import java.util.List;

public class TelaCheckOut extends AppCompatActivity implements View.OnClickListener {
    private ImageButton iBtnVoltar;
    private Button btnCheckOut;
    private Spinner spCheckOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_check_out);
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
        spCheckOut = (Spinner)findViewById(R.id.spCheckOut);
        btnCheckOut = (Button)findViewById(R.id.btnCheckOut);

        iBtnVoltar.setOnClickListener(this);
        btnCheckOut.setOnClickListener(this);
    }

    private void carregarControles() {
        String[] vetStatusCheckOut = {"- Selecione -","Sem sucesso","Ausente","Cadastro sem venda","Cadastro com venda"};
        ArrayAdapter<String> aaTempoAcademia = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, vetStatusCheckOut );
        spCheckOut.setAdapter(aaTempoAcademia);
    }

    @Override
    public void onClick(View v) {
        if (v == iBtnVoltar)
            onBackPressed();
        else if(v == btnCheckOut)
            chamarProximaTela(TelaInicial.class,null);
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
        chamarProximaTela(TelaInicialCheckIn.class, null);
    }
}
