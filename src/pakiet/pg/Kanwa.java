package pakiet.pg;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Kanwa extends JPanel implements MouseInputListener {
    private int x,y;
    private char dany_klawisz;
    public Kanwa() {
        setFocusable(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyChar() == 'x' || e.getKeyChar() == 'X'){
                    dany_klawisz='x';
                    repaint();
                }

                else if(e.getKeyChar() == 'z' || e.getKeyChar() == 'Z') {
                    dany_klawisz='z';
                    repaint();
                }


            }
        });
        addMouseListener(this);
        addMouseMotionListener(this);
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

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

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x= e.getX();
        y= e.getY();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if(dany_klawisz=='x') {
            g.setColor(Color.BLUE);
            g2d.drawRect(x, y, 70, 70);
            g2d.fillRect(x, y, 70, 70);
        }
        else if (dany_klawisz =='z'){
            g.setColor(Color.green);
            g2d.drawOval(x, y, 70, 70);
            g2d.fillOval(x, y, 70, 70);

        }
    }
}
