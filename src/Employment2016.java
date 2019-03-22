import java.util.ArrayList;

public class Employment2016 {
    private String FIPS;
    private String State;
    private int totalLaborForce;
    private int employedLabor;
    private int unemployedLabor;
    private double perUnemployed;

    public Employment2016(String file){
        String[] data = loadDatatoArray(file);
        loadDatatoFields(data);
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

    private void loadDatatoFields(String[] data) {
        setFIPS(data[0]);
        setState(data[1]);
        setTotalLaborForce(Integer.parseInt(data[42]));
        setEmployedLabor(Integer.parseInt(data[43]));
        setUnemployedLabor(Integer.parseInt(data[44]));
        setPerUnemployed(Double.parseDouble(data[45]));
    }

    public String getState(){
        return State;
    }

    public void setState(String s){
        this.State = s;
    }
    public String getFIPS() {
        return FIPS;
    }

    public void setFIPS(String FIPS) {
        this.FIPS = FIPS;
    }

    public int getTotalLaborForce() {
        return totalLaborForce;
    }

    public void setTotalLaborForce(int totalLaborForce) {
        this.totalLaborForce = totalLaborForce;
    }

    public int getEmployedLabor() {
        return employedLabor;
    }

    public void setEmployedLabor(int employedLabor) {
        this.employedLabor = employedLabor;
    }

    public int getUnemployedLabor() {
        return unemployedLabor;
    }

    public void setUnemployedLabor(int unemployedLabor) {
        this.unemployedLabor = unemployedLabor;
    }

    public double getPerUnemployed() {
        return perUnemployed;
    }

    public void setPerUnemployed(double perUnemployed) {
        this.perUnemployed = perUnemployed;
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
