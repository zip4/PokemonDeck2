package com.kovalenko.paul.pokemondeck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class PokeInfoActivity extends AppCompatActivity {

    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_info);

        Intent intent = getIntent();
        String number = intent.getStringExtra("pokemon_number");
        String name = intent.getStringExtra("pokemon_name");
        int image = intent.getIntExtra("pokemon_image", 0);
        int icon = intent.getIntExtra("pokemon_icon", 0);
        String biology = intent.getStringExtra("pokemon_biology");

        TextView numberTextView = (TextView) findViewById(R.id.singlePokemonNumTV);
        TextView nameTextView = (TextView) findViewById(R.id.singlePokemonNameTV);
        final ImageView imageView = (ImageView) findViewById(R.id.singlePokemonImageIV);
        final TextView biologyTextView = (TextView) findViewById(R.id.biologyPokemonTV);

        numberTextView.setText(number);
        nameTextView.setText(name);
        imageView.setImageResource(image);
        biologyTextView.setText(biology);

        scrollView = (ScrollView) findViewById(R.id.scrollViewPoke);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent bioIntent = new Intent(PokeInfoActivity.this, PokemonBiology.class);
//                bioIntent.putExtra("pokemon_biology", biology);
//                startActivity(bioIntent);
                scrollView.scrollTo(0, +biologyTextView.getTop());
            }
        });
    }
}
