import java.util.ArrayList;

public class Education2016 {
    private static String FIPS;
    private static String State;

    private static double PernoHighSchool;
    private static double PeronlyHighSchool;
    private static double PersomeCollege;
    private static double PerbachelorOrMore;
    private static int NumNoHighSchool;
    private static int NumOnlyHighSchool;
    private static int NumSomeCollege;
    private static int NumBachelorOrMore;

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
                cleanA += removeComma(a.substring(startQuoteIndex,i+1));
                startQuote = false;
                startQuoteIndex = 0;
            } else if(a.substring(i, i+1).equals("\"") && startQuote == false){
                startQuote = true;
                startQuoteIndex = i;
            } else if(startQuote == false){
                cleanA += a.substring(i, i+1);
            }
        }


        String[] temp = cleanA.split(",");

        for(int i = 0; i < temp.length; i++){
            String c = temp[i];
            if(c.contains("\t")){
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
            setPerNoHighSchool(Double.parseDouble(data[data.length-4]));
            setPerOnlyHighSchool(Double.parseDouble(data[data.length-3]));
            setPerSomeCollege(Double.parseDouble(data[data.length-2]));
            setPerBachelorOrMore(Double.parseDouble(data[data.length-1]));
            setNumNoHighSchool(Integer.parseInt(data[data.length-8]));
            setNumOnlyHighSchool(Integer.parseInt(data[data.length-7]));
            setNumSomeCollege(Integer.parseInt(data[data.length-6]));
            setNumBachelorOrMore(Integer.parseInt(data[data.length - 5]));
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

    public static int getNumNoHighSchool() {
        return NumNoHighSchool;
    }

    public static void setNumNoHighSchool(int numNoHighSchool) {
        NumNoHighSchool = numNoHighSchool;
    }

    public static int getNumOnlyHighSchool() {
        return NumOnlyHighSchool;
    }

    public static void setNumOnlyHighSchool(int numOnlyHighSchool) {
        NumOnlyHighSchool = numOnlyHighSchool;
    }

    public static int getNumSomeCollege() {
        return NumSomeCollege;
    }

    public static void setNumSomeCollege(int numSomeCollege) {
        NumSomeCollege = numSomeCollege;
    }

    public static int getNumBachelorOrMore() {
        return NumBachelorOrMore;
    }

    public static void setNumBachelorOrMore(int numBachelorOrMore) {
        NumBachelorOrMore = numBachelorOrMore;
    }

    public double getPernoHighSchool() {
        return PernoHighSchool;
    }

    public static void setPerNoHighSchool(double PnoHS) {
        PernoHighSchool = PnoHS;
    }

    public double getPerOnlyHighSchool() {
        return PeronlyHighSchool;
    }

    public static void setPerOnlyHighSchool(double PonlyHS) {
        PeronlyHighSchool = PonlyHS;
    }

    public double getPerSomeCollege() {
        return PersomeCollege;
    }

    public static void setPerSomeCollege(double PsomeC) {
        PersomeCollege = PsomeC;
    }

    public double getPerBachelorOrMore() {
        return PerbachelorOrMore;
    }

    public static void setPerBachelorOrMore(double PbOrMore) {
        PerbachelorOrMore = PbOrMore;
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
            if(chars[i].equals("\"") || chars[i].equals("\t")){
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

        String finalVal = newvar.trim();

        return finalVal;
    }

    private static String removeComma(String a){
        String[] chars = new String[a.length()];
        for(int i = 0; i < chars.length; i++){
            if(a.substring(i, i+1).equals(",") || a.substring(i, i+1).equals("\"") || a.substring(i, i+1).equals("\t")){
                chars[i] = "";
            }else{
                chars[i] = a.substring(i,i+1);
            }
        }

        String returnVal = "";
        for(int i = 0; i < chars.length; i++){
            returnVal += chars[i];
        }

        String finalReturn = returnVal.trim();

        return finalReturn;
    }

}
