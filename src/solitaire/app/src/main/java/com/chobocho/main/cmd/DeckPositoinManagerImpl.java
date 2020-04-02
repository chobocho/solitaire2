package com.chobocho.main.cmd;

import com.chobocho.card.Card;
import com.chobocho.command.CardPosition;
import com.chobocho.command.DeckPositoinManager;
import com.chobocho.deck.Deck;
import com.chobocho.solitaire.Solitare;

public class DeckPositoinManagerImpl extends DeckPositoinManager {
    final public static String TAG = "DeckPositoinManagerImpl";

    int width = 140;
    int height = 210;
    int cardCap = 30;

    public DeckPositoinManagerImpl() {
        super();
        init();
    }

    private void init() {
        for (int i = 0; i < 4; i++) {
            CardPosition deck = new CardPosition(Solitare.RESULT_DECK_1 + i, 0, 10 + (width + 10) * i, 10, (width + 10) * (i + 1), 10 + height);
            addDeckPosition(deck);
        }

        CardPosition playDeck = new CardPosition(Solitare.PLAY_DECK, 0, 70+width*6, 10, 70+width*7, 10 + height);
        addDeckPosition(playDeck);
        CardPosition openedDeck = new CardPosition(Solitare.OPENED_CARD_DECK, 0, 60+width*5, 10, 60+width*6, 10 + height);
        addDeckPosition(openedDeck);

        for (int i = 0; i < 6; i++) {
            CardPosition deck = new CardPosition(Solitare.BOARD_DECK_1 + i, 0, 10 + (width + 10) * i, 40 + height, (width + 10) * (i + 1), 40 + height*2);
            addCardPosition(deck);
        }
    }

    @Override
    public void initCardPosition(Solitare game) {
        clearCardPosition();

        if (!game.isPlayState()) {
            return;
        }

        for (int i = 0; i < 7; i++) {
            CardPosition deck = new CardPosition(Solitare.BOARD_DECK_1 + i, 0, 10 + (width + 10) * i, 20 + height, (width + 10) * (i + 1), 20 + height*2);
            addCardPosition(deck);
            Deck boardDeck = game.getDeck(Solitare.BOARD_DECK_1+i);
            if (boardDeck == null) {
                continue;
            }
            int cap = 0;
            int startY = 40;
            for (int j = boardDeck.size()-1, k = 0; j >= 0; j--, k++) {
                int deckNumber = Solitare.BOARD_DECK_1 + i;
                Card card = boardDeck.get(j);
                CardPosition pos;
                if (card.isOpen()) {
                    pos = new CardPosition(deckNumber, j, 10 + (width + 10) * i, startY + height + cap, (width + 10) * (i + 1), startY + height*2 + cap);
                    cap += cardCap*2;
                    addCardPosition(pos);
                } else {
                    // pos = new CardPosition(deckNumber, j, 10 + (width + 10) * i, startY + height + cap, (width + 10) * (i + 1), startY + height*2 + cap);
                    cap += cardCap;
                }
            }

        }
    }
}