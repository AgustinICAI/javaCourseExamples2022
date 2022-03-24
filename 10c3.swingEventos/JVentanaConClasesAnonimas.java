import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class JVentanaConClasesAnonimas extends JFrame{

    public static void main(String argv[]){
        new JVentanaConClasesAnonimas("Mi primera ventana");
    }

    private JTextField txtVisor;
    private JButton btnClear;
    private HashMap<JButton,String> btnTeclas;

    public JVentanaConClasesAnonimas(String titulo){
        super(titulo);
        Font fontCalculadora = new Font("SansSerif",Font.PLAIN,30);
        //EL LAYOUT DEFECTO DE UN JFRAME ES EL BorderLayout
        btnClear = new JButton("Clear");
        btnClear.setFont(fontCalculadora);

        txtVisor = new JTextField();
        txtVisor.setFont(fontCalculadora);
        txtVisor.setHorizontalAlignment(SwingConstants.RIGHT);

        txtVisor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                if(keyEvent.getKeyCode() == 0){
                    calculaResultado();
                }
            }

        });

        btnClear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                txtVisor.setText("");
            }
        });

        String[] operaciones = {"+","-","*","/","="};

        JPanel pnlEast = new JPanel();
        pnlEast.setLayout(new GridLayout(operaciones.length,1));
        //pnlEast.setLayout(new BoxLayout(pnlEast,BoxLayout.Y_AXIS));
        //pnlEast.setBackground(Color.RED);

        btnTeclas = new HashMap<>();
        for(String operacion : operaciones){
            JButton btn = new JButton(operacion);
            btn.setFont(fontCalculadora);
            pnlEast.add(btn);

            
            btn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    teclaPulsada(actionEvent);
                }
            });
            btnTeclas.put(btn,operacion);
        }
        /*
        Arrays.asList(operaciones).forEach(operacion -> {
            JButton btn = new JButton(operacion);
            btn.setFont(fontCalculadora);
            pnlEast.add(btn);
        });*/
        this.add(pnlEast,BorderLayout.EAST);
        //EL LAYOUT POR DEFECTO DE UN PANEL ES EL FlowLayout
        JPanel pnlNumeros = new JPanel();
        pnlNumeros.setLayout(new GridLayout(4,3));
        JPanel pnlSouth = new JPanel();
        pnlSouth.add(btnClear);

        int[][] numeros = {{-1,0,-1},{1,2,3},{4,5,6},{7,8,9}};
        int i = 0;

        for(int f = 0; f<numeros.length; f++){
            for(int c = 0; c<numeros[f].length; c++){
                if(numeros[f][c]!=-1) {
                    String num = String.valueOf(numeros[f][c]);
                    JButton btn = new JButton(num);
                    btnTeclas.put(btn,num);
                    pnlNumeros.add(btn, f, c);
                    btn.setFont(fontCalculadora);
                    /*btn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            teclaPulsada(actionEvent);
                        }
                    });*/
                    btn.addActionListener(actionEvent -> teclaPulsada(actionEvent));

                    i += 1;
                }
                else
                    pnlNumeros.add(new Panel(),f,c);
            }
        }

        this.add(txtVisor, BorderLayout.NORTH);
        this.add(pnlNumeros, BorderLayout.CENTER);
        this.add(pnlSouth, BorderLayout.SOUTH);
        //this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void teclaPulsada(ActionEvent actionEvent) {
        String operacion = btnTeclas.get(actionEvent.getSource());
        if(operacion.equals("="))
            calculaResultado();
        else
            JVentanaConClasesAnonimas.this.txtVisor.setText(txtVisor.getText()+operacion);
        //txtVisor.setText............
    }

    void calculaResultado(){
        this.txtVisor.setText(Util.evaluateExpressionUsingExternalLIB(txtVisor.getText()));
    }


}