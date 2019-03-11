import java.util.ArrayList;

public class State {
    private static String name;
    private static ArrayList<County> counties;
    private static ArrayList<Integer> countyFIPS;

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

    public static void sortDataByCounty( ArrayList<Education2016> a, ArrayList<ElectionResult> b, ArrayList<Employment2016> c){
        createFipsList(a, b, c);
        for(int i = 0; i < countyFIPS.size(); i++){
            County x = new County(name, countyFIPS.get(i), null, null, null);
            for(int A = 0; A < a.size(); A++){
                if(a.get(A).getFIPS() == countyFIPS.get(i)){
                    Education2016 e = a.get(A);
                    x.setEduc2016(e);
                }
            }
            for(int B = 0; B < b.size(); B++){
                if(b.get(B).getFIPS() == countyFIPS.get(i)){
                    ElectionResult f = b.get(B);
                    x.setVote2016(f);
                }
            }
            for(int C = 0; C < c.size(); C++){
                if(c.get(C).getFIPS() == countyFIPS.get(i)){
                    Employment2016 g = c.get(C);
                    x.setEmploy2016(g);
                }
            }
            counties.add(x);
        }
    }

    private static void createFipsList(ArrayList<Education2016> a, ArrayList<ElectionResult> b, ArrayList<Employment2016> c) {
        ArrayList<Integer> testFips = new ArrayList<>();
        for(int i = 0; i < a.size(); i++){
            if(!testFips.contains(a.get(i).getFIPS())){
                testFips.add(a.get(i).getFIPS());
            }
        }
        for(int i = 0; i < b.size(); i++){
            if(!testFips.contains(b.get(i).getFIPS())){
                testFips.add(b.get(i).getFIPS());
            }
        }
        for(int i = 0; i < c.size(); i++){
            if(!testFips.contains(c.get(i).getFIPS())){
                testFips.add(c.get(i).getFIPS());
            }
        }

        countyFIPS = testFips;
    }
}
