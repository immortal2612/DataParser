import java.io.File;
import java.util.ArrayList;

/***
 * by Ayush Nair
 */

public class Main {
    public static void main(String[] args){
        String file = utils.readFileAsString("data/2016_Presidential_Results.csv");
        ArrayList<ElectionResult> data = utils.parse2016PresidentialResults(file);
        //System.out.println(data.get(50).getCounty_name() + data.get(50).getPer_dem() + data.get(50).getPer_gop());
        //System.out.println(data.get(10).getCounty_name() + data.get(10).getPer_dem() + data.get(10).getPer_gop());

        //System.out.println(utils.readFileAsString("data/2016_Presidential_Results.csv"));
    }
}
