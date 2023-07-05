import processing.core.PApplet;
import java.math.BigInteger;
import java.util.*;


public class Main extends PApplet {

    public  static  int locX=100;
    public static  int locY=100;
    public static int speed=5;
    public static PApplet pApplet;م
    public static  int counter =0;
    public static int hitCounter =0;
    public static  int score =0;
    public static int passedCounter =0;
    public static int highScore =0;

    public static ArrayList<Block> blocks=new ArrayList<>();
    public static ArrayList<Star> stars=new ArrayList<>();
    public static ArrayList<Heart> hearts=new ArrayList<>();
    DataCenter dataCenter = new DataCenter();

    public static void main(String[] args) {



        PApplet.main("Main",args);

    }
    boolean startMenu=true;
    boolean loseMenu=false;
    boolean game=false;
    boolean winMenu = false;
    Human human;
    public void setup(){
        DataCenter.loadHighScore();
        pApplet = this;
        Block.makeBlocks();
        background(128,0,0);
         human = new Human();
         Star.makeStars();
         Heart.makeHearts();

    }

    public  void settings(){
        size(900,700);
    }

    public void draw() {
        if(startMenu){
            background(0);
            fill(255);

            textSize(30);
            text("high score = "+ highScore,350,100);
            if(mouseX<200 && mouseX>150 && mouseY>250 && mouseY<300){
                fill(255,0,0);
            }else {
                fill(255);
            }
            textSize(50);
            text("play",150,300);
            if(mouseX<650 && mouseX>600 && mouseY>250 && mouseY<300){
                fill(0,0,255);
            }else {
                fill(255);
            }
            text("exit",600,300);

        }
        if(game) {


            background(255);
            text("lives ="+human.lives,10,50 );
            fill(0);
            text("score = "+score,370,50);
            Block.showObject(blocks);
            Block.moveBlock(speed);
            Star.showObject(stars);
            Star.moveStar(speed);
            Heart.showObject(hearts);
            Heart.moveHeart(speed);
            if(score>120){
                speed=13;
            }else if(score>90){
                speed=11;
            }else if(score>60){
                speed=10;
            }else if(score>30){
                speed=8;
            }
                fill(0, 0, 255);
            rect(mouseX, 650, human.width, human.width);
            human.loseCheck();
            human.heartCheck();
            human.starCheck();
            System.out.println(stars.size());

            if(human.lives<1){
                DataCenter.saveHighScore(score);
                game=false;
                loseMenu= true;
            }
            Block.finishedBlock();
            if(passedCounter+hitCounter==140){
                DataCenter.saveHighScore(score);
                game=false;
                winMenu=true;
            }
        }
        if(loseMenu){
            background(255,0,0);

            textSize(30);
            fill(255);
            text("score = "+ score,350,100);
            textSize(50);

            if(mouseX<300 && mouseX>150 && mouseY>250 && mouseY<300){
                fill(0,0,255);
            }else {
                fill(255);
            }
            text("replay",150,300);
            if(mouseX<650 && mouseX>600 && mouseY>250 && mouseY<300){
                fill(0,0,255);
            }else {
                fill(255);
            }
            text("exit",600,300);
        }
        if(winMenu){
            background(0,255,0);
            textSize(30);
            fill(255);
            text("score = "+ score,350,100);
            textSize(50);

            if(mouseX<300 && mouseX>150 && mouseY>250 && mouseY<300){
                fill(0,0,255);
            }else {
                fill(255);
            }
            text("replay",150,300);
            if(mouseX<650 && mouseX>600 && mouseY>250 && mouseY<300){
                fill(0,0,255);
            }else {
                fill(255);
            }
            text("exit",600,300);
        }


//        fill(165, 42, 42);
//        noStroke();
//        rect(100, 100, 150, 100);
//        fill(100, 42, 42);
//        noStroke();
//        circle(100, 400, 60);
//        stroke(209, 89, 187);
//        strokeWeight(10);
//        line(20, 600, 100, 600);
//        fill(0);
//        noStroke();
//        background(255);
//        rect(mouseX, mouseY, 50, 50);

        if (abs(mouseX-200)<50 && abs(locY-650)<75){
            System.out.println("fuck you!");
    }

        
    }

    @Override
    public void mousePressed() {
        if(startMenu){
            if(mouseX<200 && mouseX>150 && mouseY>250 && mouseY<300){
                startMenu = false;
                game = true;
            }
            if(mouseX<650 && mouseX>600 && mouseY>250 && mouseY<300){
                exit();
            }
        }
        if(loseMenu){
            if(mouseX<300 && mouseX>150 && mouseY>250 && mouseY<300){
                loseMenu = false;
                blocks = new ArrayList<>();
                passedCounter=0;
                counter=0;
                hitCounter=0;
                speed=3;
                score=0;
                stars = new ArrayList<>();
                hearts = new ArrayList<>();
                Block.speedY=-100;
                Heart.speedY=-1000;
                Star.speedY=-300;
                Block.makeBlocks();
                Star.makeStars();
                Heart.makeHearts();
                human = new Human();
                game = true;
            }
            if(mouseX<650 && mouseX>600 && mouseY>250 && mouseY<300){
                exit();
            }
        }
        if(winMenu){
            if(mouseX<300 && mouseX>150 && mouseY>250 && mouseY<300){
                winMenu = false;
                blocks = new ArrayList<>();
                counter=0;
                hitCounter=0;
                speed=3;
                passedCounter=0;
                stars = new ArrayList<>();
                hearts = new ArrayList<>();
                score=0;
                Block.speedY=-100;
                Heart.speedY=-1000;
                Star.speedY=-300;
                Block.makeBlocks();
                Star.makeStars();
                Heart.makeHearts();
                human = new Human();
                game = true;
            }
            if(mouseX<650 && mouseX>600 && mouseY>250 && mouseY<300){
                exit();
            }
        }
    }
}