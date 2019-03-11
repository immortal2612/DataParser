import java.util.ArrayList;

public class Employment2016 {
    private int totalLaborForce;
    private int employedLabor;
    private int unemployedLabor;
    private double perUnemployed;

    public Employment2016(String file){
        String[] data = loadDatatoArray(file);
        loadDatatoFields(data);
    }

    private void loadDatatoFields(String[] data) {
        setTotalLaborForce(Integer.parseInt(data[42]));
    }

    public int getTotalLaborForce() {
        return totalLaborForce;
    }

    public void setTotalLaborForce(int totalLaborForce) {
        this.totalLaborForce = totalLaborForce;
    }

    public int getEmployedLabor() {
        return employedLabor;
    }

    public void setEmployedLabor(int employedLabor) {
        this.employedLabor = employedLabor;
    }

    public int getUnemployedLabor() {
        return unemployedLabor;
    }

    public void setUnemployedLabor(int unemployedLabor) {
        this.unemployedLabor = unemployedLabor;
    }

    public double getPerUnemployed() {
        return perUnemployed;
    }

    public void setPerUnemployed(double perUnemployed) {
        this.perUnemployed = perUnemployed;
    }




    private static String[] loadDatatoArray(String a){
        String[] temp = a.split(",");

        String[] data = new String[temp.length - 1];
        for(int i = 0; i < data.length; i++){
            data[i] = temp[i+1];
        }

        for(int i = 0; i < data.length; i++){
            String c = data[i];
            if(c.contains("\"") || c.contains(" ")){
                data[i] = cleanString(c);
            }
        }

        return data;
    }

    private static String cleanString(String var){
        String[] chars = new String[var.length()];
        ArrayList<Integer> spaces = new ArrayList<>();
        for(int i = 0; i < chars.length; i++){
            chars[i] = var.substring(i, i+1);
            if(chars[i].equals(" ") || chars[i].equals("\"")){
                spaces.add(i);
            }
        }

        for(int i = 0; i < spaces.size(); i++){
            chars[spaces.get(i)] = "";
        }

        String newvar = "";

        for(int i = 0; i < chars.length; i++){
            newvar += chars[i];
        }

        return newvar;
    }

}
