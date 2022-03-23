import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JVentana extends JFrame implements ActionListener {

    public static void main(String argv[]){
        new JVentana("Mi primera ventana");
    }

    private JTextField txtVisor;

    public JVentana(String titulo){
        super(titulo);
        Font fontCalculadora = new Font("SansSerif",Font.PLAIN,30);
        //EL LAYOUT DEFECTO DE UN JFRAME ES EL BorderLayout
        JButton btnClear = new JButton("Clear");
        btnClear.setFont(fontCalculadora);


        txtVisor = new JTextField();
        txtVisor.setFont(fontCalculadora);
        txtVisor.setHorizontalAlignment(SwingConstants.RIGHT);

        btnClear.addActionListener(this);

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
                    btnNumeros[i].setFont(fontCalculadora);

                    i += 1;
                }
                else
                    pnlNumeros.add(new Panel(),f,c);
            }
        }

        this.add(txtVisor, BorderLayout.NORTH);
        this.add(pnlNumeros, BorderLayout.CENTER);
        this.add(pnlSouth, BorderLayout.SOUTH);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.txtVisor.setText("");
    }
}