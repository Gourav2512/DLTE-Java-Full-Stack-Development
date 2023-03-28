package handlers;

class InvalidAgeException  extends Exception
{
    public InvalidAgeException (String str)
    {

        super(str);
    }
}

public class Validation {
    public static void validateAge(int age) throws InvalidAgeException {
        if(age>25 && age<18){
            throw new InvalidAgeException("Age must be between 18 and 25");
        }

    }
}
