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

        for(int i = 1; i < StringData.length; i++){
            ElectionResult a = new ElectionResult(StringData[i]);
            data.add(a);
        }

        return data;
    }
}
