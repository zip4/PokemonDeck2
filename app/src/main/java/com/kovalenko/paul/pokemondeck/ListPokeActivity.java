package com.kovalenko.paul.pokemondeck;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListPokeActivity extends AppCompatActivity {

    // Declare Variables
    ListView listView;
    PokemonAdapter adapter;
    EditText searchET;
    String[] number, biology;
    int[] image, icon;
    String[] name;
    ArrayList<Pokemon> arrayList = new ArrayList<Pokemon>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_poke);

        number = new String[]{"#001", "#002", "#003", "#004", "#005", "#006", "#007", "#008", "#009"};
        name = new String[]{"Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon",
                "Charizard", "Squirtle", "Wartortle", "Blastoise"};
        icon = new int[]{R.drawable.bulbasaur, R.drawable.ivysaur, R.drawable.venusaur,
                R.drawable.charmander, R.drawable.charmeleon, R.drawable.charizard,
                R.drawable.squirtle, R.drawable.wartortle, R.drawable.blastoise};
        image = new int[]{R.drawable.bulbasaurlarge, R.drawable.ivysaurlarge, R.drawable.venusaurlarge,
                R.drawable.charmanderlarge, R.drawable.charmeleonlarge, R.drawable.charizardlarge,
                R.drawable.squirtlelarge, R.drawable.wartortlelarge, R.drawable.blastoiselarge};
        biology = getResources().getStringArray(R.array.pokemon_description);


        listView = (ListView) findViewById(R.id.pokeLV);

        for (int i = 0; i < number.length; i++) {
            Pokemon pokemon = new Pokemon(number[i], icon[i], name[i], image[i], biology[i]);
            arrayList.add(pokemon);
        }

        adapter = new PokemonAdapter(this, arrayList);

        listView.setAdapter(adapter);

        searchET = (EditText) findViewById(R.id.searchET);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Log.d("TAG", position + "");
                Log.d("TAG", id + "");
                Intent intent = new Intent(ListPokeActivity.this, PokeInfoActivity.class);
                String number = arrayList.get(position).getPokemonNumber();
                int icon = arrayList.get(position).getPokemonIcon();
                String name = arrayList.get(position).getPokemonName();
                int image = arrayList.get(position).getPokemonImage();
                String biology = arrayList.get(position).getPokemonBiology();
                intent.putExtra("pokemon_number", number);
                intent.putExtra("pokemon_icon", icon);
                intent.putExtra("pokemon_name", name);
                intent.putExtra("pokemon_image", image);
                intent.putExtra("pokemon_biology", biology);
                startActivity(intent);
            }
        });
    }
}
