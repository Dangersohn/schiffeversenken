import java.util.Random;
import java.lang.*;

public class Meer {
    // Eigenschaften
    private Feld[][] feld = new Feld[10][10];;
    public boolean schiffGesetzt = false;

    // Konstruktor
    public Meer() {
        // Anfangswerte setzen fuer alle 100 Felder
        for (int i = 0; i < 10; i++) { // senkrecht
            for (int j = 0; j < 10; j++) { //waagerecht
                feld[j][i] = new Feld();
            }
        }
    }

    // Methoden
    public String schiesse(int x, int y) {
        if (feld[x][y].beschossen())
            return "Treffer";
        else
            return "Daneben";
    }

    public boolean beschossen(int x, int y) {
        if (feld[x][y].isBeschossen()) {
            System.out.println("Feld bereits beschossen");
            return true;
        } else {
            System.out.println("erster Schuss");
            return false;
        }
    }

    public void reset() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                feld[j][i].reset();
            }
        }
    }

    public void konsolenausgabe() {
        System.out.println("\nX  0 1 2 3 4 5 6 7 8 9"); // Leerzeile + Beschriftung
        System.out.println("Y");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < 10; j++) {
                if (feld[j][i].isBeschossen())
                    System.out.print("X");
                else {
                    if (feld[j][i].isSchiff())
                        System.out.print("1 ");
                    else
                        System.out.print("- ");
                }
            }
            System.out.println(); // Zeilenwechsel
        }
        System.out.println();
    }// End of konsolenausgabe

    public boolean nochSchiffe() {
        boolean tester = false;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (feld[j][i].isSchiff())
                    tester = true;
            }
        }
        return tester;
    }//guckt ob es noch schiffe gibt 

    public boolean schiffGesetzt() {
        return schiffGesetzt;
    }

    public void randomSchiffe(int lange) {
        Random rnd = new Random();
        int y = 0;
        int x = 0;
        int i = 0;
        int richtung = rnd.nextInt(2); //Zufallsrichtung 0 vertikal 1 horizontal  
        int a = rnd.nextInt(10 - lange); //Variable der Richtung, Minus Länge der Schiffe, damit sie beim Aufbauen das Feld nicht übertreten können
        int b = rnd.nextInt(10); //konstante 
        boolean feldFrei = true;
        schiffGesetzt = false;

        switch (richtung) {
        case 0: //Schiff vertikal setzen
            x = b; // vorher (8-lang)+1
            y = a; // vorher 8+1
            //System.out.println("Schiffslaenge:" + lange + " Startpunkt x:" + x + " y:" + y + " vertikal richtung:" + richtung);

            switch (x) {
            case 0: //Schiff vertikal und am linken Rand
                for (i = 0; i <= lange - 1 && feldFrei == true; i++) {
                    if (feld[x][y + i].feldFrei() == true) {
                        feldFrei = true; //wenn Feld frei ist wird das als boolean gespeichert
                    } else {
                        feldFrei = false;
                        //System.out.println("Fehlschlag");
                    }
                }
                if (feldFrei == true) { //wenn genug Felder frei sind fängt diese Schleife an, die entsprechenden Felder mit dem Schiff zu besetzen
                    for (i = 0; i <= lange - 1; i++) {
                        feld[x][y + i].setzeSchiff();
                        feld[x + 1][y + i].nachbarFeld(); //setze alle Felder rechts des Schiffes als Nachbarfeld
                    }
                    if (y > 0) {
                        feld[x][y - 1].nachbarFeld();
                    }
                    if (y + lange-1 < 9) {
                        feld[x][y + lange].nachbarFeld();
                    }
                    schiffGesetzt = true;
                    //System.out.println("Erfolg");
                }
                break;
            case 9: //schiff vertikal und am rechten Rand
                for (i = 0; i <= lange - 1 && feldFrei == true; i++) {
                    if (feld[x][y + i].feldFrei() == true) {
                        feldFrei = true; //wenn Feld frei ist wird das als boolean gespeichert
                    } else {
                        feldFrei = false;
                        //System.out.println("Fehlschlag");
                    }
                }
                if (feldFrei == true) { //wenn genug Felder frei sind fängt diese Schleife an, die entsprechenden Felder mit dem Schiff zu besetzen
                    for (i = 0; i <= lange - 1; i++) {
                        feld[x][y + i].setzeSchiff();
                        feld[x - 1][y + i].nachbarFeld(); //setze alle Felder links des Schiffes als Nachbarfeld
                    }
                    if (y > 0) {
                        feld[x][y - 1].nachbarFeld();
                    }
                    if (y + lange-1 < 9) {
                        feld[x][y + lange].nachbarFeld();
                    }
                    schiffGesetzt =  true;
                    //System.out.println("Erfolg");
                }
                break;
            default: //Schiff vertikal und mitten im Spielfeld
                for (i = 0; i <= lange - 1 && feldFrei == true; i++) {
                    if (feld[x][y + i].feldFrei() == true) {
                        feldFrei = true; //wenn Feld frei ist wird das als boolean gespeichert
                    } else {
                        feldFrei = false;
                        //System.out.println("Fehlschlag");
                    }
                }
                if (feldFrei == true) {
                    for (i = 0; i <= lange - 1; i++) {
                        feld[x][y + i].setzeSchiff();
                        feld[x - 1][y + i].nachbarFeld(); //setze alle Felder links des Schiffes als Nachbarfeld
                        feld[x + 1][y + i].nachbarFeld(); //setze alle Felder rechts des Schiffes als Nachbarfeld
                    }
                    if (y > 0) { //wenn schiff nicht am oberen Rand steht, setzte feld oberhalb des schiffes als Nachbarfeld
                        feld[x][y - 1].nachbarFeld();
                    }
                    if (y + lange < 10) { //wenn Schiff nicht am unteren Rand, setzte Feld unterhalb des Schiffes als Nachbarfeld
                        feld[x][y + lange].nachbarFeld();
                    }
                    schiffGesetzt = true;
                    //System.out.println("Erfolg");
                }
                break;
            }
            break;
        case 1: //Schiff horizontal setzen
            x = a;
            y = b;
            //System.out.println("Schiffslaenge:" + lange + " Startpunkt x:" + x + " y:" + y + " horizontal richtung:" + richtung);

            switch (y) {
            case 0: //Schiff horizontal am oberen Spielfeldrand
                for (i = 0; i <= lange - 1 && feldFrei == true; i++) {
                    if (feld[x + i][y].feldFrei() == true) {
                        feldFrei = true; //wenn Feld frei ist wird das als boolean gespeichert
                    } else {
                        feldFrei = false;
                        //System.out.println("Fehlschlag");
                    }
                }
                if (feldFrei == true) { //wenn genug Felder frei sind fängt diese Schleife an, die entsprechenden Felder mit dem Schiff zu besetzen
                    for (i = 0; i <= lange - 1; i++) {
                        feld[x + i][y].setzeSchiff();
                        feld[x + i][y + 1].nachbarFeld();
                    }
                    if (x > 0) { //wenn schiff nicht am oberen Rand steht, setzte feld oberhalb des schiffes als Nachbarfeld
                        feld[x - 1][y].nachbarFeld();
                    }
                    if (x + lange-1 < 9) { //wenn Schiff nicht am unteren Rand, setzte Feld unterhalb des Schiffes als Nachbarfeld
                        feld[x + lange][y].nachbarFeld();
                    }
                    schiffGesetzt = true;
                    //System.out.println("Erfolg");
                }
                break;
            case 9: //Schiff horizontal am unteren Spielfeldrand
                for (i = 0; i <= lange - 1 && feldFrei == true; i++) {
                    if (feld[x + i][y].feldFrei() == true) {
                        feldFrei = true; //wenn Feld frei ist wird das als boolean gespeichert
                    } else {
                        feldFrei = false;
                        //System.out.println("Fehlschlag");
                    }
                }
                if (feldFrei == true) { //wenn genug Felder frei sind fängt diese Schleife an, die entsprechenden Felder mit dem Schiff zu besetzen
                    for (i = 0; i <= lange - 1; i++) {
                        feld[x + i][y].setzeSchiff();
                        feld[x + i][y - 1].nachbarFeld();
                    }
                    if (x > 0) { //wenn schiff nicht am oberen Rand steht, setzte feld oberhalb des schiffes als Nachbarfeld
                        feld[x - 1][y].nachbarFeld();
                    }
                    if (x + lange-1 < 9) { //wenn Schiff nicht am unteren Rand, setzte Feld unterhalb des Schiffes als Nachbarfeld
                        feld[x + lange][y].nachbarFeld();
                    }
                    schiffGesetzt = true;
                    //System.out.println("Erfolg");
                }
                break;
            default:
                for (i = 0; i <= lange - 1 && feldFrei == true; i++) {
                    if (feld[x + i][y].feldFrei() == true) {
                        feldFrei = true; //wenn Feld frei ist wird das als boolean gespeichert
                    } else {
                        feldFrei = false;
                        //System.out.println("Fehlschlag");
                    }
                }
                if (feldFrei == true) { //wenn genug Felder frei sind fängt diese Schleife an, die entsprechenden Felder mit dem Schiff zu besetzen
                    for (i = 0; i <= lange - 1; i++) {
                        feld[x + i][y].setzeSchiff();
                        feld[x + i][y + 1].nachbarFeld();
                        feld[x + i][y - 1].nachbarFeld();
                    }
                    if (x > 0) { //wenn schiff nicht am oberen Rand steht, setzte feld oberhalb des schiffes als Nachbarfeld
                        feld[x - 1][y].nachbarFeld();
                    }
                    if (x + lange-1 < 9) { //wenn Schiff nicht am unteren Rand, setzte Feld unterhalb des Schiffes als Nachbarfeld
                        feld[x + lange][y].nachbarFeld();
                    }
                    schiffGesetzt = true;
                    //System.out.println("Erfolg");
                }
                break;
            }
            break;
        }
    } //End of randomSchiffe

} // Ende 