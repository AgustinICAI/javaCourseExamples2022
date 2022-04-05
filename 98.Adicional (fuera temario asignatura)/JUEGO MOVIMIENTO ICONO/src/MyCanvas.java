import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

class MyCanvas extends JPanel {
    private JVentana jVentana;
    Image fondo,flappyImg;
    int refreshRate = 30;
    Map<Integer,Boolean> teclasDireccion = new HashMap<>(Map.of(KeyEvent.VK_UP,false,
            KeyEvent.VK_DOWN,false,
            KeyEvent.VK_LEFT,false,
            KeyEvent.VK_RIGHT,false,
            KeyEvent.VK_SPACE,false));

    Font f = new Font("Arial", Font.BOLD, 30);

    Point posicion = new Point(30,30);

    MyCanvas(JVentana jVentana) {
        super();
        this.setPreferredSize(new Dimension(300, 300));
        this.jVentana = jVentana;
        fondo = Toolkit.getDefaultToolkit().getImage("./resources/46888871-624a3900-ce7f-11e8-808e-99fd90c8a3f4.png");
        fondo = fondo.getScaledInstance(500, 300, java.awt.Image.SCALE_SMOOTH);

        flappyImg = Toolkit.getDefaultToolkit().getImage("./resources/flappy.png");
        flappyImg = flappyImg.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(teclasDireccion.containsKey(e.getKeyCode()))
                    teclasDireccion.put(e.getKeyCode(),true);
            }
            @Override
            public void keyReleased(KeyEvent e) {
                if(teclasDireccion.containsKey(e.getKeyCode()))
                    teclasDireccion.put(e.getKeyCode(),false);
            }
        });

        Timer timer = new Timer(refreshRate,e->{
            int x = posicion.x;
            int y = posicion.y;
            if(teclasDireccion.get(KeyEvent.VK_DOWN))
                y += refreshRate/10;
            else if(teclasDireccion.get(KeyEvent.VK_UP))
                y -= refreshRate/10;
            else
                //Se mete efecto de caer continuamente
                y += refreshRate/14;
            if(teclasDireccion.get(KeyEvent.VK_RIGHT))
                x += refreshRate/10;
            if(teclasDireccion.get(KeyEvent.VK_LEFT))
                x -= refreshRate/10;
            if(teclasDireccion.get(KeyEvent.VK_SPACE))
                y -= refreshRate/10*6;
            posicion = new Point(x,y);
            repaint();
        });
        timer.start();

    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, this);
        g.drawImage(flappyImg,posicion.x,posicion.y,this);


    }


}