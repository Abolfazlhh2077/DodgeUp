import java.util.ArrayList;

public class Human implements Interface {
    int lives = 3;
    int width = 15;
    int length = 25;

    public void loseCheck() {
        for (int i = 0; i < Main.blocks.size(); i++) {
            if (Main.pApplet.mouseX < Main.blocks.get(i).locX) {
                if (Main.blocks.get(i).locX - Main.pApplet.mouseX <= 15 && 650 - Main.blocks.get(i).locY <= 70 && 650 - Main.blocks.get(i).locY > 0) {
                    lives--;
                    Main.hitCounter++;
                    Main.blocks.remove(Main.blocks.get(i));

                }
            } else {

                if (Main.pApplet.mouseX - Main.blocks.get(i).locX <= 50 && 650 - Main.blocks.get(i).locY <= 70 && 650 - Main.blocks.get(i).locY > 0) {
                    lives--;
                    Main.hitCounter++;
                    Main.blocks.remove(Main.blocks.get(i));

                }
            }
        }
    }
    public void starCheck() {

        for (int i = 0; i < Main.stars.size(); i++) {
            if (Main.pApplet.mouseX < Main.stars.get(i).locX) {
                if (Main.stars.get(i).locX - Main.pApplet.mouseX <= 15 && 650 - Main.stars.get(i).locY <= 70 && 650 - Main.stars.get(i).locY > 0) {
                    Main.score+=10;

                    Main.stars.remove(Main.stars.get(i));

                }
            } else {

                if (Main.pApplet.mouseX - Main.stars.get(i).locX <= 50 && 650 - Main.stars.get(i).locY <= 70 && 650 - Main.stars.get(i).locY > 0) {
                    Main.score+=10;
                    Main.stars.remove(Main.stars.get(i));

                }
            }
        }
    }
    public void heartCheck() {
        for (int i = 0; i < Main.hearts.size(); i++) {
            if (Main.pApplet.mouseX < Main.hearts.get(i).locX) {
                if (Main.hearts.get(i).locX - Main.pApplet.mouseX <= 15 && 650 - Main.hearts.get(i).locY <= 70 && 650 - Main.hearts.get(i).locY > 0) {

                        lives++;
                    Main.hearts.remove(Main.hearts.get(i));

                }
            } else {

                if (Main.pApplet.mouseX - Main.hearts.get(i).locX <= 50 && 650 - Main.hearts.get(i).locY <= 70 && 650 - Main.hearts.get(i).locY > 0) {
                        lives++;

                    Main.hearts.remove(Main.hearts.get(i));

                }
            }
        }
    }
}

