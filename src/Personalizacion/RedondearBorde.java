
package Personalizacion;

import com.sun.javafx.iio.ImageLoader;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.awt.RenderingHints;
import java.awt.Paint;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author mateo
 */
public class RedondearBorde extends JTextField{
    private int arcw=20;
    private int arch=20;
    private Image image;
    private Icon icon;

    public RedondearBorde(String path) {
        setOpaque(false);
        setBorder(new EmptyBorder(0,5,0,7));
        setPreferredSize(new Dimension(100,20));
        if(!(path == null)){
            image = loadImage(path);
        }
    }
    
    private static Image loadImage(String fileName) {
        try {
            return ImageIO.read(RedondearBorde.class.getResource(fileName));
        } catch (IOException ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(2f);
        g2.setStroke(stroke);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        Paint oldPaint = g2.getPaint();
        RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(0,0,getWidth(),getHeight(),arcw,arch);
        g2.clip(r2d);
        g2.setPaint(new GradientPaint(0.0f, 0.0f, getBackground(),0.0f, getHeight(), getBackground()));
        g2.fillRect(0,0,getWidth(),getHeight());
        g2.fillRoundRect(0,0,getWidth()-10,getHeight(),arcw,arch);
        if(getImage()!=null){
            g2.drawImage(getImage(), 5, 2, getHeight()-3, getHeight()-3, null);
            setBorder(new EmptyBorder(0,(int)(getHeight()*1.2),0,2));
            //g2.drawImage(getImage(), getWidth()-15, getHeight()-13,13, 13, null);
        }
        
        g2.setPaint(new GradientPaint(0.0f, 0.0f, Color.BLACK,0.0f, getHeight(), Color.BLACK));
        g2.drawRoundRect(0, 0, getWidth(), getHeight(), arcw, arch);
        g2.setPaint(oldPaint);
        super.paintComponent(g);
    }
    
    public int getArcw() {
        return arcw;
    }
    
    public void setArcw(int arcw) {
        this.arcw = arcw;
    }
    
    public int getArch() {
        return arch;
    }
    
    public void setArch(int arch) {
        this.arch = arch;
    }
    
    public Image getImage() {
        return image;
    }
    
    public void setImage(Image image) {
        this.image = image;
    }
    
    public Icon getIcon() {
        return icon;
    }
    
    public void setIcon(Icon icon){
        this.icon=icon;
        setImage(((ImageIcon)icon).getImage());
    }
    
}

