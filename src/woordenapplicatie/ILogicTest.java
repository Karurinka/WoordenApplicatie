package woordenapplicatie;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;


public class ILogicTest implements ILogic
{
    private final ILogic logic;

    public ILogicTest(ILogic logic)
    {
        this.logic = logic;
    }

    @Override
    public String[] splitString(String input)
    {
        return logic.splitString(input);
    }

    @Override
    public int aantal(String input)
    {
        return logic.aantal(input);
    }

    @Override
    public List<String> sorteer(String input)
    {
        return logic.sorteer(input);
    }

    @Override
    public SortedSet<Map.Entry<String, Integer>> frequentie(String input)
    {
        return logic.frequentie(input);
    }

    @Override
    public Map<String, Set<Integer>> concordantie(String input)
    {
        return logic.concordantie(input);
    }
}