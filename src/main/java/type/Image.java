package type;

import costants.CostantValues;
import exceptions.MaximumNumberImagesException;
import myUtils.Position;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Image{
    private static List<Image> imagesList = new ArrayList<>();
    private String path;
    private String id;
    private Position center;
    private static int cnt = 0;

    public Image(String path, Position center) {
        if (!Files.exists(Paths.get(path))) {
            throw new IllegalArgumentException("Image file does not exist at the specified path");
        }
        if (!isImage(path)) {
            throw new IllegalArgumentException("The specified file is not a valid image");
        }
        this.path = path;
        this.id = "Image" + (++cnt);
        this.center = center;
        if(imagesList.size()<1000){
            imagesList.add(this);
        }else{
            try {
                throw new MaximumNumberImagesException();
            } catch (Exception e) {
                    throw new RuntimeException(e);
            }

        }
        CostantValues.allFiguresList.add(this);
    }

    private boolean isImage(String path) {
        try {
            BufferedImage image = ImageIO.read(new File(path));
            return image != null;
        } catch (Exception e) {
            return false;
        }
    }

    public String getPath() {
        return path;
    }

    public String getId() {
        return id;
    }

    public Position getCenter() {
        return center;
    }

    public static List<Image> getImagesList() {
        return imagesList;
    }
}
