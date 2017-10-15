//DO NOT CHANGE ANY CODE IN THIS FILE
//YOU DO NOT HAVE TO SUBMIT THIS FILE. IT IS MEANT FOR TESTING OF YOUR CODE
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;

public class CoinChangeTest {

    @Test
    public void testCoinChange1() {
        CoinChange c = new CoinChange();
        int[] denomination = {1,5,10,25};
        int value = 37;
		int answer = 4;		
        assertEquals(c.NumberofCoins(denomination,value),answer);
    }

    @Test
    public void testCoinChange2() {
        CoinChange c = new CoinChange();
        int[] denomination = {1,6,10};
        int value = 11;
		int answer = 2;		
        assertEquals(c.NumberofCoins(denomination,value),answer);
    }

    @Test
    public void testCoinChange3() {
        CoinChange c = new CoinChange();
        int[] denomination = {1,6,10};
        int value = 13;
		int answer = 3;		
        assertEquals(c.NumberofCoins(denomination,value),answer);
    }

    @Test
    public void testCoinChange4() {
        CoinChange c = new CoinChange();
        int[] denomination = {1,6,10};
        int value = 17;
		int answer = 3;		
        assertEquals(c.NumberofCoins(denomination,value),answer);
    }

    @Test
    public void testCoinChange5() {
        CoinChange c = new CoinChange();
        int[] denomination = {1,9,15};
        int value = 37;
		int answer = 5;		
        assertEquals(c.NumberofCoins(denomination,value),answer);
    }

    @Test
    public void testCoinChange6() {
        CoinChange c = new CoinChange();
        int[] denomination = {1,9,15};
        int value = 54;
		int answer = 4;		
        assertEquals(c.NumberofCoins(denomination,value),answer);
    }
}