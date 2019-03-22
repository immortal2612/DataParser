import java.io.File;
import java.util.ArrayList;

/***
 * by Ayush Nair
 */

public class Main {
    public static void main(String[] args){
        String education = utils.readFileAsString("data/Education.csv");

        ArrayList<Education2016> education2016 = utils.parse2016Education(education);

        System.out.println("noHS: " + education2016.get(10).getNoHighSchool() + ". onlyHS: " + education2016.get(10).getOnlyHighSchool() + ". someCollege: " + education2016.get(10).getSomeCollege() + ". bOrMore: " + education2016.get(10).getBachelorOrMore());
    }
}
