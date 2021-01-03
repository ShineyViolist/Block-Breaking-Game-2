package com.tg50624;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Block extends Rectangle {
    Image imga;
    boolean destroyed = false;
    int a;
    int b;

    Block(int x, int y, int w, int h, String s){
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        a = 3;
        b = 3;

        try{
            imga = ImageIO.read(new File("src/" + s));
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public void draw(Graphics g, Component c){
        //g.drawImage(imga,x,y,width,height,c);
        if(!destroyed){
            g.drawImage(imga,x,y,width,height,c);
        }
    }
}
