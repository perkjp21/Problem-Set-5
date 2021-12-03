/** This program creates a version of Blackjack where the computer is the dealer.
 * The game gives the dealer and player cards and asks the player if they want to hit
 * or stay. Also, they can play again if they win or lose. This program utilizes two ADTs
 * which are of the Draw and Game classes. The Game class simulates the blackjack game
 * and creates the numbers on the cards while the draw class draws everything on
 * the screen.
 * @ Authors: Reid Brown and Johnny Perkins
 */

import java.awt.*;
import java.util.Scanner;
import java.util.Random;

public class BlackJack {
    // things to add
    // fix ace issue
    // add stddraw stuff

    public static void printButtons() {
        //prints the buttons on the screen to hit or stay
        StdDraw.setPenColor(Color.blue);
        StdDraw.filledRectangle(0,-0.5,1.5,0.5);
        StdDraw.setPenColor(Color.white);
        StdDraw.text(0,-0.5,"Hit");

        StdDraw.setPenColor(Color.red);
        StdDraw.filledRectangle(4,-0.5,1.5,0.5);
        StdDraw.setPenColor(Color.white);
        StdDraw.text(4,-0.5,"Stay");
    }

    public static void main(String[] args) {
        //creates variable types
        Scanner scnr = new Scanner(System.in);
        Random rndm = new Random();
        Game game = new Game();

        int playerTotal = 0;
        int houseTotal = 0;
        int playerCard1, playerCard2, houseCard1, houseCard2, card;
        int result;
        int count = 0;
        char response = 'z';
        boolean gameOver = false;
        Draw draw = new Draw();

        //creates the canvas
        StdDraw.setCanvasSize(600, 600);
        StdDraw.setScale(-2, 14);
        StdDraw.clear(new Color(0,100,0));

        printButtons();

        String filename ="cardBack.png";
        StdDraw.picture(5,5, filename, 2 ,3);

        int[][] deck = new int[4][13];

        game.resetDeck(deck);
        // begin game
        houseCard1 = game.returnActualCard(deck);
        houseTotal += game.cardBJValue(houseCard1);
        playerCard1 = game.returnActualCard(deck); // first card
        playerTotal += game.cardBJValue(playerCard1);
        houseCard2 = game.returnActualCard(deck);
        houseTotal += game.cardBJValue(houseCard2);
        playerCard2 = game.returnActualCard(deck); // second card
        playerTotal += game.cardBJValue(playerCard2);

        //draw cards to screen
        draw.cardsDealt(playerCard1,playerCard2);
        draw.dealerCards(houseCard1);

        //prints to terminal what cards are on the screen
        System.out.println("player has: " + playerCard1 + ", " + playerCard2 + " with a total of " + playerTotal);
        System.out.println("house is showing " + houseCard1);
        result = game.seeIfResult(playerTotal);
        //determines second step of game
        if (result == 1) {
            System.out.println("Type h for hit or s for stay");
        } else if (result == 3) {
            draw.dealerFlip(houseCard2);
            System.out.println("Blackjack!");
            // technically could be situation where dealer has bj as well but will deal with that later
        }
        double x = 0;
        double y = 0;
        //response = scnr.next().charAt(0);

        //response = returnClick();
        while (true) {
            //asks if the mouse is clicked
            if (StdDraw.isMousePressed()) {
                //captures click location
                x = StdDraw.mouseX();
                y = StdDraw.mouseY();

                //click must be inside these areas
                if (x < 1.5 && x > -1.5 && y > -1 && y < 0) {
                    System.out.println("hit");
                    response = 'h';
                } else if (x < 4.5 && x > 2.5 && y > -1 && y < 0) {
                    System.out.println("stay");
                    response = 's';
                } else {

                }
                StdDraw.pause(100);

                if (response == 'h' && playerTotal < 21) {
                    //summons another card
                    card = game.returnActualCard(deck);
                    playerTotal += game.cardBJValue(card);
                    result = game.seeIfResult(playerTotal);
                    count++;
                    //draws the new cards to screen
                    draw.playerHit(card, count);
                    //gives the player their options
                    if (result == 1) {
                        System.out.println("You got a " + card + " you now have " + playerTotal);
                        System.out.println("Type h for hit or s for stay");
                    } else if (result == 2) {
                        //flips dealer's second card
                        draw.dealerFlip(houseCard2);
                        System.out.println("You busted with " + playerTotal + ". House Wins");
                        StdDraw.setPenColor(Color.white);
                        StdDraw.text(3,10,"You busted with " + playerTotal + ". House wins!");
                        gameOver = true;
                    } else if (result == 3) {
                        System.out.println("You have 21");
                    }
                    //if the user stays
                } else if (response == 's') {
                    draw.dealerFlip(houseCard2);
                    System.out.println("house card 1 is " + houseCard1);
                    System.out.println("The dealers second card was a " + houseCard2 + " and has a total of " + houseTotal);
                    int i = 0;

                    //as long as the house has under 17 they hit
                    while (houseTotal < 17) {
                        i++;
                        //determines if the house is going to hit or stay
                        card = game.returnActualCard(deck);
                        draw.houseHits(card, i);
                        houseTotal += game.cardBJValue(card);
                        System.out.println("house got " + card + " and now has " + houseTotal);
                    }
                    if (houseTotal <= 21) {
                        //determines winner of the game
                        if (houseTotal > playerTotal) {
                            System.out.println("House wins");
                            StdDraw.setPenColor(Color.white);
                            StdDraw.text(3,10,"House wins with " + houseTotal);
                            gameOver = true;
                        } else if (houseTotal == playerTotal) {
                            //if there is a tie
                            System.out.println("Push");
                            StdDraw.setPenColor(Color.white);
                            StdDraw.text(3,10,"Player and house both have" + playerTotal + ". Push!");
                            gameOver = true;
                        } else {
                            //if the player has more than the dealer
                            System.out.println("Player Wins");
                            StdDraw.setPenColor(Color.white);
                            StdDraw.text(3,10,"Player wins with " + playerTotal);

                            gameOver = true;
                        }
                    } else {
                        System.out.println("House busts, player wins");
                        StdDraw.setPenColor(Color.white);
                        StdDraw.text(3,10,"House busts, with " + houseTotal + " you win!");
                        gameOver = true;
                    }
                }
                if (gameOver) {
                    //asks if the player wants to play again
                    System.out.println("Would you like to play again? Type y or n");
                    response = scnr.next().charAt(0);
                    if (response == 'y') {
                        //if the player plays again, this resets the game
                        StdDraw.clear(new Color(0, 100, 0));
                        game.resetDeck(deck);
                        playerTotal = 0;
                        houseTotal = 0;
                        count = 0;

                        // begin game
                        houseCard1 = game.returnActualCard(deck);
                        houseTotal += game.cardBJValue(houseCard1);
                        playerCard1 = game.returnActualCard(deck); // first card
                        playerTotal += game.cardBJValue(playerCard1);
                        houseCard2 = game.returnActualCard(deck);
                        houseTotal += game.cardBJValue(houseCard2);
                        playerCard2 = game.returnActualCard(deck); // second card
                        playerTotal += game.cardBJValue(playerCard2);

                        //draws everything to the screen
                        draw.cardsDealt(playerCard1, playerCard2);
                        draw.dealerCards(houseCard1);
                        //prints hit and stay
                        printButtons();
                        StdDraw.picture(5,5, filename, 2 ,3);
                        gameOver = false;

                        System.out.println("player has: " + playerCard1 + ", " + playerCard2 + " with a total of " + playerTotal);
                        System.out.println("house is showing " + houseCard1);
                        result = game.seeIfResult(playerTotal);
                        if (result == 1) {
                            System.out.println("Type h for hit or s for stay");
                        } else if (result == 3) {
                            System.out.println("Blackjack!");
                        }
                        //response = scnr.next().charAt(0);
                    } else if (response == 'n') {
                        break;
                    }
                }
            }
        }
    }
}
