package S_2_Bridge;

public class BridgeMain {
    public static void main(String[] args) {
//<editor-fold defaultstate="collapsed" desc="lec">

        shape red = new circle(new redcircle(),10,9,8);
        shape green = new circle(new greencircle(),4,3,2);
        red.draw();
        green.draw();
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="lab">
    vehicle v1= new car(new produce(),new assemble());
    v1.manufacture();
    vehicle v2= new bike(new produce(),new assemble());
    v2.manufacture();
//</editor-fold>

    
    }
}
// <editor-fold defaultstate="collapsed" desc="Lec">

interface drawapi{
    public void drawcircle(int r,int x, int y);
}
class redcircle implements drawapi{

    @Override
    public void drawcircle(int r, int x, int y) {
        System.out.println("Draw circle color: red, radius: "+r+", x: "+x+", y: "+y);
    }
    
}
class greencircle implements drawapi{

    @Override
    public void drawcircle(int r, int x, int y) {
        System.out.println("Draw circle color: green, radius: "+r+", x: "+x+", y: "+y);
    }
    
}
abstract class shape{
    //bridging
    public drawapi dapi;
    
    public shape(drawapi dapi){ this.dapi = dapi;}
    public abstract void draw();
}
class circle extends shape{
    private int x,y,r;
    public circle(drawapi dapi,int r, int x, int y){
        super(dapi);
        this.x=x;this.y=y;this.r=r;
    }
    
    @Override
    public void draw() {
        dapi.drawcircle(r, x, y);
    }

}

// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Lab">
abstract class vehicle{
    protected workshop ws1,ws2;
    protected vehicle(workshop ws11, workshop ws22){this.ws1 = ws11; this.ws2 = ws22;}
    public abstract void manufacture();
}
class car extends vehicle{

    public car(workshop ws11, workshop ws22){
        super(ws11,ws22);
        System.out.println("car");
    }
    @Override
    public void manufacture() {
        ws1.work();
        ws2.work();
    }

}
class bike extends vehicle{
    public bike(workshop ws11, workshop ws22){
        super(ws11,ws22);
        System.out.println("bike");
    }
    @Override
    public void manufacture() {
        ws1.work();
        ws2.work();
    }
}
interface workshop{
    public void work();
}
class produce implements workshop{

    @Override
    public void work() {
        System.out.println("produce");
    }
}
class assemble implements workshop{

    @Override
    public void work() {
        System.out.println("assemble");
    }
}
// </editor-fold>
