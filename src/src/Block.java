import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Random;

public class Block extends PApplet {

    public  static int speedY=-100;
    int locX;
    int locY;
    int length;
    int width;
    private static PApplet pApplet= Main.pApplet;



    public Block(int locX, int locY) {
        this.locX = locX;
        this.locY = locY;

    }

    public static void makeBlocks(){
        for (int i=0;i<35;i++){
            Main.blocks.add(new Block(new Random().nextInt(1,850),speedY));
            speedY-=90;
            Main.blocks.add(new Block(new Random().nextInt(1,850),speedY));
            speedY-=90;
            Main.blocks.add(new Block(new Random().nextInt(1,850),speedY));
            speedY-=90;
            Main.blocks.add(new Block(new Random().nextInt(1,850),speedY));
            speedY-=90;
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




    public static void showObject(ArrayList<Block> blocks) {
        for (Block block: blocks) {
            pApplet.fill(0);
            pApplet.rect(block.getLocX(),block.getLocY(),50,70);
        }
    }


    public static void moveBlock(int speed) {
        for (Block block:Main.blocks) {
            block.locY+=speed;
        }
    }
    public static  void finishedBlock(){

        for(int i=0;i<Main.blocks.size();i++){
            if(Main.blocks.get(i).locY>700){
                Main.passedCounter++;
                Main.score++;
                Main.blocks.remove(i);
            }
        }
    }


}
