;
import com.puzzle.State;
import com.puzzle.algos.AStar;
import com.puzzle.algos.BFS;
import com.puzzle.algos.DFS;
import com.puzzle.algos.SearchAlgorithm;
import com.puzzle.cost.CostType;
import org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class test {
    @BeforeClass
    public static void mute(){
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int arg0) throws IOException {

            }
        }));
    }

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

        testCases.add(168403725);
        //testCases.add(847632150);
        testCases.add(125340678);
        //testCases.add(631285074);


        return testCases;
    }
    @Test
    public void testDFS(){
        ArrayList<Integer> tests = initTestCases();
        for (int seq :tests){
            SearchAlgorithm<State> algo = new DFS(seq);
            int res = algo.search();
            if(res == -1) fail("Unsolvable");
            else assertEquals(res,12345678);
        }
    }
    @Test
    public void testBFS(){
        ArrayList<Integer> tests = initTestCases();
        for (int seq :tests){
            SearchAlgorithm<State> algo = new BFS(seq);
            int res = algo.search();
            if(res == -1) fail("Unsolvable");
            else assertEquals(res,12345678);        }
    }
    @Test
    public void testAstarManhattan(){
        ArrayList<Integer> tests = initTestCases();
        for (int seq :tests){
            SearchAlgorithm<State> algo = new AStar<>(seq,CostType.MANHATTAN);
            int res = algo.search();
            if(res == -1) fail("Unsolvable");
            else assertEquals(res,12345678);        }
    }
    @Test
    public void testAstarEuclidean(){
        ArrayList<Integer> tests = initTestCases();
        for (int seq :tests){
            SearchAlgorithm<State> algo = new AStar<>(seq,CostType.EUCLIDEAN);
            int res = algo.search();
            if(res == -1) fail("Unsolvable");
            else assertEquals(res,12345678);        }
    }
}