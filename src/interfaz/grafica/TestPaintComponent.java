/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.grafica;
import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 *
 * @author Estudiante
 */

    
    public class TestPaintComponent extends JFrame {
    public TestPaintComponent(){
        add(new NewPanel());
    }
    
    public static void main(String[] args) {
        TestPaintComponent frame = new TestPaintComponent();
        frame.setTitle("TestPaintComponent");
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    
    public class NewPanel extends JPanel implements ActionListener, MouseListener{
        private int x;
        private int y;
        int j=0;
        private Timer timer;

        public NewPanel() {
            this.addMouseListener(this);
            timer = new Timer(25, this);
            timer.start();
        }
        
    protected void paintComponent(Graphics g){
        
        super.paintComponent(g);
        
        //carro 1
        //base carro
        g.setColor(Color.green);
        g.fillRect(x+170, 280, 80, 30);
        //cañon tanque
        g.setColor(Color.pink);
        g.fillRect(x+20, 250, 150, 120);
        //ruedas
        g.setColor(Color.red);
        g.fillOval(x+30, 369, 40, 40);
        //Puntaje
        g.fillOval(x+110, 369, 40, 40);
        g.setColor(Color.black);
        //impacto
        g.drawRect(x+15, 245, 237, 170);
        //impacto2
        g.drawRect(x+395, 245, 237, 170);
        //Carro 2
        
        //base
        g.setColor(Color.pink);
        g.fillRect(x+400, 250, 150, 120);
        //cañon
        g.setColor(Color.green);
        g.fillRect(x+550, 280, 80, 30);
        //ruedas
        g.setColor(Color.red);
        g.fillOval(x+410, 369, 40, 40);
        g.fillOval(x+490, 369, 40, 40);
        
        g.setColor(Color.DARK_GRAY);
        g.fillRect(150, y+10, 50, 80);
        g.fillRect(300, y+10, 50, 80);
        g.fillOval(500, y+10, 50, 50);
        g.fillOval(500, y+100, 50, 50);
        
        
    }

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(j%2==0){
            x+=1;
            if(x==10){
                j++;
            }
            repaint();
            }
            else{
                j-=1;
                repaint();
            }
            y+=5;
            repaint();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Hola, we");
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
    }
}
