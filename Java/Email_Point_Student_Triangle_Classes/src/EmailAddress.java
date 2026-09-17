//Jonathan Comer
//Homework 3 CS1100
//This program Creates emailaddress objects and then converts them into a string


public class EmailAddress
{
    //varibles
    private String localPart;
    private String domain;

    //no arg constructor
    EmailAddress()
    {
        this.localPart = "johndoe";
        this.domain = "website.cxx";
    }

    //arg constructor
    EmailAddress(String localPart, String domain)
    {
        this.localPart = localPart;
        this.domain = domain;
    }

    //toString
    @Override
    public String toString() {
        return localPart +  "@" + domain;
    }

    //AntiSpam method
    public String toAntiSpamString()
    {
        return localPart + " at " + domain + " dot com";
    }

    //Getters and setters
    public String getLocalPart() {
        return localPart;
    }

    public void setLocalPart(String localPart) {
        this.localPart = localPart;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }


}
