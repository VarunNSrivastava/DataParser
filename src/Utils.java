import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {



    public static String readFileAsString(String filepath) {
        StringBuilder output = new StringBuilder();

        try (Scanner scanner = new Scanner(new File(filepath))) {

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                output.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output.toString();
    }


    /***
     *   private double 1 votesDem, 2 votesGOP, 3 totalVotes, 4 perDem, 5 perGOP;
     *     private int !diff;
     *     private double length-4 perPointDiff;
     *     private String length-3 stateAbbr, length-2 countyName;
     *     private int length-1 combinedFips;
     */


    public static ArrayList<ElectionResult> parse2016PresidentialResults(String csv_data) {
        String[] lines = csv_data.split("\n");
        ArrayList<ElectionResult> out = new ArrayList<>();

        for (int i = 1; i < lines.length; i++) {
            String current = lines[i];
            ElectionResult temp = new ElectionResult();
            temp.setDiff(getDiff(current));
            
            String[] commaBreaks = current.split(",");
            temp.setVotesDem(getVotesDem(commaBreaks));
            temp.setVotesGOP(getVotesGop(commaBreaks));
            temp.setTotalVotes(getTotalVotes(commaBreaks));
            temp.setPerDem((getPerDem(commaBreaks)));
            temp.setPerGOP((getPerGop(commaBreaks)));
            temp.setPerPointDiff((getPerPointDiff(commaBreaks)));
            temp.setStateAbbr((getStateAbbr(commaBreaks)));
            temp.setCountyName((getCountyName(commaBreaks)));
            temp.setCombinedFips((getCombinedFips(commaBreaks)));
        }

        return out;
    }

    private static int getCombinedFips(String[] commaBreaks) {
        return Integer.parseInt(commaBreaks[commaBreaks.length - 1]);
    }

    private static String getCountyName(String[] commaBreaks) { return commaBreaks[commaBreaks.length - 2]; }

    private static String getStateAbbr(String[] commaBreaks) { return commaBreaks[commaBreaks.length -3];}

    private static double getPerPointDiff(String[] commaBreaks) {
        String temp = commaBreaks[commaBreaks.length - 4];
        temp = temp.substring(0,temp.length() - 1);
        return Double.parseDouble(temp);
    }

    private static double getPerGop(String[] commaBreaks) { return Double.parseDouble(commaBreaks[5]); }

    private static double getPerDem(String[] commaBreaks) { return Double.parseDouble(commaBreaks[4]); }

    private static double getTotalVotes(String[] commaBreaks) { return Double.parseDouble(commaBreaks[3]); }

    private static double getVotesGop(String[] commaBreaks) { return Double.parseDouble(commaBreaks[2]); }

    private static double getVotesDem(String[] commaBreaks) { return Double.parseDouble(commaBreaks[1]); }

    private static int getDiff(String current) {
        String[] temp = current.split("\"");
        String diff = temp[1];
        if ( diff.indexOf(",") != -1 ) {
            int out = Integer.parseInt(diff.replace(",", ""));
            return out;
        } else return Integer.parseInt(diff);
    }
}
