import java.util.ArrayList;

public class ElectionResult {
    private int votes_dem, votes_gop, total_votes, FIPS;
    private String State;

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


    public int getFIPS() {
        return FIPS;
    }

    public void setFIPS(int FIPS) {
        this.FIPS = FIPS;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public void loadDataToFields(String[] data){
       setVotes_dem(data[0]);
       setVotes_gop(data[1]);
       setTotal_votes(data[2]);
       setFIPS(Integer.parseInt(data[10]));
       setState(data[8]);
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

    public int getVotes_dem() {
        return votes_dem;
    }

    public int getVotes_gop() {
        return votes_gop;
    }

    public int getTotal_votes() {
        return total_votes;
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
