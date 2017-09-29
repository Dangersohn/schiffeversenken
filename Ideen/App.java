//import
import java.util.Random;

public class Controller
{
  public static void main(String[] args)
  {
    //Var 
    boolean [][] board = new boolean[9][9];
    
    board = initboard(board);
    
  }
  
  public static boolean[][] initboard(boolean[][] board){
    //VAR
    Random rnd = new Random(); 
    int zeile = rnd.nextInt(10); // erzeugt Zufalls Zahlen fuer den Start des Schiffes
    int spalte = rnd.nextInt(10);
    int  richtung = rnd.nextInt(3); // zufalss Richtung 0 = nord, 1 = Osten etc.
    int k = 0;
    
    if (board[spalte][zeile] && board[spalte +1 ][zeile] && board[spalte - 1][zeile] && board[spalte][zeile + 1] && board[spalte][zeile - 1] !=true) {      //Checkt alle Felder um den Start
      switch (richtung) {
        case 0:                                //nach Oben
        for (int i = 0;i <= 5 ;i++ ) {           //test 5 schifflaenge
          if (board[spalte][zeile] != true) {  //laufen und cheken  // stimmt was nicht
            k++; 
          } // end of if
          board[spalte][zeile - i] = true;
          
        } // end of for
        
        break;
        case 1:  
        break;
        case 2:  
        break;
        case 3:  
        default: System.out.println("Error");
        break;
      }
    } // end of if
    
    
    System.out.println(spalte);
    System.out.println(zeile);
    
    return board;
  }
  
  
} 