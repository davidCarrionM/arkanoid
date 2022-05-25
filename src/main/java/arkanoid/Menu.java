package arkanoid;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JPanel implements ActionListener {
    JButton btnExit;
    JButton btnMenu;
    JButton btnStart;
    JButton btnRead;
    Juego juego;
    Principal a;
    JLabel taito;
    JLabel titulo;
    ImageIcon imagen2 = new ImageIcon(Menu.class.getResource("/arkanoid/img/play.png"));
    Image conversion2 = imagen2.getImage();
    Image tamaño2 = conversion2.getScaledInstance(220, 60, Image.SCALE_SMOOTH);
    ImageIcon imgPre2 = new ImageIcon(tamaño2);

    ImageIcon imagen3 = new ImageIcon(Menu.class.getResource("/arkanoid/img/exit.png"));
    Image conversion3 = imagen3.getImage();
    Image tamaño3 = conversion3.getScaledInstance(220, 60, Image.SCALE_SMOOTH);
    ImageIcon imgPre3 = new ImageIcon(tamaño3);

    ImageIcon imagen4 = new ImageIcon(Menu.class.getResource("/arkanoid/img/play+.png"));
    Image conversion4 = imagen4.getImage();
    Image tamaño4 = conversion4.getScaledInstance(220, 60, Image.SCALE_SMOOTH);
    ImageIcon imgPre4 = new ImageIcon(tamaño4);

    ImageIcon imagen5 = new ImageIcon(Menu.class.getResource("/arkanoid/img/exit+.png"));
    Image conversion5 = imagen5.getImage();
    Image tamaño5 = conversion5.getScaledInstance(220, 60, Image.SCALE_SMOOTH);
    ImageIcon imgPre5 = new ImageIcon(tamaño5);

    ImageIcon imagen6 = new ImageIcon(Menu.class.getResource("/arkanoid/img/read.png"));
    Image conversion6 = imagen6.getImage();
    Image tamaño6 = conversion6.getScaledInstance(120, 50, Image.SCALE_SMOOTH);
    ImageIcon imgPre6 = new ImageIcon(tamaño6);

    ImageIcon imagen7 = new ImageIcon(Menu.class.getResource("/arkanoid/img/read+.png"));
    Image conversion7 = imagen7.getImage();
    Image tamaño7 = conversion7.getScaledInstance(120, 50, Image.SCALE_SMOOTH);
    ImageIcon imgPre7 = new ImageIcon(tamaño7);

    public Menu(Principal a) {
        setLayout(null);
        this.a = a;
        this.setBackground(Color.BLACK);

        btnStart = new JButton("Start");
        btnStart.setSize(220, 50);
        btnStart.setLocation(360, 420);
        btnStart.addActionListener(this);
        btnStart.setIcon(imgPre2);
        btnStart.setFocusPainted(false);
        btnStart.setBorderPainted(false);
        btnStart.setContentAreaFilled(false);
        btnStart.addMouseListener(new MouseEvent());
        add(btnStart);
       
        btnExit = new JButton("EXIT");
        btnExit.setSize(220, 50);
        btnExit.setLocation(360, 520);
        btnExit.addActionListener(this);
        btnExit.setFocusPainted(false);
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setIcon(imgPre3);
        btnExit.addMouseListener(new MouseEvent());
        add(btnExit);
        btnRead = new JButton("READ");
        btnRead.setSize(120, 50);
        btnRead.setLocation(10, 10);
        btnRead.addActionListener(this);
        btnRead.setFocusPainted(false);
        btnRead.setBorderPainted(false);
        btnRead.setContentAreaFilled(false);
        btnRead.setIcon(imgPre6);
        btnRead.addMouseListener(new MouseEvent());
        add(btnRead);

        ImageIcon imagen1 = new ImageIcon(Menu.class.getResource("/arkanoid/img/titulo.png"));
        Image conversion1 = imagen1.getImage();
        Image tamaño1 = conversion1.getScaledInstance(700, 200, Image.SCALE_SMOOTH);
        ImageIcon imgPre1 = new ImageIcon(tamaño1);
        titulo = new JLabel();
        titulo.setSize(700,200);
        titulo.setLocation(150, 100);
        titulo.setIcon(imgPre1);
        titulo.setVisible(true);
        add(titulo);

        ImageIcon imagen = new ImageIcon(Menu.class.getResource("/arkanoid/img/subtitulo.jpg"));
        Image conversion = imagen.getImage();
        Image tamaño = conversion.getScaledInstance(500, 300, Image.SCALE_SMOOTH);
        ImageIcon imgPre = new ImageIcon(tamaño);
        taito = new JLabel();
        taito.setSize(500,300);
        taito.setLocation(250, 650);
        taito.setIcon(imgPre);
        taito.setVisible(true);
        add(taito);
        
    }

    public class MouseEvent extends MouseAdapter{
        
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            if(e.getSource()==btnStart){
                btnStart.setIcon(imgPre4);
            }
            if(e.getSource()==btnExit){
                btnExit.setIcon(imgPre5);
            }
            if(e.getSource() == btnRead){
                btnRead.setIcon(imgPre7);
            }
        }
        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            if(e.getSource()==btnStart){
                btnStart.setIcon(imgPre2);
            }
            if(e.getSource()==btnExit){
                btnExit.setIcon(imgPre3);
            }
            if(e.getSource() == btnRead){
                btnRead.setIcon(imgPre6);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnStart) {
            juego = new Juego(a);
            juego.setSize(1000, 1000);
            juego.setVisible(true);
            a.add(juego);
            this.setVisible(false);
        }
        if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }
}