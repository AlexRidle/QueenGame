package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Field {

    private ArrayList<Integer[]> freeSteps = new ArrayList<>();
    private char[][] gridView = new char[8][8];

    public int[] getFreeStep(){
        int[] step = new int[]{-1,-1};
        if(!(freeSteps.isEmpty())){
            int Random = (int) (Math.random() * freeSteps.size());
            step = Arrays.stream(freeSteps.get(Random)).mapToInt(Integer::intValue).toArray();
            return step;
        }
        return step;
    }

    public void removeFreeStep(int[] removeStep){
        for(int i = 0; i<freeSteps.size(); i++){
            Integer[] rStep = Arrays.stream(removeStep).boxed().toArray(Integer[]::new);
            if(Arrays.equals(freeSteps.get(i),rStep)){
                freeSteps.remove(i);
            }
        }
    }

    public void showGridView(){
        System.out.println("");
        for(int i=0; i<8; i++){
            for(int j=0;j<8;j++){
                System.out.print(gridView[i][j] + "  ");
            }
            System.out.println("");
        }
    }
    public void setGridViewQueen(int a, int b){
        gridView[a][b] = (char) (Queen.queens + '0');
    }
    public void setGridView(char[][] grid){
        System.arraycopy(grid, 0, this.gridView, 0, 8);
    }

    public void generate(){
        for(int i = 0; i<8;i++){
            for(int j = 0;j<8;j++){
                Integer[] step = new Integer[]{i, j};
                freeSteps.add(step);
            }
        }

        char[][] gridChar = new char[8][8];
        for(int i = 0; i<8;i++){
            for(int j = 0;j<8;j++){
                gridChar[i][j] = '_';
            }
        }
        setGridView(gridChar);
    }

}
