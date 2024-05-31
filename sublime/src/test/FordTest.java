package src.test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.concurrent.TimeUnit;

// Author: Dr. Ford
// Guest, uncomment as you implement the imported types below.
import src.main.Bernard;
import src.main.SystemWhole;
import src.main.Host;
import src.main.MazeLoop;
import src.main.MemorySnapshot;
import src.main.NarrativeLoop;

public class FordTest{
    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @Tag("grading")
    public void testBernardSimulationDiagnostics000(){
             // P2 emergences strings be like:
             String[] emergences = {"kind:Human"};
             // Using Bernard to get systems (whole)
             SystemWhole aSystemWhole = Bernard.analysis(emergences);
             // matching updateNarrativeLoops parameter types
             SystemWhole[] systemWholes = {aSystemWhole};
             // Getting a narrative
            NarrativeLoop narrativeLoop = new MazeLoop();
            //  //The system is in both, since it is the same array, it should be added to the simulation list.
            narrativeLoop.updateNarrativeLoops(systemWholes,systemWholes);
            //  // Let's make sure of it, I can verify that via Host
            Host host = new Host(narrativeLoop);
            //  // Tell me what you got host
            MemorySnapshot memorySnapshot = host.analyze();
            //  // Your simulated memories must have the aSystemWhole I created for you 
            assertTrue(memorySnapshot.getSimulationMemory().contains((Object)aSystemWhole));
            //  // This is a mockery of an assertion. Disregard once the one above works.
             //assertTrue(true);
    }  
}
