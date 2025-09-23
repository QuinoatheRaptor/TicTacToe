public class CPU extends Player{
    int intelligence;

    public CPU(int i){
        super();
        intelligence = i;
    }

    public void move(TTTBoard t){
        if(intelligence == 1){//Easy Difficulty Bot
            t.markSpot(randomMove(t), mark);
        }
        if(intelligence == 2){//Medium Difficulty Bot
            if(findWinningMove(t, mark).isValid(t)){//First the bot checks if it can win
                t.markSpot(findWinningMove(t, mark), mark);
            }
            else if(findWinningMove(t, "X").isValid(t)){//Next it checks if it needs to block the user from winning
                t.markSpot(findWinningMove(t, "X"), mark);
            }
            else if(findSecondMove(t, mark).isValid(t)){//Then it looks for two consecutive open spaces to begin setting up a win
                t.markSpot(findSecondMove(t, mark), mark);
            }
            else{//if all else fails go random
                t.markSpot(randomMove(t), mark);
            }
        }
        if(intelligence == 3){//Impossible Difficulty Bot
            if(findWinningMove(t, mark).isValid(t)){//First the bot checks if it can win
                t.markSpot(findWinningMove(t, mark), mark);
            }
            else if(findWinningMove(t, "X").isValid(t)){//Next it checks if it needs to block the user from winning
                t.markSpot(findWinningMove(t, "X"), mark);
            }
            else if(findSecondMove(t, mark).isValid(t)){//Then it looks for two consecutive open spaces to begin setting up a win
                t.markSpot(findSecondMove(t, mark), mark);
            }
            else if(new Spot(1,1).isValid(t)){//The impossible bot goes for the middle to prevent the user from setting up multiple win scenarios
                t.markSpot(new Spot(1,1), mark);
            }
            else if(new Spot(0,0).isValid(t) || new Spot(0,2).isValid(t) || new Spot(2,0).isValid(t) || new Spot(2, 2).isValid(t)){//Then it tries to secure corners to set up its own wins
                Spot[] corners = new Spot[]{new Spot(0,0), new Spot(0, 2), new Spot(2,0), new Spot(2,2)};
                Spot corner = corners[(int)(Math.random() * 4)];
                while(!corner.isValid(t)){
                    corner = corners[(int)(Math.random() * 4)];
                }
                t.markSpot(corner, mark);
            }
            else{//if all else fails go random
                t.markSpot(randomMove(t), mark);
            }

        }
    }

    public Spot findWinningMove(TTTBoard t, String mark){
        //First check is for winning move
        Spot rowRtrn = new Spot(-1, -1);
        Spot colRtrn = new Spot(-1, -1);
        for(int r = 0; r < 3; r++){//check rows & columns for winning move
            int rowMarkCount = 0;
            int colMarkCount = 0;
            int rowEmptyCount = 0;
            int colEmptyCount = 0;
            for(int c = 0; c < 3; c++){
                if(t.board[r][c].equals(mark)){
                    rowMarkCount++;
                }
                else if(t.board[r][c].equals("-")){
                    rowEmptyCount++;
                    rowRtrn.setValues(r, c);
                }
                if(t.board[c][r].equals(mark)){
                    colMarkCount++;
                }
                else if(t.board[c][r].equals("-")){
                    colEmptyCount++;
                    colRtrn.setValues(c, r);
                }
            }
            //System.out.println("Col: " + colMarkCount + " Row: " + rowMarkCount);
            if(rowMarkCount == 2 && rowEmptyCount == 1){
                return rowRtrn;
            }
            else if(colMarkCount == 2 && colEmptyCount == 1){
                return colRtrn;
            }
        }
        //Check for diagonal win move
        Spot descRtrn = new Spot(-1, -1);
        Spot incRtrn = new Spot(-1, -1);
        int descMarkCount = 0;
        int incMarkCount = 0;
        int descEmptyCount = 0;
        int incEmptyCount = 0;
        for(int r = 0; r < 3; r++){
            if(t.board[r][2 - r].equals(mark)){
                incMarkCount++;
            }
            else if(t.board[r][2 - r].equals("-")){
                incRtrn.setValues(r, 2 - r);
                incEmptyCount++;
            }
            if(t.board[r][r].equals(mark)){
                descMarkCount++;
            }
            else if(t.board[r][r].equals("-")){
                descEmptyCount++;
                descRtrn.setValues(r, r);
            }
        }
        if(descMarkCount == 2 && descEmptyCount == 1){
            return descRtrn;
        }
        else if(incMarkCount == 2 && incEmptyCount == 1){
            return incRtrn;
        }
        return new Spot(-1, -1);
    }
    public Spot findSecondMove(TTTBoard t, String mark){
        for(int i = 0; i < 3; i++){
            if(t.board[0][i].equals(mark) && t.board[1][i].equals("-") && t.board[2][i].equals("-")){
                return new Spot((int)(Math.random() * 2) + 1, i);
            }
            else if(t.board[i][0].equals(mark) && t.board[i][1].equals("-") && t.board[i][2].equals("-")){
                return new Spot(i, (int)(Math.random() * 2) + 1);
            }
            else if(t.board[1][i].equals(mark) && t.board[0][i].equals("-") && t.board[2][i].equals("-")){
                return new Spot((int)((Math.random() * 2) * 1.5), i);
            }
            else if(t.board[i][1].equals(mark) && t.board[i][0].equals("-") && t.board[i][2].equals("-")){
                return new Spot(i, (int)((Math.random() * 2) * 1.5));
            }
            else if(t.board[2][i].equals(mark) && t.board[1][i].equals("-") && t.board[0][i].equals("-")){
                return new Spot((int)(Math.random() * 2), i);
            }
            else if(t.board[i][2].equals(mark) && t.board[i][1].equals("-") && t.board[i][0].equals("-")){
                return new Spot(i, (int)(Math.random() * 2));
            }
        }
        return new Spot(-1, -1);
        
    }
    public Spot randomMove(TTTBoard t){
        int x = (int)(Math.random() * 3);
        int y = (int)(Math.random() * 3);
        while(t.spaceIsTaken(x, y)){
            x = (int)(Math.random() * 3);
            y = (int)(Math.random() * 3);
        }
        return new Spot(x, y);
    }
}
