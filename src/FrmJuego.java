import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class FrmJuego extends JFrame {

    private Dado dado1, dado2;
    private Random r = new Random();
    private JLabel lblDado1, lblDado2, lblLanzamientos, lblCenas;
    private int lanzamientos, cenas;

    public FrmJuego() {
        setSize(500, 300); // tamaño ventana
        setTitle("Juguemos a los dados"); // titulo ventana
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //cierre de ventana (salga del programa)
        setLayout(null);//anula distribucion para usar coordenadas

        //etiqueta dado 1
        lblDado1 = new JLabel();
        String nombreImagen = "/imagenes/1.jpg";
        ImageIcon imagen = new ImageIcon(getClass().getResource(nombreImagen));//cargar el archivo
        lblDado1.setIcon(imagen);//asigna la imagen a la etiqueta

        //coordenadas, alto y ancho donde voy a mostrar la imagen
        lblDado1.setBounds(10, 10, imagen.getIconWidth(), imagen.getIconHeight());
        getContentPane().add(lblDado1);//mostrar

        //etiqueta dado2
        lblDado2 = new JLabel();
        lblDado2.setIcon(imagen);
        lblDado2.setBounds(10 + imagen.getIconWidth(), 10, imagen.getIconWidth(), imagen.getIconHeight());
        getContentPane().add(lblDado2);

        //etiqueta titulo
        JLabel lblTitulo1 = new JLabel("Lanzamientos");
        lblTitulo1.setBounds(50 + 2 * imagen.getIconWidth(), 10, 100, 25);
        lblTitulo1.setHorizontalAlignment(SwingConstants.CENTER);//centrar
        getContentPane().add(lblTitulo1);

        //etiqueta titulo 2
        JLabel lblTitulo2 = new JLabel("Cenas");
        lblTitulo2.setBounds(160 + 2 * imagen.getIconWidth(), 10, 100, 25);
        lblTitulo2.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lblTitulo2);

        lblLanzamientos = new JLabel();
        lblLanzamientos.setBounds(50 + 2 * imagen.getIconWidth(), 40, 100, 100);
        lblLanzamientos.setBackground(new Color(0, 0, 0)); //color de fondo
        lblLanzamientos.setForeground(new Color(51, 255, 0));//color de la letra
        lblLanzamientos.setFont(new Font("Tahoma", 1, 72));// fuente
        lblLanzamientos.setText("0");//texto
        lblLanzamientos.setHorizontalAlignment(SwingConstants.RIGHT);// alineado a la derecha
        lblLanzamientos.setOpaque(true);//poner opaco
        getContentPane().add(lblLanzamientos);

        lblCenas = new JLabel();
        lblCenas.setBounds(160 + 2 * imagen.getIconWidth(), 40, 100, 100);
        lblCenas.setBackground(new Color(0, 0, 0));
        lblCenas.setForeground(new Color(51, 255, 0));
        lblCenas.setFont(new Font("Tahoma", 1, 72));
        lblCenas.setText("0");
        lblCenas.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCenas.setOpaque(true);
        getContentPane().add(lblCenas);

        //Boton iniciar
        JButton btnIniciar=new JButton("Iniciar");
        btnIniciar.setBounds(10, 15+imagen.getIconHeight(), 100, 25);
        getContentPane().add(btnIniciar);

        //boton lanzar
        JButton btnLanzar=new JButton("Lanzar");
        btnLanzar.setBounds(10, 45+imagen.getIconHeight(), 100, 25);
        getContentPane().add(btnLanzar);

        //escuchador de accion iniciar
        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciar();
            }
        });

        //escuchador de accion lanzar
        btnLanzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lanzar();
            }
        });

        dado1 = new Dado();
        dado2 = new Dado();
        lanzamientos = 0;
        cenas = 0;
    }

    //rutina iniciar (eventos/funciones)
    private void iniciar() {
        lanzamientos = 0;
        cenas = 0;
        lblLanzamientos.setText("0");
        lblCenas.setText("0");
    }

    //rutina lanzar 
    private void lanzar() {
        dado1.lanzar(r);
        dado2.lanzar(r);

        dado1.mostrar(lblDado1);
        dado2.mostrar(lblDado2);

        lanzamientos++;
        lblLanzamientos.setText(String.valueOf(lanzamientos));

        if (dado1.getNumero() + dado2.getNumero() >= 11) {
            cenas++;
            lblCenas.setText(String.valueOf(cenas));
        }

    }

}