package exceptions;

public class MaximumNumberImagesException extends Exception{
    public MaximumNumberImagesException(){
        super("Maximum number of images exceeded (1000)");
    }
}
