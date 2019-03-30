import java.util.ArrayList;

public class ElectionResult {
    private int votes_dem, votes_gop, total_votes;
    private String FIPS, State;

    public ElectionResult(String a){
        String[] data = loadDatatoArray(a);
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
            if(c.contains("\"") || c.contains(" ")){
                cleanString(c);
            }
        }

        return temp;
    }

    public void loadDataToFields(String[] data){
        setVotes_dem(data[0]);
        setVotes_gop(data[1]);
        setTotal_votes(data[2]);
        setFIPS(data[data.length-1]);
        setState(data[data.length-2]);
    }


    public String getFIPS() {
        return FIPS;
    }

    public void setFIPS(String FIPS) {
        this.FIPS = FIPS;
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

    public String getState() {
        return State;
    }

    public void setState(String state) {
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
