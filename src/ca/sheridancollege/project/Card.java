/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 */
public abstract class Card {
    enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES;
    }

    enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9),
        TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);

        private final int cardValue;

        Rank(int value) {
            this.cardValue = value;
        }

        public int getCardValue() {
            return cardValue;
        }
    }

    @Override
    public abstract String toString();
}
