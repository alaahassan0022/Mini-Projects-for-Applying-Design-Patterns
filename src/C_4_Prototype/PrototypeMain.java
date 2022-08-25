package C_4_Prototype;

import java.util.*;

public class PrototypeMain {
    public static void main(String[] args) {
        //<editor-fold defaultstate="collapsed" desc="lec">

        shapecache.loadchache();
        shape clonedsh; 
        
        clonedsh = (shape) shapecache.getshape("1");
        System.out.println("shape: "+clonedsh.gettype());
        
        clonedsh = (shape) shapecache.getshape("2");
        System.out.println("shape: "+clonedsh.gettype());

        clonedsh = (shape) shapecache.getshape("3");
        System.out.println("shape: "+clonedsh.gettype());
        //</editor-fold >
        
        //<editor-fold defaultstate="collapsed" desc="lec ex">
        carcache.loadcache();
        car t = carcache.getcar("t");
        System.out.println(t.type);
        car v = carcache.getcar("v");
        System.out.println(v.type);
        car f = carcache.getcar("f");
        System.out.println(f.type);
//</editor-fold >
    }
}
//<editor-fold defaultstate="collapsed" desc="lec">

abstract class shape implements Cloneable{
    public String id;
    public String type;
    
    abstract void draw();
    public String getid(){return this.id;}
    public String gettype(){return this.type;}
    public void setid(String id){
        this.id=id;
    }
    public Object clone(){
        Object cloneobj = null;
        try {
            cloneobj = super.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return cloneobj;
    }
}
class rect extends shape{

    public rect(){
        type ="rect";
    }
    @Override
    void draw() {
        System.out.println("draw rect");
    }

}
class square extends shape{

    public square(){
        type ="square";
    }
    @Override
    void draw() {
        System.out.println("draw square");
    }

}
class circle extends shape{

    public circle(){
        type ="circle";
    }
    @Override
    void draw() {
        System.out.println("draw circle");
    }

}
class shapecache{
    private static Hashtable<String,shape> hashmap=new Hashtable<>();
    
    public static shape getshape(String shapeid){
        
        shape cachedsh = hashmap.get(shapeid);
        
        return (shape)cachedsh.clone(); // cloning
    }
    
    public static void loadchache(){
        circle csh = new circle();
        csh.setid("1");
        hashmap.put("1", csh);
        square ssh = new square();
        ssh.setid("2");
        hashmap.put("2", ssh);
        rect rsh = new rect();
        rsh.setid("3");
        hashmap.put("3", rsh);
    }
}
//</editor-fold >

//<editor-fold defaultstate="collapsed" desc="lec ex">
abstract class car implements Cloneable{
    String type;
    
    public Object clone(){
        Object cloneobj = null;
        try {
            cloneobj = super.clone();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return cloneobj;
    }
}
class toyota extends car{
    toyota(){type="toyota";}
}
class volvo extends car{
    volvo(){type="volvo";}
}
class fiat extends car{
    fiat(){type="fiat";}
}

class carcache{
    private static Hashtable<String,car> hashmap=new Hashtable<>();
    
    public static void loadcache(){
        hashmap.put("t",new toyota());
        hashmap.put("v",new volvo());
        hashmap.put("f",new fiat());
    }
    public static car getcar(String carid){
        car cachedcar = hashmap.get(carid);
        return (car)cachedcar.clone(); // cloning
    }
}
//</editor-fold >
