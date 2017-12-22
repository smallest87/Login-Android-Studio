package com.binangunkreatif.tutor.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Julian on 18/12/2017.
 */

public class Daftar extends AppCompatActivity {

    BasisData helper = new BasisData(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar);
    }

    public void onSignUpClick(View v)
    {
        if(v.getId() == R.id.BDaftarSignup)
        {
            EditText name = findViewById(R.id.ETNamaLengkapSignup);
            EditText email = findViewById(R.id.ETEmailSignup);
            EditText uname = findViewById(R.id.ETNamaPenggunaSignup);
            EditText pass1 = findViewById(R.id.ETSandiSignup);
            EditText pass2 = findViewById(R.id.ETSandiKonfirmasiSignup);

            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String unamestr = uname.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();

            if(!pass1str.equals(pass2str))
            {
                Toast pass = Toast.makeText(Daftar.this , "Password dont match" , Toast.LENGTH_SHORT);
                pass.show();
            }
            else
            {
                //insert the detail in database
                Contact c = new Contact();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setUname(unamestr);
                c.setPass(pass1str);

                helper.insertContact(c);

                Toast tambahdata = Toast.makeText(Daftar.this , "Data telah ditambahkan" , Toast.LENGTH_SHORT);
                tambahdata.show();

                Intent i = new Intent(Daftar.this, Login.class);
                startActivity(i);
            }

        }
    }

}
