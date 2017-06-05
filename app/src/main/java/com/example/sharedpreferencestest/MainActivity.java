package com.example.sharedpreferencestest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button saveDataBtn = (Button)findViewById(R.id.save_data);
        saveDataBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name","wangliyue");
                editor.putInt("age",26);
                editor.putBoolean("male",true);
                editor.apply();
            }
        });

        Button restoreDataBtn = (Button)findViewById(R.id.restore_data);
        restoreDataBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
                String name = sharedPreferences.getString("name","");
                int age = sharedPreferences.getInt("age",0);
                boolean isMale = sharedPreferences.getBoolean("male",false);

                Log.d(TAG, "name:"+name);
                Log.d(TAG, "age:"+age);
                Log.d(TAG, "isMale:"+isMale);
            }
        });
    }
}
