import java.util.ArrayList;

public class region {

    String name;
    ArrayList<String> joint = new ArrayList<String>();

    String color = "\0";
    String required_color = "\0";
    String cannot_color = "\0";

    public void setName(String name){
        this.name= name;
    }

    public void setColor(String color){
        this.color = color;
    }


    public void setRequired_color(String color){ this.required_color = color; }

    public void setCannot_color(String color){this.cannot_color = color;}

    public void create_joint(ArrayList<String> joint){ this.joint = joint; }



    public String getName(){return this.name;}
    public ArrayList getJoint(){return this.joint;}
    public String getColor(){return this.color;}
    public String getRequired_color(){return  this.required_color;}
    public String getCannot_color() { return this.cannot_color; }
}
