package xiangqi;

import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Xiangqi implements MouseListener {
    
    
    JFrame j = new JFrame();
    JPanel p = new JPanel();
    JPanel pp = new JPanel();
    Graphics g = null;
    Graphics g2 = null;
    
    
    Point canonBlack, canonBlack2, rookBlack, rookBlack2, longKnightBlack,
        longKnightBlack2, knightBlack, knightBlack2, guardBlack, guardBlack2,
        kingBlack, pawnBlack, pawnBlack2, pawnBlack3, pawnBlack4, pawnBlack5;

    Point canonRed, canonRed2, rookRed, rookRed2, longKnightRed,
        longKnightRed2, knightRed, knightRed2, guardRed, guardRed2,
        kingRed, pawnRed, pawnRed2, pawnRed3, pawnRed4, pawnRed5;

    
    int xx = -10, yy = -10;
    
    int X = -10, Y = -10;
    
    int press = 0;
    
    int selectedX = -10, selectedY = -10;
    
    
    class Point {
        
        int x, y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    
    public Xiangqi() {
        setGUI();

        initBoard();
        
        paintBoard();

        Thread t = new Thread() {
            public void run() {
                refresh();
            }
        };
        t.start();
        
        j.addMouseListener(this);
    }

    void initBoard() {
        rookRed = new Point(0, 9);
        knightRed = new Point(1, 9);
        longKnightRed = new Point(2, 9);
        guardRed = new Point(3, 9);
        guardRed2 = new Point(5, 9);
        kingRed = new Point(4, 9);
        longKnightRed2 = new Point(6, 9);
        knightRed2 = new Point(7, 9);
        rookRed2 = new Point(8, 9);
        canonRed = new Point(1, 7);
        canonRed2 = new Point(7, 7);
        pawnRed = new Point(0, 6);
        pawnRed2 = new Point(2, 6);
        pawnRed3 = new Point(4, 6);
        pawnRed4 = new Point(6, 6);
        pawnRed5 = new Point(8, 6);


        rookBlack = new Point(0, 0);
        knightBlack = new Point(1, 0);
        longKnightBlack = new Point(2, 0);
        guardBlack = new Point(3, 0);
        guardBlack2 = new Point(5, 0);
        kingBlack = new Point(4, 0);
        longKnightBlack2 = new Point(6, 0);
        knightBlack2 = new Point(7, 0);
        rookBlack2 = new Point(8, 0);
        canonBlack = new Point(1, 2);
        canonBlack2 = new Point(7, 2);
        pawnBlack = new Point(0, 3);
        pawnBlack2 = new Point(2, 3);
        pawnBlack3 = new Point(4, 3);
        pawnBlack4 = new Point(6, 3);
        pawnBlack5 = new Point(8, 3);

    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

        if(press == 0) {

            X = (int)((double)e.getX()/(double)90);
            Y = (int)((double)e.getY()/(double)90);
            
            selectedX = X;
            selectedY = Y;
            
            press = 1;
            refresh();
        } else if(press == 1) {
            
            selectedX = -10;
            selectedY = -10;

            xx = (int)((double)e.getX()/(double)90);
            yy = (int)((double)e.getY()/(double)90);

            if(rookBlack.x == xx && rookBlack.y == yy) {
                rookBlack.x = -1000;
                rookBlack.y = yy;
            }
            if(rookBlack2.x == xx && rookBlack2.y == yy) {
                rookBlack2.x = -1000;;
                rookBlack2.y = yy;
            }
            if(longKnightBlack.x == xx && longKnightBlack.y == yy) {
                longKnightBlack.x = -1000;;
                longKnightBlack.y = yy;
            }
            if(longKnightBlack2.x == xx && longKnightBlack2.y == yy) {
                longKnightBlack2.x = -1000;;
                longKnightBlack2.y = yy;
            }
            if(knightBlack.x == xx && knightBlack.y == yy) {
                knightBlack.x = -1000;;
                knightBlack.y = yy;
            }
            if(knightBlack2.x == xx && knightBlack2.y == yy) {
                knightBlack2.x = -1000;;
                knightBlack2.y = yy;
            }
            if(guardBlack.x == xx && guardBlack.y == yy) {
                guardBlack.x = -1000;;
                guardBlack.y = yy;
            }
            if(guardBlack2.x == xx && guardBlack2.y == yy) {
                guardBlack2.x = -1000;;
                guardBlack2.y = yy;
            }
            if(canonBlack.x == xx && canonBlack.y == yy) {
                canonBlack.x = -1000;;
                canonBlack.y = yy;
            }
            if(canonBlack2.x == xx && canonBlack2.y == yy) {
                canonBlack2.x = -1000;;
                canonBlack2.y = yy;
            }
            if(pawnBlack.x == xx && pawnBlack.y == yy) {
                pawnBlack.x = -1000;;
                pawnBlack.y = yy;
            }
            if(pawnBlack2.x == xx && pawnBlack2.y == yy) {
                pawnBlack2.x = -1000;;
                pawnBlack2.y = yy;
            }
            if(pawnBlack3.x == xx && pawnBlack3.y == yy) {
                pawnBlack3.x = -1000;;
                pawnBlack3.y = yy;
            }
            if(pawnBlack4.x == xx && pawnBlack4.y == yy) {
                pawnBlack4.x = -1000;;
                pawnBlack4.y = yy;
            }
            if(pawnBlack5.x == xx && pawnBlack5.y == yy) {
                pawnBlack5.x = -1000;;
                pawnBlack5.y = yy;
            }
            if(rookRed.x == xx && rookRed.y == yy) {
                rookRed.x = -1000;;
                rookRed.y = yy;
            }
            if(rookRed2.x == xx && rookRed2.y == yy) {
                rookRed2.x = -1000;;
                rookRed2.y = yy;
            }
            if(longKnightRed.x == xx && longKnightRed.y == yy) {
                longKnightRed.x = -1000;;
                longKnightRed.y = yy;
            }
            if(longKnightRed2.x == xx && longKnightRed2.y == yy) {
                longKnightRed2.x = -1000;;
                longKnightRed2.y = yy;
            }
            if(knightRed.x == xx && knightRed.y == yy) {
                knightRed.x = -1000;;
                knightRed.y = yy;
            }
            if(knightRed2.x == xx && knightRed2.y == yy) {
                knightRed2.x = -1000;;
                knightRed2.y = yy;
            }
            if(guardRed.x == xx && guardRed.y == yy) {
                guardRed.x = -1000;;
                guardRed.y = yy;
            }
            if(guardRed2.x == xx && guardRed2.y == yy) {
                guardRed2.x = -1000;;
                guardRed2.y = yy;
            }
            if(canonRed.x == xx && canonRed.y == yy) {
                canonRed.x = -1000;;
                canonRed.y = yy;
            }
            if(canonRed2.x == xx && canonRed2.y == yy) {
                canonRed2.x = -1000;;
                canonRed2.y = yy;
            }
            if(pawnRed.x == xx && pawnRed.y == yy) {
                pawnRed.x = -1000;;
                pawnRed.y = yy;
            }
            if(pawnRed2.x == xx && pawnRed2.y == yy) {
                pawnRed2.x = -1000;;
                pawnRed2.y = yy;
            }
            if(pawnRed3.x == xx && pawnRed3.y == yy) {
                pawnRed3.x = -1000;;
                pawnRed3.y = yy;
            }
            if(pawnRed4.x == xx && pawnRed4.y == yy) {
                pawnRed4.x = -1000;;
                pawnRed4.y = yy;
            }
            if(pawnRed5.x == xx && pawnRed5.y == yy) {
                pawnRed5.x = -1000;;
                pawnRed5.y = yy;
            }
            if(kingRed.x == xx && kingRed.y == yy) {
                kingRed.x = -1000;;
                kingRed.y = yy;
            }
            if(kingBlack.x == xx && kingBlack.y == yy) {
                kingBlack.x = -1000;;
                kingBlack.y = yy;
            }

            if(rookBlack.x == X && rookBlack.y == Y) {
                rookBlack.x = xx;
                rookBlack.y = yy;
            }
            if(rookBlack2.x == X && rookBlack2.y == Y) {
                rookBlack2.x = xx;
                rookBlack2.y = yy;
            }
            if(longKnightBlack.x == X && longKnightBlack.y == Y) {
                longKnightBlack.x = xx;
                longKnightBlack.y = yy;
            }
            if(longKnightBlack2.x == X && longKnightBlack2.y == Y) {
                longKnightBlack2.x = xx;
                longKnightBlack2.y = yy;
            }
            if(knightBlack.x == X && knightBlack.y == Y) {
                knightBlack.x = xx;
                knightBlack.y = yy;
            }
            if(knightBlack2.x == X && knightBlack2.y == Y) {
                knightBlack2.x = xx;
                knightBlack2.y = yy;
            }
            if(guardBlack.x == X && guardBlack.y == Y) {
                guardBlack.x = xx;
                guardBlack.y = yy;
            }
            if(guardBlack2.x == X && guardBlack2.y == Y) {
                guardBlack2.x = xx;
                guardBlack2.y = yy;
            }
            if(canonBlack.x == X && canonBlack.y == Y) {
                canonBlack.x = xx;
                canonBlack.y = yy;
            }
            if(canonBlack2.x == X && canonBlack2.y == Y) {
                canonBlack2.x = xx;
                canonBlack2.y = yy;
            }
            if(pawnBlack.x == X && pawnBlack.y == Y) {
                pawnBlack.x = xx;
                pawnBlack.y = yy;
            }
            if(pawnBlack2.x == X && pawnBlack2.y == Y) {
                pawnBlack2.x = xx;
                pawnBlack2.y = yy;
            }
            if(pawnBlack3.x == X && pawnBlack3.y == Y) {
                pawnBlack3.x = xx;
                pawnBlack3.y = yy;
            }
            if(pawnBlack4.x == X && pawnBlack4.y == Y) {
                pawnBlack4.x = xx;
                pawnBlack4.y = yy;
            }
            if(pawnBlack5.x == X && pawnBlack5.y == Y) {
                pawnBlack5.x = xx;
                pawnBlack5.y = yy;
            }
            if(rookRed.x == X && rookRed.y == Y) {
                rookRed.x = xx;
                rookRed.y = yy;
            }
            if(rookRed2.x == X && rookRed2.y == Y) {
                rookRed2.x = xx;
                rookRed2.y = yy;
            }
            if(longKnightRed.x == X && longKnightRed.y == Y) {
                longKnightRed.x = xx;
                longKnightRed.y = yy;
            }
            if(longKnightRed2.x == X && longKnightRed2.y == Y) {
                longKnightRed2.x = xx;
                longKnightRed2.y = yy;
            }
            if(knightRed.x == X && knightRed.y == Y) {
                knightRed.x = xx;
                knightRed.y = yy;
            }
            if(knightRed2.x == X && knightRed2.y == Y) {
                knightRed2.x = xx;
                knightRed2.y = yy;
            }
            if(guardRed.x == X && guardRed.y == Y) {
                guardRed.x = xx;
                guardRed.y = yy;
            }
            if(guardRed2.x == X && guardRed2.y == Y) {
                guardRed2.x = xx;
                guardRed2.y = yy;
            }
            if(canonRed.x == X && canonRed.y == Y) {
                canonRed.x = xx;
                canonRed.y = yy;
            }
            if(canonRed2.x == X && canonRed2.y == Y) {
                canonRed2.x = xx;
                canonRed2.y = yy;
            }
            if(pawnRed.x == X && pawnRed.y == Y) {
                pawnRed.x = xx;
                pawnRed.y = yy;
            }
            if(pawnRed2.x == X && pawnRed2.y == Y) {
                pawnRed2.x = xx;
                pawnRed2.y = yy;
            }
            if(pawnRed3.x == X && pawnRed3.y == Y) {
                pawnRed3.x = xx;
                pawnRed3.y = yy;
            }
            if(pawnRed4.x == X && pawnRed4.y == Y) {
                pawnRed4.x = xx;
                pawnRed4.y = yy;
            }
            if(pawnRed5.x == X && pawnRed5.y == Y) {
                pawnRed5.x = xx;
                pawnRed5.y = yy;
            }
            if(kingRed.x == X && kingRed.y == Y) {
                kingRed.x = xx;
                kingRed.y = yy;
            }
            if(kingBlack.x == X && kingBlack.y == Y) {
                kingBlack.x = xx;
                kingBlack.y = yy;
            }
            press = 0;
            refresh();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    void refresh() {
        
        paintBoard();

        try {
            java.awt.Image imgFb = null;

            String imageFb = "rookBlack.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, rookBlack.x*90+20, rookBlack.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "longKnightBlack.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, longKnightBlack.x*90+20, longKnightBlack.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "knightBlack.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, knightBlack.x*90+20, knightBlack.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "guardBlack.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, guardBlack.x*90+20, guardBlack.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "guardBlack.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, guardBlack2.x*90+20, guardBlack2.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "kingBlack.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, kingBlack.x*90+20, kingBlack.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "longKnightBlack.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, longKnightBlack2.x*90+20, longKnightBlack2.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "knightBlack.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, knightBlack2.x*90+20, knightBlack2.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "rookBlack.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, rookBlack2.x*90+20, rookBlack2.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "canonBlack.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, canonBlack.x*90+20, canonBlack.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "canonBlack.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, canonBlack2.x*90+20, canonBlack2.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "pawnBlack.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, pawnBlack.x*90+20, pawnBlack.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "pawnBlack.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, pawnBlack2.x*90+20, pawnBlack2.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "pawnBlack.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, pawnBlack3.x*90+20, pawnBlack3.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "pawnBlack.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, pawnBlack4.x*90+20, pawnBlack4.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "pawnBlack.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, pawnBlack5.x*90+20, pawnBlack5.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}


        try {
            java.awt.Image imgFb = null;

            String imageFb = "rookRed.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, rookRed.x*90+20, rookRed.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "longKnightRed.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, longKnightRed.x*90+20, longKnightRed.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "knightRed.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, knightRed.x*90+20, knightRed.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "guardRed.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, guardRed.x*90+20, guardRed.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "guardRed.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, guardRed2.x*90+20, guardRed2.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "kingRed.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, kingRed.x*90+20, kingRed.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "longKnightRed.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, longKnightRed2.x*90+20, longKnightRed2.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "knightRed.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, knightRed2.x*90+20, knightRed2.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "rookRed.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, rookRed2.x*90+20, rookRed2.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "canonRed.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, canonRed.x*90+20, canonRed.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "canonRed.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, canonRed2.x*90+20, canonRed2.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "pawnRed.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, pawnRed.x*90+20, pawnRed.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "pawnRed.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, pawnRed2.x*90+20, pawnRed2.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "pawnRed.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, pawnRed3.x*90+20, pawnRed3.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "pawnRed.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, pawnRed4.x*90+20, pawnRed4.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        try {
            java.awt.Image imgFb = null;

            String imageFb = "pawnRed.png";

            javax.swing.ImageIcon iFb = new javax.swing.ImageIcon(this.getClass().getResource(imageFb));
            imgFb = iFb.getImage();

            g.drawImage(imgFb, pawnRed5.x*90+20, pawnRed5.y*90+20, 60, 60, null);
        } catch(Exception e) {e.printStackTrace();}

        boolean isPieceSelected = false;
        
        if(rookBlack.x == selectedX && rookBlack.y == selectedY) {
            isPieceSelected = true;
        }
        if(rookBlack2.x == selectedX && rookBlack2.y == selectedY) {
            isPieceSelected = true;
        }
        if(longKnightBlack.x == selectedX && longKnightBlack.y == selectedY) {
            isPieceSelected = true;
        }
        if(longKnightBlack2.x == selectedX && longKnightBlack2.y == selectedY) {
            isPieceSelected = true;
        }
        if(knightBlack.x == selectedX && knightBlack.y == selectedY) {
            isPieceSelected = true;
        }
        if(knightBlack2.x == selectedX && knightBlack2.y == selectedY) {
            isPieceSelected = true;
        }
        if(guardBlack.x == selectedX && guardBlack.y == selectedY) {
            isPieceSelected = true;
        }
        if(guardBlack2.x == selectedX && guardBlack2.y == selectedY) {
            isPieceSelected = true;
        }
        if(canonBlack.x == selectedX && canonBlack.y == selectedY) {
            isPieceSelected = true;
        }
        if(canonBlack2.x == selectedX && canonBlack2.y == selectedY) {
            isPieceSelected = true;
        }
        if(pawnBlack.x == selectedX && pawnBlack.y == selectedY) {
            isPieceSelected = true;
        }
        if(pawnBlack2.x == selectedX && pawnBlack2.y == selectedY) {
            isPieceSelected = true;
        }
        if(pawnBlack3.x == selectedX && pawnBlack3.y == selectedY) {
            isPieceSelected = true;
        }
        if(pawnBlack4.x == selectedX && pawnBlack4.y == selectedY) {
            isPieceSelected = true;
        }
        if(pawnBlack5.x == selectedX && pawnBlack5.y == selectedY) {
            isPieceSelected = true;
        }
        if(rookRed.x == selectedX && rookRed.y == selectedY) {
            isPieceSelected = true;
        }
        if(rookRed2.x == selectedX && rookRed2.y == selectedY) {
            isPieceSelected = true;
        }
        if(longKnightRed.x == selectedX && longKnightRed.y == selectedY) {
            isPieceSelected = true;
        }
        if(longKnightRed2.x == selectedX && longKnightRed2.y == selectedY) {
            isPieceSelected = true;
        }
        if(knightRed.x == selectedX && knightRed.y == selectedY) {
            isPieceSelected = true;
        }
        if(knightRed2.x == selectedX && knightRed2.y == selectedY) {
            isPieceSelected = true;
        }
        if(guardRed.x == selectedX && guardRed.y == selectedY) {
            isPieceSelected = true;
        }
        if(guardRed2.x == selectedX && guardRed2.y == selectedY) {
            isPieceSelected = true;
        }
        if(canonRed.x == selectedX && canonRed.y == selectedY) {
            isPieceSelected = true;
        }
        if(canonRed2.x == selectedX && canonRed2.y == selectedY) {
            isPieceSelected = true;
        }
        if(pawnRed.x == selectedX && pawnRed.y == selectedY) {
            isPieceSelected = true;
        }
        if(pawnRed2.x == selectedX && pawnRed2.y == selectedY) {
            isPieceSelected = true;
        }
        if(pawnRed3.x == selectedX && pawnRed3.y == selectedY) {
            isPieceSelected = true;
        }
        if(pawnRed4.x == selectedX && pawnRed4.y == selectedY) {
            isPieceSelected = true;
        }
        if(pawnRed5.x == selectedX && pawnRed5.y == selectedY) {
            isPieceSelected = true;
        }
        if(kingRed.x == selectedX && kingRed.y == selectedY) {
            isPieceSelected = true;
        }
        if(kingBlack.x == selectedX && kingBlack.y == selectedY) {
            isPieceSelected = true;
        }
            
        if(isPieceSelected) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(5));
            g2.setColor(Color.GREEN);
            g2.drawOval(selectedX*90+10, selectedY*90, 80, 80);
        }

        g2.setColor(Color.LIGHT_GRAY);
        g2.fillRect(0, 110, 200, 500);
        
        g2.setColor(Color.BLACK);
        g2.drawString("B   R    ", 15, 140);

        int iy = 0;

        try {
            if(pawnRed.x == -1000) {
                Image i = ImageIO.read(getClass().getResourceAsStream("pawnRed.png"));
                g2.drawImage(i, (int) 20+15, (int) iy*20+150, 10, 10, null);
                iy++;
            }
        } catch(Exception e) {}
        try {
            if(pawnRed2.x == -1000) {
                Image i = ImageIO.read(getClass().getResourceAsStream("pawnRed.png"));
                g2.drawImage(i, (int) 20+15, (int) iy*20+150, 10, 10, null);
                iy++;
            }
        } catch(Exception e) {}
        try {
            if(pawnRed3.x == -1000) {
                Image i = ImageIO.read(getClass().getResourceAsStream("pawnRed.png"));
                g2.drawImage(i, (int) 20+15, (int) iy*20+150, 10, 10, null);
                iy++;
            }
        } catch(Exception e) {}
        try {
            if(pawnRed4.x == -1000) {
                Image i = ImageIO.read(getClass().getResourceAsStream("pawnRed.png"));
                g2.drawImage(i, (int) 20+15, (int) iy*20+150, 10, 10, null);
                iy++;
            }
        } catch(Exception e) {}
        try {
            if(pawnRed5.x == -1000) {
                Image i = ImageIO.read(getClass().getResourceAsStream("pawnRed.png"));
                g2.drawImage(i, (int) 20+15, (int) iy*20+150, 10, 10, null);
                iy++;
            }
        } catch(Exception e) {}
        try {
            if(rookRed.x == -1000) {
                Image i = ImageIO.read(getClass().getResourceAsStream("rookRed.png"));
                g2.drawImage(i, (int) 20+15, (int) iy*20+150, 10, 10, null);
                iy++;
            }
        } catch(Exception e) {}
        try {
            if(rookRed2.x == -1000) {
                Image i = ImageIO.read(getClass().getResourceAsStream("rookRed.png"));
                g2.drawImage(i, (int) 20+15, (int) iy*20+150, 10, 10, null);
                iy++;
            }
        } catch(Exception e) {}
        try {
            if(knightRed.x == -1000) {
                Image i = ImageIO.read(getClass().getResourceAsStream("knightRed.png"));
                g2.drawImage(i, (int) 20+15, (int) iy*20+150, 10, 10, null);
                iy++;
            }
        } catch(Exception e) {}
        try {
            if(knightRed2.x == -1000) {
                Image i = ImageIO.read(getClass().getResourceAsStream("knightRed.png"));
                g2.drawImage(i, (int) 20+15, (int) iy*20+150, 10, 10, null);
                iy++;
            }
        } catch(Exception e) {}
        try {
            if(longKnightRed.x == -1000) {
                Image i = ImageIO.read(getClass().getResourceAsStream("longKnightRed.png"));
                g2.drawImage(i, (int) 20+15, (int) iy*20+150, 10, 10, null);
                iy++;
            }
        } catch(Exception e) {}
        try {
            if(longKnightRed2.x == -1000) {
                Image i = ImageIO.read(getClass().getResourceAsStream("longKnightRed.png"));
                g2.drawImage(i, (int) 20+15, (int) iy*20+150, 10, 10, null);
                iy++;
            }
        } catch(Exception e) {}
        try {
            if(guardRed.x == -1000) {
                Image i = ImageIO.read(getClass().getResourceAsStream("guardRed.png"));
                g2.drawImage(i, (int) 20+15, (int) iy*20+150, 10, 10, null);
                iy++;
            }
        } catch(Exception e) {}
        try {
            if(guardRed2.x == -1000) {
                Image i = ImageIO.read(getClass().getResourceAsStream("guardRed.png"));
                g2.drawImage(i, (int) 20+15, (int) iy*20+150, 10, 10, null);
                iy++;
            }
        } catch(Exception e) {}

        int yy = 0;
        try {
            if(pawnBlack.x == -1000) {
                Image i = ImageIO.read(getClass().getResourceAsStream("pawnBlack.png"));
                g2.drawImage(i, (int) 0+15, (int) yy*20+150, 10, 10, null);
                yy++;
            }
        } catch(Exception e) {}
        try {
            if(pawnBlack2.x == -1000) {
                Image i = ImageIO.read(getClass().getResourceAsStream("pawnBlack.png"));
                g2.drawImage(i, (int) 0+15, (int) yy*20+150, 10, 10, null);
                yy++;
            }
        } catch(Exception e) {}
        try {
            if(pawnBlack3.x == -1000) {
                Image i = ImageIO.read(getClass().getResourceAsStream("pawnBlack.png"));
                g2.drawImage(i, (int) 0+15, (int) yy*20+150, 10, 10, null);
                yy++;
            }
        } catch(Exception e) {}
        try {
            if(pawnBlack4.x == -1000) {
                Image i = ImageIO.read(getClass().getResourceAsStream("pawnBlack.png"));
                g2.drawImage(i, (int) 0+15, (int) yy*20+150, 10, 10, null);
                yy++;
            }
        } catch(Exception e) {}
        try {
            if(pawnBlack5.x == -1000) {
                Image i = ImageIO.read(getClass().getResourceAsStream("pawnBlack.png"));
                g2.drawImage(i, (int) 0+15, (int) yy*20+150, 10, 10, null);
                yy++;
            }
        } catch(Exception e) {}
        try {
            if(rookBlack.x == -1000) {
                Image i = ImageIO.read(getClass().getResourceAsStream("rookBlack.png"));
                g2.drawImage(i, (int) 0+15, (int) yy*20+150, 10, 10, null);
                yy++;
            }
        } catch(Exception e) {}
        try {
            if(rookBlack2.x == -1000) {
                Image i = ImageIO.read(getClass().getResourceAsStream("rookBlack.png"));
                g2.drawImage(i, (int) 0+15, (int) yy*20+150, 10, 10, null);
                yy++;
            }
        } catch(Exception e) {}
        try {
            if(knightBlack.x == -1000) {
                Image i = ImageIO.read(getClass().getResourceAsStream("knightBlack.png"));
                g2.drawImage(i, (int) 0+15, (int) yy*20+150, 10, 10, null);
                yy++;
            }
        } catch(Exception e) {}
        try {
            if(knightBlack2.x == -1000) {
                Image i = ImageIO.read(getClass().getResourceAsStream("knightBlack.png"));
                g2.drawImage(i, (int) 0+15, (int) yy*20+150, 10, 10, null);
                yy++;
            }
        } catch(Exception e) {}
        try {
            if(longKnightBlack.x == -1000) {
                Image i = ImageIO.read(getClass().getResourceAsStream("longKnightBlack.png"));
                g2.drawImage(i, (int) 0+15, (int) yy*20+150, 10, 10, null);
                yy++;
            }
        } catch(Exception e) {}
        try {
            if(longKnightBlack2.x == -1000) {
                Image i = ImageIO.read(getClass().getResourceAsStream("longKnightBlack.png"));
                g2.drawImage(i, (int) 0+15, (int) yy*20+150, 10, 10, null);
                yy++;
            }
        } catch(Exception e) {}
        try {
            if(guardBlack.x == -1000) {
                Image i = ImageIO.read(getClass().getResourceAsStream("guardBlack.png"));
                g2.drawImage(i, (int) 20+15, (int) iy*20+150, 10, 10, null);
                iy++;
            }
        } catch(Exception e) {}
        try {
            if(guardBlack2.x == -1000) {
                Image i = ImageIO.read(getClass().getResourceAsStream("guardBlack.png"));
                g2.drawImage(i, (int) 20+15, (int) iy*20+150, 10, 10, null);
                iy++;
            }
        } catch(Exception e) {}
    }
    
    public void paintBoard() {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g2.setColor(new Color(100, 50, 15));
        g2.fillRect(0, 0, 950, 950);
        g2.setColor(Color.pink);
        for(int i=0; i<9; i++) {
            g2.drawLine(i*90+50, 40, i*90+50, 810+40);
        }
        for(int i=0; i<10; i++) {
            g2.drawLine(0+50, i*90+40, 720+50, i*90+40);
        }
        g2.setColor(Color.white);
        g2.fillRect(50,360+40,810-90,90);
        g2.setColor(Color.pink);
        g2.drawLine(270+50, 0+40, 450+50, 180+40);
        g2.drawLine(270+50, 180+40, 450+50, 0+40);
        g2.drawLine(270+50, 630+40, 450+50, 810+40);
        g2.drawLine(270+50, 810+40, 450+50, 630+40);
    }
    
    void setGUI() {
        
        j.setExtendedState(j.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        j.setLayout(null);
        j.setBounds(0, 0, 950, 1050);
        p.setBounds(0,0,880,900);
        pp.setBounds(880,0,70,900);
        JButton c = new JButton("DESELECT");
        c.setBounds(900,10,160,35);
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                xx = X = selectedX = -10;
                yy = Y = selectedY = -10;
                
                press = 0;
                
                refresh();
                
            }
        });
        JButton b = new JButton("New");
        b.setBounds(900,10,40,35);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xx = X = selectedX = -10;
                yy = Y = selectedY = -10;
                press = 0;
                
                initBoard();

                refresh();
                
            }
        });
        pp.add(b);
        pp.add(c);
        j.add(p);
        j.add(pp);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setVisible(true);
        setGraphics();
    
    }
    
    void setGraphics() {
        g = p.getGraphics();
 
        g2 = pp.getGraphics();
    }
    
    public static void main(String[] args) {
        new Xiangqi();
    }
}