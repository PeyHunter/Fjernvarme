
/**
 * Write a description of class Forbruger here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Forbruger
{
    private String  navn;
    private int     maalerNr;
    private int     nyAflaesning;
    private int     forrigeAflaesning;
    private int     maalerMax;

    public Forbruger()
    {
    }

    public Forbruger(String n, int mNr, int mMax)
    {
        navn = n;
        maalerNr = mNr;
        maalerMax = mMax;
    }

    public int getMaalerNr()
    {
        return maalerNr;
    }

    public int getMaalerMax()
    {
        return 1000;
    }

    public String setNavn(String nyN)
    {
        navn = nyN;
        return navn;
    }


    public String getNavn()
    {
        return navn;
    }

    //Den forrige aflaesning er den gamle nyAflaesning
    //Eksempel: NyAf (600) - forAf (400) --> NyAf(1000) - forAf(600)
    //Dvs at den forrige aflaesning er den 'gamle' nye aflaesning, som var 600.
    //Dermed er den forrige aflaesning = nyAflaesning.

    public void aflaesMaaler(int aflaesning)
    {
        forrigeAflaesning = nyAflaesning;
        nyAflaesning = aflaesning;
    }


    public int beregnForbrug()
    {
        int forbrug = nyAflaesning - forrigeAflaesning;

        if (nyAflaesning < forrigeAflaesning)
        {
            return nyAflaesning + maalerMax - forrigeAflaesning;
        }
        else
        {
            return nyAflaesning - forrigeAflaesning;
        }
    }
}

