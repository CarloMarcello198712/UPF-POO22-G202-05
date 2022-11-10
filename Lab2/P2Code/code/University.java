import java.util.LinkedList;


public class University {
   
    //atributes

    private LinkedList<Student> students;
    private LinkedList<Teacher> teachers;
    private LinkedList<Classroom> classrooms;
    private LinkedList<Course> courses;

    //constructor

    public University(){

        students = new LinkedList<Student>();
        teachers = new LinkedList<Teacher>();
        classrooms = new LinkedList<Classroom>();
        courses = new LinkedList<Course>();

        LinkedList<String[]> _students = Utility.readXML( "student" );

        for(String[] array : _students){
            int x = Integer.parseInt(array[1]);
            Student student = new Student(array[0],x);
            this.students.add(student);
        }

        LinkedList<String[]> _teachers = Utility.readXML( "teacher" );

        for(String[] array : _teachers){
            Teacher teacher = new Teacher(array[0]);
            this.teachers.add(teacher);
        }

        LinkedList< String[] > _classrooms = Utility.readXML( "classroom" );
        
        for(String[] array : _classrooms){
            //int x = Integer.parseInt(array[0]);
            Classroom clasroom = new Classroom(array[0]);
            this.classrooms.add(clasroom);
        }

        LinkedList< String[] > _courses = Utility.readXML( "course" );

        for(String[] array : _courses){
            Course course = new Course(array[0]);
            this.courses.add(course);
        }

        LinkedList< String[] > _lectures = Utility.readXML( "lecture" );

        for(String[] array : _lectures){
            
            Classroom cl = Utility.getObject(array[0], classrooms);
            Course c = Utility.getObject(array[1], courses);
            
            int x = Integer.parseInt(array[3]);
            int y = Integer.parseInt(array[4]);
            Lecture lecture = new Lecture(array[2],x,y);

            lecture.addClassroom(cl);
            lecture.addCourse(c);

            cl.addLecture(lecture);
            c.addLecture(lecture);

        }

        LinkedList< String[] > _enrollments = Utility.readXML( "enrollment" );

        for(String[] array : _enrollments){
            Student student = Utility.getObject(array[0], students);
            Course course = Utility.getObject(array[1], courses);
            
            Enrollment enrollment = new Enrollment(array[2]);

            enrollment.addStudent(student);
            enrollment.addCourse(course);

            student.addEnrollment(enrollment);
            course.addEnrollment(enrollment);

        }

        LinkedList< String[] > _assignments = Utility.readXML( "assignment" );

        for(String[] array : _assignments){
            Teacher teacher = Utility.getObject(array[0], teachers);
            Course course = Utility.getObject(array[1], courses);
            
            LinkedList<String> groups = new LinkedList<String>();

            for(int i = 2; i< array.length;i++){
                groups.add(array[i]);

            }
            
            Assignment assignment = new Assignment(groups);

            assignment.addTeacher(teacher);
            assignment.addCourse(course);

            teacher.addAssignment(assignment);
            course.addAssignment(assignment);

        }
    }

    
    //Getters

    public String getStudents(){
        return students.toString();
    }
    public String getTeacher(){
        return teachers.toString();
    }
    
    public String getClassrooms(){
        return classrooms.toString();
    }
    public String getCourses(){
        return courses.toString();
    }

    //Queries implementation

    public LinkedList<String> coursesOfStudent(String s){
        Student student = Utility.getObject(s,this.students);
        return student.getCourses();
    }

    public LinkedList<String> teachersOfCourse(String c){
        Course course = Utility.getObject(c,this.courses);
        return course.getTeachers();
    }

    public LinkedList<String> coursesOfClassroom(String cl){
        Classroom classroom = Utility.getObject(cl,this.classrooms);
        return classroom.getCourses();
    }


    public String classroomOfTeacher(String t, int t_s){
        String ret_c = "The teacher doesn't have class at this time slot"; //Error avoidance
        LinkedList<Lecture> lectures = new LinkedList<Lecture>();
        
        for(Classroom c : this.classrooms){
            for(Lecture lec: c.getLectures()){
                if(lec.getTimeSlot()==t_s){
                    lectures.add(lec);
                }
            }
        }

        for(Lecture lec: lectures){
            LinkedList<String> teachers = teachersOfCourse(lec.getCourse().toString());
            for(String teacher_name: teachers){
                if(teacher_name.equals(t)){
                    ret_c = lec.getClassroom().toString();
                }
            }
        }

        return ret_c;
        
    }

    public String classroomOfStudent(String s, int t_s){
        String ret_c = "The student doesn't have class at this time slot";  //Error avoidance
        LinkedList<Lecture> lectures = new LinkedList<Lecture>();
        
        for(Classroom c : this.classrooms){
            for(Lecture lec: c.getLectures()){
                if(lec.getTimeSlot()==t_s){
                    lectures.add(lec);
                }
            }
        }

        LinkedList<String> courses = coursesOfStudent(s);
        for(Lecture lec: lectures){
            for(String course_name: courses){
                if(course_name.equals(lec.getCourse().toString())){
                    ret_c = lec.getClassroom().toString();
                    return ret_c;
                }
            }
        }

        return ret_c;
        
    }

    public String teacherOfClassroom(String c, int t_s){
        String return_t = "Teacher not found";  //Error avoidance
        for(Teacher t: this.teachers){
            String classr = classroomOfTeacher(t.toString(), t_s);

            if(classr.equals(c)){
                return_t = t.toString();
                return return_t;
            }
        }
        return return_t;
    }

    public String studentOfClassroom(String c, int t_s){
        String return_s = "Student not found";  //Error avoidance
        for(Student s: this.students){
            String classr = classroomOfStudent(s.toString(), t_s);

            if(classr.equals(c)){
                return_s = s.toString();
                return return_s;
            }
        }
        return return_s;
    }
}
