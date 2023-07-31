/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author Adeem
 */
 public class WarPlayer extends Player {
    private ArrayList<WarCard> hand;

    public WarPlayer(String name) {
        super(name);
        this.hand = new ArrayList<>();
    }

    @Override
    public void play() {
        // This method might not be needed in this context, since play logic is in the game class
    }

    public void receiveCard(WarCard card) {
        this.hand.add(card);
    }

    public WarCard playCard() {
        return this.hand.remove(0);
    }

    public int getHandSize() {
        return this.hand.size();
    }
}

