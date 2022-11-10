
public class Lecture {
   //atributes
   private String group;
   private int timeSlot;
   private int type;
   private Classroom classroom;
   private Course course;


   //Contructor
   public Lecture(String g, int s, int t){
      this.group = g;
      this.timeSlot = s;
      this.type = t;
   }

   public void addClassroom(Classroom c){
      this.classroom = c;
   }
   public void addCourse(Course c){
      this.course = c;  
   }

   //Getters

   public Course getCourse(){
      return this.course;
   }

   public int getTimeSlot(){
      return timeSlot;
   }

   public Classroom getClassroom(){
      return this.classroom;
   }
}
