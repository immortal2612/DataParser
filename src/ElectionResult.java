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
            if(c.contains("\"") || c.contains(" ")){
                cleanString(c);
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
       setState(data[7]);
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
}
