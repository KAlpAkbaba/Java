package com.example.haliyazilimi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainScreen extends AppCompatActivity {
    Button cikis;
    Button alimdacitim;
    Button yenisiparis;
    Button alinan;
    Button dagitilacak;
    Button teslimalinan;
    Button teslimedilen;
    Button yikamadakiler;
    Button dagitimahazirla;
    Button siparisbul;
    Button onlinesiparisler;
    ImageView yardim;
    Button musterihizmetleri;
    Button patronislemler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        cikis = (Button) findViewById(R.id.cikis);
        cikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cikiss = new Intent(MainScreen.this,MainActivity.class);
                startActivity(cikiss);
            }
        });
        yenisiparis = (Button) findViewById(R.id.yenisiparis);
        yenisiparis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent yenisiparis = new Intent(MainScreen.this, com.example.haliyazilimi.yenisiparis.class);
                startActivity(yenisiparis);
            }
        });
        alinan = (Button) findViewById(R.id.alinan);
        alinan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent alinann = new Intent(MainScreen.this,alinacak.class);
                startActivity(alinann);
            }
        });
        dagitilacak = (Button) findViewById(R.id.dagitilan);
        dagitilacak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dagitilacakk = new Intent(MainScreen.this,dagitilacak.class);
                startActivity(dagitilacakk);
            }
        });
        teslimalinan = (Button) findViewById(R.id.teslimalinan);
        teslimalinan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent teslimalinann = new Intent(MainScreen.this, com.example.haliyazilimi.teslimalinan.class);
                startActivity(teslimalinann);
            }
        });
        teslimedilen = (Button) findViewById(R.id.teslimedlien);
        teslimedilen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent teslimedilenn = new Intent(MainScreen.this, com.example.haliyazilimi.teslimedilen.class);
                startActivity(teslimedilenn);
            }
        });
        yikamadakiler = (Button) findViewById(R.id.yikamadakiler);
        yikamadakiler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent yikamadakilerr = new Intent(MainScreen.this, com.example.haliyazilimi.yikamadakiler.class);
                startActivity(yikamadakilerr);
            }
        });
        siparisbul = (Button) findViewById(R.id.bul);
        siparisbul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent siparisbull = new Intent(MainScreen.this, com.example.haliyazilimi.siparisbul.class);
                startActivity(siparisbull);
            }
        });
        onlinesiparisler = (Button) findViewById(R.id.siparisler);
        onlinesiparisler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent onlinesiparislerr = new Intent(MainScreen.this, com.example.haliyazilimi.onlinesiparisler.class);
                startActivity(onlinesiparislerr);
            }
        });
        yardim = (ImageView) findViewById(R.id.yardim);
        yardim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent yardimm = new Intent(MainScreen.this,yardimsayfasi.class);
                startActivity(yardimm);
            }
        });
        musterihizmetleri= (Button) findViewById(R.id.rehber);
        musterihizmetleri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent musterihizmetlerii = new Intent(MainScreen.this, com.example.haliyazilimi.musterihizmetleri.class);
                startActivity(musterihizmetlerii);
            }
        });
        patronislemler = (Button) findViewById(R.id.patronislemlerii);
        patronislemler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent patronislemlerr = new Intent(MainScreen.this,patronislemleri.class);
                startActivity(patronislemlerr);
            }
        });
    }
}
