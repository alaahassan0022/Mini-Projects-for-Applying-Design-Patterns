package B_1_ChainOfResponsibility;

public class ChaiOfResponsibilityMain {
    private static atm getch2(){
        atm a= new d50(1);
        atm b= new d20(2);
        atm c= new d10(3);
        
        a.setNext(b);
        b.setNext(c);
        
        return a;
    }
    
    private static abstractLogger getchain(){
        abstractLogger errorlogger = new errorLogger(abstractLogger.ERROR);//3
        abstractLogger filelogger = new fileLogger(abstractLogger.DEBUG);//2
        abstractLogger consolelogger = new consoleLogger(abstractLogger.INFO);//1
        
        errorlogger.setNextLogger(filelogger);
        filelogger.setNextLogger(consolelogger);
        
        return errorlogger;
    
    }
    public static void main(String[] args) {
//<editor-fold desc="lec">
        abstractLogger loggerChain = getchain();
        loggerChain.logMessage(abstractLogger.INFO, "this is info");
        System.out.println("\n");
        loggerChain.logMessage(abstractLogger.DEBUG, "this is debug info");
        System.out.println("\n");
        loggerChain.logMessage(abstractLogger.ERROR, "this is error info");
//</editor-fold>
        
//<editor-fold desc="lec ex">
        atm t= getch2();
        t.logg(1, 40);
//</editor-fold>

    }
}
//<editor-fold desc="lec">
abstract class abstractLogger{
    public static int INFO=1,DEBUG=2,ERROR=3;
    protected int level;
    
    public abstractLogger nextLogger;
    
    public void setNextLogger(abstractLogger nextLogger){
        this.nextLogger=nextLogger;
    }
    
    public void logMessage(int level, String message){
        if(this.level<=level)
            write(message);
        if(nextLogger != null)
            nextLogger.logMessage(level, message);
    }
    
    protected abstract void write(String message);    
}
class consoleLogger extends abstractLogger{
    public consoleLogger(int level){
        this.level=level;
    }

    @Override
    protected void write(String message) {
        System.out.println("consoleLogger: "+message);
    }
    
}
class errorLogger extends abstractLogger{
    public errorLogger(int level){
        this.level=level;
    }

    @Override
    protected void write(String message) {
        System.out.println("errorLogger: "+message);
    }
    
}
class fileLogger extends abstractLogger{
    public fileLogger(int level){
        this.level=level;
    }

    @Override
    protected void write(String message) {
        System.out.println("fileLogger: "+message);
    }
    
}
//</editor-fold>


//<editor-fold desc="lec ex">

abstract class atm{
    public static int _50=1,_20=2,_10=3;
    public int level;
    
    atm next;
    
    int w,fw;
    
    public void setNext(atm next) {
        this.next = next;
    }
    public void logg(int l,int ww){
        if(l<=1){
            withdraw(ww);
        }
        if(next!=null){
            next.logg(l, fw);
        }
    }
    protected abstract void withdraw(int ww);
    
    
}
class d50 extends atm{

    d50(int l){
        level=l;
        w=50;
    }
    @Override
    protected void withdraw(int ww) {
        fw=ww;
        int c=1;
        while(true){
            if(fw-w<0)
                break;
            fw-=w;
            System.out.println("Bn50 #"+(c++));
        }
    }
}
class d20 extends atm{

    d20(int l){
        level=l;
        w=20;
    }
    @Override
    protected void withdraw(int ww) {
        fw=ww;
        int c=1;
        while(true){
            if(fw-w<0)
                break;
            fw-=w;
            System.out.println("Bn20 #"+(c++));

        }
    }
}
class d10 extends atm{

    d10(int l){
        level=l;
        w=10;
    }
    @Override
    protected void withdraw(int ww) {
        fw=ww;
        int c=1;
        while(true){
            if(fw-w<0)
                break;
            fw-=w;
            System.out.println("Bn10 #"+(c++));

        }
    }
}
//</editor-fold>
