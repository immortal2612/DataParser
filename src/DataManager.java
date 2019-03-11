import java.util.ArrayList;

public class DataManager {
    private static ArrayList<State> states;

    private static String[] stateAbbr = { "AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DC", "DE", "FL", "GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY"};

    public DataManager(ArrayList<Education2016> a, ArrayList<ElectionResult> b, ArrayList<Employment2016> c){
        sortDatabyState(a, b, c);
    }

    public static void sortDatabyState(ArrayList<Education2016> a, ArrayList<ElectionResult> b, ArrayList<Employment2016> c){
        for(int i = 0; i < stateAbbr.length; i++){
            State x = new State(stateAbbr[i], education2016(a, stateAbbr[i]), election2016(b, stateAbbr[i]), employment2016(c, stateAbbr[i]));

            states.add(x);
        }
    }

    public static ArrayList<Education2016> education2016(ArrayList<Education2016> a, String stateabbr){
        ArrayList<Education2016> stateEducation = new ArrayList<>();
            for(int j = 0; j < a.size(); j++){
                if(a.get(j).getState().equals(stateabbr)){
                    stateEducation.add(a.get(j));
                }
            }

        return stateEducation;
    }

    public static ArrayList<ElectionResult> election2016(ArrayList<ElectionResult> a, String stateabbr){
        ArrayList<ElectionResult> stateElection = new ArrayList<>();
            for(int j = 0; j < a.size(); j++) {
                if (a.get(j).getState().equals(stateabbr)) {
                    stateElection.add(a.get(j));
                }
            }

        return stateElection;
    }

    public static ArrayList<Employment2016> employment2016(ArrayList<Employment2016> a, String stateabbr){
        ArrayList<Employment2016> stateEmployment = new ArrayList<>();
            for(int j = 0; j < a.size(); j++){
                if(a.get(j).getState().equals(stateabbr)){
                    stateEmployment.add(a.get(j));
                }
            }

        return stateEmployment;
    }
}
