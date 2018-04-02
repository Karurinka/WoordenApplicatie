package woordenapplicatie;

import java.util.*;

public class Logic implements ILogic
{

    public String[] splitString(String input) // O(N^2)
    {
        return input.toLowerCase().split("[,\n ]+"); // O(N^2)
    }

    public List<String> getList(String input) // O(N + N^2)
    {
        return Arrays.asList(splitString(input)); // O(N + N^2)
    }

    public TreeSet<String> getTreeSet(String input) // O(log(N) + 1 + N^2)
    {
        return new TreeSet<String>(getList(input)); // O(log(N) + 1 + N^2)
    }

    public HashSet<String> getHashSet(String input) // O(N + N^2+ 1)
    {
        return new HashSet<>(getList(input)); // O(1 + N^2+ 1)
    }

    /**
     * Shows the total amount of words
     * and the amount of different words
     *
     * @return
     */
    @Override
    public int aantal(String input) // O(N + N^2+ 1)
    {
        return getHashSet(input).size(); // O(1 + N^2+ 1)
    }

    @Override
    public List<String> sorteer(String input)// O(1 + N^2 + N)
    {
        List<String> sortedString = new LinkedList<>(); // O(1)
        sortedString.addAll(getTreeSet(input).descendingSet());// O(N^2 + N)
        return sortedString;
    }

    @Override
    public List<Map.Entry<String, Integer>> frequentie(String input) //2n^2
    {
        String[] allWords = splitString(input);

        HashMap<String, Integer> wordFrequency = new HashMap<>();

        for (String word : allWords) // 2n^2
        {
            if (wordFrequency.containsKey(word))
            {
                wordFrequency.replace(word, wordFrequency.get(word) + 1); //O(n) + O(n) = O(2n)
            }
            else
            {
                wordFrequency.put(word, 1); //O(n)
            }
        }

        List<Map.Entry<String, Integer>> entries = new LinkedList<>(wordFrequency.entrySet()); //O(2n)

        entries.sort(Comparator.comparing(Map.Entry::getValue));

        return entries;
    }

    @Override
    public Map<String, Set<Integer>> concordantie(String input)
    {
        Map<String, Set<Integer>> map = new HashMap<>(); // O(1)
        String[] lines = input.split("\n+"); // O(N^2)

        for (int i = 0; i < lines.length; i++) //O(n)
        {
            String line = lines[i];

            for (String word : line.split(" "))
            {
                map.computeIfAbsent(word, k -> new HashSet<>()).add(i + 1); // O(3)
            }
        }
        return map;
    }
}
