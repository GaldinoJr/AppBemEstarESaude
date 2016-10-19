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
import android.widget.TextView;

import com.example.galdino.appbemestaresaude.R;

public class TelaCheckIn extends AppCompatActivity implements View.OnClickListener {
    private Button btnCheckIn;
    private ImageButton iBtnVoltar;
    private TextView txtEndereco,
                    txtCliente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_check_in);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        associarObjetos();
        //
        Intent intent = getIntent();
        txtCliente.setText(intent.getStringExtra("nmCliente"));
        txtEndereco.setText(intent.getStringExtra("nmRua"));
    }

    private void associarObjetos()
    {
        iBtnVoltar = (ImageButton)findViewById(R.id.iBtnVoltar);
        btnCheckIn = (Button)findViewById(R.id.btnCheckIn);
        txtEndereco = (TextView)findViewById(R.id.txtEndereco);
        txtCliente = (TextView)findViewById(R.id.txtCliente);
        //
        iBtnVoltar.setOnClickListener(this);
        btnCheckIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v == iBtnVoltar)
            onBackPressed();
        if(v == btnCheckIn)
        {
            Intent intent = new Intent();
            intent.putExtra("nmCliente",txtCliente.getText());
            intent.putExtra("nmRua",txtEndereco.getText());
            chamarProximaTela(TelaInicialCheckIn.class, intent);
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
        chamarProximaTela(TelaRoteiro.class, null);
    }
}
