;
import com.puzzle.State;
import com.puzzle.algos.AStar;
import com.puzzle.algos.BFS;
import com.puzzle.algos.DFS;
import com.puzzle.algos.SearchAlgorithm;
import org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class test {
    private ArrayList<Integer> initTestCases()
    {
        ArrayList<Integer> testCases = new ArrayList<>();
        testCases.add(12345678);
        testCases.add(102345678);
        testCases.add(120345678);
        testCases.add(123045678);
        testCases.add(123405678);
        testCases.add(123450678);
        testCases.add(123456078);
        testCases.add(123456708);
        testCases.add(123456780);
        return testCases;
    }
    @Test
    public void testDFS(){
        ArrayList<Integer> tests = initTestCases();
        for (int seq :tests){
            SearchAlgorithm<State> algo = new DFS(seq);
            if(algo.search() == -1) fail("Unsolvable");
        }
    }
    @Test
    public void testBFS(){
        ArrayList<Integer> tests = initTestCases();
        for (int seq :tests){
            SearchAlgorithm<State> algo = new BFS(seq);
            if(algo.search() == -1) fail("Unsolvable");
        }
    }
    @Test
    public void testAstarManhattan(){
        ArrayList<Integer> tests = initTestCases();
        for (int seq :tests){
            SearchAlgorithm<State> algo = new AStar<>(seq);
            if(algo.search() == -1) fail("Unsolvable");
        }
    }
}
//TODO: WHERE DO THE MULTIPLE ZEROS COME FROM???????