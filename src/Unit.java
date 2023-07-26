public class Unit {

    private String unitCode;
    private String unitDescription;
    private int creditPoints;

    public Unit()
    {
        this.unitCode = "ITO4131";
        this.unitDescription = "Java Programming";
        this.creditPoints = 6;
    }

    public Unit(String unitCode, String unitDescription, int creditPoints)
    {
        this.unitCode = unitCode;
        this.unitDescription = unitDescription;
        this.creditPoints = creditPoints;
    }

    public String display()
    {
        return "Unit Code: " + unitCode + "\n" +
                "Unit Description: " + unitDescription + "\n" +
                "Credit Points: " + creditPoints + "\n\n";
    }
    public int getCreditPoints() {
        return creditPoints;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public String getUnitDescription() {
        return unitDescription;
    }

    public void setCreditPoints(int creditPoints) {
        this.creditPoints = creditPoints;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public void setUnitDescription(String unitDescription) {
        this.unitDescription = unitDescription;
    }

}
