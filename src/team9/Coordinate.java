/*
Team 9
Matthew Lents
*/
package team9;

public class Coordinate extends java.awt.Point {
    public Coordinate(int x, int y){
        super(x,y);
    }
    public String toString(){
        if(x<0||y<0){
            return"(never)";
        }
        else{
            return"("+x+","+y+")";
        }
    }
}
