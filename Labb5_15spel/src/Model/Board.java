/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.ArrayList;
 
/**
 *
 * @author Faddy
 */
public class Board {

    private final ArrayList<Tile> tiles;

    Board() {
        tiles = new ArrayList<>();
        initBoard();
    }

    private void initBoard() {
        int column = 0, row = 0;
                tiles.add(new Tile(0, 3, 3));
        for (int i = 1; i < 16; i++) {
            Tile tile = new Tile(i, column, row);
            addTile(tile);
            if (!(column == 3)) {
                column++;
            } else {
                column = 0;
                row++;
            }
        }

    }
    
    public void resetBoard(){
        
    }

    public ArrayList<Tile> getBoard() {
        return tiles;
    }

    public void swapTiles(int index) {
        int tempColumn, tempRow;
        tempColumn = getGreyColumn();
        tempRow = getGreyRow();
        setGreyColumn(tiles.get(index).getColumn());
        setGreyRow(tiles.get(index).getRow());
        tiles.get(index).setColumn(tempColumn);
        tiles.get(index).setRow(tempRow);
    }

    public void addTile(Tile tile) {
        tiles.add(tile);
    }

    private int getGreyColumn() {
        return tiles.get(0).getColumn();
    }

    private int getGreyRow() {
        return tiles.get(0).getRow();
    }
    
    private void setGreyColumn(int column){
        tiles.get(0).setColumn(column);
    }
    
    private void setGreyRow(int row){
        tiles.get(0).setRow(row);
    }
    public Tile getTile(int index){
        return tiles.get(index);
    }
}