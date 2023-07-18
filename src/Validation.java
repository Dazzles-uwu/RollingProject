public class Validation {

    public Validation()
    {

    }

    public boolean isBlank(String input)
    {
        return input.equals("");
    }

    public boolean lengthWithinRange(String input, int min, int max)
    {
        return input.length() > min && input.length() < max;
    }
}
