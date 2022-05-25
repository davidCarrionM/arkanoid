package arkanoid;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Principal extends JFrame implements ActionListener{
    
    Timer tiempo;
    int contTiempo = 0;
    String titulo = "Arkanoid";
    String tituloAux = "";
    public  Menu menu;
    public  Juego juego; 
    public  GameOver gameOver;
    public  Win win;
    static boolean eliminar = false;

    public Principal(){
        super("Arkanoid");

        tiempo = new Timer(300, this);
        tiempo.start();
        juego = new Juego(this);
        juego.setSize(1000,1000);
        juego.setVisible(false);
        add(juego);
        menu = new Menu(this);
        menu.setSize(1000,1000);
        menu.setVisible(false);
        add(menu);
        gameOver = new GameOver(this);
        gameOver.setSize(1000,1000);
        gameOver.setVisible(true);
        add(gameOver);
        win = new Win(this);
        win.setSize(1000,1000);
        win.setVisible(false);
        add(win);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tiempo) {
           
            if (contTiempo == 0) {
                contTiempo = titulo.length() + 4;
                Principal.super.setTitle(" -- "+Principal.super.getTitle());
                tituloAux = " -- "+tituloAux;
            }
            if (contTiempo <= titulo.length()) {
                tituloAux = titulo.charAt(contTiempo - 1) + tituloAux;
                Principal.super.setTitle(tituloAux);
            }
            contTiempo--;


            if(eliminar){
                this.remove(juego);
                this.juego.setVisible(false);
                eliminar = false;
            }
        }
        
    }

}
