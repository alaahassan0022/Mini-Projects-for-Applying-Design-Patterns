package S_1_Adapter;

import java.util.Arrays;

public class AdapterMain {
    public static void main(String[] args) {
        //<editor-fold defaultstate="collapsed" desc="lec">
//        audioplayer ap = new audioplayer();
//        ap.play("mp3", "song1.mp3");
//        ap.play("mp4", "vid1.mp4");
//        ap.play("vlc", "vid2.vlc");
       //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="lab">
        bird sp = new sparrow();
        sp.fly();
        sp.makesound();
        toyduck td = new plastictoyduck();
        td.squeak();
        toyduck bdp = new birdadapter(sp);
        bdp.squeak();
       //</editor-fold>
       
        //<editor-fold defaultstate="collapsed" desc="lec ex">
        FileManager fm = new filem();
        System.out.println(fm.open("file1(fm)"));
        System.out.println(fm.read(0, 5, "data1"));
        System.out.println(fm.write(5, 5, "data2"));
        System.out.println(fm.close());
        
        System.out.println("\n");
        FileManager fm2 = new fileutiladpt(new fileu());
        System.out.println(fm2.open("file2(adpt)"));
        System.out.println(fm2.read(0, 5, "data11"));
        System.out.println(fm2.write(5, 5, "data22"));
        System.out.println(fm2.close());
        //</editor-fold>
    
    }
}


//<editor-fold defaultstate="collapsed" desc="lec">

interface advmediaplayer{
    public void playvlc(String filename);
    public void playmp4(String filename);
}
class vlcplayer implements advmediaplayer{

    @Override
    public void playvlc(String filename) {
        System.out.println("playing vlc: "+ filename);
    }

    @Override
    public void playmp4(String filename) {
        
    }
    
}
class mp4player implements advmediaplayer{

    @Override
    public void playvlc(String filename) {
    }

    @Override
    public void playmp4(String filename) {
        System.out.println("playing mp4: "+ filename);

    }
    
}
interface mediaplayer{
    public void play(String audiotype, String filename);
}
class mediaadapter implements mediaplayer{

    private advmediaplayer advpl;
    
    public mediaadapter(String audiotype){
        if(audiotype.equals("vlc"))
            advpl = new vlcplayer();
        else
            advpl = new mp4player();
    }
    
    @Override
    public void play(String audiotype, String filename) {

        if(audiotype.equals("vlc"))
            advpl.playvlc(filename);
        else
            advpl.playmp4(filename);

    }

}
class audioplayer implements mediaplayer{

    private mediaadapter madpt;
        
    @Override
    public void play(String audiotype, String filename) {
        if(audiotype.equals("mp3"))
            System.out.println("playing "+audiotype+": "+ filename);
        else{
            madpt = new mediaadapter(audiotype);
            madpt.play(audiotype, filename);
        }
            
    }

}
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="lab">
interface toyduck{
    public void squeak();
}
class plastictoyduck implements toyduck{

    public plastictoyduck(){
        System.out.println("plastictoyduck..");
    }
    @Override
    public void squeak() {
        System.out.println("squeak");
    }

}
class birdadapter implements toyduck{

    bird b;
    public birdadapter(bird bb){
        System.out.println("birdadapter..");
        b=bb;
    }
    @Override
    public void squeak() {
        b.makesound();
    }
    
}
interface bird{
    public void fly();
    public void makesound();
    
}
class sparrow implements bird{

    public sparrow(){
        System.out.println("sparrow..");
    }
    @Override
    public void fly() {
        System.out.println("fly");
    }

    @Override
    public void makesound() {
        System.out.println("chirp chirp");
    }
}
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="lec ex">
interface fileutil{//bird
    String openfile(String s);
    String closefile();
    String readfromfile(int pos, int amount, String data);
    String writetofile(int pos, int amount, String data);

}
class fileu implements fileutil{

    @Override
    public String openfile(String s) {
        return ("openfile:"+s);

    }

    @Override
    public String closefile() {
        return ("closefile");

    }

    @Override
    public String readfromfile(int pos, int amount, String data) {
        return ("readfromfile: pos:"+pos+" amount:"+amount+" data:"+data);

    }

    @Override
    public String writetofile(int pos, int amount, String data) {
        return ("writetofile: pos:"+pos+" amount:"+amount+" data:"+data);
    }

}
class fileutiladpt implements FileManager{

    fileutil fu;
    fileutiladpt(fileutil fuu){
        fu=fuu;
    }
    @Override
    public String open(String s) {
        return fu.openfile(s);
    }

    @Override
    public String close() {
        return fu.closefile();

    }

    @Override
    public String read(int pos, int amount, String data) {
        return fu.readfromfile(pos, amount, data);
    }

    @Override
    public String write(int pos, int amount, String data) {
        return fu.writetofile(pos, amount, data);

    }
}
interface FileManager { //toyduck
    String open(String s);
    String close();
    String read(int pos, int amount, String data);
    String write(int pos, int amount, String data);
}
class filem implements FileManager{
    
 @Override
    public String open(String s) {
        return ("open:"+s);
    }

    @Override
    public String close() {
        return ("close");

    }

    @Override
    public String read(int pos, int amount, String data) {
        return ("read: pos:"+pos+" amount:"+amount+" data:"+data);
    }

    @Override
    public String write(int pos, int amount, String data) {
        return ("write: pos:"+pos+" amount:"+amount+" data:"+data);

    }
}

    
//</editor-fold>
    