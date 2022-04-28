public class Rute {
    public int kolonne;
    public int rad;
    public Labyrint lab;
    protected Rute nord, ost, sor, vest;

 
    
public Rute(int rad, int kol, Labyrint lab){
    this.rad = rad;
    this.kolonne = kol;
    this.lab = lab;

}

public void settInnNaboer(Rute nord, Rute ost, Rute sor, Rute vest){
    this.nord = nord;
    this.ost = ost;
    this.sor = sor;
    this.vest = vest;
}
    
}
