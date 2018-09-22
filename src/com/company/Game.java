package com.company;

public class Game {
    public void start(){
        Field field = new Field();
        field.generate();
        while(Queen.hasMove) {
            Queen.placeQueen(field);
        }
        field.showGridView();
    }
}
