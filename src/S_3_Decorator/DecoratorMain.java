//<editor-fold defaultstate="collapsed" desc="Lec">
//</editor-fold>
package S_3_Decorator;

public class DecoratorMain {
    public static void main(String[] args) {
       //<editor-fold defaultstate="collapsed" desc="Lec">
        shape c = new circle();
        shape r = new rect();
        shape redc = new redshdecorator(new circle());
        shape redr = new redshdecorator(new rect());
        System.out.println("circle with normal border");
        c.draw();
        System.out.println("\nrect with normal border");
        r.draw();
        System.out.println("\ncircle red border");
        redc.draw();
        System.out.println("\nrect red border");
        redr.draw();
       
       
       //</editor-fold>
      
       //<editor-fold defaultstate="collapsed" desc="Lab">
        System.out.println("\n\nLab:\n");
       widget wdg = 
            new borderdec(
                 new borderdec(
                     new scrolldec(
                         new tf(80,24))));
       wdg.draw();
//       //</editor-fold>
       
//        p prs= new person("alaa","hassan");
//        prs.dispnm();
//       pdec pd = new pdec(prs);
//       pd.setId(1);
//       pd.dispnm();
    }
}
//<editor-fold defaultstate="collapsed"  desc="Lec">
interface shape{
    public void draw();
}
class circle implements shape{

    @Override
    public void draw() {
        System.out.println("draw: circle");
    }
}
class rect implements shape{

    @Override
    public void draw() {
        System.out.println("draw: rect");
    }
}
abstract class shdecorator implements shape{

    protected shape decsh;
    public shdecorator(shape newdecsh){
        decsh = newdecsh;
    }
    @Override
    public void draw() {
        decsh.draw();
    }
}
class redshdecorator extends shdecorator{

    public redshdecorator(shape newdecsh){
        super(newdecsh);
    }
    @Override
    public void draw() {
        decsh.draw();
        this.setborder(decsh);
    }
    public void setborder(shape decsh2){
        System.out.println("border clr: red");
    }
}

//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Lab">
interface widget{
    void draw();
}
class tf implements widget{

    private int w,h;
    
    public tf(int ww,int hh){
        w=ww;h=hh;
    }
    @Override
    public void draw() {
        System.out.println("tf: w:"+w+" h:"+h);
    }
    
}
class widdec implements widget{

    protected widget w;
    public widdec(widget ww){
        w=ww;
    }
    @Override
    public void draw() {
        w.draw();
    }
}
class borderdec extends widdec{

    public borderdec(widget ww) {
        super(ww);
    }
    public void draw(){
        w.draw();
        System.out.println("+ border");
    }
}
class scrolldec extends widdec{

    public scrolldec(widget ww) {
        super(ww);
    }
    public void draw(){
        w.draw();
        System.out.println("+ scroll");
    }
}
//</editor-fold>

//<editor-fold defaultstate="collapsed"  desc="Lec ex">
interface p{
    public void dispnm();
}

final class person implements p{
    private final String fn,ln;

    public person(String fn, String ln) {
        this.fn = fn;
        this.ln = ln;
    }
    public void dispnm(){
        System.out.print("\nfn:"+fn+" ln:"+ln);
    }
}
class pdec implements p{

    p pp;
    int id;
    pdec(p pr){
        pp=pr;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public void dispnm() {
        pp.dispnm();
        System.out.println(" id:"+id);
    }
    
}

//</editor-fold >
