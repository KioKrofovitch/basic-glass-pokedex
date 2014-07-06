package com.kiodev.basicglasspokedex;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Pokemon Types
 */
public class PokemonIndex {

    private static final String TAG = PokemonIndex.class.getSimpleName();

    private static PokemonIndex sPokemonIndex;

    private HashMap<String, Pokemon> mPokemon;
    private ArrayList<String> mTypes;

    // Constructor
    private PokemonIndex (){

        mPokemon = new HashMap<String, Pokemon>();

        mTypes = new ArrayList<String>();

        // Fire types
        mTypes.add("Fire");
        mPokemon.put("004", new Pokemon("Charmander", "Fire", R.drawable.charmander));
        mPokemon.put("005", new Pokemon("Charmeleon", "Fire", R.drawable.charmeleon));
        mPokemon.put("037", new Pokemon("Vulpix", "Fire", R.drawable.vulpix));

        // Water types
        mTypes.add("Water");
        mPokemon.put("007", new Pokemon("Squirtle", "Water", R.drawable.squirtle));
        mPokemon.put("008", new Pokemon("Wartortle", "Water", R.drawable.wartortle));
        mPokemon.put("009", new Pokemon("Blastoise", "Water", R.drawable.blastoise));

        // Electric tyeps
        mTypes.add("Electric");
        mPokemon.put("025", new Pokemon("Pikachu", "Electric", R.drawable.pikachu));
        mPokemon.put("026", new Pokemon("Raichu", "Electric", R.drawable.raichu));
        mPokemon.put("135", new Pokemon("Jolteon", "Electric", R.drawable.jolteon));

    }

    // Singleton
    public static PokemonIndex get(){
        if( sPokemonIndex == null ){
            sPokemonIndex = new PokemonIndex();
        }

        return sPokemonIndex;
    }

    public HashMap<String, Pokemon> getPokemon() {
        return mPokemon;
    }

    public ArrayList<String> getTypes(){
        return mTypes;
    }


}
