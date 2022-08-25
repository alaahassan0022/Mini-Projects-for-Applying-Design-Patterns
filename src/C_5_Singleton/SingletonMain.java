package C_5_Singleton;

public class SingletonMain {
    public static void main(String[] args) {
       
       //<editor-fold defaultstate="collapsed" desc="lec">
        singleton obj = singleton.getinstance();
        obj.showmsg();
       //</editor-fold>
       
       //<editor-fold defaultstate="collapsed" desc="lab">
       user u = user.getinstance();
       u.fn="firstname";u.ln="lastname";u.sal=6000;
       u.info();
       //</editor-fold>

       //<editor-fold defaultstate="collapsed" desc="lec ex">

       dbcon dc= dbcon.getInst();
       dc.showcon();
       //</editor-fold >

    }
}



//<editor-fold defaultstate="collapsed" desc="lab">
class user{
    private user(){}

    private static user u = new user();

    static user getinstance(){ return u;}

    String fn,ln;
    int sal;
    public void info(){
        System.out.println("fn: "+fn+", ln: "+ln+", sal: "+sal);
    }
}
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="lec">

class singleton{
    
    private static singleton instance= new singleton();
    private singleton(){
    
    }
    public static singleton getinstance(){
        return instance;
    }
    public void showmsg(){
        System.out.println("singleton ptrn");
    }
}
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="lec ex">
class dbcon{
    private dbcon(){}
    private static dbcon inst = new dbcon();

    public static dbcon getInst() {
        return inst;
    }
    public void showcon(){
        System.out.println("orcl,1521,hr");
    }
}
//</editor-fold >

