package woordenapplicatie;

import java.util.*;

public class Logic implements ILogic, Comparator<String>
{
    private HashSet aantalSet;
    private TreeSet<String[]> sorteerSet;
    private String words;
    private String[] allWords;

    public Logic(String words)
    {
        this.words = words;
        allWords = splitString(words.toLowerCase());
    }

    private String[] splitString(String string)
    {
        return string.split("[,\n ]+");
    }

    /**
     * Shows the total amount of words
     * and the amount of different words
     *
     * @return
     */
    public String aantal()
    {
        aantalSet = new HashSet(Arrays.asList(allWords));

        String returnString = "Totaal aantal woorden: " + allWords.length + "\n" + "Aantal verschillende woorden: " + aantalSet.size();
        return returnString;
    }

    public String sorteer()
    {
        sorteerSet = new TreeSet<>();
        Arrays.sort(allWords, Collections.reverseOrder());
        sorteerSet.add(allWords);

        System.out.println(allWords.toString());

        return "";
    }

    public String frequentie()
    {
        HashMap<String, Integer> frequency = new HashMap<>();
        for (String s : allWords)
        {
            if (frequency.containsKey(s))
            {
                frequency.replace(s, frequency.get(s) + 1);

            }
            else
            {
                frequency.put(s, 1);
            }
        }

        return "";
    }

    public String concordantie()
    {
        return "";
    }

    @Override
    public int compare(String o1, String o2)
    {
        return 0;
    }
}
