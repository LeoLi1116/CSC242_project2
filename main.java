import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class main {

    public static CSP read_map_file(String path){
        CSP problem = new CSP();
        try {
            File file = new File(path);
            Scanner s = new Scanner(file);

            s.nextLine();

            String task_line = s.nextLine();
            String[] prefix = task_line.split(" ");
            ArrayList<String> postfix = new ArrayList<String>(Arrays.asList(prefix));
            problem.setTask(postfix);

            int index = postfix.size();

            while (index > 0){

                String description = s.nextLine();
                String[] line = description.split(" ");
                ArrayList<String> fixLine = new ArrayList<String>(Arrays.asList(line));
                String region_name = fixLine.get(0);
                fixLine.remove(0);


                region place = new region();
                place.setName(region_name);
                place.create_joint(fixLine);
                problem.add_map(region_name, place);
                index--;

            }

            ArrayList<String> color = new ArrayList<String>(Arrays.asList(s.nextLine().split(" ")));
            problem.setAction(color);



            while (s.hasNextLine()){
                String req_line = s.nextLine();
                ArrayList<String> req = new ArrayList<>(Arrays.asList(req_line.split(" ")));

                if (req.get(1).equals("=")){
                    problem.map.get(req.get(0)).setRequired_color(req.get(2));

                }
                else if (req.get(1).equals("!=")){
                    problem.map.get(req.get(0)).setCannot_color(req.get(2));
                }
            }
        }
        catch (Exception e){
            System.out.println("This file is wrong, please try another.");
        }
        return problem;
    }

    public static CSP read_job_file(String path){

        CSP problem = new CSP();
        try {
            File file = new File(path);
            Scanner s = new Scanner(file);

            s.nextLine();

            String task_line = s.nextLine();
            String[] prefix = task_line.split(" ");
            ArrayList<String> postfix = new ArrayList<String>(Arrays.asList(prefix));
            problem.setTask(postfix);

            int index = postfix.size();

            while (index > 0){

                String description = s.nextLine();
                String[] line = description.split(" ");

                ArrayList<String> fixLine = new ArrayList<String>(Arrays.asList(line));
                String job_name = fixLine.get(0);
                fixLine.remove(0);


                job newJob = new job();
                newJob.setName(job_name);
                newJob.setWorkingTime(Integer.parseInt(fixLine.get(0)));
                problem.addJob(job_name, newJob);
                index--;

            }

            String timeLimit = s.nextLine();
            Scanner s2 = new Scanner(timeLimit);
            int totalTime = s2.nextInt();
            problem.setTotalTime(totalTime);


            while (s.hasNextLine()){
                String req_line = s.nextLine();
                ArrayList<String> req = new ArrayList<>(Arrays.asList(req_line.split(" ")));

                if (req.get(1).equals("before")){
                    problem.jobs.get(req.get(2)).addAfter(req.get(0));
                }
                else if (req.get(1).equals("disjoint")){
                    problem.jobs.get(req.get(2)).addAfter(req.get(0));
                }
            }
        }
        catch (Exception e){
            System.out.println("This file is wrong, please try another.");
        }
        return problem;
    }



    public static void main(String[] args) {

        if (args[0].equals("map")){
            CSP problem = read_map_file(args[1]);
            problem.solve_map_CSP();
        }
        else if (args[0].equals("job")){
            CSP problem = read_job_file(args[1]);
            problem.solve_job_CSP();
        }
        else {
            System.out.println("Argument format is not correct.");
        }




    }






}





