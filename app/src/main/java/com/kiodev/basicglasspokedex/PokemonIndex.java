package com.kiodev.basicglasspokedex;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Pokemon Types
 */
public class PokemonIndex {

    private static final String TAG = PokemonIndex.class.getSimpleName();

    private static PokemonIndex sPokemonIndex;

    private HashMap<String, ArrayList<String>> mPokemon;
    private ArrayList<String> mTypes;

    // Constructor
    private PokemonIndex (){

        mPokemon = new HashMap<String, ArrayList<String>>();
        mTypes = new ArrayList<String>();

        // Set Fire Pokemon
        ArrayList<String> fire = new ArrayList<String>();
        fire.add("Charmander");
        fire.add("Charmeleon");
        fire.add("Vulpix");
        mPokemon.put("Fire", fire);


        // Set Water
        ArrayList<String> water = new ArrayList<String>();
        water.add("Squirtle");
        water.add("Wartortle");
        water.add("Blastoise");
        mPokemon.put("Water", water);

        // Set Types
        for (String key : mPokemon.keySet()) {
            Log.d(TAG, "key is: " + key);
            mTypes.add(key);
        }

        Log.d(TAG, "mTypes is now: " + mTypes.toString());

    }

    // Singleton
    public static PokemonIndex get(){
        if( sPokemonIndex == null ){
            sPokemonIndex = new PokemonIndex();
        }

        return sPokemonIndex;
    }

    public ArrayList<String> getTypes() {
        return mTypes;
    }

    public ArrayList<String> getThesePokemon(String type){
        return mPokemon.get(type);
    }

}
