package arkanoid.poderes;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import arkanoid.acciones.Juego;
import arkanoid.objetos.Bola;

/**
 * SuperPoder que hace que la barra sea mas larga
 */
public class Tall extends JLabel implements ActionListener {
    Juego p;
    public Timer timer;
    public Timer timerEmpezar;
    public boolean move = false;
    boolean empezar = false;
    int cont = 0;

    public void ReproducirSonido(String nombreSonido) {
        try {
            AudioInputStream audioInputStream = AudioSystem
                    .getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error al reproducir el sonido.");
        }
    }

    public Tall(Juego p) {
        ImageIcon imagen = new ImageIcon(Tall.class.getResource("/arkanoid/img/power0.png"));
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
        if (e.getSource() == timer && move) {
            this.setLocation(this.getX(), this.getY() + 10);

            if (this.getY() >= 880 && this.getY() <= 900 && this.getX() >= p.barra.getX()
                    && this.getX() <= (p.barra.getX() + 130 + p.powerCrecer)) {
                ReproducirSonido("src/main/java/arkanoid/sonidos/power.wav");

                p.remove(this);
                this.setVisible(false);
                this.move = false;
                this.empezar = true;
                ImageIcon imagen = new ImageIcon(Bola.class.getResource("/arkanoid/img/barra.png"));
                Image conversion = imagen.getImage();
                Image tamaño = conversion.getScaledInstance(160, 25, Image.SCALE_SMOOTH);
                ImageIcon imgPre = new ImageIcon(tamaño);
                p.barra.setIcon(imgPre);
                p.barra.setSize(160, 25);
                p.barra.setVisible(true);
                p.powerCrecer = 30;
            }

            if (this.getY() >= 950) {
                p.remove(this);
                this.setVisible(false);
                this.move = false;
            }

        }
        if (e.getSource() == timerEmpezar && empezar) {

            if (cont == 7) {
                p.barra.setIcon(p.barra.imgPre);
                p.barra.setSize(130, 25);
                empezar = false;
                cont = 0;
                p.powerCrecer = 0;
                timer.stop();
                timerEmpezar.stop();
            }
            cont++;
        }

    }

}
