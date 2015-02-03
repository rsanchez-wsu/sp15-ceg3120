/*
 * Team 6
 * Mason Henrickson
 * Christopher Dolence
 * Scott Lee
 * Benjamin Winks
 */

/*
 * For liscense information see <http://www.gnu.org/licenses/>.
 */

package team6;

public class TankObject {
    
    public String TankImage;
    public String Name;
    public String IP;    
    public int xCoord;
    public int yCoord;
    public int health;
    public int score;
    public String state;

    public TankObject() {
    }// end empty constructor
    
    //full constructor
    public TankObject(String TankImage, String Name, String IP,
            int xCoord, int yCoord, int health, int score, String state) {        
        
        this.TankImage = TankImage;
        this.Name = Name;
        this.IP = IP;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.health = health;
        this.score = score;
        this.state = state;
    }//end empty constructor    
    
    
     public String[] toStringArray() {
        String[] stringArray = {TankImage,Name,IP,String.valueOf(xCoord),String.valueOf(yCoord) ,String.valueOf(health) ,String.valueOf(score),state }; 
         
        return stringArray ;
    }   

    @Override
    public String toString() {
        return "TankObject{" + "TankImage=" + TankImage + ", Name=" + Name + ", IP=" + IP + ", xCoord=" + xCoord + ", yCoord=" + yCoord + ", health=" + health + ", score=" + score + ", state=" + state + '}';
    }
     
}//end tank class

