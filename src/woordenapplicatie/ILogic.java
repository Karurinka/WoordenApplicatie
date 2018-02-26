package woordenapplicatie;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

public interface ILogic
{
    String[] splitString(String input);
    int aantal(String input);
    List<String> sorteer(String input);
    SortedSet<Map.Entry<String, Integer>> frequentie(String input);
    Map<String, Set<Integer>> concordantie(String input);
}
