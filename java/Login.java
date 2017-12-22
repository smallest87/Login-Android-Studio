package com.binangunkreatif.tutor.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    BasisData helper = new BasisData(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v)
    {
        if(v.getId() == R.id.BLoginMain)
        {
            EditText a = findViewById(R.id.ETNamaPenggunaMain);
            String str = a.getText().toString();
            EditText b = findViewById(R.id.ETSandiMain);
            String pass = b.getText().toString();

            String password = helper.searchPass(str);
            if (pass.equals(password))
            {
                Intent i = new Intent(Login.this, Beranda.class);
                i.putExtra("Username", str);
                startActivity(i);
            }
            else
            {
                Toast temp = Toast.makeText(Login.this , "Nama pengguna dan kata sandi tidak cocok." , Toast.LENGTH_SHORT);
                temp.show();
            }

        }

        if(v.getId() == R.id.BDaftarMain)
        {
            Intent i = new Intent(Login.this, Daftar.class);
            startActivity(i);
        }
    }
}
