//<editor-fold defaultstate="collapsed" desc="Lec">
//</editor-fold>
package S_4_Composite;

import java.util.ArrayList;

public class CompositeMain {
    public static void main(String[] args) {

        emp ceo = new emp("ceojohn","ceo",30000);
        emp hs = new emp("hsjohn","hs",20000);
        emp hm = new emp("hmjohn","hm",20000);
        emp m = new emp("mjohn","m",10000);
        emp m2 = new emp("m2john","m2",10000);
        emp s = new emp("sjohn","s",10000);
        emp s2 = new emp("s2john","s2",10000);

        ceo.add(hs);
        ceo.add(hm);

        hs.add(s);
        hs.add(s2);

        hm.add(m);
        hm.add(m2);

        System.out.println(ceo.tostr());
        for(emp hemp : ceo.getsub()){
            System.out.println(hemp.tostr());
            for(emp em : hemp.getsub())
                System.out.println(em.tostr());
        }
        
        
        folder f1= new folder("parent");
        folder f2= new folder("child1");
        folder f3= new folder("child2");
        folder f4= new folder("child11");
        f1.add(f2); f1.add(f3);
        f2.add(f4);
        System.out.println(f1.tostr());
        for(folder f : f1.getSubd()){
            System.out.println("   "+f.tostr());
            for(folder ff : f.getSubd())
                System.out.println("      "+ff.tostr());
        }
    }
}
class emp{
    private String name,dept;
    private float sal;
    private ArrayList<emp> sub;
    
    public emp(String n, String d, float s){
        name=n;dept=d;sal=s;
        sub = new ArrayList<>();
    }
    public void add(emp e){
        sub.add(e);
    }
    public void rem(emp e){
        sub.remove(e);
    }
    public ArrayList<emp> getsub(){
        
        return sub;
    }
    public String tostr(){ 
        
        return ("Employee:[Name: "+name+", dept: "+dept+", sal: "+sal+"]");
    
    }
}

class folder{
    ArrayList<folder>subd;
    String nm;

    public ArrayList<folder> getSubd() {
        return subd;
    }

    public folder(String n) {
        subd = new ArrayList<>();
        nm=n;
    }
    public String tostr(){
        return ("Folder: Name: "+nm);
    }
    public void add(folder s){
        subd.add(s);
    }
    
    
}