package com.example.haliyazilimi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Button btngrs;
    Button sifrebtn;
    EditText username;
    EditText pass;
    FirebaseAuth mAuth;
    TextView Textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btngrs = (Button) findViewById(R.id.btnlogin);
        sifrebtn = (Button) findViewById(R.id.btnforgetpass);
        username = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.pass);
        Textview = (TextView) findViewById(R.id.textView111);
        mAuth = FirebaseAuth.getInstance();
        DatabaseReference usernamecheck;
        DatabaseReference passcheck;
        DatabaseReference usernameref;
        String usernametext = username.getText().toString();
        String passwordtext = pass.getText().toString();
        usernameref = FirebaseDatabase.getInstance().getReference().child("users").child(usernametext);
        usernamecheck = FirebaseDatabase.getInstance().getReference().child("users").child(usernametext).child("username");
        passcheck = FirebaseDatabase.getInstance().getReference().child("users").child(usernametext).child("pass");
        btngrs.setOnClickListener(view -> {
                    readdata();
                });
        sifrebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pass = new Intent(MainActivity.this,forgetpass.class);
                startActivity(pass);
            }
        });

    }
    private void createuser(){
        String email = username.getText().toString();
        String pasword = pass.getText().toString();
        if(TextUtils.isEmpty(email)){
            username.setError("Email Can Not Be Empty");
            username.requestFocus();
        }else if (TextUtils.isEmpty(pasword)){
            pass.setError("Password Can Not Be Empty");
            pass.requestFocus();
        }else {
            mAuth.createUserWithEmailAndPassword(email,pasword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(MainActivity.this,"Kullanıcı Kayıtı Başarılı",Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(MainActivity.this,"Kullanıcı Kayıt Hatası" + task.getException().getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    public void readdata(){
        DatabaseReference usernamecheck;
        DatabaseReference passcheck;
        DatabaseReference usernameref;
        String usernametext = username.getText().toString();
        String passwordtext = pass.getText().toString();
        usernameref = FirebaseDatabase.getInstance().getReference().child("users").child(usernametext);
        usernamecheck = FirebaseDatabase.getInstance().getReference().child("users").child(usernametext).child("username");
        passcheck = FirebaseDatabase.getInstance().getReference().child("users").child(usernametext).child("pass");
        usernameref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    usernamecheck.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String Usernamecheck = snapshot.getValue().toString();
                            if (snapshot.exists()){
                                passcheck.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        String Passcheck = snapshot.getValue().toString();
                                        if (usernametext.equals(Usernamecheck) && passwordtext.equals(Passcheck)){
                                            Intent mainscreen = new Intent(MainActivity.this,MainScreen.class);
                                            startActivity(mainscreen);
                                        }
                                        else{
                                            Textview.setText("Kullanıcı Adı Veya Şifre Hatalı !!!");
                                        }
                                    }
                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                    }
                                });
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

}
