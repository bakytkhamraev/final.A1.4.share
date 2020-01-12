package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityLauncher extends AppCompatActivity {

    TextView textView;
    Button calculator1, calculator2, share;
    static private final int ID_FOR_SECOND = 1;
    static private final String KEY_FOR_MAIN_LAUNCHER = "KEY_FOR_MAIN_LAUNCHER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_launcher);

        textView = findViewById(R.id.text_view1);
        calculator1 = findViewById(R.id.btn_calculator1);
        calculator2 = findViewById(R.id.btn_calculator2);
        share = findViewById(R.id.btn_share);
    }

    public void onOpenMainActivity(View v){
        Intent intent = new Intent(MainActivityLauncher.this , MainActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ID_FOR_SECOND && resultCode == RESULT_OK){
            String s = data.getStringExtra(KEY_FOR_MAIN_LAUNCHER);
            textView.setText(s);
        } else {
        }
    }

    public void onClickShare(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, textView.getText());
        intent.setType("text/plain");
        startActivity(intent);
    }
}
