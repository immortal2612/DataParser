import javax.xml.crypto.Data;
import java.io.File;
import java.util.ArrayList;

/***
 * by Ayush Nair
 */

public class Main {
    public static void main(String[] args){
        String education = utils.readFileAsString("data/Education.csv");
        String election = utils.readFileAsString("data/2016_Presidential_Results.csv");
        ArrayList<Education2016> education2016 = utils.parse2016Education(education);
        ArrayList<ElectionResult> election2016 = utils.parse2016PresidentialResults(election);

        DataManager f = new DataManager(education2016, election2016);
        f.PrintCountyInfo(f.getCounty(20));
    }
}
