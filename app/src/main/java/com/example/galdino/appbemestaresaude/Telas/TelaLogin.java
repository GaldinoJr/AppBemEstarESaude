package com.example.galdino.appbemestaresaude.Telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.example.galdino.appbemestaresaude.R;

public class TelaLogin extends AppCompatActivity implements View.OnClickListener
{
    private Button btnConectar;
    private EditText edtSenha,
                        edtId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
        associarObjetos();
    }
    // Associa os objetos da tela com as varáveis do arquivo
    private void associarObjetos()
    {
        btnConectar = (Button)findViewById(R.id.btnConectar);
        edtSenha = (EditText)findViewById(R.id.edtSenha);
        edtId = (EditText)findViewById(R.id.edtId);
        //
        btnConectar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v == btnConectar)
        {
            Intent intent = new Intent();
            intent.setClass(this,TelaInicial.class);
            startActivity(intent);
            finish();
        }
    }
}
