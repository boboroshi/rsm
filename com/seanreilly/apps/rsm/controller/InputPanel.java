package com.seanreilly.apps.rsm.controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class InputPanel
  extends JPanel
  implements MouseListener,
             MouseMotionListener,
             KeyListener
{
  private Main main;
  private int lastX;
  private int lastY;
  private float width = -1;
  private float height = -1;

  public InputPanel(Main main) {
    this.main = main;
    
    lastX = -1;
    lastY = -1;
    
    addMouseListener(this);
    addMouseMotionListener(this);
    addKeyListener(this);
  }

  public void setVisible(boolean vis) {
    super.setVisible(vis);
    requestFocus();
  }

  public void reshape(int x, int y, int w, int h) {
    super.reshape(x, y, w, h);
    width = -1;
    height = -1;
  }
  
  public void mouseEntered(MouseEvent evt) {
    requestFocus();
  }

  public void mouseExited(MouseEvent evt) {
    main.setYValue(0);
    main.setXValue(0);
  }
  public void mouseClicked(MouseEvent evt) {}
  public void mousePressed(MouseEvent evt) {}
  public void mouseReleased(MouseEvent evt) {}

  public void mouseDragged(MouseEvent evt) {}
  public final void mouseMoved(MouseEvent evt) {
    if(width<=0 || height<=0) {
      Dimension sz = getSize();
      System.err.println("size: "+sz);
      width = sz.width;
      height = sz.height;
    }

    int newX = evt.getX();
    int newY = evt.getY();

    if(newY!=lastY) main.setYValue(newY/height);
    if(newX!=lastX) main.setXValue(newX/width);
    
    this.lastX = newX;
    this.lastY = newY;
    requestFocus();
  }


  public void keyPressed(KeyEvent evt) {
    switch(evt.getKeyCode()) {
    case KeyEvent.VK_W:
      main.setUseWave(true); break;
    case KeyEvent.VK_R:
      main.setReverseWave(true); break;
    case KeyEvent.VK_H:
      main.setHold(true); break;
    case KeyEvent.VK_S:
      main.setUseScratch(true); break;
    }
  }
  public void keyReleased(KeyEvent evt) {
    switch(evt.getKeyCode()) {
    case KeyEvent.VK_W:
      main.setUseWave(false); break;
    case KeyEvent.VK_R:
      main.setReverseWave(false); break;
    case KeyEvent.VK_H:
      main.setHold(false); break;
    case KeyEvent.VK_S:
      main.setUseScratch(false); break;
    }
  }
  public void keyTyped(KeyEvent evt) {}
}




