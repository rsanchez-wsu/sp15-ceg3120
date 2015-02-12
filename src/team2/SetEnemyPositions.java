package team2;

//I re-purposed the original code from programmingforums.org 

/*
* Copyright (C) <2015> <Team 2>
* 
* Will Hatfield
* Kevin Alig
* Alyssa Ramsey
* Anthony Lamping
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
import java.util.Random;

public class SetEnemyPositions {
		
public static void setEnemyPositions(int[][] board)
{ 
	int columns = 64;
	int rows = 64;
Random temp = new Random();
int dir = temp.nextInt(2);
		int dir2 = temp.nextInt(2);
if(dir == 1) //horizontal
{
   int left = Math.abs(0 - columns), right = Math.abs(7 - columns), total = 4;
   board[rows][columns] = 1;
   total--;
   if(dir2 == 1)
   {
      for(int i = 0; i < right + 1; i++)
      {
         if(total > 0 && right > 0)
         {
            board[rows][columns + (i + 1)] = 1;
            right--;
            total--;
         }
      }

      for(int i = 0; i < left + 1; i++)
      {
         if(total > 0 && left > 0)
         {
            board[rows][columns - (i + 1)] = 1;
            left--;
            total--;
         }
      }
   }
   else
   {
      for(int i = 0; i < left + 1; i++)
      {
         if(total > 0 && left > 0)
         {
            board[rows][columns - (i + 1)] = 1;
            left--;
            total--;
         }
      }
      for(int i = 0; i < right + 1; i++)
      {
         if(total > 0 && right > 0)
         {
            board[rows][columns + (i + 1)] = 1;
            right--;
            total--;
         }
      }
   }
}
else // vertical
{
   int left = Math.abs(0 - rows), right = Math.abs(7 - rows), total = 4;
   board[rows][columns] = 1;
   total--;
   if(dir2 == 1)
   {
      for(int i = 0; i < right + 1; i++)
      {
         if(total > 0 && right > 0)
         {
            board[rows + (i + 1)][columns] = 1;
            right--;
            total--;
         }
      }

      for(int i = 0; i < left + 1; i++)
      {
         if(total > 0 && left > 0)
         {
            board[rows  - (i + 1)][columns] = 1;
            left--;
            total--;
         }
      }
   }
   else
   {
      for(int i = 0; i < left + 1; i++)
      {
         if(total > 0 && left > 0)
         {
            board[rows - (i + 1)][columns] = 1;
            left--;
            total--;
         }
      }
      for(int i = 0; i < right + 1; i++)
      {
         if(total > 0 && right > 0)
         {
            board[rows + (i + 1)][columns] = 1;
            right--;
            total--;
         }
      }
   }
}
}
}

