package com.company;

public class Queen {

    public static boolean hasMove = true;
    public static int queens = 0;
    private static int countI;
    private static int countJ;

    public static void placeQueen(Field game){
        int[] step = game.getFreeStep();
        if(!(step[0]<0 && step[1]<0)){
            game.setGridViewQueen(step[0], step[1]);
            closeQueenSteps(step[0], step[1], game);
            queens++;
        }else{
            hasMove = false;
        }
    }

    private static void closeQueenSteps(int queenI, int queenJ, Field game){
        int[] step = new int[]{queenI, queenJ};
        game.removeFreeStep(step);
        //up
        checkAndSetBoolean(queenI,queenJ,game,-1,0);
        //UpRight
        checkAndSetBoolean(queenI,queenJ,game,-1,1);
        //Right
        checkAndSetBoolean(queenI,queenJ,game,0,1);
        //RightDown
        checkAndSetBoolean(queenI,queenJ,game,1,1);
        //Down
        checkAndSetBoolean(queenI,queenJ,game,1,0);
        //LeftDown
        checkAndSetBoolean(queenI,queenJ,game,1,-1);
        //Left
        checkAndSetBoolean(queenI,queenJ,game,0,-1);
        //UpLeft
        checkAndSetBoolean(queenI,queenJ,game,-1,-1);
    }

    private static void countEqualsQueen(int queenI, int queenJ){
        countI = queenI;
        countJ = queenJ;
    }

    private static void checkAndSetBoolean(int queenI, int queenJ, Field game, int counterI, int counterJ){
        countEqualsQueen(queenI, queenJ);
        while((countI>=0 && countI<8) && (countJ>=0 && countJ<8)){
            int[] step = new int[]{countI, countJ};
            game.removeFreeStep(step);
            countI += counterI;
            countJ += counterJ;
        }
    }

}
