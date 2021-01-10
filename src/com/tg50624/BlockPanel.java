package com.tg50624;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class BlockPanel extends JPanel implements KeyListener {
    ArrayList<Block> blocks = new ArrayList<Block>();
    Block ball = new Block(400,450, 40,40,"ball.png");
    Block paddle = new Block(100,750,70,20,"paddle.png");

    BlockPanel(){
        for(int i = 0; i < 5; i++){
            blocks.add(new Block(i + 50, 20,40,20,"block1.png"));
        }

        addKeyListener(this);
        setFocusable(true);
    }

    public void update(){
        ball.x += ball.a;
        ball.y += ball.b;
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            new Thread(() -> {
                while(true){
                    update();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
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

    public void paintComponent(Graphics g){
        blocks.forEach(block -> {
            block.draw(g,this);
        });
        //System.out.println("Hello");
        ball.draw(g,this);
        paddle.draw(g,this);
    }
}
