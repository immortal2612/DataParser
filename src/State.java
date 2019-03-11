import java.util.ArrayList;

public class State {
    private String name;
    private ArrayList<County> counties;
    private ArrayList<Integer> countyFIPS;

    public State(String n, ArrayList<Education2016> a, ArrayList<ElectionResult> b, ArrayList<Employment2016> c){
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<County> getCounties() {
        return counties;
    }

    public void setCounties(ArrayList<County> counties) {
        this.counties = counties;
    }

    public static void sortDataByCounty
}
