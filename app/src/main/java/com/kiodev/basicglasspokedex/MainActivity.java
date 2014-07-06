package com.kiodev.basicglasspokedex;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.google.android.glass.app.Card;
import com.google.android.glass.media.Sounds;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

import java.util.ArrayList;


public class MainActivity extends Activity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private ArrayList<Card> mCards;
    private CardScrollView mCardScrollView;
    private ArrayList<String> mTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createCards();

        mCardScrollView = new CardScrollView(this);
        CustomCardScrollAdapter adapter = new CustomCardScrollAdapter();

        mCardScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "TAP!");

                // Play tap sound
                AudioManager audio = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
                audio.playSoundEffect(Sounds.TAP);

                // Kick off new Activity
                Intent intent = new Intent(MainActivity.this, PokemonDetailActivity.class);
                intent.putExtra(PokemonDetailActivity.EXTRA_POKEMON_TYPE, mTypes.get(position));
                startActivity(intent);
            }
        });

        mCardScrollView.setAdapter(adapter);

        mCardScrollView.activate();

        // Now set the content view, just like regular Android
        setContentView(mCardScrollView);

    }

    private void createCards() {
        mCards = new ArrayList<Card>();

        Card card;

        mTypes = PokemonIndex.get().getTypes();

        for(String type : mTypes){
            card = new Card(this);
            card.setText(type);
            card.setImageLayout(Card.ImageLayout.LEFT);
            mCards.add(card);
        }
    }

    private class CustomCardScrollAdapter extends CardScrollAdapter{
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
