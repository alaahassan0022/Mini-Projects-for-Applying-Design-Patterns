//<editor-fold defaultstate="collapsed" desc="Lab">
//</editor-fold>
package C_2_AbstractFactory;

public class AbstractFactoryMain {
    public static void main(String[] args) {
//<editor-fold defaultstate="collapsed" desc="Lec">
        factoryproducer fp= new factoryproducer();
        abstractfactory af = fp.getfactory(true);
        shape sh;
        
        sh = af.getshape("square");
        sh.draw();
        sh = af.getshape("rect");
        sh.draw();
        
        af = fp.getfactory(false);
        
        sh = af.getshape("square");
        sh.draw();
        sh = af.getshape("rect");
        sh.draw();
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Lab">
        abstfact abf = factcrt.getfact("bank");
        bank b = abf.getbank("hdfc");
        System.out.println(b.getbankname());
        abf = factcrt.getfact("loan");
        loan l = abf.getloan("hl");
        l.getrate(0);
        l.calcloanpmnt(0, 0);
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Lec ex">
        abstmnfctr a = mnfctrs.getmnfctr("toyota");
        car c = a.getcar("suv");
        car c2 = a.getcar("sedan");
        a= mnfctrs.getmnfctr("fiat");
        c=a.getcar("suv");
        c2 = a.getcar("sedan");
//</editor-fold>
    }
    
}
//<editor-fold defaultstate="collapsed" desc="Lec">
interface shape{
    void draw();
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
class roundrect implements shape{

    @Override
    public void draw() {
          System.out.println("draw() in roundrect");
    }

}
class roundsquare implements shape{

    @Override
    public void draw() {
          System.out.println("draw() in roundsquare");
    }

}
abstract class abstractfactory{
    public abstract shape getshape(String sh);
}
class shapefactory extends abstractfactory{

    @Override
    public shape getshape(String sh) {
        if(sh.equals("rect"))
            return new rect();
        else
            return new square();
    }
    
}
class roundshapefactory extends abstractfactory{

    @Override
    public shape getshape(String sh) {
        if(sh.equals("rect"))
            return new roundrect();
        else
            return new roundsquare();
    }
    
}
class factoryproducer{
    public abstractfactory getfactory(boolean round){
        if(round)
            return new roundshapefactory();
        else
            return new shapefactory();
    }
}
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Lab">
class factcrt{
    
    static abstfact getfact(String f){
        if(f.equals("bank"))
            return new bankfact();
        else
            return new loanfact();
    }
}


abstract class abstfact{
    abstract bank getbank(String b);
    abstract loan getloan(String l);
}
class bankfact extends abstfact{

    @Override
    bank getbank(String b) {
        if(b.equals("hdfc"))
            return new hdfc();
        else if(b.equals("sbi"))
            return new sbi();
        else
            return new icici();
    }

    @Override
    loan getloan(String l) {
        return null;
    }

}
class loanfact extends abstfact{

    @Override
    bank getbank(String b) {
        return null;
    }

    @Override
    loan getloan(String l) {
        if(l.equals("bl"))
            return new bl();
        else if (l.equals("hl"))
            return new hl();
        else
            return new el();
    }

}
interface bank{
    public String getbankname();
}
class hdfc implements bank{
    private String bname;

    hdfc(){
    bname ="hdfc";
    }
    
    @Override
    public String getbankname() {
       return bname; 
    }

}
class icici implements bank{
    private String bname;

    icici(){
    bname ="icici";
    }
    
    @Override
    public String getbankname() {
       return bname; 
    }

}
class sbi implements bank{
    private String bname;

    sbi(){
    bname ="sbi";
    }
    
    @Override
    public String getbankname() {
       return bname; 
    }

}

abstract class loan{
    protected double rate;
    abstract void getrate(double r);
    public void calcloanpmnt(double loanamnt, int yrs){
        double emi;
        int n;
        n=yrs*12;
        rate = rate/1200;
        emi = n+rate*n;
        System.out.println("emi:"+emi+" lamnt:"+loanamnt);
    }
}
class hl extends loan{

    @Override
    void getrate(double r) {
        rate =r;
    }
}
class bl extends loan{

    @Override
    void getrate(double r) {
        rate =r;
    }
}
class el extends loan{

    @Override
    void getrate(double r) {
        rate =r;
    }
}
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Lec ex">
abstract class car{
    String type,brand;
}
class suvtoyota extends car{
    suvtoyota(){
        brand = "toyota";
        type = "suv";
        System.out.println(type+" "+brand);
    }
}
class suvfiat extends car{
    suvfiat(){
        brand = "fiat";
        type = "suv";
        System.out.println(type+" "+brand);
    }
}
class sedanfiat extends car{
    sedanfiat(){
        brand = "fiat";
        type = "sedan";
        System.out.println(type+" "+brand);
    }
}
class sedantoyota extends car{
    sedantoyota(){
        brand = "toyota";
        type = "sedan";
        System.out.println(type+" "+brand);
    }
}

abstract class abstmnfctr{
    public abstract car getcar(String type);
}
class toyotamnfctr extends abstmnfctr{

    @Override
    public car getcar(String type) {
        if(type.equals("suv"))
            return new suvtoyota();
        if(type.equals("sedan"))
            return new sedantoyota();
        return null;
    }
}
class fiatmnfctr extends abstmnfctr{

    @Override
    public car getcar(String type) {
        if(type.equals("suv"))
            return new suvfiat();
        if(type.equals("sedan"))
            return new sedanfiat();
        return null;
    }
}
class mnfctrs{
    public static abstmnfctr getmnfctr(String brand){
        if(brand.equals("toyota"))
            return new toyotamnfctr();
        else if(brand.equals("fiat"))
            return new fiatmnfctr();
        return null;
    }
}

//</editor-fold>
