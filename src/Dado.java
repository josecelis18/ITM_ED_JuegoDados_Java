import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Dado {

    private int numero;
//iniciado
    public void lanzar(Random r) {
        // generar mumero aleatorio en 1 y 6
        numero = r.nextInt(6) + 1;
    }
    //devolver el valor
    public int getNumero() {
        return numero;
    }
//archivo a mostrar
    public void mostrar(JLabel lbl) {
        String nombreImagen = "/imagenes/" + String.valueOf(numero) + ".jpg"; //imagen del dado lanzado
        ImageIcon imagen = new ImageIcon(getClass().getResource(nombreImagen));
        lbl.setIcon(imagen);
    }

}
