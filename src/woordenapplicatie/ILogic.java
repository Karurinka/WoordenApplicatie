package woordenapplicatie;

import java.util.*;

public interface ILogic
{
    String[] splitString(String input);
    List<String> getList(String input);
    HashSet<String> getHashSet(String input);
    int aantal(String input);
    List<String> sorteer(String input);
    SortedSet<Map.Entry<String, Integer>> frequentie(String input);
    Map<String, Set<Integer>> concordantie(String input);
}
