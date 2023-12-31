import java.util.ArrayList;

public class University {

    private ArrayList<Enrolment> enrolments;
    public static final String FILE_NAME = "src/students.txt";

    public void startProgram()
    {
        Input input = new Input();
        Validation validation = new Validation();
        readFile();

        String mainMenu = "~Main Menu~" + "\n" +
                "1) Enrol a Student" + "\n" +
                "2) Exit" + "\n";

        boolean exit = false;

        while (!exit) {
            int userChoice = input.acceptIntegerInput(mainMenu);

            if (userChoice == 1) {
                String dateOfEnrolment = input.acceptStringInput("What is the Enrolment Date?: ");
                while (validation.isBlank(dateOfEnrolment))
                {
                    System.out.println("Value cannot be blank");
                    dateOfEnrolment = input.acceptStringInput("What is the Enrolment Date?: ");
                }

                Enrolment currentEnrolmentObj = new Enrolment(dateOfEnrolment, new Student(), new Unit[4]);
                inputStudentDetails(currentEnrolmentObj);

                int numberOfUnits = input.acceptIntegerInput("What is the amount of units you would like to enrol in?");
                while (numberOfUnits <= 0)
                {
                    System.out.println("Value cannot be blank or the number must be greater than 0");
                    numberOfUnits = input.acceptIntegerInput("What is the amount of units you would like to enrol in?");
                }
                currentEnrolmentObj.setUnitSize(numberOfUnits);
                inputUnitDetails(currentEnrolmentObj);

                enrolments.add(currentEnrolmentObj);
                display();
            } else if (userChoice == 2) {
                writeFile();
                exit = true;
            } else {
                System.out.println("Please give a valid number");
            }
        }
    }

    public static void main(String[] args)
    {
        University uniObj = new University();
        uniObj.startProgram();
    }

    public University()
    {
        this.enrolments = new ArrayList<Enrolment>();
    }

    public University(Enrolment enrolment)
    {
        this.enrolments = new ArrayList<Enrolment>();
    }

    public void display()
    {
        if (enrolments.size() > 0)
        {
            for (Enrolment enrolmentObj : enrolments) {
                System.out.println(enrolmentObj.display());
            }
        }
    }

    public void inputStudentDetails(Enrolment enrolment)
    {
        Input input = new Input();
        Validation validation = new Validation();

        String name = input.acceptStringInput("What is Student's name?: ");
        while (validation.isBlank(name))
        {
            System.out.println("Please enter a valid String");
            name = input.acceptStringInput("What is Student's name?: ");
        }

        String address = input.acceptStringInput("What is Student's address?: ");
        while (validation.isBlank(address))
        {
            System.out.println("Please enter a valid String");
            address = input.acceptStringInput("What is Student's address?: ");
        }

        String phoneNumber = input.acceptStringInput("What is Student's Phone Number?: ");
        while (validation.isBlank(phoneNumber))
        {
            System.out.println("Please enter a valid String");
            phoneNumber = input.acceptStringInput("What is Student's Phone Number?: ");
        }

        String email = input.acceptStringInput("What is Student's Email?: ");
        while (validation.isBlank(email))
        {
            System.out.println("Please enter a valid String");
            email = input.acceptStringInput("What is Student's Email?: ");
        }

        enrolment.getStudent().setName(name);
        enrolment.getStudent().setAddress(address);
        enrolment.getStudent().setPhoneNo(phoneNumber);
        enrolment.getStudent().setEmail(email);
    }

    public void inputUnitDetails(Enrolment enrolment)
    {
        for (int i = 0; i < enrolment.getUnitSize(); i++)
        {
            inputUnitDetailsOnce(i, enrolment);
        }
    }

