public class Student {
    // fields and properties

    // student details
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    private String surname;

    public String getSurname() {
        return surname;
    }

    private int id;

    public int getID() {
        return id;
    }

    // student grades
    private float homeworkPercent;

    public float getHomeworkPercent() {
        return homeworkPercent;
    }

    private int interimPercent;

    public int getInterimPercent() {
        return interimPercent;
    }

    private int examPercent;

    public int getExamPercent() {
        return examPercent;
    }

    // the corresponding weights of each exam to final grade
    private static float HOMEWORK_WEIGHT = 0.1f;
    private static float INTERIM_WEIGHT = 0.2f;
    private static float EXAM_WEIGHT = 0.7f;

    /**
     * innitialises class, setting variables to an initial state
     * 
     * @param interimPercent should be between 1 and 100
     * @param examPercent    should be between 1 and 100
     */
    public Student(String firstName, String surname, Homeworks homeworks, int interimPercent, int examPercent,
            int id) {
        // initilise variables
        this.firstName = firstName;
        this.surname = surname;
        this.interimPercent = interimPercent;
        this.examPercent = examPercent;
        this.id = id;
        // gets percent from a homeworks object
        this.homeworkPercent = homeworks.getPercentageOfTop3();

        // validate interimPercent make sure its a value between 0 and 100
        if (interimPercent < 0 || interimPercent > 100) {
            throw new IllegalArgumentException("interimPercent should be between 0 and 100");
        }
        // validate examPercent make sure its a value between 0 and 100
        if (examPercent < 0 || examPercent > 100) {
            throw new IllegalArgumentException("examPercent should be between 0 and 100");
        }
    }

    /**
     * uses data about homework/interim/exam to get the final percentage
     * 
     * @return float of final percentage from 0-100
     */
    public float getFinalPercent() {
        // get the weighted percentages
        float weightedHomeworkPercent = this.homeworkPercent * Student.HOMEWORK_WEIGHT;
        float weightedInterimPercent = this.interimPercent * Student.INTERIM_WEIGHT;
        float weightedExamPercent = this.examPercent * Student.EXAM_WEIGHT;
        // combinde the wighted percentages
        float finalPercent = weightedHomeworkPercent + weightedInterimPercent + weightedExamPercent;
        // return the result
        return finalPercent;
    }
}
