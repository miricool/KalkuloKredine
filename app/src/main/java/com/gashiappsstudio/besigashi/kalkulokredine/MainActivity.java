package com.gashiappsstudio.besigashi.kalkulokredine;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText krediaEditText;
    EditText interesiEditText;
    EditText vitetEditText;
    Button llogaritKreditin;
    Button pastro;
    TextView shfaqRrezTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        krediaEditText = (EditText) findViewById(R.id.Kredia_editText);
        interesiEditText = (EditText) findViewById(R.id.Interesi_EditTxt);
        vitetEditText = (EditText) findViewById(R.id.vitet_EditTxt);
        llogaritKreditin = (Button) findViewById(R.id.button_kalkulo);
        pastro = (Button) findViewById(R.id.button_pastro);
        shfaqRrezTextView = (TextView) findViewById(R.id.txt_shfaq_rrez);

        llogaritKreditin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int kredia = Integer.parseInt(krediaEditText.getText().toString());
                double interesi = Double.parseDouble(interesiEditText.getText().toString());
                int vitet = Integer.parseInt(vitetEditText.getText().toString());

                String llog_kredine = Integer.toString(llogariKredine(kredia, interesi, vitet));

                double muaji = (double)Integer.parseInt(llog_kredine) / ( vitet * 12);
                java.text.DecimalFormat df = new java.text.DecimalFormat("#0.00");


                shfaqRrezTextView.setText("Shuma e pergjithshme e Kredise: " + "$" + llog_kredine
                + "\n Pagesa mujore: " + df.format(muaji) + "$");
            }
        });

        pastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                krediaEditText.getText().clear();
                interesiEditText.getText().clear();
                vitetEditText.getText().clear();
                shfaqRrezTextView.setText("");
            }
        });

    }

    public static int llogariKredine(int kredia, double interesi, int vitet){

        double Interesi = (interesi / 100) / 12;

        double shuma = kredia *  Math.pow((1 + Interesi), vitet * 12);

        return (int) shuma;
    }
}
