
public class Enrolment {

/*    public static void main(String[] args) {
        Student studentObj = new Student("Daffa", "395 Bourke Street",
                "0439 284 141", "daffa@email.com");
        Unit unitObj = new Unit("FIT2096", "Game Development 1", 6);

        Enrolment enrolmentObj = new Enrolment("11/07/23", studentObj, unitObj);
        System.out.println(enrolmentObj.display());
    }*/

    private String date;
    private Student student;
    private Unit unit;

    public Enrolment()
    {
        this.date = "11/07/2023";
        this.student = new Student();
        this.unit = new Unit();
    }

    public Enrolment(String date)
    {
        this.date = date;
        this.student = new Student();
        this.unit = new Unit();
    }

    public Enrolment(String date, Student student, Unit unit) {
        this.date = date;
        this.student = student;
        this.unit = unit;
    }

    public String display()
    {
        return "Date: " + date + "\n" +
                "~Student Information~" + "\n" +
                this.student.display() + "\n" +
                "~Unit Information~" + "\n" +
                this.unit.display();
    }

    public String getDate() {
        return date;
    }

    public Student getStudent() {
        return student;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}