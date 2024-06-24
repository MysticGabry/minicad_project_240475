import myUtils.Position;
import org.junit.jupiter.api.Test;
import type.Image;
import type.ImagePanel;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestImage {
    @Test
    public void testImage() {
        assert Image.getImagesList().isEmpty();
        Image image = new Image("C:\\Users\\Utente\\Desktop\\prova.jpg", new Position(0, 0));
        assert Image.getImagesList().size() == 1;
    }

    @Test
    public void testImagePanel() {
        Image image = new Image("C:\\Users\\Utente\\Desktop\\prova.jpg", new Position(0, 0));
        ImagePanel p1 = new ImagePanel(image);
        assert p1.getImage() != null;
        assertThrows(Exception.class, () -> {
            ImagePanel p2 = new ImagePanel(new Image("INVALID PATH FOR TESTING", new Position(0, 0)));
        });
    }
}
