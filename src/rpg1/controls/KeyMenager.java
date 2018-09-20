package rpg1.controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyMenager implements KeyListener {

    public boolean []keys;
    public boolean up,down,left,right;

    public KeyMenager(){
        keys = new boolean[256];
    }

    public void tick(){
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
    }

    @Override
    public void keyTyped(KeyEvent e){
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        System.out.println("pressed");
    }

    @Override
    public void keyReleased(KeyEvent e){
        keys[e.getKeyCode()] = false;
    }
}
