package com.kiodev.basicglasspokedex;

import android.app.Activity;
import android.os.Bundle;
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

    private ArrayList<Card> mCards;
    private CardScrollView mCardScrollView;

    public static final String TAG = PokemonDetailActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        card = new Card(this);
        card.setText("POKEMON!!");
        card.setImageLayout(Card.ImageLayout.LEFT);
        card.addImage(R.drawable.ic_launcher);
        mCards.add(card);

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