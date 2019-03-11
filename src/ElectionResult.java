import java.util.ArrayList;

public class ElectionResult {
    private int votes_dem, votes_gop, total_votes, diff, fips;
    private double per_dem, per_gop, per_point_diff;
    private String state_abbr, county_name;

    public ElectionResult(String a){
        String[] data = loadDatatoArray(a);
        loadDataToFields(data);
    }

    private static String[] loadDatatoArray(String a){
        String[] temp = a.split(",");

        String[] data = new String[temp.length - 1];
        for(int i = 0; i < data.length; i++){
            data[i] = temp[i+1];
        }

        for(int i = 0; i < data.length; i++){
            String c = data[i];
            if(c.substring(0,1).equals("\"") && c.substring(c.length()-1).equals("\"")){
                c = removeQuotationMarks(c);
            } else if (c.substring(0,1).equals("\"")){
                c = removeStartQuotation(c);
            } else if(c.substring(c.length()-1).equals("\"")){
                c = removeEndQuotation(c);
            }
        }

        return data;
    }



    public void loadDataToFields(String[] data){
       setVotes_dem(data[0]);
       setVotes_gop(data[1]);
       setTotal_votes(data[2]);
       setPer_dem(data[3]);
       setPer_gop(data[4]);
       setDiff(data[5]);
       setPer_point_diff(data[6]);
       setState_abbr(data[7]);
       setCounty_name(data[8]);
       setFips(data[9]);
    }

    public void setVotes_dem(String votes_dem) {
        this.votes_dem = (int)Double.parseDouble(votes_dem);
    }

    public void setVotes_gop(String votes_gop) {
        this.votes_gop = (int)Double.parseDouble(votes_gop);
    }

    public void setTotal_votes(String total_votes) {
        this.total_votes = (int)Double.parseDouble(total_votes);
    }

    public void setDiff(String diff) {
        this.diff = Integer.parseInt(diff);
    }

    public void setFips(String fips) {
        this.fips = Integer.parseInt(fips);
    }

    public void setPer_dem(String per_dem) {
        this.per_dem = Double.parseDouble(per_dem);
    }

    public void setPer_gop(String per_gop) {
        this.per_gop = Double.parseDouble(per_gop);
    }

    public void setPer_point_diff(String per_point_diff) {
        this.per_point_diff = Double.parseDouble(per_point_diff);
    }

    public void setState_abbr(String state_abbr) {
        this.state_abbr = state_abbr;
    }

    public void setCounty_name(String county_name) {
        this.county_name = county_name;
    }

    public int getVotes_dem() {
        return votes_dem;
    }

    public int getVotes_gop() {
        return votes_gop;
    }

    public int getTotal_votes() {
        return total_votes;
    }

    public int getDiff() {
        return diff;
    }

    public int getFips() {
        return fips;
    }

    public double getPer_dem() {
        return per_dem;
    }

    public double getPer_gop() {
        return per_gop;
    }

    public double getPer_point_diff() {
        return per_point_diff;
    }

    public String getState_abbr() {
        return state_abbr;
    }

    public String getCounty_name() {
        return county_name;
    }

    public static String removeQuotationMarks(String var){
        String[] chars = new String[var.length()];

        for(int i = 0; i < chars.length; i++){
            chars[i] = var.substring(i, i+1);
        }

        String newVar = "";

        for(int i = 1; i < chars.length - 1; i++){
            newVar += chars[i];
        }


        if(newVar.substring(0,1).equals("\"") && newVar.substring(newVar.length()-1).equals("\"")){
            return removeQuotationMarks(newVar);
        } else if(newVar.substring(0,1).equals("\"")){
            return removeStartQuotation(newVar);
        } else if(newVar.substring(newVar.length()-1).equals("\"")){
            return removeEndQuotation(newVar);
        } else{
            return newVar;
        }
    }
    private static String removeStartQuotation(String newVar) {
        String newestVar = "";

        for(int i = 1; i < newVar.length(); i++){
            newestVar += newVar.substring(i, i+1);
        }

        if(newestVar.substring(0,1).equals("\"")){
            return removeStartQuotation(newestVar);
        } else {
            return newestVar;
        }
    }

    private static String removeEndQuotation(String newVar){
        String newestVar = "";

        for(int i = 0; i < newVar.length() - 1; i++){
            newestVar += newVar.substring(i, i+1);
        }

        if(newestVar.substring(newestVar.length()-1).equals("\"")){
            return removeEndQuotation(newestVar);
        } else{
            return newestVar;
        }
    }

    private static String removeSpaces(String var){
        String[] chars = new String[var.length()];
        ArrayList<Integer> spaces = new ArrayList<>();
        for(int i = 0; i < chars.length; i++){
            chars[i] = var.substring(i, i+1);
            if(chars[i].equals(" ")){
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
}
