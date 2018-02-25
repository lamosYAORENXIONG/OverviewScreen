package com.example.lamos.overviewscreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by lamos on 2018/2/21.
 */

public class IntentStartActivity extends AppCompatActivity {
    private static int count = 1;
    public static Intent newInstance(Context context ,String title){
        Intent intent = new Intent(context, IntentStartActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);//只有这个一个模板只能使用一次
        intent.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);//有它可以一个模板多次使用
        intent.putExtra("title", title);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intentstart);

        String ActivityTitle = getIntent().getStringExtra("title");
        TextView activitytitle = (TextView)findViewById(R.id.intentstart_title);
        activitytitle.setText(ActivityTitle);


        Button startbutton = (Button)findViewById(R.id.start_self);
        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = IntentStartActivity.newInstance(IntentStartActivity.this, "" + count);
                count++;
                startActivity(intent);
            }
        });


    }
}
