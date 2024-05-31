package src.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

//hints:
import src.main.Dolores;
import src.main.Freezable;

//For this project, it is OK to place all tests in this class. Prefer creating a test class per project class.
public class DoloresTest {

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public void testHelloWestWorld(){
        assertTrue(true);
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public boolean testFreezeAllMotorFunctions(Freezable host){
         throw new UnsupportedOperationException("Unimplemented method 'testFreezeAllMotorFunctions'");
    }
    
    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    public boolean testFreezeAllMotorFunctions(Dolores host){
        throw new UnsupportedOperationException("Unimplemented method 'testFreezeAllMotorFunctions'");
    }    
    
}
