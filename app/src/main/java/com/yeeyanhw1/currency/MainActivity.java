package com.yeeyanhw1.currency;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edNtd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNtd = findViewById(R.id.ntd);
    }

    public void ntd(View view){
        String edit_NTD = edNtd.getText().toString();
        if(edit_NTD.equals("")){
            new AlertDialog.Builder(this)
                    .setTitle("Problem")
                    .setMessage("Please enter your NTD amount")
                    .setPositiveButton("OK",null)
                    .show();
        }
        else{
            Double ntd_num = Double.parseDouble(edit_NTD);
            Double usd_num = ntd_num/30.9;
            new AlertDialog.Builder(this)
                    .setTitle("Result")
                    .setMessage("USD is " + usd_num)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            edNtd.setText("");
                        }
                    })
                    .show();
        }
    }
}
