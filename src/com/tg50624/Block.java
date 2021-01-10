package com.tg50624;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Block extends Rectangle {
    Image img;
    int a, b;

    Block(int x,int y, int width, int height, String s){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        a = 10;
        b = 10;

        try{
            img = ImageIO.read(new File("C:\\Users\\17185\\IdeaProjects\\Networking\\3\\Block Breaking Game Restart\\src\\" + s));
            //System.out.println(img);
        }

        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics g, Component c){
        g.drawImage(img,x,y,width, height,c);
    }
}

