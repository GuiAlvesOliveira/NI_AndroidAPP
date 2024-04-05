package com.example.r6;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private RadioButton ash, sledge, thermite, blitz, pulse, lesion, doc, bandit;
    private SeekBar seekBarFrequencia;

    private String txtDialog;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarFrequencia = findViewById(R.id.seekBarFq);

        ash = findViewById(R.id.Ash);
        sledge = findViewById(R.id.Sledge);
        thermite = findViewById(R.id.Thermite);
        blitz = findViewById(R.id.Blitz);
        pulse = findViewById(R.id.Pulse);
        lesion = findViewById(R.id.Lesion);
        doc = findViewById(R.id.Doc);
        bandit = findViewById(R.id.Bandit);

        seekBarFrequencia.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int frequenciaSelecionada = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

        });
    }

    public void enviar(View view) {

    }

    public void alertDialog(View view) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Confirmação de resposta");
        dialog.setMessage("Tem certeza da sua resposta?");
        dialog.setCancelable(false);
        dialog.setIcon(android.R.drawable.ic_delete);
        dialog.setPositiveButton("sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                boolean ashSelected = ash.isChecked();
                boolean sledgeSelected = sledge.isChecked();
                boolean thermiteSelected = thermite.isChecked();
                boolean blitzSelected = blitz.isChecked();
                boolean pulseSelected = pulse.isChecked();
                boolean lesionSelected = lesion.isChecked();
                boolean docSelected = doc.isChecked();
                boolean banditSelected = bandit.isChecked();

                Intent intent = new Intent(MainActivity.this, Confirmacao.class);
                intent.putExtra("ashSelected", ashSelected);
                intent.putExtra("sledgeSelected", sledgeSelected);
                intent.putExtra("thermiteSelected", thermiteSelected);
                intent.putExtra("blitzSelected", blitzSelected);
                intent.putExtra("pulseSelected", pulseSelected);
                intent.putExtra("lesionSelected", lesionSelected);
                intent.putExtra("docSelected", docSelected);
                intent.putExtra("banditSelected", banditSelected);
                int frequenciaSelecionada = seekBarFrequencia.getProgress();


                intent.putExtra("frequenciaSelecionada", frequenciaSelecionada);



                startActivity(intent);
            }
        });
        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), ".", Toast.LENGTH_LONG).show();
            }
        });
        dialog.create();
        dialog.show();
    }
}