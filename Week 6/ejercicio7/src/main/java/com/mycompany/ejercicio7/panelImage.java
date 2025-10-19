package com.mycompany.ejercicio7;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class panelImage extends JPanel {
    
    @Override
    public void paint(Graphics g) {
        Dimension dimension = this.getSize();
ImageIcon icon = new ImageIcon(getClass().getResource("/resources/Pista.jpg"));
g.drawImage(icon.getImage(), 0, 0, dimension.width, dimension.height, null);
        setOpaque(false);
        super.paintChildren(g);
    }
}
