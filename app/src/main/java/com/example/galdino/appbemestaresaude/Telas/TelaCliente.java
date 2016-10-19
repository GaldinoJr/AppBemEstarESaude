package com.example.galdino.appbemestaresaude.Telas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.galdino.appbemestaresaude.R;

public class TelaCliente extends AppCompatActivity implements View.OnClickListener {
    private ImageButton iBtnVoltar;
    private LinearLayout llBotoesAcoes,
                        llBotoesMaisInfromacoes;
    private Button btnPesquisar,
                    btnLimpar,
                    btnIncluir,
                    btnHistorico,
                    btnPontos,
                    btnAlterar;
    private EditText edtEndereco,
                    edtCpf,
                    edtNmCliente,
                    edtIdCliente;
    //
    private static String tela;
    private static boolean fgTelaLista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cliente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        associarObjetos();
        tela= "";
        fgTelaLista = false;
        //
        carregarControles();
    }


    private void associarObjetos()
    {
        llBotoesAcoes = (LinearLayout)findViewById(R.id.llBotoesAcoes);
        llBotoesMaisInfromacoes = (LinearLayout)findViewById(R.id.llBotoesMaisInfromacoes);

        iBtnVoltar = (ImageButton)findViewById(R.id.iBtnVoltar);
        btnPesquisar = (Button)findViewById(R.id.btnPesquisar);
        btnLimpar = (Button)findViewById(R.id.btnLimpar);
        btnIncluir = (Button)findViewById(R.id.btnIncluir);
        btnHistorico = (Button)findViewById(R.id.btnHistorico);
        btnPontos = (Button)findViewById(R.id.btnPontos);
        btnAlterar = (Button)findViewById(R.id.btnAlterar);

        edtEndereco = (EditText)findViewById(R.id.edtEndereco);
        edtCpf = (EditText)findViewById(R.id.edtCpf);
        edtNmCliente = (EditText)findViewById(R.id.edtNmCliente);
        edtIdCliente = (EditText)findViewById(R.id.edtIdCliente);

        iBtnVoltar.setOnClickListener(this);
        btnPesquisar.setOnClickListener(this);
        btnLimpar.setOnClickListener(this);
        btnIncluir.setOnClickListener(this);
        btnHistorico.setOnClickListener(this);
        btnPontos.setOnClickListener(this);
        btnAlterar.setOnClickListener(this);
    }

    private void carregarControles()
    {
        Intent intent = getIntent();
        tela = intent.getStringExtra("tela");
        String telaLista = intent.getStringExtra("lista");

        if(telaLista != null)
            if(telaLista.equals("1"))
                fgTelaLista = true;
        //
        // Tela Inicial CHECK IN
        if (tela.equals(TelaInicialCheckIn.class.getCanonicalName()))
            btnIncluir.setVisibility(View.VISIBLE);
        else
            btnIncluir.setVisibility(View.INVISIBLE);
        // Tela Alteração
        if(fgTelaLista)
        {
            btnAlterar.setVisibility(View.VISIBLE);
            edtIdCliente.setEnabled(false);
            llBotoesAcoes.setVisibility(View.GONE);
            llBotoesMaisInfromacoes.setVisibility(View.VISIBLE);
            edtNmCliente.setText(intent.getStringExtra("nmCliente"));
            edtEndereco.setText(intent.getStringExtra("nmRua"));
        }
        else
        {
            btnAlterar.setVisibility(View.INVISIBLE);
            llBotoesAcoes.setVisibility(View.VISIBLE);
            llBotoesMaisInfromacoes.setVisibility(View.GONE);
            edtIdCliente.setEnabled(true);
        }
    }

    @Override
    public void onClick(View v)
    {
        if(v == iBtnVoltar)
            onBackPressed();
        else if(v == btnPesquisar)
        {
            Intent intent = new Intent();
            intent.putExtra("tela",tela);
            chamarProximaTela(TelaListaClientes.class, intent, false);
        }
        else if(v == btnLimpar)
            limparControles();
        else if(v == btnIncluir)
        {
            if(!validaDados())
            {
                Toast.makeText(this,"Favor preencher todos os campos!",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(this, "Cliente inserido com sucesso!", Toast.LENGTH_LONG).show();
                chamarProximaTela(TelaInicialCheckIn.class, null, true);
            }
        }
        else if(v == btnHistorico)
        {
            Intent intent = new Intent();
            intent.putExtra("tela",tela);
            String sfgTelaLista = "0";
            if(fgTelaLista)
                sfgTelaLista = "1";
            intent.putExtra("fgTelaLista", sfgTelaLista);
            chamarProximaTela(TelaHistorico.class, intent, true);
        }
        else if(v == btnPontos)
            chamarProximaTela(TelaPontos.class,null,false);
        else if(v == btnAlterar)
        {
            if(!validaDados())
            {
                Toast.makeText(this,"Favor preencher todos os campos!",Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(this, "Cliente inserido com sucesso!", Toast.LENGTH_LONG).show();
                if (tela.equals(TelaInicialCheckIn.class.getCanonicalName()))
                    chamarProximaTela(TelaInicialCheckIn.class, null, true);
                else if (tela.equals(TelaListaClientes.class.getCanonicalName()))
                {
                    Intent intent = new Intent();
                    intent.putExtra("tela",tela);
                    chamarProximaTela(TelaListaClientes.class, intent, true);
                }
            }
        }
    }

    private boolean validaDados()
    {
        if(TextUtils.isEmpty(edtEndereco.getText()) ||
            TextUtils.isEmpty(edtCpf.getText()) ||
            TextUtils.isEmpty(edtNmCliente.getText()) ||
            TextUtils.isEmpty(edtIdCliente.getText()))
        return false;
        else
            return  true;
    }

    private void limparControles()
    {
        edtEndereco.setText("");
        edtCpf.setText("");
        edtNmCliente.setText("");
        edtIdCliente.setText("");
    }

    private void chamarProximaTela(Class proximaTela, Intent intent,boolean fgTelaNova)
    {
        if(intent == null)
            intent = new Intent();
        intent.setClass(this, proximaTela);
        startActivity(intent);
        if(fgTelaNova)
            finish();
    }

    public void onBackPressed()
    {
        if(fgTelaLista) {
            Intent intent = new Intent();
            intent.putExtra("tela", tela);
            chamarProximaTela(TelaListaClientes.class, intent, true);
        }
        else {
            if (tela.equals(TelaInicialCheckIn.class.getCanonicalName()))
                chamarProximaTela(TelaInicialCheckIn.class, null, true);
            else
                chamarProximaTela(TelaInicial.class, null, true);
        }
    }
}
