import java.util.ArrayList;

public class DataManager {
    ArrayList<State> states = new ArrayList<>();
    String[] StateFips = {"01000", "02000", "04000", "05000", "06000", "07000", "08000","09000","10000","11000","12000","13000","15000","16000","17000","18000","19000","20000","21000","22000","23000","24000","25000","26000","27000","28000","29000","30000","31000","32000","33000","34000","35000","36000","37000","38000","39000","40000","41000","42000","44000","45000","46000","47000","48000","49000","50000","51000","53000","54000","55000","56000", "57000"};

    public DataManager(ArrayList<ElectionResult> a, ArrayList<Education2016> b, ArrayList<Depression> c){
        createStates(a, b, c);
    }

    private void createStates(ArrayList<ElectionResult> a, ArrayList<Education2016> b, ArrayList<Depression> c) {
        for(int i = 0; i < StateFips.length - 1; i++){
            String target = StateFips[i];
            String limit = StateFips[i+1];

            Education2016 stateEdu = findEducationForState(target, b);

            ArrayList<ElectionResult> countyVotes = findCountyVotes(Integer.parseInt(target), Integer.parseInt(limit), a);

            Depression numDepression = findStateDepression(c, stateEdu.getState());

            State x = new State(stateEdu.getState(), countyVotes, stateEdu, numDepression);

            states.add(x);
        }
    }

    private Education2016 findEducationForState(String target, ArrayList<Education2016> b) {
        for(int i = 0; i < b.size(); i++){
            if(b.get(i).getFIPS().equals(target)){
                return b.get(i);
            }
        }

        return null;
    }

    private ArrayList<ElectionResult> findCountyVotes(int lowerLim, int upperLim, ArrayList<ElectionResult> a) {
        ArrayList<ElectionResult> counties = new ArrayList<>();

        for(int i = 0; i < a.size(); i++){
            if(Integer.parseInt(a.get(i).getFIPS()) > lowerLim && Integer.parseInt(a.get(i).getFIPS()) < upperLim){
                counties.add(a.get(i));
            }
        }

        return counties;
    }

    private Depression findStateDepression(ArrayList<Depression> c, String name) {
        for(int i = 0; i < c.size(); i++){
            if(c.get(i).getName().equals(name)){
                return c.get(i);
            }
        }

        return null;
    }
}
