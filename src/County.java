public class County {
    private int FIPS;
    private String state;
    private ElectionResult vote2016;
    private Education2016 educ2016;
    private Employment2016 employ2016;

    public County(String n, int f, String s){
        FIPS = f;
        state = s;
    }

    public int getFIPS() {
        return FIPS;
    }

    public void setFIPS(int FIPS) {
        this.FIPS = FIPS;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public ElectionResult getVote2016() {
        return vote2016;
    }

    public void setVote2016(ElectionResult vote2016) {
        this.vote2016 = vote2016;
    }

    public Education2016 getEduc2016() {
        return educ2016;
    }

    public void setEduc2016(Education2016 educ2016) {
        this.educ2016 = educ2016;
    }

    public Employment2016 getEmploy2016() {
        return employ2016;
    }

    public void setEmploy2016(Employment2016 employ2016) {
        this.employ2016 = employ2016;
    }
}
