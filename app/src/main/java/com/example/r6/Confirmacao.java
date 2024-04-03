package com.example.r6;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Confirmacao extends AppCompatActivity {
    String escolhaAT, escolhaDF;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_confirmacao);

        ImageView picAsh = findViewById(R.id.imgAsh);
        ImageView picTher = findViewById(R.id.imgThermite);
        ImageView picSle = findViewById(R.id.imgSledge);
        ImageView picBlit = findViewById(R.id.imgBlitz);
        ImageView picPul = findViewById(R.id.imgPulse);
        ImageView picDoc = findViewById(R.id.imgDoc);
        ImageView picBand = findViewById(R.id.imgBandit);
        ImageView picLes = findViewById(R.id.imgLesion);
        picAsh.setVisibility(View.INVISIBLE);
        picTher.setVisibility(View.INVISIBLE);
        picSle.setVisibility(View.INVISIBLE);
        picBlit.setVisibility(View.INVISIBLE);
        picPul.setVisibility(View.INVISIBLE);
        picDoc.setVisibility(View.INVISIBLE);
        picBand.setVisibility(View.INVISIBLE);
        picLes.setVisibility(View.INVISIBLE);

        TextView textoAtaque = findViewById(R.id.txtAtq);
        TextView textoDefesa = findViewById(R.id.txtDefesa);
        TextView textoFrequencia = findViewById(R.id.txtFq);

        Intent intent = getIntent();
        int frequenciaSelecionada = intent.getIntExtra("frequenciaSelecionada", 0);
        textoFrequencia.setText("Frequência selecionada: " + frequenciaSelecionada);

        intent = getIntent();
        boolean ashSelected = intent.getBooleanExtra("ashSelected", false);
        boolean sledgeSelected = intent.getBooleanExtra("sledgeSelected", false);
        boolean thermiteSelected = intent.getBooleanExtra("thermiteSelected", false);
        boolean blitzSelected = intent.getBooleanExtra("blitzSelected", false);
        boolean pulseSelected = intent.getBooleanExtra("pulseSelected", false);
        boolean lesionSelected = intent.getBooleanExtra("lesionSelected", false);
        boolean docSelected = intent.getBooleanExtra("docSelected", false);
        boolean banditSelected = intent.getBooleanExtra("banditSelected", false);

        if (ashSelected == true) {
            escolhaAT = "Ash";
            picAsh.setVisibility(View.VISIBLE);
        } else if (sledgeSelected == true) {
            escolhaAT = "Sledge";
            picSle.setVisibility(View.VISIBLE);
        } else if (thermiteSelected == true) {
            escolhaAT = "Thermite";
            picTher.setVisibility(View.VISIBLE);
        } else if (blitzSelected == true) {
            escolhaAT = "Blitz";
            picBlit.setVisibility(View.VISIBLE);
        } else {
            escolhaAT = "";
        }

        if (pulseSelected == true) {
            escolhaDF = "Pulse";
            picPul.setVisibility(View.VISIBLE);
        } else if (lesionSelected == true) {
            escolhaDF = "Lesion";
            picLes.setVisibility(View.VISIBLE);
        } else if (docSelected == true) {
            escolhaDF = "Doc";
            picDoc.setVisibility(View.VISIBLE);
        } else if (banditSelected == true) {
            escolhaDF = "Bandit";
            picBand.setVisibility(View.VISIBLE);
        } else {
            escolhaDF = "";
        }

        switch (escolhaAT) {
            case "Ash":
                textoAtaque.setText("Operador de ataque escolido é " + escolhaAT);
                break;
            case "Sledge":
                textoAtaque.setText("Operador de ataque escolido é " + escolhaAT);
                break;
            case "Thermite":
                textoAtaque.setText("Operador de ataque escolido é " + escolhaAT);
                break;
            case "Blitz":
                textoAtaque.setText("Operador de ataque escolido é " + escolhaAT);
                break;
            case "":
                textoAtaque.setText("Nenhum operador escolhido");
                break;
        }
        switch (escolhaDF) {
            case "Pulse":
                textoDefesa.setText("Operador de defesa escolhido é " + escolhaDF);
                break;
            case "Lesion":
                textoDefesa.setText("Operador de defesa escolhido é " + escolhaDF);
                break;
            case "Doc":
                textoDefesa.setText("Operador de defesa escolhido é " + escolhaDF);
                break;
            case "Bandit":
                textoDefesa.setText("Operador de defesa escolhido é " + escolhaDF);
                break;
            case "":
                textoDefesa.setText("Nenhum operador escolhido");
        }

    }
    public void voltarParaTelaInicial(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

}
