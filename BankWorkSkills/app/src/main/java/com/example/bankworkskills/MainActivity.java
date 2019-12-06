package com.example.bankworkskills;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private ImageView imageView1;
    private ImageView bttnStart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView15);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        bttnStart = findViewById(R.id.imageView13);
        bttnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnStart();
            }
        });


        imageView1 = findViewById(R.id.imageView14);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
    }

    public void openActivity2() {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    public void openActivity3() {
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }



    public void btnStart(){
        try {
            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

            final EditText input1 = new EditText(this);
            final EditText input2 = new EditText(this);


            input1.setText("Логин", EditText.BufferType.EDITABLE);
            input2.setText("Пароль", EditText.BufferType.EDITABLE);

            /*------ Lay on alertDialog
            lay = new LinearLayout(this);
            lay.setOrientation(LinearLayout.VERTICAL);
            lay.addView(input1);
            lay.addView(input2);
            builder.setView(lay);*/

            builder.setTitle("Автоизация")
                    .setMessage("Введите ваш логин и пароль")
                    .setCancelable(false)
                    .setView(input1)
                    .setView(input2)
                    .setNegativeButton("Добавить", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    }).setPositiveButton("Отмена", null);
            AlertDialog alert = builder.create();
            alert.show();
        }
        catch (Exception ex)
        {
            final AlertDialog.Builder exAlert = new AlertDialog.Builder(MainActivity.this);
            exAlert.setTitle("ERROR").setMessage(""+ex);
            exAlert.show();
        }
    }
}
