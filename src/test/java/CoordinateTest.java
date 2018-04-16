import GameModel.Coordinates;
import org.junit.Assert;
import org.junit.Test;

public class CoordinateTest {

   @Test
    public void isCoordinateValid(){
       Assert.assertTrue(Coordinates.isValidFormat("3,1"));
       Assert.assertFalse(Coordinates.isValidFormat("11"));
       Assert.assertFalse(Coordinates.isValidFormat("2,f"));
       Assert.assertTrue(Coordinates.isValidFormat("4,5"));
   }

   @Test
    public void WhenGivenInputStringConvertToCoordinate(){
       Assert.assertEquals(Coordinates.convertInput("2,3"), new Coordinates(1,2));
       Assert.assertEquals(Coordinates.convertInput("9,3"), new Coordinates(8,2));
       Assert.assertEquals(Coordinates.convertInput("1,2"), new Coordinates(0,1));
   }



}
