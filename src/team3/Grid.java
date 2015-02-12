package team3;

	public class Grid {

	    private String outputFileName;
	    private int width = 64;
	    private int height = 64;
	    private byte[][] grid = new byte[64][64];
	    private int counter = 1;

	    /**
	     * creates a new Grid
	     * PreConditions: none
	     * PostConditions: a Grid is created
	     * @param outputFileName: the name of the file to output the results to
	     */
	    public Grid(byte[][] map) {
	    	for(int i = 0; i < 64; i++) {
	    		for(int j = 0; j < 64; j++) {
	    			if(map[i][j] == 2 || map[i][j] == 3) {
	    				grid[i][j] = 0;
	    			}//end of if
	    			else {
	    				grid[i][j] = 1;
	    			}//end of else
	    		}//end of for
	    	}//end of for
	    }//end of Grid Constuctor

	    /**
	     * creates an array out of the input file
	     * PreConditions: must have an input file
	     * PostConditions: an array is created
	     * @param inputFileName: the name of the file that input is taken from
	     * @throws FileNotFoundException 
	     */
//	    public void load(String inputFileName) throws FileNotFoundException {
//	        
//	        //creates a scanner
//	        input = new Scanner(new File(inputFileName));
//	        height = input.nextInt();
//	        width = input.nextInt();
//	        
//	        //creates an array
//	        grid = new int[height][width];
//	        
//	        //fills the array
//	        for (int i = 0; i < height; i++) {
//	            for (int j = 0; j < width; j++) {
//	                grid[i][j] = input.nextInt();
//	            }//end of j for
//	        }//end of i for
//	    }//end of load

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
	    }//end of findRegions

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
	        	//System.out.println("here");
	            return;
	        }//end of if
	        
//	        System.out.println();
//	        for(int i = 0; i < 64; i++) {
//	        	for(int j = 0; j < 64; j++) {
//	        		System.out.print(grid[i][j] + " ");
//	        	}
//	        	System.out.println();
//	        }

	        //if the number is 1, add counter to it and check all adjacent squares,
	        //if the square has a 1, call regions recursively for that poiont
	        if (grid[yCoord][xCoord] == 1) {
	            grid[yCoord][xCoord] += counter;
	            if (xCoord < width - 1 && grid[yCoord][xCoord + 1] == 1) {
	                regions(yCoord, xCoord + 1);
	            }
//	            if (xCoord < width - 1 && yCoord < height - 1 && grid[yCoord + 1][xCoord + 1] == 1) {
//	                regions(yCoord + 1, xCoord + 1);
//	            }
	            if (yCoord < height - 1 && grid[yCoord + 1][xCoord] == 1) {
	                regions(yCoord + 1, xCoord);
	            }
//	            if (yCoord < height - 1 && xCoord > 0 && grid[yCoord + 1][xCoord - 1] == 1) {
//	                regions(yCoord + 1, xCoord - 1);
//	            }
	            if (xCoord > 0 && grid[yCoord][xCoord - 1] == 1) {
	                regions(yCoord, xCoord - 1);
	            }
//	            if (yCoord > 0 && xCoord > 0 && grid[yCoord - 1][xCoord - 1] == 1) {
//	                regions(yCoord - 1, xCoord - 1);
//	            }
	            if (yCoord > 0 && grid[yCoord - 1][xCoord] == 1) {
	                regions(yCoord - 1, xCoord);
	            }
//	            if (yCoord > 0 && xCoord < width - 1 && grid[yCoord - 1][xCoord + 1] == 1) {
//	                regions(yCoord - 1, xCoord + 1);
//	            }
	        }//end of if
	        
	        //if the group has finished, add one to counter and call findRegions
	        if (groupDone()) {
	            counter++;
	            Point p = findNextOne();
	            regions(p.x,p.y);
	        }//end of if
	    }//end of regions

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
	                }//end of if
	            }//end of j for
	            if (uncounted) {
	                break;
	            }//end of if
	        }//end of i for
	        //System.out.println(uncounted);
	        return uncounted;
	    }//end of anyUncounted

	    /**
	     * saves the file
	     * PreConditions: must have a file to save to
	     * PostConditions: the file is saved
	     * @param outputFileName: the name of the file that is being saved
	     * @throws FileNotFoundException
	     */
//	    public void save(String outputFileName) {
//	        int num = 0;
//	        int region = 1;
//	        
//	        //cycles through each region
//	        for (int k = 2; k <= counter; k++) {
//	            
//	            //cycles through the array, if the number is the same as k then add 1 to num
//	            for (int i = 0; i < height; i++) {
//	                for (int j = 0; j < width; j++) {
//	                    if (grid[i][j] == k) {
//	                        num++;
//	                        
//	                        //subtracts one from the number to make the number match the region
//	                        grid[i][j]--;
//	                    }//end of if
//	                }//end of j for
//	            }//end of i for
//	            
//	            //prints region to the file
//	            myWriter.println("Region " + region + " has a size of " + num + ".");
//	            region++;
//	            num = 0;
//	        }//end of k for
//	        
//	        //prints the array with the regions labeled
//	        myWriter.println("\n\nLabeled Regions\n\n");
//	        for (int i = 0; i < height; i++) {
//	            for (int j = 0; j < width; j++) {
//	                myWriter.print(grid[i][j] + " ");
//	            }//end of j for
//	            myWriter.println();
//	        }//end of i for
//	        myWriter.close();
//	        System.exit(0);
//	    }//end of save

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
	                }//end of if
	            }//end of j for
	        }//end of i for
	        return new Point(pointA, pointB);
	    }//end of findNextOne

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
	                }//end of if
	            }//end of j for
	        }//end of i for
	        return done;
	    }//end of groupDone
	    
	    public int getCounter() {
	    	return counter;
	    }
	}//end of Grid class
