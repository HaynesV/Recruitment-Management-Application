
package Views.javaswingdev.login.login;

import Views.javaswingdev.login.shadow.ShadowRenderer;
import com.twelvemonkeys.image.ImageUtil;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class background extends JComponent {

    private Icon image;
    private BufferedImage bufferedImage;
    private Component blur;

    public Component getBlur() {
        return blur;
    }

    public void setBlur(Component blur) {
        this.blur = blur;
    }

    public background() {
        image = new ImageIcon(getClass().getResource("/Views/javaswingdev/login/login/image.jpg"));
    }

    private void createImage() {
        if (image != null) {
            int witdh = getWidth();
            int height = getHeight();
            if (witdh > 0 && height > 0) {
                bufferedImage = new BufferedImage(witdh, height, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2 = bufferedImage.createGraphics();
                g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                Rectangle rec = getAutoSize(image);
                g2.drawImage(((ImageIcon)image).getImage(), rec.x, rec.y,rec.width,rec.height,null );
                if(blur != null){
                    createBlurImage(g2);
                }
                g2.dispose();

            }   
        }
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height); 
        createImage();
// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    
   
    
    
    private Rectangle getAutoSize(Icon image) {
        int w = getWidth();
        int h = getHeight();
        int iw = image.getIconWidth();
        int ih = image.getIconHeight();
        double xScale = (double) w / iw;
        double yScale = (double) h / ih;
        double scale = Math.max(xScale, yScale);
        int width = (int) (scale * iw);
        int height = (int) (scale * ih);
        if (width < 1) {
            width = 1;
        }
        if (height < 1) {
            height = 1;
        }
        int x = (w - width) / 2;
        int y = (h - height) / 2;
        return new Rectangle(new Point(x, y), new Dimension(width, height));
    }
    private void createBlurImage(Graphics2D g){
        int x= blur.getX();
        int y = blur.getY();
        int witdh =blur.getWidth();
        int height =blur.getHeight();
        int shadow = 8;
        if(witdh > 0 && height > 0){
            BufferedImage img = new BufferedImage(witdh, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = img.createGraphics();
            g2.drawImage(ImageUtil.blur(bufferedImage.getSubimage(x, y, witdh, height),10f), 0, 0, null);
          
            g2.dispose();  
           
            g.drawImage(new ShadowRenderer(shadow,0.3f,new Color(0,0,0)).createShadow(img),(int)(x-shadow*0.8f), (int)(y-shadow*0.8f),null);
            g.drawImage(img, x, y,null);
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(bufferedImage, 0, 0, null);
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
