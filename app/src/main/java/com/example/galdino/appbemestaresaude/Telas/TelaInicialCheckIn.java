package com.example.galdino.appbemestaresaude.Telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.galdino.appbemestaresaude.R;

public class TelaInicialCheckIn extends AppCompatActivity implements View.OnClickListener {
    private Button btnCliente,
                    btnVenda,
                    btnCheckOut;
    private TextView txtEndereco,
            txtCliente;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial_check_in);
        associarObjetos();
        //
        Intent intent = getIntent();
        txtCliente.setText(intent.getStringExtra("nmCliente"));
        txtEndereco.setText(intent.getStringExtra("nmRua"));
    }

    private void associarObjetos()
    {
        btnCliente = (Button)findViewById(R.id.btnCliente);
        btnVenda = (Button)findViewById(R.id.btnVenda);
        btnCheckOut = (Button)findViewById(R.id.btnCheckOut);
        txtEndereco = (TextView)findViewById(R.id.txtEndereco);
        txtCliente = (TextView)findViewById(R.id.txtCliente);
        //
        btnCliente.setOnClickListener(this);
        btnVenda.setOnClickListener(this);
        btnCheckOut.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnCheckOut)
            chamarProximaTela(TelaCheckOut.class,null);
        if(v == btnCliente)
        {
            Intent intent = new Intent();
            intent.putExtra("tela",TelaInicialCheckIn.class.getCanonicalName());
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

    }
}
