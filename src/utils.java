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

        for(int i = 23; i < StringData.length; i++){
            Education2016 a = new Education2016(StringData[i]);
            data.add(a);
        }
        /*for(int i = 23; i < StringData.length; i++){
            System.out.println(StringData[i]);
        }*/
        return data;
    }

    public static ArrayList<Employment2016> parse2016Employment(String fileToString){
        String[] StringData = fileToString.split("\n");

        ArrayList<Employment2016> data = new ArrayList<>();

        for(int i = 19; i < StringData.length; i++){
            Employment2016 a = new Employment2016(StringData[i]);
            data.add(a);
        }

        return data;
    }
}
