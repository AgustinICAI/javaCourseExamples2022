import javax.swing.*;
import java.awt.*;

public class JVentana extends JFrame {

    public static void main(String argv[]){
        new JVentana("Mi primera ventana");
    }


    public JVentana(String titulo){
        super(titulo);

        //EL LAYOUT DEFECTO DE UN JFRAME ES EL BorderLayout
        JButton btnClear = new JButton("Clear");

        JTextField txtVisor = new JTextField();

        //EL LAYOUT POR DEFECTO DE UN PANEL ES EL FlowLayout
        JPanel pnlNumeros = new JPanel();
        pnlNumeros.setLayout(new GridLayout(4,3));
        JPanel pnlSouth = new JPanel();
        pnlSouth.add(btnClear);

        JButton[] btnNumeros = new JButton[12];
        int[][] numeros = {{-1,0,-1},{1,2,3},{4,5,6},{7,8,9}};
        int i = 0;

        for(int f = 0; f<numeros.length; f++){
            for(int c = 0; c<numeros[f].length; c++){
                if(numeros[f][c]!=-1) {
                    btnNumeros[i] = new JButton(String.valueOf(numeros[f][c]));
                    pnlNumeros.add(btnNumeros[i], f, c);
                    i += 1;
                }
                else
                    pnlNumeros.add(new Panel(),f,c);
            }
        }

        this.add(txtVisor, BorderLayout.NORTH);
        this.add(pnlNumeros, BorderLayout.CENTER);

        this.add(pnlSouth, BorderLayout.SOUTH);

        this.setVisible(true);
        this.setSize(800,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



}