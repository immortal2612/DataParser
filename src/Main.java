/***
 * by Ayush Nair
 */

public class Main {
    public static void main(String[] args){
        String filename = utils.readFileAsString("data/depression.csv");
        utils.parseDepressionData(filename);
    }
}
