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

        return data;
    }

    public void loadDataToFields(String[] data){
        setVotes_dem(Integer.parseInt(data[0]));
        setVotes_gop(Integer.parseInt(data[1]));
        setTotal_votes(Integer.parseInt(data[2]));
        setPer_dem(Double.parseDouble(data[3]));
        setPer_gop(Double.parseDouble(data[4]));
        setDiff(Integer.parseInt(data[5]));
        setPer_point_diff(Double.parseDouble(data[6]));
        setState_abbr(data[7]);
        setCounty_name(data[8]);
        setFips(Integer.parseInt(data[9]));
    }
    public void setVotes_dem(int votes){
        votes_dem = votes;
    }

    public void setVotes_gop(int votes){
        votes_gop = votes;
    }

    public void setTotal_votes(int votes){
        total_votes = votes;
    }

    public void setDiff(int votes_diff){
        diff = votes_diff;
    }

    public void setFips(int f){
        fips = f;
    }

    public void setPer_dem(double per){
        per_dem = per;
    }

    public void setPer_gop(double per){
        per_gop = per;
    }

    public void setPer_point_diff(double per){
        per_point_diff = per;
    }

    public void setState_abbr(String abbr){
        state_abbr = abbr;
    }

    public void setCounty_name(String county){
        county_name = county;
    }

}
