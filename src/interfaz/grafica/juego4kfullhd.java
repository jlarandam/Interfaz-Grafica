/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz.grafica;

import hgfds.TestPaintComponent;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Estudiante
 */
public class juego4kfullhd extends JFrame{
    public juego4kfullhd(){
        add(new Panel());
    }
    
    public static void main(String[] args) {
        juego4kfullhd frame = new juego4kfullhd();
        frame.setTitle("juego4kfullhd");
        frame.setSize(1024, 680);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
    }
    
    public class Panel extends JPanel implements ActionListener{
            private int x;
            private int y;
            private int j;
            private int k;
            private Timer timer;
            private int secuencia =0;
            
            public Panel(){
                timer = new Timer(25, this);
                addKeyListener(new TAdapter());
                setFocusable(true);
                timer.start();
            }
            
            private class TAdapter extends KeyAdapter{
                public void keyReleased(KeyEvent e){
            System.out.println("Tecla Soltada");
        }
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_RIGHT){
                j+=7;
                System.out.println(j);
            }
            if(key == KeyEvent.VK_LEFT){
                j-=7;
                System.out.println(j);
            }
            if(key == KeyEvent.VK_UP){
                k-=3;
            }
            if(key == KeyEvent.VK_DOWN){
                k+=3;
            }
            if(key == KeyEvent.VK_0){
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException ex){
                    System.out.println("algo fashó");
                }
            }
            System.out.println("Tecla Oprimida alv");
        }
            }
            
        @Override
        public void actionPerformed(ActionEvent e) {
            checkCollisions();
            if(this.secuencia==5){
                this.secuencia = 0;
            }else
                this.secuencia+=118;
            repaint();
        }
        
        public Image loadImage(String imageName){
            ImageIcon ii = new ImageIcon(imageName);
            Image image = ii.getImage();
            return image;
        }
        
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Image fondo = loadImage("blue_background.png");
            for(int i =0; i<100000+x; i++){
                g.drawImage(fondo, i, 0, null);
            }
            Image cloud = loadImage("clouds.png");
            for(int i=0; i<10000+x;i+=335){
                g.drawImage(cloud, i, 30, null);
                
            }
            Image ground = loadImage("ground_single.png");
            g.drawImage(ground, 0, 585,null);
            
            Image gLoop = loadImage("ground_loop.png");
            for(int i=110; i<10000+x;i+=111){
                g.drawImage(gLoop, i, 585, null);
            }
            
            Image pj = loadImage("standing.png");
            g.drawImage(pj, j+20, k+453,j+20+118, k+133+453, (this.secuencia * 118),0,(this.secuencia*118)+118, 133,this);
        }
        
        public void checkCollisions(){
//            Rectangle rec = getBounds();
//            Rectangle rRect = new Rectangle (500, 355, 40, 10);
//            if(rec.intersects(rRect)){
//                System.out.println("Colision");
//                this.timer.stop();
            }
        }
        
}
    

