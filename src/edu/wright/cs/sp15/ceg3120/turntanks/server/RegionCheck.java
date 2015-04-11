package edu.wright.cs.sp15.ceg3120.turntanks.server;

import java.awt.Point;

public class RegionCheck {
	private int width = 64;
    private int height = 64;
    private int[][] grid = new int[64][64];
    private int counter = 1;

    /**
     * creates a new Grid
     * PreConditions: none
     * PostConditions: a Grid is created
     */
    public RegionCheck(char[][] map) {
    	for(int i = 0; i < 64; i++) {
    		for(int j = 0; j < 64; j++) {
    			if(map[i][j] == 'm' || map[i][j] == 'w') {
    				grid[i][j] = 0;
    			} else {
    				grid[i][j] = 1;
    			}
    		}
    	}
    }

    /**
     * finds the regions in the array
     * PreConditions: none
     * PostConditions: the regions have been found
     * @throws FileNotFoundException 
     */
    public int findRegions() {
        
        //finds the point of the next '1'
        Point p = findNextOne();
        regions(p.x, p.y);
        return counter;
    }

    /**
     * finds and labels the regions in the array
     * PreConditions: must have an x and y coord
     * PostConditions: the regions have been found
     * @param yCoord: the y coord of the item to check
     * @param xCoord: the x coord of the item to check
     * @throws FileNotFoundException 
     */
    private void regions(int yCoord, int xCoord){
        
        //base case
        if (!anyUncounted()) {
            return;
        }

        //if the number is 1, add counter to it and check all adjacent squares,
        //if the square has a 1, call regions recursively for that poiont
        if (grid[yCoord][xCoord] == 1) {
            grid[yCoord][xCoord] += counter;
            if (xCoord < width - 1 && grid[yCoord][xCoord + 1] == 1) {
                regions(yCoord, xCoord + 1);
            }
            if (yCoord < height - 1 && grid[yCoord + 1][xCoord] == 1) {
                regions(yCoord + 1, xCoord);
            }
            if (xCoord > 0 && grid[yCoord][xCoord - 1] == 1) {
                regions(yCoord, xCoord - 1);
            }
            if (yCoord > 0 && grid[yCoord - 1][xCoord] == 1) {
                regions(yCoord - 1, xCoord);
            }
        }
        
        //if the group has finished, add one to counter and call findRegions
        if (groupDone()) {
            counter++;
            Point p = findNextOne();
            regions(p.x,p.y);
        }
    }

    /**
     * checks if there are any numbers in the array that have been uncounted
     * PreConditions: none
     * PostConditions: returns if there are numbers that have yet to be checked
     * @return uncounted: if there are numbers that have yet to be checked
     */
    public boolean anyUncounted() {
        boolean uncounted = false;
        
        //cycles through the array, if one of the numbers is 1 then return true
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) {
                    uncounted = true;
                    break;
                }
            }

            if (uncounted) {
                break;
            }
        }
        //System.out.println(uncounted);
        return uncounted;
    }

    /**
     * finds the next one
     * PreConditions: must have an array
     * PostConditions: the point of the next one is returned
     * @return: the point of the next one
     */
    public Point findNextOne() {
        int pointA = 0;
        int pointB = 0;
        
        //cycles through the array, if it is one makes pointA and B equal to it's coordinates,
        //then returns those coordinates as a point
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) {
                    pointA = i;
                    pointB = j;
                }
            }
        }
        return new Point(pointA, pointB);
    }

    /**
     * tests if a group is done
     * PreConditions: must have an array
     * PostConditions: tested if a group is done
     * @return done: if a group is done
     */
    public boolean groupDone() {
        boolean done = true;
        
        //cycles through the array, if the number has been counted (> 1) then checks
        //if any of the adjacent squares are 1, if the adjacent squares are one
        //then the group is not done and false is returned, else true is returned
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] > 1) {
                    if (j < width - 1 && grid[i][j + 1] == 1) {
                        done = false;
                    } 
                    /*else if (j < width - 1 && i < height - 1 && grid[i + 1][j + 1] == 1) {
                        done = false;
                    }*/ else if (i < height - 1 && grid[i + 1][j] == 1) {
                        done = false;
                    } 
                      /*else if (i < height - 1 && j > 0 && grid[i + 1][j - 1] == 1) {
            	   		done = false;
                    }*/ else if (j > 0 && grid[i][j - 1] == 1) {
                        done = false;
                    } /*else if (i > 0 && j > 0 && grid[i - 1][j - 1] == 1) {
                        done = false;
                    }*/ else if (i > 0 && grid[i - 1][j] == 1) {
                        done = false;
                    } /*else if (i > 0 && j < width - 1 && grid[i - 1][j + 1] == 1) {
                        done = false;
                    }*/
                }
            }
        }
        return done;
    }
}
