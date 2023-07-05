import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Random;

public class Star {
    public  static int speedY=-300;
    int locX;
    int locY;
    int length;
    int width;
    private static PApplet pApplet= Main.pApplet;



    public Star(int locX, int locY) {
        this.locX = locX;
        this.locY = locY;

    }

    public static void makeStars(){
        for (int i=0;i<7;i++){

            Main.stars.add(new Star(new Random().nextInt(1,850),speedY));
            speedY-=400;
            Main.stars.add(new Star(new Random().nextInt(1,850),speedY));
            speedY-=400;
            Main.stars.add(new Star(new Random().nextInt(1,850),speedY));
            speedY-=400;
            Main.stars.add(new Star(new Random().nextInt(1,850),speedY));
            speedY-=400;
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




    public static void showObject(ArrayList<Star> stars) {
        for (Star star: stars) {
            pApplet.fill(255, 251, 0);
            pApplet.rect(star.getLocX(),star.getLocY(),30,25);
        }
    }


    public static void moveStar(int speed) {
        for (Star star:Main.stars) {
            star.locY+=speed;
        }
    }



}
