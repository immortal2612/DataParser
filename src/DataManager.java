import java.util.ArrayList;
import java.util.HashMap;

public class DataManager {
    ArrayList<State> states = new ArrayList<>();
    String[] StateFips = {"01000", "02000", "04000", "05000", "06000", "07000", "08000","09000","10000","11000","12000","13000","15000","16000","17000","18000","19000","20000","21000","22000","23000","24000","25000","26000","27000","28000","29000","30000","31000","32000","33000","34000","35000","36000","37000","38000","39000","40000","41000","42000","44000","45000","46000","47000","48000","49000","50000","51000","53000","54000","55000","56000", "57000"};

    public DataManager(ArrayList<ElectionResult> a, ArrayList<Education2016> b, ArrayList<Depression> c){
        createStates(a, b, c);
    }

    private void createStates(ArrayList<ElectionResult> a, ArrayList<Education2016> b, ArrayList<Depression> c){
        for(int i = 0; i < StateFips.length; i++){
            Education2016 stateEdu = findEducationData(b, StateFips[i]);
            Depression stateDepressed = findDepressionData(c, stateEdu.getState());
            ArrayList<ElectionResult> stateVotes = findCountyVotes(Integer.parseInt(StateFips[i]), Integer.parseInt(StateFips[i+1]), a);

            State x = new State(stateEdu.getState(), stateVotes, stateEdu, stateDepressed);

            states.add(x);
        }
    }

    private Depression findDepressionData(ArrayList<Depression> c, String stateName) {
        for(int i = 0; i < c.size(); i++){
            if(c.get(i).getStateName().equals(stateName)){
                return c.get(i);
            }
        }

        return null;
    }

    private Education2016 findEducationData(ArrayList<Education2016> b, String target) {
        for(int i = 0; i < b.size(); i++){
            Education2016 x = b.get(i);
            if(x.getFIPS().equals(target)){
                return x;
            }
        }

        return null;
    }

    private ArrayList<ElectionResult> findCountyVotes(int lowerLim, int upperLim, ArrayList<ElectionResult> a) {
        ArrayList<ElectionResult> counties = new ArrayList<>();

        for(int i = 0; i < a.size(); i++){
            int fips = Integer.parseInt(a.get(i).getFIPS());

            if(fips > lowerLim && fips < upperLim){
                counties.add(a.get(i));
            }
        }

        return counties;
    }

    public String getStateInfo(int a){
        return states.get(a).returnAll();
    }
}
