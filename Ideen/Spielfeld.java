public class Spielfeld{    
    // Eigenschaften
    private Gebiet[][] feld;    
    // Konstruktor
    public Spielfeld(){
      this.feld = new Gebiet[10][10];
      // Anfangswerte setzen fuer alle 100 Felder
      for (int i=0;i<10;i++){ // senkrecht
         for (int j=0;j<10;j++){ //waagerecht
          feld[j][i]=new Gebiet();
        }
      }
     feld[1][2].setzeSchiff();
     feld[2][2].setzeSchiff();
     feld[3][2].setzeSchiff();
}
    // Methoden
  public String schiesse(int x, int y){
    if (feld[x][y].beschiesseFeld())
        return "Treffer";
      else 
        return "Daneben";
  }
  public void gibSpielfeldAufKonsoleAus(){
    System.out.println("\n  0123456789"); // Leerzeile + Beschriftung
    for (int i=0;i<10;i++){
      System.out.print(i+" ");
      for (int j=0;j<10;j++){
        if (feld[j][i].isFeldWurdeBeschossen()) System.out.print("*");
        else { 
            if (feld[j][i].isSchiff()) System.out.print("X");
            else System.out.print("-");
        }
      }
      System.out.println(); // Zeilenwechsel
    }
  }
} // Ende 