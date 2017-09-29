public class Feld {
    // Eigenschaften
    private boolean beschossen = false; //Abfrage ob Schiff auf Feld, wenn geschossen wird
    private boolean beschifft = false; //Abfrage ob Schiff auf Feld
    private boolean nachbar = false;


    public boolean beschossen() {
        beschossen = true;
        if (beschifft) {
            versenkeSchiff();
            return true;
        } else
            return false;
    }

    public void setzeSchiff() {
        beschifft = true;
    }// End of setzeSchiff

    public void nachbarFeld() {
        nachbar = true;
    }

    public void versenkeSchiff() {
        beschifft = false;
    }//End of versenkeSchiff  

    public boolean isBeschossen() {
        return beschossen;
    }//End oif isBeschossen

    public boolean isSchiff() {
        return beschifft;
    }

    public boolean feldFrei() {
        if (beschifft == false && nachbar == false) {
            return true;
        } else {
            return false;
        }
    }

    public void reset() {
        beschifft = false;
        beschossen = false;
        nachbar = false;
    }
} // End of Feld
