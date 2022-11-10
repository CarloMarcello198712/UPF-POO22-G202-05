
public class TestUniversity {
    public static void main(String args[]){

        //University initialitzation
        University university = new University();

        //3.1 Methods that return lists of entities
        System.out.println( "Students:");
        System.out.println(university.getStudents()+"\n");

        System.out.println( "Teachers:");
        System.out.println( university.getTeacher()+"\n");

        System.out.println( "Classrooms:");
        System.out.println( university.getClassrooms()+"\n");

        System.out.println( "Courses:");
        System.out.println( university.getCourses()+"\n");

        System.out.println( "\n"); //Space between methods and queries

        //4. Queries
        System.out.println("Courses of a student: " + university.coursesOfStudent("Ron Weasley"));

        System.out.println("Teachers of a course: " + university.teachersOfCourse("Transformations"));
        
        System.out.println("Courses of a classroom: " + university.coursesOfClassroom("10.100"));

        System.out.println("Classroom of teacher for an especific time slot: " + university.classroomOfTeacher("Albus Dumbledore", 1));
        
        System.out.println("Classroom of student for an especific time slot: " + university.classroomOfStudent("Harry Potter", 1));

        System.out.println("Teacher of a classroom for an especific time slot: " + university.teacherOfClassroom("10.100", 1));

        System.out.println("Student of a classroom for an especific time slot: " + university.studentOfClassroom("10.100", 1));
    } 
}
