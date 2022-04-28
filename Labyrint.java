import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Labyrint{
    private Rute[][] labyrint;
    private int kolonne;
    private int rad;

    // Labyrint(Rute[][]labyrint, int kolonne, int rad){
    //     this.labyrint = labyrint;
    //     this.kolonne = kolonne;
    //     this.rad = rad;
    // }

    public Labyrint (String filnavn) {
        File fil = new File(filnavn);
        Scanner sc = null;
        try {
            sc = new Scanner(fil);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        String [] str = sc.nextLine().split("");
        int antallKolonner = Integer.parseInt(str[0]);
        int antallRader = Integer.parseInt(str[1]);

        this.labyrint = new Rute[antallRader][antallKolonner];

        for (int rad = 0; rad < antallRader; rad++) {
            String linje = sc.nextLine();

            String[]linjeSplit = linje.split("");

        for (int kol = 0; kol < linjeSplit.length; kol++){
            if (linjeSplit[kol].equals(".")){
                if (rad == antallRader || rad == 0 || kol == antallKolonner || kol == 0){
                    labyrint[rad][kol] = new Aapning(rad,kol, this);
                }else{
                    labyrint[rad][kol] = new HvitRute(rad, kol, this);
                }
            }else if (linjeSplit[kol].equals("#")){
                labyrint[rad][kol] = new SortRute(rad, kol, this);
                }
            }  
        }
        this.labyrint = labyrint;


        for (int i = 0; i < rad; i++){
            for (int j = 0; j < kolonne; j++){
                Rute nord = null;
                Rute ost = null;
                Rute sor = null;
                Rute vest = null;


                if (i - 1 >= 0){
                    nord = labyrint[i-1][j];
                }
                if (j + 1 <= kolonne - 1){
                    ost = labyrint[i][j+1];
                }
                if (i + 1 <= rad - 1){
                    sor = labyrint[i+1][j];
                }
                if (j-1 >= 0){
                    vest = labyrint[i][j-1];
                }
                labyrint[i][j].settInnNaboer(nord, ost, sor, vest);
            }
        }
    } 

    public Rute hentRute(int rad, int kolonne){
        return labyrint[rad][kolonne];
    }


    public String toString(){
        String skrift = "";

        for (int y = 0; y < labyrint.length; y++){
            for (int x = 0; x < labyrint[y].length; x++){
                skrift += labyrint[x][y];
            }
        }
        return skrift;
        

    }

}