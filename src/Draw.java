import java.awt.*;
import java.util.Random;

public class Draw {
    Random rand = new Random();

    public void cardsDealt(int first, int second) {
        //gets a random suit
        int suit1 = rand.nextInt(4);
        int suit2 = rand.nextInt(4);

        String card1;
        String card2;
        //converts the number of card into string
        card1 = String.valueOf(first);
        card2 = String.valueOf(second);

        //prints the cards
        StdDraw.setPenColor(Color.white);
        StdDraw.filledRectangle(1,2,1,1.5);
        StdDraw.filledRectangle(3.5,2,1,1.5);

        //this checks the suit of the card and prints the suit accordingly on the screen of each card
        if (suit1 == 0) {
            String filename ="Heart.png";
            StdDraw.picture(1,2, filename, .5 ,.75);
        }
        if (suit1 == 1) {
                String filename ="Club.png";
                StdDraw.picture(1,2, filename, .5 ,.75);
        }
        if (suit1 == 2) {
            String filename ="Spade4.jpeg";
            StdDraw.picture(1,2, filename, .5 ,.75);
        }
        if (suit1 == 3) {
            String filename ="Diamond.png";
            StdDraw.picture(1,2, filename, .5 ,.75);
        }
        if (suit2 == 0) {
            String filename ="Heart.png";
            StdDraw.picture(3.5,2, filename, .5 ,.75);
        }
        if (suit2 == 1) {
            String filename ="Club.png";
            StdDraw.picture(3.5,2, filename, .5 ,.75);
        }
        if (suit2 == 2) {
            String filename ="Spade4.jpeg";
            StdDraw.picture(3.5,2, filename, .5 ,.75);
        }
        if (suit2 == 3) {
            String filename ="Diamond.png";
            StdDraw.picture(3.5,2, filename, .5 ,.75);
        }
        StdDraw.setPenColor(Color.black);

        //if the cards are face cards, then this changes the number to the letter
        if (first == 11) {
            StdDraw.text(1, 1, "J");
        }
        else if (first == 12) {
            StdDraw.text(1,1, "Q");
        }
        else if (first == 13) {
            StdDraw.text(1,1, "K");
        }
        else if (first == 1) {
            StdDraw.text(1,1, "K");
        } else {
            StdDraw.text(1,1, card1);
        }

        if (second == 11) {
            StdDraw.text(3.5, 1, "J");
        }
        else if (second == 12) {
            StdDraw.text(3.5,1, "Q");
        }
        else if (second == 13) {
            StdDraw.text(3.5,1, "K");
        }
        else if (second == 1) {
            StdDraw.text(3.5,1, "A");
        }
        else {
            StdDraw.text(3.5,1, card2);
        }
    }

