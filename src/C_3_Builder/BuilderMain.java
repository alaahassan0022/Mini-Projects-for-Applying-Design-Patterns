package C_3_Builder;

import java.util.ArrayList;

public class BuilderMain {
    public static void main(String[] args) {
//<editor-fold defaultstate="collapsed" desc="Lec">
        mealbuilder mb = new mealbuilder();
        meal newmeal = mb.prepnonvegmeal();
        newmeal.showitems();
        System.out.println("nonvegmeal cost: "+newmeal.getcost()+"\n\n");
        
        newmeal = mb.prepvegmeal();
        newmeal.showitems();
        System.out.println("vegmeal cost: "+newmeal.getcost());
//</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Lab">
        waiter w = new waiter();
        w.setpb(new hpb());
        w.constructp();
        pizza p = w.getp();
        //</editor-fold>  
    }
}
//<editor-fold defaultstate="collapsed" desc="Lec">
interface packing{
    public String pack();
}
class wrapper implements packing{

    @Override
    public String pack() {
        return "wrapper";
    }

}
class bottle implements packing{

    @Override
    public String pack() {
        return "bottle";
    }

}
abstract interface item{
    public packing packingofitem();
    public abstract String name();
    public abstract float price();

}
abstract class burger implements item{

    public abstract String name();

    @Override
    public packing packingofitem() {
       return new wrapper();
    }

    public abstract float price();

}
class vegburger extends burger{

    public String name(){
        return "VegBurger";
    }

    public float price(){
        return 10.0f;
    }
}
class chickenburger extends burger{

    public String name(){
        return "ChickenBurger";
    }

    public float price(){
        return 20.0f;
    }
}
abstract class colddrink implements item{

    public abstract String name();

    @Override
    public packing packingofitem() {
       return new bottle();
    }

    public abstract float price();

}
class pepsi extends colddrink{

    public String name(){
        return "pepsi";
    }

    public float price(){
        return 5.0f;
    }
}
class coke extends colddrink{

    public String name(){
        return "coke";
    }

    public float price(){
        return 6.0f;
    }
}
class meal{
    
    private ArrayList<item> items = new ArrayList<>();
    public void additem(item it){
        items.add(it);
    }
    public float getcost(){
        float sum=0;
        for(int i=0;i<items.size();i++){
            sum+=items.get(i).price();
        }            
        return sum;
    }
    public void showitems(){
        for(int i=0;i<items.size();i++){
            System.out.println(items.get(i).name() + ", " +items.get(i).price() + ", " + items.get(i).packingofitem().pack());
        }
    
    }
    
}
class mealbuilder{
    public meal prepvegmeal(){
        meal m = new meal();
        m.additem(new vegburger());
        m.additem(new pepsi());
        return m;
    }
    public meal prepnonvegmeal(){
        meal m = new meal();
        m.additem(new chickenburger());
        m.additem(new coke());
        return m;
    }
}
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Lab">
class pizza{
    private String d,s,t;

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }
    
}
abstract class pb{
    protected pizza p;

    public pizza getP() {
        return p;
    }
    public void crtnew(){
        p= new pizza();
    }
    public abstract void bd();
    public abstract void bs();
    public abstract void bt();
}
class spb extends pb{

    @Override
    public void bd() {
        p.setD("pan");
    }

    @Override
    public void bs() {
        p.setS("hot");
    }

    @Override
    public void bt() {
        p.setT("pepperoni + salami");
    }
}
class hpb extends pb{

    @Override
    public void bd() {
        p.setD("cross");
    }

    @Override
    public void bs() {
        p.setS("mild");
    }

    @Override
    public void bt() {
        p.setT("meat+pineapple");
    }
}
class waiter{
    pb p;
    void setpb(pb pp){
        p=pp;
    }
    pizza getp(){return p.getP();}
    
    void constructp(){
        p.crtnew();
        p.bd();p.bs();p.bt();
    }
}
//</editor-fold>