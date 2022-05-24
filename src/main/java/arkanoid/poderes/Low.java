package arkanoid.poderes;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import arkanoid.Principal;

public class Low extends JLabel implements ActionListener {
    Principal p;
    Timer timer;
    Timer timerEmpezar;

    public boolean move = false;
    boolean empezar = false;
    int cont = 0;
    
    public Low(Principal p) {
        ImageIcon imagen = new ImageIcon(Tall.class.getResource("/arkanoid/img/power4.png"));
        Image conversion = imagen.getImage();
        Image tamaño = conversion.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon imgPre = new ImageIcon(tamaño);
        this.setIcon(imgPre);
        this.p = p;
        timer = new Timer(50, this);
        timer.start();
        timerEmpezar = new Timer(1000, this);
        timerEmpezar.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer && move){
            this.setLocation(this.getX(), this.getY()+10);


            if (this.getY() >= 880 && this.getY() <= 900 && this.getX() >= p.barra.getX()  && this.getX() <= (p.barra.getX() + 130)) {
                p.remove(this);
                this.setVisible(false);
                this.move = false;
                this.empezar=true;
                p.bola.vel = 2;
                // if(p.bola.velocidady<0){
                //     p.bola.velocidady = -1;
                // }else{
                    
                //     p.bola.velocidady = +1;
                // }
            }
            
            if(this.getY() >= 950){
                p.remove(this);
                this.setVisible(false);
                this.move = false;
            }
            //130,25
        }      
        if(e.getSource()==timerEmpezar&&empezar){
            if(cont==7){
                p.bola.vel = 4;
                empezar = false;
                cont = 0;
                timer.stop();
                timerEmpezar.stop();
            }
            cont++;
        }
        
    }

}