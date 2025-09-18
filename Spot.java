//a spot on the board with a row and a column value
public class Spot {
    int r;
    int c;
    String mark;

    public Spot(int r, int c){
        this.r = r;
        this.c = c;
    }

    public boolean isValid(TTTBoard t){
        return (r != -1 && c != -1) && (r < 3 && c < 3) && !t.spaceIsTaken(r, c);
    }

    public void setValues(int r, int c){
        this.r = r;
        this.c = c;
    }
}
