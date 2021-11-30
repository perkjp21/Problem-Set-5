import java.awt.*;
import java.util.Random;

public class Draw {
    Random rand = new Random();
    public void cardsDealt(int first, int second) {
        int suit;
        String card1;
        String card2;
        card1 = String.valueOf(first);
        card2 = String.valueOf(second);


        StdDraw.rectangle(3.9,1.5,1,1.5);
        StdDraw.rectangle(6.1,1.5,1,1.5);
        if (first == 11) {
            StdDraw.text(3.9, 1, "Q");
        }
        else if (first == 12) {
            StdDraw.text(3.9,1, "K");
        }
        else if (first == 13) {
            StdDraw.text(3.9,1, "A");
        }
        else if (first == 10) {
            int a = rand.nextInt(2);
            if (a % 2 == 0) {
                StdDraw.text(3.9,1, "J");
            }
            else {
                StdDraw.text(3.9,1, card1);
            }

        }
        else {
            StdDraw.text(3.9,1, card1);
        }

        if (second == 11) {
            StdDraw.text(6.1, 1, "Q");
        }
        else if (second == 12) {
            StdDraw.text(6.1,1, "K");
        }
        else if (second == 13) {
            StdDraw.text(6.1,1, "A");
        }
        else if (second == 10) {
            int a = rand.nextInt(2);
            if (a % 2 == 0) {
                StdDraw.text(6.1,1, "J");
            }
            else {
                StdDraw.text(6.1,1, card2);
            }
        }
        else {
            StdDraw.text(6.1,1, card2);
        }

    }

    public void dealerCards(int second) {
        String card2;

        card2 = String.valueOf(second);


        StdDraw.rectangle(3.9,8.5,1,1.5);
        StdDraw.rectangle(6.1,8.5,1,1.5);

        if (second == 11) {
            StdDraw.text(6.1, 9, "Q");
        }
        else if (second == 12) {
            StdDraw.text(6.1,9, "K");
        }
        else if (second == 13) {
            StdDraw.text(6.1,9, "A");
        }
        else if (second == 10) {
            int a = rand.nextInt(2);
            if (a % 2 == 0) {
                StdDraw.text(6.1,9, "J");
            }
            else {
                StdDraw.text(6.1,9, card2);
            }
        }
        else {
            StdDraw.text(6.1,9, card2);
        }
}
    public void dealerFlip(int first) {
        String card1;
        card1 = String.valueOf(first);
        StdDraw.text(3.9,8.5, card1);
    }
    public void playerHit(int card) {
        String card1 = String.valueOf(card);
        StdDraw.rectangle(7.5,2.5,1,1.5);
        StdDraw.text(7.5,2, card1);
    }
    }


