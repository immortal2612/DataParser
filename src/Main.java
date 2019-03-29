import java.util.ArrayList;

/***
 * by Ayush Nair
 */

public class Main {
    public static void main(String[] args){
        String depressionFile = utils.readFileAsString("data/depression.csv");
        String EducationFile = utils.readFileAsString("data/Education.csv");
        String ElectionFile = utils.readFileAsString("data/2016_Presidential_Results.csv");

        ArrayList<DepressionStats> depression = utils.parse2016DepressionStatistics(depressionFile);
        ArrayList<Education2016> education = utils.parse2016Education(EducationFile);
        ArrayList<ElectionResult> election = utils.parse2016PresidentialResults(ElectionFile);

        DataManager d = new DataManager(election, education, depression);

        System.out.println(d.getStateInfo(25));
    }
}
