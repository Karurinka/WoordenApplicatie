package woordenapplicatie;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class LogicTest
{
    private String originalInput;
    private String expectedOutput;
    private String[] originalSplitOutput;
    private LogicManager logicManager;
    private List<String> testList;
    private List<String> correctList;

    private HashSet<String> correctHashSet;
    private HashSet<String> testHashSet;

    private SortedSet<Map.Entry<String, Integer>> correctSet;
    private SortedSet<Map.Entry<String, Integer>> testSet;

    @Before
    public void setUp() throws Exception
    {
        logicManager = new LogicManager(new Logic());
        originalInput = "Hello world";
        expectedOutput = "hello world";
        testList = new ArrayList<>();
        correctList = new ArrayList<>();
    }

    @Test
    public void splitString()
    {
        originalSplitOutput = logicManager.splitString(originalInput);
        originalInput = String.join(" ", originalSplitOutput);

        assertEquals(expectedOutput, originalInput);
        assertNotEquals("Dhde", originalSplitOutput);
    }

    @Test
    public void getList()
    {
        correctList.add("e");
        correctList.add("f");
        correctList.add("g");

        testList = logicManager.getList("E, f, G");

        assertEquals(correctList, testList);
    }

    @Test
    public void getHashSet()
    {
        correctHashSet = new HashSet<>(logicManager.getList(originalInput));
        testHashSet = new HashSet<>(logicManager.getList(expectedOutput));

        assertEquals(correctHashSet, testHashSet);
    }


    @Test
    public void aantal()
    {
        int originalInputAmount = logicManager.aantal(originalInput);
        assertEquals(2, originalInputAmount);
    }

    @Test
    public void sorteer()
    {
        correctList.add("g");
        correctList.add("f");
        correctList.add("e");

        testList = logicManager.sorteer("E, f, G");
        assertEquals(correctList, testList);
    }

    @Test
    public void frequentie()
    {
        //logicManager.frequentie()
    }

    @Test
    public void concordantie()
    {

    }
}