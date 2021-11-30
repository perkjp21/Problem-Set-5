import java.awt.*;
import java.util.Scanner;
import java.util.Random;

public class BlackJack {
    static boolean playerStillPlaying = true;

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Random rndm = new Random();
        Game game = new Game();
        int playerTotal = 0;
        int houseTotal = 0;
        int playerCard1, playerCard2, houseCard1, houseCard2, card;
        int result;
        char response;
        boolean gameOver = false;
        Draw draw = new Draw();

        StdDraw.setCanvasSize(500, 500);
        StdDraw.setScale(0, 10);
        StdDraw.clear(new Color(0,100,0));
        //String filename ="cardBack.png";
        //StdDraw.picture(5,5, filename, 2 ,3);

        int[][] deck = new int[4][13];

        game.resetDeck(deck);
        // begin game, will make into method in a little
        houseCard1 = game.returnActualCard(deck);
        houseTotal += game.cardBJValue(houseCard1);
        playerCard1 = game.returnActualCard(deck); // first card
        playerTotal += game.cardBJValue(playerCard1);
        houseCard2 = game.returnActualCard(deck);
        houseTotal += game.cardBJValue(houseCard2);
        playerCard2 = game.returnActualCard(deck); // second card
        playerTotal += game.cardBJValue(playerCard2);

        // will add specifics later

        //draw cards to screen
        draw.cardsDealt(playerCard1,playerCard2);
        draw.dealerCards(houseCard1);


        System.out.println("player has: " + playerCard1 + ", " + playerCard2 + " with a total of " + playerTotal);
        System.out.println("house is showing " + houseCard1);
        result = game.seeIfResult(playerTotal);
        if (result == 1) {
            System.out.println("Type h for hit or s for stay");
        } else if (result == 3) {
            draw.dealerFlip(houseCard2);
            System.out.println("Blackjack!");
            // technically could be situation where dealer has bj as well but will deal with that later
        }
        response = scnr.next().charAt(0);

        while (true) {
            //hit counter
            int count = 0;
            if (response == 'h' && playerTotal < 21) {
                card = game.returnActualCard(deck);
                playerTotal += game.cardBJValue(card);
                result = game.seeIfResult(playerTotal);
                count++;
                draw.playerHit(card, count);
                if (result == 1) {
                    System.out.println("You got a " + card + " you now have " + playerTotal);
                    System.out.println("Type h for hit or s for stay");
                    response = scnr.next().charAt(0);
                } else if (result == 2) {
                    draw.dealerFlip(houseCard2);
                    System.out.println("You busted with " + playerTotal + ". Dealer Wins");
                    gameOver = true;
                } else if (result == 3) {
                    System.out.println("You have 21");
                }
            } else if (response == 's') {
                draw.dealerFlip(houseCard2);
                System.out.println("The dealers second card was a " + houseCard2 + " and has a total of " + houseTotal);
                int i = 0;
                while (houseTotal < 17) {
                    i++;
                    card = game.returnActualCard(deck);
                    draw.houseHits(card, i);
                    houseTotal += game.cardBJValue(card);
                    System.out.println("house got " + card + " and now has " + houseTotal);
                }
                if (houseTotal <= 21) {
                    if (houseTotal > playerTotal) {
                        System.out.println("House wins");
                        gameOver = true;
                    } else if (houseTotal == playerTotal) {
                        System.out.println("Push");
                        gameOver = true;
                    } else {
                        System.out.println("Player Wins");
                        gameOver = true;
                    }
                } else {
                    System.out.println("House busts, player wins");
                    gameOver = true;
                }
            }
            if (gameOver) {
                System.out.println("Would you like to play again? Type y or n");
                response = scnr.next().charAt(0);
                if (response == 'y') {
                    StdDraw.clear(new Color(0,100,0));
                    game.resetDeck(deck);
                    playerTotal = 0;
                    houseTotal = 0;
                    // begin game, will make into method in a little
                    houseCard1 = game.returnActualCard(deck);
                    houseTotal += game.cardBJValue(houseCard1);
                    playerCard1 = game.returnActualCard(deck); // first card
                    playerTotal += game.cardBJValue(playerCard1);
                    houseCard2 = game.returnActualCard(deck);
                    houseTotal += game.cardBJValue(houseCard2);
                    playerCard2 = game.returnActualCard(deck); // second card
                    playerTotal += game.cardBJValue(playerCard2);
                    gameOver = false;

                    System.out.println("player has: " + playerCard1 + ", " + playerCard2 + " with a total of " + playerTotal);
                    System.out.println("house is showing " + houseCard1);
                    result = game.seeIfResult(playerTotal);
                    if (result == 1) {
                        System.out.println("Type h for hit or s for stay");
                    } else if (result == 3) {
                        System.out.println("Blackjack!");
                        // technically could be situation where dealer has bj as well but will deal with that later
                    }
                    response = scnr.next().charAt(0);
                } else if (response == 'n') {
                    break;
                }
            }
        }





    }
}