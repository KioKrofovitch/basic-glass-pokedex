package com.kiodev.basicglasspokedex;

/**
 * Pokemon
 */
public class Pokemon {

    String mName;
    String mType;
    int mImage;
    String mNote;

    public Pokemon (String name, String type, int img, String note) {
        this.mName = name;
        this.mType = type;
        this.mImage = img;
        this.mNote = note;
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

    public String getNote() {
        return mNote;
    }

    public void setNote(String note){
        mNote = note;
    }
}
