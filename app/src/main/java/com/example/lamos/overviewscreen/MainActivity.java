package com.example.lamos.overviewscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button IntentStartButton = (Button)findViewById(R.id.IntentStart);
        IntentStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = IntentStartActivity.newInstance(MainActivity.this, "This is IntentStart");
                startActivity(intent);
            }
        });

        Button IntoButton = (Button)findViewById(R.id.IntoExisting);
        IntoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = IntoExistingActivity.newInstance(MainActivity.this, "This is IntoExisting");
                startActivity(intent);
            }
        });

        Button alwaysButton = (Button)findViewById(R.id.always);
        alwaysButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = AlwaysActivity.newInstance(MainActivity.this, "This is Always");
                startActivity(intent);
            }
        });



        Button RemoveTaskButton = (Button)findViewById(R.id.RemoveTask);
        RemoveTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAndRemoveTask();//只能移除自身（不能移除IntentStartActivity）
            }
        });
    }
}