    public void inputUnitDetailsOnce(int index, Enrolment enrolment)
    {
        Input input = new Input();
        Validation validation = new Validation();

        String unitCode = input.acceptStringInput("What is the Unit Code?: ");
        while (validation.isBlank(unitCode) || unitCode.length() != 7)
        {
            System.out.println("Unit Code cannot be blank and has to be 7 characters long");
            unitCode = input.acceptStringInput("What is the Unit Code?: ");
        }

        String unitDescription = input.acceptStringInput("What is the Unit's description?: ");
        while (validation.isBlank(unitDescription) || !validation.lengthWithinRange(unitDescription, 1, 25))
        {
            System.out.println("Unit Desc cannot be blank and has a 25 max characters long");
            unitDescription = input.acceptStringInput("What is the Unit's description?: ");
        }

        int creditPoints = input.acceptIntegerInput("What is the unit's Credit Point?: ");
        while (creditPoints <= 0)
        {
            System.out.println("Credit point cannot be 0");
            creditPoints = input.acceptIntegerInput("What is the unit's Credit Point?: ");
        }

        enrolment.setSpecificUnit(index, unitCode, unitDescription, creditPoints);
    }

    public ArrayList<Enrolment> getEnrolments() {
        return enrolments;
    }

    public void setEnrolments(ArrayList<Enrolment> enrolments) {
        this.enrolments = enrolments;
    }

    public int getEnrolmentSize()
    {
        return this.enrolments.size();
    }

    public void addEnrolment(Enrolment enrolment)
    {
        this.enrolments.add(enrolment);
    }

    public void removeEnrolment(int index)
    {
        this.enrolments.remove(index);
    }

    public Enrolment getSpecificEnrolment(int index)
    {
        return this.enrolments.get(index);
    }

    public void setSpecificEnrolment(int index, Enrolment enrolment)
    {
        this.enrolments.set(index, enrolment);
    }

    public void readFile()
    {
        FileIO fileIOObj = new FileIO();
        String fileContent = "";
        fileContent = fileIOObj.readFile();
        System.out.println(fileContent);

        String[] individualStudent = fileContent.split("\n");

        for (int i = 0; i < individualStudent.length; i++)
        {
            String[] enrolmentInfo = individualStudent[i].split(",");
            String[] unitInfo = enrolmentInfo[enrolmentInfo.length - 1].split(";");

            String date = enrolmentInfo[0];
            String name = enrolmentInfo[1];
            String address = enrolmentInfo[2];
            String phoneNo = enrolmentInfo[3];
            String email = enrolmentInfo[4];

            Unit[] unit = new Unit[unitInfo.length];

            for (int j = 0; j < unitInfo.length; j++)
            {
                String[] unitIndividualInfo = unitInfo[j].split("-");
                unit[j] = new Unit(unitIndividualInfo[0], unitIndividualInfo[1], Integer.parseInt(unitIndividualInfo[2]));
            }

            this.enrolments.add(new Enrolment(date, new Student(name, address, phoneNo, email), unit));
        }
    }

    public void writeFile()
    {
        FileIO fileIOObj = new FileIO();
        String enrolmentContent = "";
        for (Enrolment enrolment : this.enrolments) {
            enrolmentContent += enrolment.getDate() + ",";
            enrolmentContent += enrolment.getStudent().getName() + ",";
            enrolmentContent += enrolment.getStudent().getAddress() + ",";
            enrolmentContent += enrolment.getStudent().getPhoneNo() + ",";
            enrolmentContent += enrolment.getStudent().getEmail() + ",";

            String unitContent = "";
            for (int j = 0; j < enrolment.getUnitSize(); j++) {
                if (j != enrolment.getUnitSize() - 1) {
                    unitContent += enrolment.getSpecificUnit(j).getUnitCode() + "-" +
                            enrolment.getSpecificUnit(j).getUnitDescription() + "-" +
                            enrolment.getSpecificUnit(j).getCreditPoints() + ";";
                } else {
                    unitContent += enrolment.getSpecificUnit(j).getUnitCode() + "-" +
                            enrolment.getSpecificUnit(j).getUnitDescription() + "-" +
                            enrolment.getSpecificUnit(j).getCreditPoints();
                }
            }

            enrolmentContent += unitContent + "\n";
        }
        fileIOObj.writeFile(enrolmentContent);
    }
}
