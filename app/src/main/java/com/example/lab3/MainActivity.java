package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText su,sp;
    Button sb;
    String re ="(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        su=(EditText)findViewById(R.id.user_signup);
        sp=(EditText)findViewById(R.id.pswd_signup);
        sb=(Button)findViewById(R.id.button_signup);
        sb.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String sun=su.getText().toString();
        String sps=sp.getText().toString();
        if(validatepassword(sps)){
            Bundle bundle=new Bundle();
            bundle.putString("user",sun);
            bundle.putString("pwd",sps);
            Intent it= new Intent(this,login.class);
            it.putExtra("data",bundle);
            startActivity(it);
        }
        else{
            Toast.makeText(getBaseContext(),"invalid password",Toast.LENGTH_LONG).show();
        }


    }

    private boolean validatepassword(String sps) {
        Pattern pattern = Pattern.compile(re);
        Matcher matcher = pattern.matcher(sps);
        return matcher.matches();
    }
}