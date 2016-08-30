package com.kovalenko.paul.pokemondeck;

/**
 * Created by Pashulya on 27.08.2016.
 */
public class Pokemon {

    private String number;
    private String name;
    private int icon;
    private int image;
    private String biology;

    public String getPokemonNumber() { return number; }

    public void setPokemonNumber(String number) { this.number = number; }

    public String getPokemonName() { return name; }

    public void setPokemonName(String name) { this.name = name; }

    public int getPokemonIcon() { return icon; }

    public void setPokemonIcon(int icon) { this.icon = icon; }

    public int getPokemonImage() { return image; }

    public void setPokemonImage(int image) {this.image = image; }

    public String getPokemonBiology() { return biology; }

    public void setPokemonBiology(String biology) { this.biology = biology; }

    public Pokemon(String number, int icon, String name, int image, String biology) {
        this.number = number;
        this.icon = icon;
        this.name = name;
        this.image = image;
        this.biology = biology;
    }

    public String toString(){
        return getPokemonNumber()+getPokemonName();
    }
}
