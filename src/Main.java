import java.io.File;
import java.util.ArrayList;

/***
 * by Ayush Nair
 */

public class Main {
    public static void main(String[] args){
        String election = utils.readFileAsString("data/2016_Presidential_Results.csv");
        String education = utils.readFileAsString("data/Education.csv");
        String employment = utils.readFileAsString("data/Unemployment.csv");

        ArrayList<ElectionResult> electionResults = utils.parse2016PresidentialResults(election);
        ArrayList<Education2016> education2016 = utils.parse2016Education(education);
        ArrayList<Employment2016> employment2016 = utils.parse2016Employment(employment);

        System.out.println("votes dem: " + electionResults.get(10).getVotes_dem() + ". votes gop: " + electionResults.get(10).getVotes_gop() + ". total votes: " +electionResults.get(10).getTotal_votes());
        System.out.println("noHS: " + education2016.get(10).getNoHighSchool() + ". onlyHS: " + education2016.get(10).getOnlyHighSchool() + ". someCollege: " + education2016.get(10).getSomeCollege() + ". bOrMore: " + education2016.get(10).getBachelorOrMore());
        System.out.println("totalLaborForce: " + employment2016.get(10).getTotalLaborForce() + ". EmployedLabor: " + employment2016.get(10).getEmployedLabor() + ". UnemployedLabor: " + employment2016.get(10).getUnemployedLabor() + ". percentUnemployed: " + employment2016.get(10).getPerUnemployed());
    }
}
