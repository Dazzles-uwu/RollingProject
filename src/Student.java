public class Student {

    private String name;
    private String address;
    private String phoneNo;
    private String email;

    public Student()
    {
        this.name = "Jane Doe";
        this.address = "141 Monash Way";
        this.phoneNo = "000 000 000";
        this.email = "default@monash.edu";
    }

    public Student(String name, String address, String phoneNo, String email)
    {
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public String display()
    {
        return "Student Name: " + name + "\n" +
                "Student Address: " + address + "\n" +
                "Student Phone Number: " + phoneNo + "\n" +
                "Student Email: " + email;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
