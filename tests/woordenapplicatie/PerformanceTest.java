package woordenapplicatie;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PerformanceTest
{
    private LogicManager logicManager;
    private String stringPerformance10k;
    private String stringPerformance1mil;

    private static final Logger logger = Logger.getLogger(LogicManager.class.getName());
    private static final String DEFAULT_TEXT =
                    "Een, twee, drie, vier\n" +
                    "Hoedje van, hoedje van\n" +
                    "Een, twee, drie, vier\n" +
                    "Hoedje van papier\n" +
                    "\n" +

                    "Heb je dan geen hoedje meer\n" +
                    "Maak er één van bordpapier\n" +
                    "Eén, twee, drie, vier\n" +
                    "Hoedje van papier\n" + "\n" +
                    "Een, twee, drie, vier\n" +
                    "Hoedje van, hoedje van\n" +
                    "Een, twee, drie, vier\n" +
                    "Hoedje van papier\n" +
                    "\n" +

                    "En als het hoedje dan niet past\n" +
                    "Zetten we 't in de glazenkas\n" +
                    "Een, twee, drie, vier\n" +
                    "Hoedje van papier";


    @Before
    public void setUp() throws Exception
    {
        logicManager = new LogicManager(new Logic());
        stringPerformance10k = generateString(10000);
        stringPerformance1mil = generateString(1000000);
    }

    @Test
    public void splitString() throws Exception
    {
        long startTime = System.nanoTime();
        logicManager.splitString(DEFAULT_TEXT);
        long resultTime = System.nanoTime() - startTime;
        String logMessage = String.format("getSplitText - time measured: %d nanoseconds", resultTime);
        logger.log(Level.INFO, logMessage);

        long startTime10k = System.nanoTime();
        logicManager.splitString(stringPerformance10k);
        long resultTime10k = System.nanoTime() - startTime10k;
        String logMessage10k = String.format("getSplitText10k - time measured: %d nanoseconds", resultTime10k);
        logger.log(Level.INFO, logMessage10k);

        long startTime1mil = System.nanoTime();
        logicManager.splitString(stringPerformance1mil);
        long resultTime1mil = System.nanoTime() - startTime1mil;
        String logMessage1mil = String.format("getSplitText1mil - time measured: %d nanoseconds", resultTime1mil);
        logger.log(Level.INFO, logMessage1mil);
    }

    @Test
    public void getList() throws Exception
    {
        long startTime = System.nanoTime();
        logicManager.getList(DEFAULT_TEXT);
        long resultTime = System.nanoTime() - startTime;
        String logMessage = String.format("getList - time measured: %d nanoseconds", resultTime);
        logger.log(Level.INFO, logMessage);

        long startTime10k = System.nanoTime();
        logicManager.getList(stringPerformance10k);
        long resultTime10k = System.nanoTime() - startTime10k;
        String logMessage10k = String.format("getList10k - time measured: %d nanoseconds", resultTime10k);
        logger.log(Level.INFO, logMessage10k);

        long startTime1mil = System.nanoTime();
        logicManager.getList(stringPerformance1mil);
        long resultTime1mil = System.nanoTime() - startTime1mil;
        String logMessage1mil = String.format("getList1mil - time measured: %d nanoseconds", resultTime1mil);
        logger.log(Level.INFO, logMessage1mil);
    }

    @Test
    public void aantal() throws Exception
    {
        long startTime = System.nanoTime();
        logicManager.aantal(DEFAULT_TEXT);
        long resultTime = System.nanoTime() - startTime;
        String logMessage = String.format("aantal - time measured: %d nanoseconds", resultTime);
        logger.log(Level.INFO, logMessage);

        long startTime10k = System.nanoTime();
        logicManager.aantal(stringPerformance10k);
        long resultTime10k = System.nanoTime() - startTime10k;
        String logMessage10k = String.format("aantal10k - time measured: %d nanoseconds", resultTime10k);
        logger.log(Level.INFO, logMessage10k);

        long startTime1mil = System.nanoTime();
        logicManager.aantal(stringPerformance1mil);
        long resultTime1mil = System.nanoTime() - startTime1mil;
        String logMessage1mil = String.format("aantal1mil - time measured: %d nanoseconds", resultTime1mil);
        logger.log(Level.INFO, logMessage1mil);
    }

    @Test
    public void sorteer() throws Exception
    {
        long startTime = System.nanoTime();
        logicManager.sorteer(DEFAULT_TEXT);
        long resultTime = System.nanoTime() - startTime;
        String logMessage = String.format("sorteer - time measured: %d nanoseconds", resultTime);
        logger.log(Level.INFO, logMessage);

        long startTime10k = System.nanoTime();
        logicManager.sorteer(stringPerformance10k);
        long resultTime10k = System.nanoTime() - startTime10k;
        String logMessage10k = String.format("sorteer10k - time measured: %d nanoseconds", resultTime10k);
        logger.log(Level.INFO, logMessage10k);

        long startTime1mil = System.nanoTime();
        logicManager.sorteer(stringPerformance1mil);
        long resultTime1mil = System.nanoTime() - startTime1mil;
        String logMessage1mil = String.format("sorteer1mil - time measured: %d nanoseconds", resultTime1mil);
        logger.log(Level.INFO, logMessage1mil);
    }

    @Test
    public void frequentie() throws Exception
    {
        long startTime = System.nanoTime();
        logicManager.frequentie(DEFAULT_TEXT);
        long resultTime = System.nanoTime() - startTime;
        String logMessage = String.format("frequentie - time measured: %d nanoseconds", resultTime);
        logger.log(Level.INFO, logMessage);

        long startTime10k = System.nanoTime();
        logicManager.frequentie(stringPerformance10k);
        long resultTime10k = System.nanoTime() - startTime;
        String logMessage10k = String.format("frequentie10k - time measured: %d nanoseconds", resultTime10k);
        logger.log(Level.INFO, logMessage10k);

        long startTime1mil = System.nanoTime();
        logicManager.frequentie(stringPerformance1mil);
        long resultTime1mil = System.nanoTime() - startTime1mil;
        String logMessage1mil = String.format("frequentie1mil - time measured: %d nanoseconds", resultTime1mil);
        logger.log(Level.INFO, logMessage1mil);
    }

    @Test
    public void concordantie() throws Exception
    {
        long startTime = System.nanoTime();
        logicManager.concordantie(DEFAULT_TEXT);
        long resultTime = System.nanoTime() - startTime;
        String logMessage = String.format("concordantie - time measured: %d nanoseconds", resultTime);
        logger.log(Level.INFO, logMessage);

        long startTime10k = System.nanoTime();
        logicManager.concordantie(stringPerformance10k);
        long resultTime10k = System.nanoTime() - startTime;
        String logMessage10k = String.format("concordantie10k - time measured: %d nanoseconds", resultTime10k);
        logger.log(Level.INFO, logMessage10k);

        long startTime1mil = System.nanoTime();
        logicManager.concordantie(stringPerformance1mil);
        long resultTime1mil = System.nanoTime() - startTime1mil;
        String logMessage1mil = String.format("concordantie1mil - time measured: %d nanoseconds", resultTime1mil);
        logger.log(Level.INFO, logMessage1mil);
    }

    private String generateString(int numberOfWords)
    {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < numberOfWords; i++)
        {
            String name = " " + random.nextInt();
            if ((i % 5) == 0)
            {
                stringBuilder.append("\n");
            }
            stringBuilder.append(name + "");
        }
        return  stringBuilder.toString();
    }
}
