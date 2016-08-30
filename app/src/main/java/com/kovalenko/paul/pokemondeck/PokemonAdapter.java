package com.kovalenko.paul.pokemondeck;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pashulya on 27.08.2016.
 */
public class PokemonAdapter extends BaseAdapter{

    Context mContext;
    LayoutInflater inflater;
    private List<Pokemon> pokemonList = null;
    private ArrayList<Pokemon> arraylist;
    private ArrayList<Pokemon> filteredPokemonList;


    public PokemonAdapter(Context context, List<Pokemon> pokemonList) {
        mContext = context;
        this.pokemonList = pokemonList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Pokemon>();
        this.arraylist.addAll(pokemonList);
    }

    public class ViewHolder {
        TextView number;
        ImageView image;
        TextView name;
    }

    @Override
    public int getCount() { return pokemonList.size(); }

    @Override
    public Object getItem(int position) { return pokemonList.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Pokemon filteredPokemon = filteredPokemonList.get(position);
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_item, null);

            holder.number = (TextView) convertView.findViewById(R.id.pokeNumTV);
            holder.image = (ImageView) convertView.findViewById(R.id.pokeIcon);
            holder.name = (TextView) convertView.findViewById(R.id.pokeNameTV);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
//      Don't really get why we need this???
//        holder.number.setText(pokemonList.get(position).getPokemonNumber());
//        holder.image.setImageResource(pokemonList.get(position).getPokemonIcon());
//        holder.name.setText(pokemonList.get(position).getPokemonName());


        View view = convertView;
        if (view == null)
            view = inflater.inflate(R.layout.list_item, parent, false);

        String number = /*pokemonList.get(position)*/filteredPokemon.getPokemonNumber();
        int image = filteredPokemon.getPokemonIcon();
        String name = filteredPokemon.getPokemonName();

        ((TextView) view.findViewById(R.id.pokeNumTV)).setText(number);
        ((ImageView) view.findViewById(R.id.pokeIcon)).setImageResource(image);
        ((TextView) view.findViewById(R.id.pokeNameTV)).setText(name);

        return view;
    }
}
