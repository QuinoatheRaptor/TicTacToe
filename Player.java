//import csci1140.*;

public class Player {
    String mark;
    static int playerCount = 0;

    public Player(){
        if(playerCount == 0){
            mark = "X";
            playerCount++;
        }
        else{
            mark = "O";
        }
    }

    public void move(TTTBoard t){
        int r = KeyboardReader.readInt(mark + " - Enter the row you want to play in: ") - 1;
        int c = KeyboardReader.readInt("Enter the column you want to play in: ") - 1;
        while(!new Spot(r, c).isValid(t)){
            // if(t.spaceIsTaken(x, y)){
            //     System.out.println("SPACE IS TAKEN!");
            // }
            System.out.print("That spot is invalid. Try again. ");
            r = KeyboardReader.readInt("Enter the row you want to play in: ") - 1;
            c = KeyboardReader.readInt("Enter the column you want to play in: ") - 1;
            //System.out.println("x = " + x + " and y = " + y);
        }
        t.markSpot(new Spot(r, c), mark);
    }


}
