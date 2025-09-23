import csci1140.KeyboardReader;

public class Driver{
    public static void main(String[] args){
        KeyboardReader r = new KeyboardReader();
        Player p1 = new Player();
        int oppSelection = r.readInt("1 - Easy Bot\n2 - Medium Bot\n3 - Impossible Bot\n4 - Play against another player");
        Player p2 = new Player();
        if(oppSelection == 4){
            p2 = new Player();
        }
        else{
            p2 = new CPU(oppSelection);
        }
        TTTBoard t = new TTTBoard();
        System.out.print(t);
        while(!t.hasWon() && !t.isTie()){
            p1.move(t);
            System.out.println(t);
            if(t.hasWon() || t.isTie()){
                break;
            }
            p2.move(t);
            System.out.println(t);
        }
        if(t.hasWon()){
            System.out.println(t.playerHasWon() + " is the winner!");
        }
        else{
            System.out.println("It's a tie!");
        }
    }
}

//Winning plays: L (2 diagonals), hill/bump, 3 corners
//First move middle, take corner; first move corner, take middle; first move edge, take adjacent corner