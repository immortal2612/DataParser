import java.util.ArrayList;

public class DataManager {
    private static ArrayList<County> counties;
    private ArrayList<Education2016> educationData;
    private ArrayList<ElectionResult> electionData;
    private ArrayList<String> countyFips = new ArrayList<>();

    public DataManager(ArrayList<Education2016> a, ArrayList<ElectionResult> b){
        educationData = a;
        electionData = b;

        createCounties();
    }

    private void createCounties() {
        for(int i = 0; i < educationData.size(); i++){
            if(!countyFips.contains(educationData.get(i).getFIPS())){
                countyFips.add(educationData.get(i).getFIPS());
                County n = new County(educationData.get(i).getFIPS(), educationData.get(i), electionData.get(i));
                counties.add(n);
            }
        }
    }

    public void PrintCountyInfo(County a){
        System.out.println("FIPS: " + a.getFIPS());

        System.out.println("Education Data");
        System.out.println("");
        System.out.println("");
        printEducationInfo(a);

        System.out.println("Election Data");
        System.out.println("");
        System.out.println("");
        printElectionInfo(a);
    }

    private void printElectionInfo(County a) {
        ElectionResult elecTemp = a.getElectionData();
        System.out.println("");
    }

    private void printEducationInfo(County a){
        Education2016 eduTemp = a.getEducationData();
        System.out.println("Percent with No High School: " + eduTemp.getPernoHighSchool() + "\tNumber with No High School: " + eduTemp.getNumNoHighSchool());
        System.out.println("Percent with Only High School: " + eduTemp.getPerOnlyHighSchool() + "\tNumber with Only High School: " + eduTemp.getNumOnlyHighSchool());
        System.out.println("Percent with Some College: " + eduTemp.getPerSomeCollege() + "\tNumber with Some College: " + eduTemp.getNumSomeCollege());
        System.out.println("Percent with Bachelors Degree or More: " + eduTemp.getPerBachelorOrMore() + "\tNumber with Bachelors Degree or More: " + eduTemp.getNumBachelorOrMore());
    }

    public County getCounty(int i){
        return counties.get(i);
    }




}
