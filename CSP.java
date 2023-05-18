import java.util.ArrayList;
import java.util.Hashtable;


public class CSP {
    ArrayList<String> task = new ArrayList<>();
    Hashtable<String, region> map = new Hashtable<>();
    Hashtable<String, job> jobs = new Hashtable<>();
    ArrayList<String> action;
    int totalTime;

    public void setTask(ArrayList<String> a) {
        this.task = a;
    }

    public void setAction(ArrayList<String> a) {
        this.action = a;
    }

    public void add_map(String name, region a) {
        this.map.put(name, a);
    }

    public void setTotalTime (int a){totalTime = a;}

    public void addJob (String name, job a){
        this.jobs.put(name,a);
    }

    public void solve_map_CSP() {
        Hashtable<String, String> assignment = new Hashtable<String,String>();

        int complete = 0;

        for (String key : task) {
            region cur = map.get(key);

            for (String color : action) {
                if (!cur.getCannot_color().equals(color)) {
                    if (cur.getRequired_color().equals(color) || cur.getRequired_color().equals("\0")) {
                        cur.setColor(color);

                        ArrayList joint = cur.getJoint();

                        boolean valid = true;

                        for (Object joint_name : joint) {
                            region joint_region = map.get(joint_name);
                            if (cur.getColor().equals(joint_region.getColor())) {
                                valid = false;
                                break;
                            }
                        }

                        if (valid) {
                            assignment.put(cur.getName(), cur.getColor());
                            complete++;
                            break;
                        }

                    }
                }

            }

        }

        if (complete != task.size()){
            assignment.clear();
        }

        if (assignment.isEmpty()) {
            System.out.println("no solution for this CSP");
        } else {

            for (String name: task) {
                System.out.printf("%s %s\n", name, assignment.get(name));
            }

        }


    }

    public void solve_job_CSP() {
        Hashtable<String, Integer> assignment = new Hashtable<>();

        int complete = 0;

        for (String key:this.task) {
            job cur = this.jobs.get(key);
            ArrayList<String> beforeJob = cur.getAfter();

            for (int i = 0; i < this.totalTime; i++) {
                boolean valid = true;
                cur.updateSchedule(i);

                if (!cur.getAfter().isEmpty()) {
                    for (String jobName : beforeJob) {
                        job job = this.jobs.get(jobName);
                        int previous = job.getSchedule();
                        int now = cur.getSchedule() - job.getWorkingTime();
                        if (now < previous) {
                            valid = false;
                            break;
                        }

                    }
                }

                if (valid) {
                    assignment.put(cur.getName(), cur.getSchedule());
                    complete++;
                    break;
                }

            }

        }


        if (complete != task.size()){
            assignment.clear();
        }

        if (assignment.isEmpty()) {
            System.out.println("no solution for this CSP");
        } else {
            for (String name: task) {
                System.out.printf("%s %s\n", name, assignment.get(name));
            }
        }

    }


}


