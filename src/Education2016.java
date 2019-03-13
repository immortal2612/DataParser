import java.util.ArrayList;

public class Education2016 {
    private static String FIPS;
    private static String State;

    private static double noHighSchool;
    private static double onlyHighSchool;
    private static double someCollege;
    private static double bachelorOrMore;

    public Education2016(String file){
        String[] data = loadDatatoArray(file);
        loadDataToFields(data);
    }

    private static String[] loadDatatoArray(String a){
        boolean startQuote = false;
        boolean endQuote = false;
        int startQuoteIndex = 0;
        String cleanA = "";
        for(int i = 0; i < a.length(); i++){
            if (a.substring(i, i + 1).equals("\"") && startQuote == true) {
                cleanA += removeComma(a.substring(startQuoteIndex,i));
            } else if(a.substring(i, i+1).equals("\"") && startQuote == false){
                startQuote = true;
                startQuoteIndex = i;
            } else{
                cleanA += a.substring(i, i+1);
            }
        }


        String[] temp = cleanA.split(",");

        for(int i = 0; i < temp.length; i++){
            String c = temp[i];
            if(c.contains("\"") || c.contains(" ")){
                temp[i] = cleanString(c);
            }
        }

        return temp;
    }

    private static void loadDataToFields(String[] data){
        setFIPS(data[0]);
        setState(data[1]);
        boolean full = checkIfDataIsEmpty(data);
        if(full == true){
            setNoHighSchool(Double.parseDouble(data[data.length-4]));
            setOnlyHighSchool(Double.parseDouble(data[data.length-3]));
            setSomeCollege(Double.parseDouble(data[data.length-2]));
            setBachelorOrMore(Double.parseDouble(data[data.length-1]));
        }
    }

    private static boolean checkIfDataIsEmpty(String[] data) {
        for(int i = 0; i < data.length; i++){
            if(data[i].equals("")){
                return false;
            }
        }

        return true;
    }

    public String getFIPS() {
        return FIPS;
    }

    public static void setFIPS(String fips) {
        FIPS = fips;
    }

    public double getNoHighSchool() {
        return noHighSchool;
    }

    public static void setNoHighSchool(double noHS) {
        noHighSchool = noHS;
    }

    public double getOnlyHighSchool() {
        return onlyHighSchool;
    }

    public static void setOnlyHighSchool(double onlyHS) {
        onlyHighSchool = onlyHS;
    }

    public double getSomeCollege() {
        return someCollege;
    }

    public static void setSomeCollege(double someC) {
        someCollege = someC;
    }

    public double getBachelorOrMore() {
        return bachelorOrMore;
    }

    public static void setBachelorOrMore(double bOrMore) {
        bachelorOrMore = bOrMore;
    }
    public static String getState() {
        return State;
    }

    public static void setState(String state) {
        State = state;
    }

    private static String cleanString(String var){
        String[] chars = new String[var.length()];
        ArrayList<Integer> spaces = new ArrayList<>();
        for(int i = 0; i < chars.length; i++){
            chars[i] = var.substring(i, i+1);
            if(chars[i].equals(" ") || chars[i].equals("\"")){
                spaces.add(i);
            }
        }

        for(int i = 0; i < spaces.size(); i++){
            chars[spaces.get(i)] = "";
        }

        String newvar = "";

        for(int i = 0; i < chars.length; i++){
            newvar += chars[i];
        }

        return newvar;
    }

    private static String removeComma(String a){
        String[] chars = new String[a.length()];
        for(int i = 0; i < chars.length; i++){
            if(a.substring(i, i+1).equals(",")){
                chars[i] = "";
            }else{
                chars[i] = a.substring(i,i+1);
            }
        }

        String returnVal = "";
        for(int i = 0; i < chars.length; i++){
            returnVal += chars[i];
        }

        return returnVal;
    }

}
