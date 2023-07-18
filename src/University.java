public class University {

    private Enrolment enrolment;

    public static void main(String[] args)
    {
        Input input = new Input();
        Validation validation = new Validation();

        String mainMenu = "~Main Menu~" + "\n" +
                "1) Enrol a Student" + "\n" +
                "2) Exit" + "\n";

        boolean exit = false;

        while (!exit) {
            int userChoice = input.acceptIntegerInput(mainMenu);

            if (userChoice == 1) {
                String dateOfEnrolment = input.acceptStringInput("What is the Enrolment Date?: ");

                if (validation.isBlank(dateOfEnrolment)) {
                    new University(new Enrolment());

                } else {
                    new University(new Enrolment(dateOfEnrolment));
                }
            } else if (userChoice == 2) {
                exit = true;
            } else {
                System.out.println("Please give a valid number");
            }
        }
    }

    public University()
    {
        this.enrolment = new Enrolment("Unknown",
                new Student("John Doe", "1300 Monash Way", "000", "default@email.com"),
                new Unit("FIT000", "This is a default Unit", 6));
    }

    public University(Enrolment enrolment)
    {
        this.enrolment = enrolment;
    }

    public void display()
    {
        System.out.println("Placeholder");
    }

    public Enrolment getEnrolment()
    {
        return enrolment;
    }

    public void inputStudentDetails(Enrolment enrolment)
    {
        Input input = new Input();

        String name = input.acceptStringInput("What is Student's name?: ");
        String address = input.acceptStringInput("What is Student's address?: ");
        String phoneNumber = input.acceptStringInput("What is Student's Phone Number?: ");
        String email = input.acceptStringInput("What is Student's Email?: ");

        enrolment.getStudent().setName(name);
        enrolment.getStudent().setAddress(address);
        enrolment.getStudent().setPhoneNo(phoneNumber);
        enrolment.getStudent().setPhoneNo(email);
    }

    public void inputUnitDetails(int numberOfUnits, Enrolment enrolment)
    {
        Input input = new Input();
        Validation validation = new Validation();

        String unitCode = input.acceptStringInput("What is the Unit Code?: ");
        while (validation.isBlank(unitCode) || unitCode.length() != 7)
        {
            unitCode = input.acceptStringInput("What is the Unit Code?: ");
        }

        String unitDescription = input.acceptStringInput("What is the Unit's description?: ");
        while (validation.isBlank(unitDescription) || !validation.lengthWithinRange(unitDescription, 1, 25))
        {
            unitDescription = input.acceptStringInput("What is the Unit's description?: ");
        }

        int creditPoints = input.acceptIntegerInput("What is the unit's Credit Point?: ");
        while (creditPoints < 0)
        {
            creditPoints = input.acceptIntegerInput("What is the unit's Credit Point?: ");
        }

        enrolment.getUnit().setUnitCode(unitCode);
        enrolment.getUnit().setUnitDescription(unitDescription);
        enrolment.getUnit().setCreditPoints(creditPoints);
    }

    public void setEnrolment(Enrolment enrolment)
    {
        this.enrolment = enrolment;
    }
}
