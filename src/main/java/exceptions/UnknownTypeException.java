package exceptions;

public class UnknownTypeException extends Exception{
    public UnknownTypeException(String type){
        super("\"" + type + "\" does not exist in the available types: {Circle,Rectangle,Image}");

    }
}
