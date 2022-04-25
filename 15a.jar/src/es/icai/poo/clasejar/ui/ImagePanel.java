package es.icai.poo.clasejar.ui;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private Image img;
    private Image scaled;

    public ImagePanel(Image img) {
        this.img = img;
    }

    @Override
    public void invalidate() {
        super.invalidate();
        int width = getWidth();
        int height = getHeight();
        if (width > 0 && height > 0) {
            scaled = img.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(scaled, 0, 0, null);
    }
}