package com.tg50624;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class BlockPanel extends JPanel implements KeyListener {

    ArrayList <Block> blocks = new ArrayList <Block> ();

    Block ball = new Block(400,450, 40,40,"ball.png");

    Block paddle = new Block(100,750, 80,20, "paddle.png");

    BlockPanel(){
        for(int i = 0; i < 10; i++){
            blocks.add(new Block((i*60) + 5,15,80,30,"block1.png"));
            //System.out.println("here");
        }

        for(int i = 0; i < 10; i++){
            blocks.add(new Block((i*60) + 5,30,40,30,"block3.png"));
        }

        for(int i = 0; i < 10; i++){
            blocks.add(new Block((i*60) + 5,60,80,30,"block2.png"));
        }

        addKeyListener(this);
        setFocusable(true);
    }

    public void paintComponent(Graphics g){

        //super();
        System.out.println("here");

        blocks.forEach(block -> {
            block.draw(g,this);
        });


        ball.draw(g,this);

        paddle.draw(g,this);
    }

    public void update(){
        ball.x = ball.x + ball.a;
        ball.y += ball.b;
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Here too");
        if(e.getKeyCode() == KeyEvent.VK_ENTER){

            new Thread(() -> {
                while(true){
                    update();
                    try{
                        Thread.sleep(10);
                    }
                    catch(InterruptedException err){
                        err.printStackTrace();
                    }
                }
            }).start();
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            paddle.x += -10;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            paddle.x += 10;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
