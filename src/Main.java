import java.io.File;
import java.util.ArrayList;

/***
 * by Ayush Nair
 */

public class Main {
    public static void main(String[] args){
        String education = utils.readFileAsString("data/Education.csv");

        ArrayList<Education2016> education2016 = utils.parse2016Education(education);
        Education2016 num10 = education2016.get(10);
        System.out.println(num10.getPernoHighSchool() + " " + num10.getNumNoHighSchool() + " " + num10.getPerOnlyHighSchool() + " " + num10.getNumOnlyHighSchool() + " " + num10.getPerSomeCollege() + " " + num10.getNumSomeCollege() + " " +num10.getPerBachelorOrMore() + " " + num10.getNumBachelorOrMore());

    }
}
