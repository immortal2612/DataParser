import java.io.File;
import java.util.ArrayList;

/***
 * by Ayush Nair
 */

public class Main {
    public static void main(String[] args){
        String file = utils.readFileAsString("data/2016_Presidential_Results.csv");
        ArrayList<ElectionResult> data = utils.parse2016PresidentialResults(file);
        System.out.println("votes dem " + data.get(50).getVotes_dem() + ". votes gop " + data.get(50).getVotes_gop() + ". total votes " +data.get(50).getTotal_votes());
        System.out.println("votes dem " + data.get(10).getVotes_dem() + ". votes gop " + data.get(10).getVotes_gop() + ". total votes " +data.get(10).getTotal_votes());

        //System.out.println(utils.readFileAsString("data/2016_Presidential_Results.csv"));
    }
}
