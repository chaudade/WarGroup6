/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Adeem
 */
class WarCard extends Card {
    protected Card.Suit suit;
    protected Card.Rank rank;

    public WarCard(Card.Suit suit, Card.Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    public Card.Rank getRank() {
        return rank;
    }
}
