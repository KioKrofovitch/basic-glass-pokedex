package com.kiodev.basicglasspokedex;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

import java.util.ArrayList;

/**
 * Pokemon Detail
 */
public class PokemonDetailActivity extends Activity {

    public static final String TAG = PokemonDetailActivity.class.getSimpleName();
    public static final String EXTRA_POKEMON_TYPE = "com.kiodev.basicglasspokedex.extraPokemonType";

    private ArrayList<Card> mCards;
    private CardScrollView mCardScrollView;

    private String mType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mType = getIntent().getStringExtra(EXTRA_POKEMON_TYPE);

        createCards();

        mCardScrollView = new CardScrollView(this);
        CustomCardScrollAdapter adapter = new CustomCardScrollAdapter();

        mCardScrollView.setAdapter(adapter);

        mCardScrollView.activate();

        // Now set the content view, just like regular Android
        setContentView(mCardScrollView);
    }

    private void createCards() {
        mCards = new ArrayList<Card>();

        Card card;

        Log.d(TAG, "Type we seek: " + mType);

        for (Pokemon pk : PokemonIndex.get().getPokemon().values()) {
            Log.d(TAG, "value type is: " + pk.getType());
            if( pk.getType().equals(mType) ){
                Log.d(TAG, "Adding " + pk.getName());
                card = new Card(this);
                card.setText(pk.getName());
                card.setFootnote(pk.getNote());
                card.setImageLayout(Card.ImageLayout.LEFT);
                card.addImage(pk.getImage());
                mCards.add(card);
            }
        }
    }

    private class CustomCardScrollAdapter extends CardScrollAdapter {
        @Override
        public int getPosition( Object item ) {
            return mCards.indexOf(item);
        }

        @Override
        public int getCount() {
            return mCards.size();
        }

        @Override
        public Object getItem( int position ) {
            return mCards.get(position);
        }

        @Override
        public int getViewTypeCount() {
            return Card.getViewTypeCount();
        }

        @Override
        public int getItemViewType (int position) {
            return mCards.get(position).getItemViewType();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return mCards.get(position).getView(convertView, parent);
        }
    }

}
