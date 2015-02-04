/*
 * Copyright (C) 2015 - Matthew J Lents mlents0929@gmail.com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 */
package team9;
/*
Coordinate used for the locations on the game map
*/
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
