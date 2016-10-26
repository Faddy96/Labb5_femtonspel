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
    Tile tile;

    public Board() {
        tiles = new ArrayList<>();
        initBoard();
      //  initBoardPreSet();
    }

    private void initBoard() {
        int column = 0, row = 1;
        tiles.add(new Tile(0, 3, 4));

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
    public void resetBoard() {
        tiles.removeAll(tiles);
        initBoardPreSet();
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

    private void setGreyColumn(int column) {
        tiles.get(0).setColumn(column);
    }

    private void setGreyRow(int row) {
        tiles.get(0).setRow(row);
    }

    public Tile getTile(int index) {
        return tiles.get(index);
    }

   public boolean isDone() {
        int column = 0, row = 1;
        for (int i = 1; i < 16; i++) {
            if(!(tiles.get(i).getColumn() == column && tiles.get(i).getRow() == row)){
                return false;
            }
            if (column == 2 && row == 4){
                   
                return true;
            }
            else if (!(column == 3)) {
                column++;
            } 
            else {
                column = 0;
                row++;
            }
        }
        return false;
    }

    public boolean checkMoveOk(Tile other) {
        if (tiles.get(0).getColumn() == other.getColumn() || tiles.get(0).getRow() == other.getRow()) {
            if (tiles.get(0).getColumn() == other.getColumn() + 1
                    || tiles.get(0).getColumn() == other.getColumn() - 1
                    || tiles.get(0).getRow() == other.getRow() + 1
                    || tiles.get(0).getRow() == other.getRow() - 1) {
                return true;
            }
        }

        return false;

    }

    public Tile findTile(int row, int col) {
        Tile tmp = new Tile();
        for (Tile tile : tiles) {
            if (tile.getColumn() == col && tile.getRow() == row) {
                return tile;

            } else {
                tmp = null;
            }
        }
        return tmp;
    }
   private void initBoardPreSet() {
        int rand = 0;
        tiles.add(new Tile(0, 3, 4));
        rand = (int) (Math.random() * 3 + 1);
        switch (rand) {
            case 1:
                tiles.add(new Tile(1, 3, 1));
                tiles.add(new Tile(2, 1, 3));
                tiles.add(new Tile(3, 2, 3)); 
                tiles.add(new Tile(4, 0, 4));
                tiles.add(new Tile(5, 1, 1));
                tiles.add(new Tile(6, 1, 4));
                tiles.add(new Tile(7, 0, 2));
                tiles.add(new Tile(8, 3, 2));
                tiles.add(new Tile(9, 0, 1));
                tiles.add(new Tile(10, 0, 3));
                tiles.add(new Tile(11, 3, 3));
                tiles.add(new Tile(12, 2, 4));
                tiles.add(new Tile(13, 2, 1));
                tiles.add(new Tile(14, 1, 2));
                tiles.add(new Tile(15, 2, 2));
                break;
            case 2:
                tiles.add(new Tile(1, 1, 2));
                tiles.add(new Tile(2, 2, 4));
                tiles.add(new Tile(3, 2, 3));
                tiles.add(new Tile(4, 0, 4));
                tiles.add(new Tile(5, 0, 3));
                tiles.add(new Tile(6, 3, 1));
                tiles.add(new Tile(7, 3, 2));
                tiles.add(new Tile(8, 1, 4));
                tiles.add(new Tile(9, 1, 3));
                tiles.add(new Tile(10, 1, 1));
                tiles.add(new Tile(11, 0, 2));
                tiles.add(new Tile(12, 2, 1));
                tiles.add(new Tile(13, 3, 3));
                tiles.add(new Tile(14, 0, 1));
                tiles.add(new Tile(15, 2, 2));
                break;
                
            case 3:
                tiles.add(new Tile(1, 2, 1));
                tiles.add(new Tile(2, 2, 2));
                tiles.add(new Tile(3, 1, 2));
                tiles.add(new Tile(4, 3, 3));
                tiles.add(new Tile(5, 0, 1));
                tiles.add(new Tile(6, 3, 2));
                tiles.add(new Tile(7, 2, 4));
                tiles.add(new Tile(8, 1, 3));
                tiles.add(new Tile(9, 1, 4));
                tiles.add(new Tile(10, 1, 1));
                tiles.add(new Tile(11, 0, 4));
                tiles.add(new Tile(12, 0, 3));
                tiles.add(new Tile(13, 0, 2));
                tiles.add(new Tile(14, 2, 3));
                tiles.add(new Tile(15, 3, 1));
                break;
            case 4:
                tiles.add(new Tile(1, 0, 4));
                tiles.add(new Tile(2, 1, 4));
                tiles.add(new Tile(3, 3, 1));
                tiles.add(new Tile(4, 0, 2));
                tiles.add(new Tile(5, 0, 1));
                tiles.add(new Tile(6, 0, 3));
                tiles.add(new Tile(7, 2, 1));
                tiles.add(new Tile(8, 1, 1));
                tiles.add(new Tile(9, 2, 2));
                tiles.add(new Tile(10, 2, 4));
                tiles.add(new Tile(11, 3, 2));
                tiles.add(new Tile(12, 3, 3));
                tiles.add(new Tile(13, 1, 3));
                tiles.add(new Tile(14, 2, 3));
                tiles.add(new Tile(15, 1, 2));
                break;

        }
    }
}
