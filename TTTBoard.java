import csci1140.*;

public class TTTBoard {
    String[][] board;

    public TTTBoard(){
        board = new String[][]{{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
    }

    public boolean hasWon(){
        for(int i = 0; i < 3; i++){
            if(!board[i][0].equals("-") && board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])){
                return true;
            }
        }
        for(int i = 0; i < 3; i++){
            if(!board[0][i].equals("-") && board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i])){
                return true;
            }
        }
        if((!board[1][1].equals("-")) && ((board[1][1].equals(board[0][2]) && board[0][2].equals(board[2][0])) || (board[1][1].equals(board[0][0]) && board[0][0].equals(board[2][2])))){
            return true;
        }
        return false;
    }

    public boolean isTie(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j].equals("-")){
                    return false;
                }
            }
        }
        return true;
    }

    public void markSpot(Spot s, String mark){
        board[s.r][s.c] = mark;
    }

    public boolean spaceIsTaken(int x, int y){
        return !board[x][y].equals("-");
    }

    public String playerHasWon(){
        for(int i = 0; i < 3; i++){
            if(!board[i][0].equals("-") && board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])){
                return board[i][0];
            }
        }
        for(int i = 0; i < 3; i++){
            if(!board[0][i].equals("-") && board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i])){
                return board[0][i];
            }
        }
        if(!board[1][1].equals("-") && (board[1][1].equals(board[0][2]) && board[0][2].equals(board[2][0])) || (board[1][1].equals(board[0][0]) && board[0][0].equals(board[2][2]))){
            return board[1][1];
        }
        return null;
    }

    public String toString(){
        String rtrn = "  1 2 3\n";
        for(int i = 0; i < 3; i++){
            rtrn += i + 1 + " ";
            for(int j = 0; j < 3; j++){
                rtrn += board[i][j] + " ";
            }
            rtrn += "\n";
        }
        return rtrn;
    }
}
