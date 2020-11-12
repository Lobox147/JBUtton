/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.expo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author esaul
 */
public class Ventana extends JPanel implements ActionListener{
    // ventana
    int op;
    private JFrame ventana;
    // contenedor
    private Container contenedor;
    //declarar la figura
    private Punto figura[];
    public JMenuBar arc;
    public JButton b;
    public JButton b1,b2,b3;
    public JButton btn4;


    /**
     * Crear una ventana para representar la figura
     * @param titulo Titulo de la ventana
     * @param figura Figura representada por puntos
     */
    public Ventana(String titulo,Punto figura[]) {
        // inicializar la ventana
        ventana = new JFrame(titulo);
        // definir tamaño a ventana
        ventana.setSize(800, 600);
        setLayout(new FlowLayout(FlowLayout.LEFT, 2, 0));
        arc = new JMenuBar();
 
        b1= new JButton("Trasladar");
        b2 = new JButton("Rotacion");
  
        add(arc);
  
        
        b1.addActionListener(this);
        b2.addActionListener(this);
                
  
        
        arc.add(b1);
        arc.add(b2);
  
        b = new JButton("salir");
        b.setBounds(100, 150, 100, 30);
        b.addActionListener(this);
        add(b);
   
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        
        contenedor = ventana.getContentPane();
        contenedor.setSize(800, 600);
        // agregar la ventana en el contenedor
        contenedor.add(this, BorderLayout.CENTER);
        this.figura=figura;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        //Dibujar la figura original
        g.setColor(Color.blue);
        this.dibujar(g);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            int x,y;
            x=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de traslado en X"));
            y=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de traslado en Y"));
            this.traslacion(x,y);
            ventana.repaint();
        
        }
        if(e.getSource()==b2){
            double angulo;
            angulo=45;
            this.Rotacion(angulo);
            ventana.repaint();
        }    
           
        if(e.getSource()==b){
          
        }
    }
        
    public void traslacion(int xf, int yf){
        for (Punto punto : figura) {
        //punto x:((x - xf) 
        //punto y: ((y - yf)
            punto.setX((int)(punto.getX() + xf));
            punto.setY((int)(punto.getY() + yf));
        }
    }
    public void Rotacion (double angulo){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for (Punto punto : figura) {
        //punto x:(x - tx) * cos – (b – ty) * sin + tx
        //punto y: (x - ty) * sin + (b – ty) * cos + ty
            punto.setX((int)((punto.getX() - tx)*Math.cos(Math.toRadians(angulo))-(punto.getY()-ty)*Math.sin(Math.toRadians(angulo))+tx));
            //punto y
            punto.setY((int)((punto.getX() - ty)*Math.sin(Math.toRadians(angulo))+(punto.getY()-ty)*Math.cos(Math.toRadians(angulo))+ty));
        }
    }
        public void escalar (float factor_x, float factor_y){
        for (Punto punto : figura) {
            punto.setX((int)(punto.getX()*factor_x));
            punto.setY((int)(punto.getY()*factor_y));
        }
    }
        public void escalar (float escalar){
        for (Punto punto : figura){
            punto.setX((int) (punto.getX()*escalar));
            punto.setY((int) (punto.getY()*escalar));
        }
    }
           public void escalarFijo (float escalar, int fx, int fy){
        for (Punto punto : figura){
            punto.setX((int) (fx + ((punto.getX() - fx) * escalar)));
            punto.setY((int) (fy + ((punto.getY() - fy) * escalar)));
        }
    }
        public void escalarFijo (float factorX, float factorY, int fx, int fy){
        for (Punto punto : figura){
            punto.setX((int) (fx + ((punto.getX() - fx) * factorX)));
            punto.setY((int) (fy + ((punto.getY() - fy) * factorY)));
        }
    }
        
    public void rotacionFija(double ang, int fx, int fy){
        this.traslacion(-fx, -fy);
        this.Rotacion(ang);
        this.traslacion(fx, fy);
    }
    
    public void reflexionY (){
        int tx = figura [0].getX();
        int ty = figura [0].getY();
        
        for (Punto punto : figura){
            punto.setX((punto.getX()-tx) + tx);
            punto.setY(-(punto.getY()-ty) + ty);
        }
    }
    
    public void reflexionXY(){
        int tx = figura [0].getX();
        int ty = figura [0].getY();
        
        for (Punto punto : figura){
            punto.setX(-(punto.getX()-tx) + tx);
            punto.setY(-(punto.getY()-ty) + ty);
        }
    }
    private void dibujar(Graphics g){
        for (int i = 0; i < figura.length-1; i++) {
            g.drawLine(
                    this.figura[i].getX(),//punto A
                    this.figura[i].getY(),
                    this.figura[i+1].getX(),//punto B
                    this.figura[i+1].getY()
            );
        }
    }
    
}
