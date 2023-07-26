
public class Enrolment {

    private String date;
    private Student student;
    private Unit[] unit;

    public Enrolment()
    {
        this.date = "11/07/2023";
        this.student = new Student();
        this.unit = new Unit[1];
        this.unit[0] = new Unit();
    }

//    public Enrolment(String date)
//    {
//        this.date = date;
//        this.student = new Student();
//        this.unit = new Unit[1];
//        this.unit[0] = new Unit();
//    }

    public Enrolment(String date, Student student, Unit[] unit) {
        this.date = date;
        this.student = student;
        this.unit = unit;
    }

    public String display()
    {
        String unitDisplay = "";

        if (unit != null) {
            for (Unit unitObj : unit) {
                unitDisplay += unitObj.display();
            }
        }

        return "\nDate: " + date + "\n" +
                "~Student Information~" + "\n" +
                this.student.display() + "\n\n" +
                "~Unit Information~" + "\n" +
                unitDisplay + "\n\n";
    }

    public String getDate() {
        return date;
    }

    public Student getStudent() {
        return student;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Unit[] getUnit()
    {
        return unit;
    }

    public void setUnit(Unit[] unit)
    {
        this.unit = unit;
    }

    public int getUnitSize()
    {
        return this.unit.length;
    }

    public void setUnitSize(int unitSize)
    {
        this.unit = new Unit[unitSize];
    }

    public Unit getSpecificUnit(int specificUnit)
    {
        return this.unit[specificUnit];
    }

    public void setSpecificUnit(int index, String unitCode, String unitDescription, int creditPoints)
    {
        this.unit[index] = new Unit();
        this.unit[index].setUnitCode(unitCode);
        this.unit[index].setUnitDescription(unitDescription);
        this.unit[index].setCreditPoints(creditPoints);
    }
}