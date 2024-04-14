package com.example.cardshuffling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cardshuffling.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ImageView card;
    private Button buttonShuffle;
    private TextView txtRankAndSuit;
    private int[] deck;
    private ActivityMainBinding binding;
    int[] clubs = {R.drawable.clubsace, R.drawable.clubs2, R.drawable.clubs3, R.drawable.clubs4,
            R.drawable.clubs5, R.drawable.clubs6, R.drawable.clubs7, R.drawable.clubs8,
            R.drawable.clubs9, R.drawable.clubs10, R.drawable.clubsjack, R.drawable.clubsqueen
            , R.drawable.clubsking};
    int[] diamonds = {R.drawable.diamondsace, R.drawable.diamonds2, R.drawable.diamonds3,
            R.drawable.diamonds4, R.drawable.diamonds5, R.drawable.diamonds6,
            R.drawable.diamonds7, R.drawable.diamonds8, R.drawable.diamonds9, R.drawable.diamonds10,
            R.drawable.diamondsjack, R.drawable.diamondsqueen, R.drawable.diamondsking};
    int[] hearts = {R.drawable.heartsace, R.drawable.hearts2, R.drawable.hearts3,
            R.drawable.hearts4, R.drawable.hearts5, R.drawable.hearts6,
            R.drawable.hearts7, R.drawable.hearts8, R.drawable.hearts9,
            R.drawable.hearts10, R.drawable.heartsjack, R.drawable.heartsqueen, R.drawable.heartsking};
    int[] spades = {R.drawable.spadesace, R.drawable.spades2, R.drawable.spades3,
            R.drawable.spades4, R.drawable.spades5, R.drawable.spades6,
            R.drawable.spades7, R.drawable.spades8, R.drawable.spades9, R.drawable.spades10,
            R.drawable.spadesjack, R.drawable.spadesqueen, R.drawable.spadesking};
    String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);

        card = findViewById(R.id.imageView1);
        deck = new int[52];
        buttonShuffle = binding.button;
        txtRankAndSuit = binding.txtSuitAndRank;
        buttonShuffle.setOnClickListener(view1 -> chooseCard());


    }

    public void chooseCard() {
        //initialize the deck

        for (int i = 0; i < 52; i++) {
            deck[i] = i;
        }

        //shuffle the deck
        shuffleTheDeck();

        //index to pick a card
        int index = (int) (Math.random() * deck.length);
        //suit index
        int suit = (int) (Math.random() * 4);
        //rank index to set the textview
        String rank = ranks[deck[index] % 13];

        switch (suit) {

            case 0:
                card.setImageResource(spades[deck[index] % 13]);
                txtRankAndSuit.setText(getResources().getString(R.string.spades).concat("-").concat(rank));
                break;
            case 1:
                card.setImageResource(hearts[deck[index] % 13]);
                txtRankAndSuit.setText(getResources().getString(R.string.hearts).concat("-").concat(rank));
                break;
            case 2:
                card.setImageResource(diamonds[deck[index] % 13]);
                txtRankAndSuit.setText(getResources().getString(R.string.diamonds).concat("-").concat(rank));
                break;
            case 3:
                card.setImageResource(clubs[deck[index] % 13]);
                txtRankAndSuit.setText(getResources().getString(R.string.clubs).concat("-").concat(rank));
                break;
            default:
                break;

        }

    }

    private void shuffleTheDeck() {

        for (int i = 0; i < deck.length; i++) {
            int index = (int) (Math.random() * deck.length);

            int temp = deck[i];
            deck[i] = deck[index];
            deck[index] = temp;

        }
    }
}