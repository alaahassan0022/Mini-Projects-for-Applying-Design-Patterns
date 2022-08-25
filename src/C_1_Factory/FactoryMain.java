//<editor-fold defaultstate="collapsed" desc="Lec">
//</editor-fold>
package C_1_Factory;

import java.text.NumberFormat;
import java.util.*;

public class FactoryMain {
    public static void main(String[] args) {
        //<editor-fold defaultstate="collapsed" desc="Lec">
        shapefactory shf = new shapefactory();
        shape sh;
        
        sh = shf.getshape("circle");
        sh.draw();
        
        sh = shf.getshape("rect");
        sh.draw();
        
        sh = shf.getshape("square");
        sh.draw();
        
        
        System.out.println("\nRl UC:");
        
        NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println(us.format(10.57f));
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Lab">
    dlg dd;
    Scanner s = new Scanner(System.in);
    String d =  s.next();
    if(d.equals("win"))
        dd = new wnddlg();
    else
        dd = new webdlg();
    dd.crtbtn();
    dd.render();
//</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Lec ex">
carfct cf = new carfct();
cf.getcar("toyota");
cf.getcar("bmw");
cf.getcar("volvo");

//</editor-fold>
    }
}
//<editor-fold defaultstate="collapsed" desc="Lec">
interface shape{
    public void draw();
}
class rect implements shape{

    @Override
    public void draw() {
        System.out.println("draw() in rect");
    }

}
class square implements shape{

    @Override
    public void draw() {
          System.out.println("draw() in square");
    }

}
class circle implements shape{

    @Override
    public void draw() {
        System.out.println("draw() in circle");
    }

}
class shapefactory{

    shape getshape(String sh){
    
        if(sh.equals("rect"))
            return new rect();
        else if(sh.equals("square"))
            return new square();
        else
            return new circle();
        
    }
    
}
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Lab">
interface btn{
    public void render();
    public void onclk();
}
class wndbtn implements btn {

    @Override
    public void render() {
        System.out.println("wndbtn render");
    }

    @Override
    public void onclk() {
        System.out.println("wndbtn onclk");

    }
    
}
class htmlbtn implements btn {

    @Override
    public void render() {
        System.out.println("htmlbtn render");
    }

    @Override
    public void onclk() {
        System.out.println("htmlbtn onclk");

    }
    
}
abstract class dlg{
    btn b;
    public abstract void render();
    public abstract btn crtbtn();
}
class wnddlg extends dlg{

    
    @Override
    public void render() {
        b.render();
    }

    @Override
    public btn crtbtn() {
        b = new wndbtn();
        return b;
    }
}
class webdlg extends dlg{


    @Override
    public void render() {
       b.render();
    }

    @Override
    public btn crtbtn() {
        b = new htmlbtn();
        return b;
    }
}
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Lec ex">
abstract class car{
    String clr,trns;
    int maxsp;
    public void fwd(){System.out.println("fwd");}
    public void bkwd(){System.out.println("bkwd");}
}
class toyota extends car{

    public toyota(String c, String t,int m) {
        clr=c;trns=t;maxsp=m;
        System.out.println("toyota: "+c+" "+t+" "+m);
    }
    
}
class bmw extends car{

    public bmw(String c, String t,int m) {
        clr=c;trns=t;maxsp=m;
        System.out.println("bmw: "+c+" "+t+" "+m);
    }
    
}
class volvo extends car{

    public volvo(String c, String t,int m) {
        clr=c;trns=t;maxsp=m;
        System.out.println("volvo: "+c+" "+t+" "+m);
    }
    
}

class carfct{
    public car getcar(String br){
        if(br.equals("toyota"))
            return new toyota("red","au",200);
        if(br.equals("bmw"))
                return new bmw("black","au",300);
        if(br.equals("volvo"))
                return new volvo("white","au",320);
        return null;
    }
    
}

//</editor-fold>