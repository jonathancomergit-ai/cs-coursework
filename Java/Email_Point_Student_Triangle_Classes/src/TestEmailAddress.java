// TestEmailAddress
// Add this file to your IntelliJ project.
// Do not modify this file.

public class TestEmailAddress
{
    public static void main(String[] args)
    {
        System.out.println("Constructors");
        // Test the no arg constructor.
        EmailAddress e1 = new EmailAddress();

        // Test the other constructor.
        EmailAddress e2= new EmailAddress("jack", "sparrow.cxx");

        System.out.println("e1: " + e1);
        System.out.println("e2: " + e2);

        System.out.println();

        // Check the format of the toString() method.
        System.out.println("toString() Method");
        System.out.println("Correct format? " + e1.toString().equals("johndoe@website.cxx"));

        System.out.println();

        System.out.println("Getters and Setters");
        System.out.println("e1.getLocalPart(): " + e1.getLocalPart());
        System.out.println("e1.getDomain(): " + e1.getDomain());
        e1.setLocalPart("jane");
        e1.setDomain("doe.cxx");
        System.out.println("e1.getLocalPart(): " + e1.getLocalPart());
        System.out.println("e1.getDomain(): " + e1.getDomain());

        System.out.println();

        // Test the toAntiSpamString() method.
        System.out.println("toAntiSpamString() Method");
        System.out.println("e1.toAntiSpamString(): " + e1.toAntiSpamString());
        System.out.println("e2.toAntiSpamString(): " + e2.toAntiSpamString());
    }
}
