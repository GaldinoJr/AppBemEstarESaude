package com.example.galdino.appbemestaresaude.Telas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.galdino.appbemestaresaude.R;

public class TelaInicial extends AppCompatActivity implements View.OnClickListener
{
    private ImageButton iBtnVoltar;
    private Button btnRoteiro,
                    btnCliente;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        associarObjetos();
    }

    private void associarObjetos()
    {
        iBtnVoltar = (ImageButton)findViewById(R.id.iBtnVoltar);
        btnCliente = (Button)findViewById(R.id.btnCliente);
        btnRoteiro = (Button)findViewById(R.id.btnRoteiro);
        iBtnVoltar.setOnClickListener(this);
        btnRoteiro.setOnClickListener(this);
        btnCliente.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v == iBtnVoltar)
            onBackPressed();
        else if (v == btnRoteiro)
            chamarProximaTela(TelaRoteiro.class, null);
        else if (v == btnCliente)
        {
            Intent intent = new Intent();
            intent.putExtra("tela",TelaInicial.class.getCanonicalName());
            chamarProximaTela(TelaCliente.class, intent);
        }
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
        chamarProximaTela(TelaLogin.class, null);
    }
}
