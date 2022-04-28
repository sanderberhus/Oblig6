import java.io.File;
import java.util.Scanner;
public class Hovedprogram {
    

    public static void main(String[] args) {
        String fil = args[0];

        Labyrint labyrint = new Labyrint(fil);

        System.out.println(labyrint.toString());

        Rute rute = labyrint.hentRute(3, 3);
    
    }
        
        
     
    }
    

