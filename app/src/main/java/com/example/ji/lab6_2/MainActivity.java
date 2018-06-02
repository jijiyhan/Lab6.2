package com.example.ji.lab6_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String userNum,userName;
    EditText StudentNumber,Name;
    Button Call,Save,Clear;
    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StudentNumber=(EditText)findViewById(R.id.num);
        Name=(EditText)findViewById(R.id.name);
        Call=(Button)findViewById(R.id.call);
        Save=(Button)findViewById(R.id.save);
        Clear=(Button)findViewById(R.id.clear);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName=Name.getText().toString();
                userNum=StudentNumber.getText().toString();
                sharedPreferences();
            }
        });

        Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                applySharedPreference();
            }
        });

        Clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                StudentNumber.setText("");
                Name.setText("");
            }

        });
    }

    public void sharedPreferences(){
        sh_Pref=getSharedPreferences("Student",MODE_PRIVATE);
        toEdit=sh_Pref.edit();
        toEdit.putString("StudentNum",userNum);
        toEdit.putString("StudentName",userName);
        toEdit.commit();
    }
    public void applySharedPreference(){
        sh_Pref=getSharedPreferences("Student",MODE_PRIVATE);
        if(sh_Pref!=null && sh_Pref.contains("StudentName")){
            String name=sh_Pref.getString("StudentName","");
            Name.setText(name);

            String num=sh_Pref.getString("StudentNum","");
            StudentNumber.setText(num);
        }
    }
}
