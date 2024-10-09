
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String args[])
    {
        Forbruger   peter = new Forbruger("Peter", 67, 1000);
        Forbruger   iben = new Forbruger("Iben", 212, 1000);

        Distrikt    tagensvej = new Distrikt("Tagensvej", (float) 12.5);

        tagensvej.generereForbruger(20);

        peter.aflaesMaaler(990);
        peter.aflaesMaaler(25);



        ForbrugerPersistens.writeForbrugerArray(tagensvej.getForbruger());

        ForbrugerPersistens.readForbruger();

        tagensvej.udskrivForbrugere();

        tagensvej.forbrugerInterval(200, 400);

        System.out.println("antal piger " + tagensvej.countGirls());
        System.out.println("antal drenge " + tagensvej.countBoys());
    }
}
