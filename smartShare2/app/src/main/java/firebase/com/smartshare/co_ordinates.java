package firebase.com.smartshare;

public class co_ordinates {
    public float x;
    public  float y;
    public String position;
    public String user;

    @SuppressWarnings("unused")
    public co_ordinates(){

    }
    public co_ordinates( float x,float y, String position,String user){
       this.x=x;
        this.y=y;
        this.position=position;
        this.user=user;
    }


    public void setY(float y) {
        this.y = y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public float getY() {
        return y;
    }

    public float getX() {
        return x;
    }
    @Override
    public String toString() {
        return "co_ordinates{x='" + x + "\', y='" + y + "\', position='" + position + "'}";
    }
}
