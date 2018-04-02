package woordenapplicatie;

import java.util.*;

public interface ILogic
{
    /**
     * splits the input on spaces, new lines and lowercases the entire string
     * @param input
     * @return
     */
    String[] splitString(String input);

    /**
     * gets the list with the corresponding input
     * @param input
     * @return
     */
    List<String> getList(String input);

    /**
     *
     * @param input
     * @return the hasset with the corresponding input
     */
    HashSet<String> getHashSet(String input);

    /**
     *
     * @param input
     * @return the total amount of different words
     */
    int aantal(String input);

    /**
     *
     * @param input
     * @return the sorted list in descending order
     */
    List<String> sorteer(String input);

    /**
     *
     * @param input
     * @return the sortedset with the frequency of words
     */
    List<Map.Entry<String, Integer>> frequentie(String input);

    /**
     *
     * @param input
     * @return a map with words and corresponding lines
     */
    Map<String, Set<Integer>> concordantie(String input);
}
