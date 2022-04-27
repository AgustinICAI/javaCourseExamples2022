package examen;

import jdk.internal.jimage.ImageStrings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.HashSet;

public class JVentanaMonitorizacion extends JFrame {
    String idMonitor;
    JTextArea txtEventos;
    HashSet<String> sensoresSubscritos;
    TreeSet<Sensor> sensoresAnadidos;
    boolean ventanaCerrada = false;

    JVentanaMonitorizacion(String idMonitor){
        this.idMonitor = idMonitor;
        this.sensoresSubscritos = new HashSet<>();
        initComponents();
    }

    private void initComponents() {
        JLabel lblTitulo = new JLabel("Monitor " + idMonitor);
        lblTitulo.setHorizontalAlignment(JLabel.CENTER);
        txtEventos = new JTextArea();
        txtEventos.setEditable(false);
        txtEventos.setColumns(10);
        txtEventos.setRows(10);
        JTextField txtSensor = new JTextField();
        txtSensor.setColumns(10);
        JButton btnSubscribe = new JButton("SUBSCRIBIRSE");
        JPanel pnlSouth = new JPanel();
        pnlSouth.add(txtSensor);
        pnlSouth.add(btnSubscribe);

        this.add(lblTitulo,BorderLayout.NORTH);
        this.add(txtEventos,BorderLayout.CENTER);
        this.add(pnlSouth, BorderLayout.SOUTH);

        this.pack();
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                IOSensores.writeObjects(sensoresAnadidos))));
                dispose();
                ventanaCerrada = true;
            }
        });
        btnSubscribe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                this.eventosSubscritos.add(txtSensor.getText());
            }
        });

    }

    public HashSet<String> getSensoresSubscritos() {
        return sensoresSubscritos;
    }

    public void addEventoMonitorizacion(Sensor sensorNuevo) {
        this.txtEventos.append("\n"+sensorNuevo);
        this.sensoresAnadidos.add(sensorNuevo);
    }

    public boolean isVentanaCerrada()
    {
        return ventanaCerrada;
    }
}
