package myUtils;

public class Position {
    private float x;//posfloat
    private float y;//posfloat

    public Position(){}
    public Position(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder(100);
        sb.append("Position [x="+x+", y="+y+"]");
        return sb.toString();
    }
}
