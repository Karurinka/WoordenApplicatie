package woordenapplicatie;

import java.util.*;


public class LogicManager implements ILogic
{
    private final ILogic logic;

    public LogicManager(ILogic logic)
    {
        this.logic = logic;
    }

    @Override
    public String[] splitString(String input)
    {
        return logic.splitString(input);
    }

    @Override
    public List<String> getList(String input)
    {
        return logic.getList(input);
    }

    @Override
    public HashSet<String> getHashSet(String input)
    {
        return logic.getHashSet(input);
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