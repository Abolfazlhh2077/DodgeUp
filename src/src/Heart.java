import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Random;

public class Heart {
    public  static int speedY=-700;
    int locX;
    int locY;
    int length;
    int width;
    private static PApplet pApplet= Main.pApplet;



    public Heart(int locX, int locY) {
        this.locX = locX;
        this.locY = locY;

    }

    public static void makeHearts(){
        for (int i=0;i<4;i++){

            Main.hearts.add(new Heart(new Random().nextInt(1,850),speedY));
            speedY-=700;
            Main.hearts.add(new Heart(new Random().nextInt(1,850),speedY));
            speedY-=700;
            Main.hearts.add(new Heart(new Random().nextInt(1,850),speedY));
            speedY-=700;
            Main.hearts.add(new Heart(new Random().nextInt(1,850),speedY));
            speedY-=700;
        }
    }

    public int getLocX() {
        return locX;
    }

    public void setLocX(int locX) {
        this.locX = locX;
    }

    public int getLocY() {
        return locY;
    }

    public void setLocY(int locY) {
        this.locY = locY;
    }




    public static void showObject(ArrayList<Heart> hearts) {
        for (Heart heart: hearts) {
            pApplet.fill(0,255,0);
            pApplet.rect(heart.getLocX(),heart.getLocY(),25,30);
        }
    }


    public static void moveHeart(int speed) {
        for (Heart heart:Main.hearts) {
            heart.locY+=speed;
        }
    }

}
