package woordenapplicatie;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class LogicTest
{
    private final String TEST_TEXT_1 = "this is a test text";
    private final String TEST_TEXT_2 = "this is test text 2, and this is supposed to test more";

    private ILogic logic;

    @Before
    public void setUp() throws Exception
    {
        logic = new Logic();
    }

    @Test
    public void splitStringTest()
    {
        String[] result = logic.splitString(TEST_TEXT_1);

        String[] simpleResult = TEST_TEXT_1.split(" ");

        for (int i = 0; i < simpleResult.length; i++)
        {
            Assert.assertFalse("General split fails", !result[i].equals(simpleResult[i]));
        }

        result = logic.splitString(TEST_TEXT_2);
        String[] advancedResult = TEST_TEXT_2.split("[, \n]+");

        for (int i = 0; i < advancedResult.length; i++)
        {
            Assert.assertFalse("Split fails on other character than spaces", !result[i].equals(advancedResult[i]));
        }
    }

    @Test
    public void getListTest()
    {
        List<String> result = logic.getList(TEST_TEXT_1);
        List<String> simpleResult = Arrays.asList(TEST_TEXT_1.split(" "));

        Assert.assertFalse("list does not contain equal amount of items (simple)", result.size() != simpleResult.size());
        Assert.assertFalse("the items it contains aren't correct (simple)", !result.containsAll(simpleResult));

        result = logic.getList(TEST_TEXT_2);
        List<String> advancedResult = Arrays.asList(TEST_TEXT_2.split("[, \n]+"));

        Assert.assertFalse("List does not contain equal amount of items (advanced)", result.size() != advancedResult.size());
        Assert.assertFalse("The items it contains aren't correct (advanced)", !result.containsAll(advancedResult));
    }

    @Test
    public void aantalTest()
    {
        int simpleResult = 5;

        Assert.assertEquals("Check on unique words fails in simple attempt", simpleResult, logic.aantal(TEST_TEXT_1));

        int advancedResult = 9;

        Assert.assertEquals("Check on unique words fails in advanced attempt", advancedResult, logic.aantal(TEST_TEXT_2));
    }

    @Test
    public void sorteerTest()
    {
        List<String> result = logic.sorteer(TEST_TEXT_1);
        Set<String> simpleResult = new TreeSet<>(Arrays.asList(TEST_TEXT_1.split(" ")));

        Assert.assertFalse("Result does not contain the items it should contain (simple)", result.size() != simpleResult.size() || !result.containsAll(simpleResult));
        Assert.assertFalse("Result does not contain the correct order of items (simple)", !(result.get(0).equals("this") || result.get(1).equals("test") || result.get(2).equals("text") || result.get(3).equals("is") || result.get(4).equals("a")));

        result = logic.sorteer(TEST_TEXT_2);
        Set<String> advancedResult = new TreeSet<>(Arrays.asList(TEST_TEXT_2.split("[, \n]+")));

        Assert.assertFalse("Result does not contain the items it should contain (advanced)", result.size() != advancedResult.size() || !result.containsAll(advancedResult));
        Assert.assertFalse("Result does not contain the correct order of items (advanced)", !(result.get(0).equals("to") || result.get(1).equals("this") || result.get(2).equals("text") || result.get(3).equals("test") || result.get(4).equals("supposed") || result.get(5).equals("more") || result.get(6).equals("is") || result.get(7).equals("and") || result.get(8).equals("2")));
    }

    @Test
    public void frequentieTest()
    {
        String frequencyString = "three two three one two three";
        List<Map.Entry<String, Integer>> entries = logic.frequentie(frequencyString);

        for (Map.Entry<String, Integer> entry : entries)
        {
            switch (entry.getKey())
            {
                case "one":
                    Assert.assertTrue(entry.getValue() == 1);
                    break;
                case "two":
                    Assert.assertTrue(entry.getValue() == 2);
                    break;
                case "three":
                    Assert.assertTrue(entry.getValue() == 3);
                    break;
                default:
                    Assert.fail();
            }
        }
    }

    @Test
    public void concordantieTest()
    {
        Map<String, Set<Integer>> result = logic.concordantie(TEST_TEXT_1);

        String[] simpleResult = TEST_TEXT_1.toLowerCase().split("[, \n]+");

        for (String splitItem : simpleResult)
        {
            Set<Integer> integers = result.get(splitItem);

            Assert.assertFalse("Every word should contain at least 1 value", integers == null);

            integers.iterator().forEachRemaining(integer -> Assert.assertFalse("Incorrect line number has been given to words in a text with one line", integer != 1));
        }

        String lineTestText = "this is a test text \n" + "with text on multiple on lines \n" + "with double text";

        result = logic.concordantie(lineTestText);

        Set<Integer> thisIntegers = result.get("this");
        Assert.assertFalse("Every item should appear at least once", thisIntegers.size() != 1);

        Set<Integer> onIntegers = result.get("on");
        Assert.assertFalse("Every integer can only appear once per word", onIntegers.size() > 1);

        Set<Integer> withIntegers = result.get("with");
        withIntegers.iterator().forEachRemaining(integer -> Assert.assertFalse("Incorrect integers assigned to 'with' value", !(integer == 2 || integer == 3)));
    }
}