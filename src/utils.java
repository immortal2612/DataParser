import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class utils {
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

    public static ArrayList<ElectionResult> parse2016PresidentialResults(String fileToString){
        String[] StringData = fileToString.split("\n");

        ArrayList<ElectionResult> data = new ArrayList<>();

        for(int i = 29; i < StringData.length; i++){
            ElectionResult a = new ElectionResult(StringData[i]);
            data.add(a);
        }

        return data;
    }

    public static ArrayList<Education2016> parse2016Education(String fileToString){
        String[] StringData = fileToString.split("\n");

        ArrayList<Education2016> data = new ArrayList<>();

        for(int i = 23; i < StringData.length - 11; i++){
            Education2016 a = new Education2016(StringData[i]);
            data.add(a);
        }

        return data;
    }
        public static ArrayList<DepressionStats> parse2016DepressionStatistics(String data) {
            //   Create your return arraylist;
            ArrayList<DepressionStats> results = new ArrayList<>();
            //  split input data by \n to create array of rows
            String[] lines = data.split("\n");

            //   loop over all rows BUT SKIP THE FIRST 25 ROWS (look at the file to see why)
            for (int a = 25; a < lines.length-1; a++) {

                //       for each row {
                //       split it into individual values and save into the right kinds of variables.
                lines[a] = cleanLine(lines[a]);
                String[] lineOfCoordinates = lines[a].split(",");
                String stateName = "";
                String over18 = "";
                int numOver18;
                stateName += lineOfCoordinates[1];
                stateName = clean(stateName);
                over18 += lineOfCoordinates[2];
                over18 = clean(over18);
                numOver18 = Integer.parseInt(over18);

                DepressionStats newDepStats = new DepressionStats(stateName, numOver18);
                //     Add it to your list.
                results.add(newDepStats);
            }

            return results;
        }

        private static String cleanLine(String row){

            int firstQuote = row.indexOf("\"");
            int secondQuote = row.indexOf("\"", firstQuote + 1);

            while (firstQuote != -1 && secondQuote != -1){
                row = cleanSubstring(row, firstQuote, secondQuote);

                firstQuote = row.indexOf("\"");
                secondQuote = row.indexOf("\"", firstQuote+1);
            }
            return row;
        }

        private static String cleanSubstring(String row, int firstQuote, int secondQuote) {
            String before = row.substring(0, firstQuote);
            String after = row.substring(secondQuote+1);

            String toClean = row.substring(firstQuote+1, secondQuote);

            return before + clean(toClean) + after;
        }

        private static String clean(String toClean) {
            toClean = toClean.replaceAll(",", "").trim();
            toClean = toClean.replaceAll("%", "");
            return toClean;
        }
}
