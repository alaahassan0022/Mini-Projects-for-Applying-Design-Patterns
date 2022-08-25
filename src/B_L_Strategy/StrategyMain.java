
package B_L_Strategy;

public class StrategyMain {
    public static void main(String[] args) {
        shoppingmallcontext spc = new shoppingmallcontext();
        spc.setstrtg(new low());
        float bill = 100.0f;
        bill = spc.getfinalbill(bill);
        spc.setstrtg(new hi());
        bill= spc.getfinalbill(bill);
        System.out.println("New bill: "+bill);
    }
}
interface discountstrtg{
    public float getfinalbill(float billamount);
}
class low implements discountstrtg{

    @Override
    public float getfinalbill(float billamount) {
        return billamount-(billamount*(10.0f/100));
    }
}
class hi implements discountstrtg{

    @Override
    public float getfinalbill(float billamount) {
        return billamount-(billamount*(50.0f/100));
    }
}
class no implements discountstrtg{

    @Override
    public float getfinalbill(float billamount) {
        return billamount-(billamount*(0.0f/100));
    }
}
class shoppingmallcontext{
    private discountstrtg st;
    public void setstrtg(discountstrtg sst){
        st=sst;
    }
    public discountstrtg getstrtg(){
        return st;
    }
    public float getfinalbill(float amount){
        return st.getfinalbill(amount);
    }
}