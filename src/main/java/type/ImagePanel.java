package type;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImagePanel extends JPanel {
    private static List<Image> images = new ArrayList<>();
    private Image image;
    private BufferedImage bufferedImage;

    public ImagePanel(Image image) {
        if (image == null) {
            throw new IllegalArgumentException("Image is null");
        } else {
            this.image = image;
            images.add(image);
            try {
                bufferedImage = ImageIO.read(new File(image.getPath()));
            } catch (IOException e) {
                throw new IllegalArgumentException("Unable to load image from path: " + image.getPath(), e);
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (bufferedImage != null) {
            return new Dimension(bufferedImage.getWidth(), bufferedImage.getHeight());
        } else {
            return super.getPreferredSize();
        }
    }

    public static List<Image> getImages() {
        return images;
    }

    public Image getImage() {
        return image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 1;
        int y = 1;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        if (bufferedImage != null) {
            g2d.drawImage(bufferedImage, x, y, getPreferredSize().getSize().width, getPreferredSize().height, this);
        }
    }
}