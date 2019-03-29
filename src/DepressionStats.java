public class DepressionStats {
    private int numOver18AffectedByDepression;
    private String stateName;

    public DepressionStats(String stateName, int numOver18AffectedByDepression){
        this.numOver18AffectedByDepression = numOver18AffectedByDepression;
        this.stateName = stateName;
    }

    public int getNumOver18AffectedByDepression() {
        return numOver18AffectedByDepression;
    }

    public void setNumOver18AffectedByDepression(int numOver18AffectedByDepression) {
        this.numOver18AffectedByDepression = numOver18AffectedByDepression;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String toString() {
        return "State name: " + stateName + "; Number over 18 affected by depression (in thousands): "  + numOver18AffectedByDepression;
    }
}
