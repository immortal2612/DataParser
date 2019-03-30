public class Depression {
    private String stateName;
    private int over18Depression;
    public Depression(String name, int c){
        stateName = name;
        over18Depression = c;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public int getOver18Depression() {
        return over18Depression;
    }

    public void setOver18Depression(int over18Depression) {
        this.over18Depression = over18Depression;
    }
}
