public class County {
    private String FIPS;
    private ElectionResult vote2016;
    private Education2016 educ2016;

    public County(String f, Education2016 a, ElectionResult b){
        FIPS = f;
        educ2016 = a;
        vote2016 = b;
    }

    public String getFIPS() {
        return FIPS;
    }

    public void setFIPS(String FIPS) {
        this.FIPS = FIPS;
    }

    public ElectionResult getElectionData() {
        return vote2016;
    }

    public void setElectionData(ElectionResult vote2016) {
        this.vote2016 = vote2016;
    }

    public Education2016 getEducationData() {
        return educ2016;
    }

    public void setEducationData(Education2016 educ2016) {
        this.educ2016 = educ2016;
    }
}
