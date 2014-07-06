package com.kiodev.basicglasspokedex;

import java.util.ArrayList;

/**
 * Pokemon Types
 */
public class PokemonTypes {

    // KIO this should be a singleton
    private ArrayList<String> mAvailableTypes;

    public PokemonTypes () {
        mAvailableTypes = new ArrayList<String>();

        mAvailableTypes.add(0, "Fire");
        mAvailableTypes.add(1, "Water");
        mAvailableTypes.add(2, "Grass");
        mAvailableTypes.add(3, "Electric");
        mAvailableTypes.add(4, "Ghost");
    }

    public ArrayList<String> getTypesList() {
        return mAvailableTypes;
    }

}
