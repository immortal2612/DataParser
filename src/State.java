import java.util.ArrayList;

public class State {
    private String name;
    private int votes_dem, votes_gop, total_votes;
    private int numNoHS, numOnlyHS, numSomeCollege, numBachelorsOrMore;
    private double perNoHS, perOnlyHS, perSomeCollege, perBachelorOrMore;
    private int EighteenOrOver = 0;

    public State(String n, ArrayList<ElectionResult> a, Education2016 b, Depression c){
        numNoHS = b.getNumNoHighSchool();
        numOnlyHS = b.getNumOnlyHighSchool();
        numSomeCollege = b.getNumSomeCollege();
        numBachelorsOrMore = b.getNumBachelorOrMore();
        name = n;
        EighteenOrOver = c.getCount();

        sumCountyData(a);
        perCountyData();
    }

    private void sumCountyData(ArrayList<ElectionResult> a) {
        for(int i = 0; i < a.size(); i++){
            votes_gop += a.get(i).getVotes_gop();
            votes_dem += a.get(i).getVotes_dem();
            total_votes += a.get(i).getTotal_votes();
        }
    }

    private void perCountyData() {
        int sum = 0;
        sum += numNoHS + numOnlyHS + numSomeCollege + numBachelorsOrMore;

        perNoHS = numNoHS/sum;
        perOnlyHS = numOnlyHS/sum;
        perSomeCollege = numSomeCollege/sum;
        perBachelorOrMore = numBachelorsOrMore/sum;
    }

    public String getName() {
        return name;
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

    public int getNumNoHS() {
        return numNoHS;
    }

    public int getNumOnlyHS() {
        return numOnlyHS;
    }

    public int getNumSomeCollege() {
        return numSomeCollege;
    }

    public int getNumBachelorsOrMore() {
        return numBachelorsOrMore;
    }

    public double getPerNoHS() {
        return perNoHS;
    }

    public double getPerOnlyHS() {
        return perOnlyHS;
    }

    public double getPerSomeCollege() {
        return perSomeCollege;
    }

    public double getPerBachelorOrMore() {
        return perBachelorOrMore;
    }

    public int getEighteenOrOver() {
        return EighteenOrOver;
    }
}
