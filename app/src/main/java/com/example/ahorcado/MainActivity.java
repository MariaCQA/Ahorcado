package com.example.ahorcado;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CustomView customView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customView = findViewById(R.id.customView);
        Button btnJugar = findViewById(R.id.btnJugar);
        Button btnReiniciar = findViewById(R.id.btnReiniciar);

        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customView.nextStage();
            }
        });

        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customView.reset();
            }
        });
    }
}
