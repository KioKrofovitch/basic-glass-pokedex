package com.kiodev.basicglasspokedex;

/**
 * Pokemon
 */
public class Pokemon {

    String mName;
    String mType;
    int mImage;

    public Pokemon (String name, String type, int img) {
        this.mName = name;
        this.mType = type;
        this.mImage = img;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getType() {
        return mType;
    }

    public void setType(String mType) {
        this.mType = mType;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int mImage) {
        this.mImage = mImage;
    }
}
