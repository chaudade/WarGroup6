/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import ca.sheridancollege.project.Card.Rank;
import ca.sheridancollege.project.Card.Suit;
import java.util.ArrayList;

/**
 *
 * @author Adeem
 */

public class Deck extends GroupOfCards {
    public Deck() {
        super(52);
        this.cards = new ArrayList<>();
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                this.cards.add(new WarCard(s, r));
            }
        }
    }

    public WarCard draw() {
        if (!cards.isEmpty()) {
            return (WarCard) cards.remove(0);
        } else {
            return null;
        }
    }
}



