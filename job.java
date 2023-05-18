import java.util.ArrayList;

public class job {

    String name;
    int workingTime;
    int schedule = 0;
    ArrayList<String> after = new ArrayList<>();


    public void setName(String name){
        this.name= name;
    }

    public void setWorkingTime(int a){this.workingTime = a;}

    public void addAfter (String before){ this.after.add(before);}

    public void updateSchedule(int a){schedule = a;}

    public String getName(){return this.name;}

    public int  getWorkingTime(){return this.workingTime;}

    public int getSchedule(){return  this.schedule;}

    public ArrayList<String> getAfter(){return this.after;}





}