    public void dealerCards(int second) {
        String card2;
        int suit1 = rand.nextInt(4);

        card2 = String.valueOf(second);

        //prints the flipped over dealer card
        String filename ="cardBack.png";
        StdDraw.picture(1,8, filename, 2 ,3);

        StdDraw.setPenColor(Color.white);

        //creates one face up card
        StdDraw.filledRectangle(3.5,8,1,1.5);

        //this checks the suit of the card and prints the suit accordingly on the screen of each card

        if (suit1 == 0) {
            String filename2 ="Heart.png";
            StdDraw.picture(3.5,8, filename2, .5 ,.75);
        }
        if (suit1 == 1) {
            String filename2 ="Club.png";
            StdDraw.picture(3.5,8, filename2, .5 ,.75);

        }
        if (suit1 == 2) {
            String filename2 ="Spade4.jpeg";
            StdDraw.picture(3.5,8, filename2, .5 ,.75);
        }
        if (suit1 == 3) {
            String filename2 ="Diamond.png";
            StdDraw.picture(3.5,8, filename2, .5 ,.75);
        }

        StdDraw.setPenColor(Color.black);

        //changes the number of face cards to the letter to print on the card
        if (second == 11) {
            StdDraw.text(3.5, 9, "J");
        }
        else if (second == 12) {
            StdDraw.text(3.5,9, "Q");
        }
        else if (second == 13) {
            StdDraw.text(3.5,9, "K");
        }
        else if (second == 1) {
            StdDraw.text(3.5,9, "A");
        }
        else {
            StdDraw.text(3.5,9, card2);
        }
}
    public void dealerFlip(int first) {
        int suit1 = rand.nextInt(4);
        String card1;

        //changes the number of face cards to the letter to print on the card

        if (first == 11) {
            card1 = "J";
        } else if (first == 12) {
            card1 = "Q";
        } else if (first == 13) {
            card1 = "K";
        } else if (first == 1) {
            card1 = "A";
        } else {
            card1 = String.valueOf(first);
        }

        //prints the flipped over dealer card when summoned
        StdDraw.setPenColor(Color.white);
        StdDraw.filledRectangle(1,8,1,1.5);
        StdDraw.setPenColor(Color.black);
        StdDraw.text(1,9, card1);

        //retrieves the suit of card and prints it on the screen
        if (suit1 == 0) {
            String filename ="Heart.png";
            StdDraw.picture(1,8, filename, .5 ,.75);
        }
        if (suit1 == 1) {
            String filename ="Club.png";
            StdDraw.picture(1,8, filename, .5 ,.75);

        }
        if (suit1 == 2) {
            String filename ="Spade4.jpeg";
            StdDraw.picture(1,8, filename, .5 ,.75);
        }
        if (suit1 == 3) {
            String filename ="Diamond.png";
            StdDraw.picture(1,8, filename, .5 ,.75);
        }
    }
    public void playerHit(int card, int count) {
        String card1;
        //changes the number of face cards to the letter to print on the card
        if (card == 11) {
            card1 = "J";
        } else if (card == 12) {
            card1 = "Q";
        } else if (card == 13) {
            card1 = "K";
        } else if (card == 1) {
            card1 = "A";
        } else {
            card1 = String.valueOf(card);
        }
        int suit1 = rand.nextInt(4);

        //prints the card to screen
        StdDraw.setPenColor(Color.white);
        StdDraw.filledRectangle(3.5 + count * 2.5,2,1,1.5);
        StdDraw.setPenColor(Color.black);
        StdDraw.text(3.5 + count * 2.5,1, card1);

        //gets suit and prints suit on the card
        if (suit1 == 0) {
            String filename ="Heart.png";
            StdDraw.picture(3.5 + count * 2.5,2, filename, .5 ,.75);
        }
        if (suit1 == 1) {
            String filename ="Club.png";
            StdDraw.picture(3.5 + count * 2.5,2, filename, .5 ,.75);
        }
        if (suit1 == 2) {
            String filename ="Spade4.jpeg";
            StdDraw.picture(3.5 + count * 2.5,2, filename, .5 ,.75);
        }
        if (suit1 == 3) {
            String filename ="Diamond.png";
            StdDraw.picture(3.5 + count * 2.5,2, filename, .5 ,.75);
        }
    }
    public void houseHits(int card, int count) {
        String card1;

        //changes the number of face cards to the letter to print on the card
        if (card == 11) {
            card1 = "J";
        } else if (card == 12) {
            card1 = "Q";
        } else if (card == 13) {
            card1 = "K";
        } else if (card == 1) {
            card1 = "A";
        } else {
            card1 = String.valueOf(card);
        }
        int suit1 = rand.nextInt(4);

        //prints the cards to the screen
        StdDraw.setPenColor(Color.white);
        StdDraw.filledRectangle(3.5 + count * 2.5,8,1,1.5);
        StdDraw.setPenColor(Color.black);
        StdDraw.text(3.5 + count * 2.5,9, card1);

        //prints suit on the card based on which card it is
        if (suit1 == 0) {
            String filename ="Heart.png";
            StdDraw.picture(3.5 + count * 2.5,8, filename, .5 ,.75);
        }
        if (suit1 == 1) {
            String filename ="Club.png";
            StdDraw.picture(3.5 + count * 2.5,8, filename, .5 ,.75);
        }
        if (suit1 == 2) {
            String filename ="Spade4.jpeg";
            StdDraw.picture(3.5 + count * 2.5,8, filename, .5 ,.75);
        }
        if (suit1 == 3) {
            String filename ="Diamond.png";
            StdDraw.picture(3.5 + count * 2.5,8, filename, .5 ,.75);
        }
    }
}


