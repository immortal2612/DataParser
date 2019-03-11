import java.util.ArrayList;

public class Education2016 {
    private static int FIPS;
    private static String State;

    private static double noHighSchool;
    private static double onlyHighSchool;
    private static double someCollege;
    private static double bachelorOrMore;

    public Education2016(String file){
        String[] data = loadDatatoArray(file);
        loadDataToFields(data);
    }

    private static void loadDataToFields(String[] data){
        setFIPS(Integer.parseInt(data[0]));
        setState(data[1]);
        setNoHighSchool(Double.parseDouble(data[43]));
        setOnlyHighSchool(Double.parseDouble(data[44]));
        setSomeCollege(Double.parseDouble(data[45]));
        setBachelorOrMore(Double.parseDouble(data[46]));
    }
    public int getFIPS() {
        return FIPS;
    }

    public static void setFIPS(int fips) {
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
    private static String[] loadDatatoArray(String a){
        String[] temp = a.split(",");

        String[] data = new String[temp.length - 1];
        for(int i = 0; i < data.length; i++){
            data[i] = temp[i+1];
        }

        for(int i = 0; i < data.length; i++){
            String c = data[i];
            if(c.contains("\"") || c.contains(" ")){
                data[i] = cleanString(c);
            }
        }

        return data;
    }
}
