package B_2_Iterator;

public class IteratorMain {
    
    public static void main(String[] args) {
    
        //<editor-fold defaultstate="collapsed">
        cont nr = new nmrep();
        for(iter i = nr.getiter(); i.hasnext();)
        {
            String n = (String)i.next();
            System.out.println("Name: "+n);
        }
        //</editor-fold>
        langrep lr = new langrep();
        for(abstiter i = lr.getiter(); i.has();)
        {
            String n = (String)i.next();
            System.out.println("Lang: "+n);
        }
        
    }
}
//<editor-fold>
interface iter{
    public boolean hasnext();
    public Object next();
}
class nmiter implements iter{
    String [] nms;
    int ind;
    
    nmiter(String [] n){
        nms=n;
        ind=0;
    }
    
    @Override
    public boolean hasnext() {
        return ind<nms.length-1;
    }
    

    @Override
    public Object next() {
        if(hasnext())
            return nms[ind++];
        return null;
    }
}
interface cont{
    public iter getiter();
}
class nmrep implements cont{
    private String [] nms={"alaa","hassan","mahmoud","abdelhalim"};
    private iter nmit;
    
    @Override
    public iter getiter() {
        nmit= new nmiter(nms);
        return nmit;
    }
}
//</editor-fold>

interface abstiter{
    public Object next();
    public boolean has();
}
class langiter implements abstiter{

    String [] l;
    int ind;
    
    langiter(String [] ll){
        l=ll;
        ind=0;
    }
    
    @Override
    public Object next() {
        if(has())
            return l[ind++];
        return null;
    }

    @Override
    public boolean has() {
        if(ind< l.length)
            return true;
        return false;
    }
}
interface cont2{
    public abstiter getiter();
}
class langrep implements cont2{

    String [] langs = {"Arabic","English","French"};
    langiter li;
    
    
    
    @Override
    public abstiter getiter() {
        li = new langiter(langs);
        return li;
    }
    
}