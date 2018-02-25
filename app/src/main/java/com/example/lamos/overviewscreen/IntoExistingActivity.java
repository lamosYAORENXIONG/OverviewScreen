package com.example.lamos.overviewscreen;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IntoExistingActivity extends AppCompatActivity {
    public static int count = 1;

    public static Intent newInstance(Context context, String title){
        Intent intent = new Intent(context, IntoExistingActivity.class);
        intent.putExtra("title", title);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intentstart);

        String Title = getIntent().getStringExtra("title");
        TextView titieview = (TextView)findViewById(R.id.intentstart_title);
        titieview.setText(Title);

        Button startselfbutton = (Button)findViewById(R.id.start_self);
        startselfbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = IntoExistingActivity.newInstance(IntoExistingActivity.this, count + "");
                count++;
                startActivity(intent);
            }
        });
    }
}
