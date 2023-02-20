import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XX007 {
    List<Student> students;

    public XX007() {
        // start create a scanner obj
        Scanner input = new Scanner(System.in);
        // get number of students in class
        System.out.print("number of students: ");
        int numberOfStudents = input.nextInt();
        // initialise students array
        this.students = new ArrayList<>();
        for (int i = 0; i < numberOfStudents; i++) {
            // get first name input
            System.out.print("first name: ");
            String firstName = input.next();
            // get surname input
            System.out.print("surname: ");
            String surname = input.next();
            // get interimPercent
            System.out.print("interim percent: ");
            int interimPercent = input.nextInt();
            // get interimPercent
            System.out.print("exam percent: ");
            int examPercent = input.nextInt();

            // array containing homework scores
            int[] homeworkScores = new int[5];
            // inputs homework scores 1 by one into array
            for (int j = 0; j < 5; j++) {
                // get score
                System.out.print("homework score" + Integer.toString(j) + ": ");
                int score = input.nextInt();
                // add to array
                homeworkScores[j] = score;
            }
            // create homeworks instance
            Homeworks homeworks = new Homeworks(homeworkScores[0], homeworkScores[1], homeworkScores[2],
                    homeworkScores[3], homeworkScores[4]);

            // create the student obj
            Student student = new Student(firstName, surname, homeworks, interimPercent, examPercent, i);
            // add student to this class (students list)
            this.students.add(student);
        }

        // close scanner obj
        input.close();
    }

    /** prints out students values as a table */
    public void printStudents() {
        // print headers
        padWrite("ID");
        padWrite("Name");
        padWrite("Surame");
        padWrite("Coursework");
        padWrite("Exam");
        padWrite("Final Mark");
        // line break
        System.out.println();
        for (Student student : students) {
            // print values
            padWrite(Integer.toString(student.getID()));
            padWrite(student.getFirstName());
            padWrite(student.getSurname());
            padWrite(Float.toString(student.getHomeworkPercent()));
            padWrite(Float.toString(student.getExamPercent()));
            padWrite(Float.toString(student.getFinalPercent()));
            // line break
            System.out.println();
        }
    }

    /**
     * takes string and adds spaces to the end to make the length of the string 20
     */
    public void padWrite(String value) {
        // output length of the string
        int columnSize = 20;
        // how many spaces that need to get added
        int padSize = columnSize - value.length();
        // print the value
        System.out.print(value);
        // print out padSize spaces
        for (int i = 0; i < padSize; i++) {
            System.out.print(" ");
        }
    }
}