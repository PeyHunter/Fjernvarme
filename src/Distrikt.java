import java.util.ArrayList;
import java.util.Random;

public class Distrikt
{
    private String distriktNavn;
    private float prisPrM3;

    private ArrayList<Forbruger> forbrugere = new ArrayList<>();
    private int antalForbrugere = 0;

    Random random = new Random();

    private static String [] pigeNavne = {"Peyton","Sumaya", "Line", "Isabella", "Nauer", "Hawra","Rachal", "Anna", "Caroline", "Sif"};
    private static String [] drengeNavne = {"Peter","Asger", "Valdemar", "Hugo", "Ole", "Henrik","Adam", "Ib", "Bo", "Magnus"};
    private static String [] efternavne = {"Jones","Albrektsen", "Steffensen", "Hendel", "Andersen", "Badreldin","Vestergaard", "Hunter", "Green", "Simonsen"};



    public Distrikt()
    { }

    public Distrikt(String n, float pPM3)
    {
        distriktNavn = n;
        prisPrM3 = pPM3;
    }

    public float afregnForbrug(int maalerNr)
    {

        for(int i = 0; i < antalForbrugere; i++)
        {
            Forbruger f = forbrugere.get(i);

            if (f.getMaalerNr() == maalerNr)
            {
                int  aarsForbrug = f.beregnForbrug();
                return aarsForbrug * prisPrM3;
            }
        }

        return -1;

    }

    public void addForbruger(Forbruger nyForbruger)
    {
        {
            forbrugere.add(nyForbruger);
            antalForbrugere++;
        }
    }


    public int randomMaalerNr()
    {
        int min = 1;
        int max = 999;
        //e.    Lav et Forbruger-objekt og indsæt det i arraylisten, dog således at et bestemt målernummer kun kan forekomme én gang. Husk maalerMax.

        return random.nextInt(max - min + 1) + min;
    }

    public boolean findesMaalerNr(int maalerNr)
    {
        for (Forbruger f: forbrugere)
            if (f.getMaalerNr() == maalerNr)
            {
                return true;
            }
        return false;
    }

    public void generereForbruger(int antal)
    {
        Random random = new Random();

        for (int i = 0; i < antal; i++ )
        {
            String navn = "";
            int maalerNr = 0;

            int x = random.nextInt(2);

            if (x == 0)
                navn += drengeNavne[random.nextInt(drengeNavne.length)];
            else
                navn += pigeNavne[random.nextInt(pigeNavne.length)];

            navn += " " + efternavne[random.nextInt(efternavne.length)];

            while(true)
            {
                maalerNr = random.nextInt(999)+1;
                if (!findesMaalerNr(maalerNr))
                    break;
            }

            Forbruger f = new Forbruger(navn, maalerNr, 1000);
            addForbruger(f);
        }
    }

    public int countGirls()
    {
        int antal = 0;

        for(int i = 0; i < antalForbrugere; i++)
            for(int j = 0; j < 10; j++)
                if(forbrugere.get(i).getNavn().contains(pigeNavne[j]))
                    antal++;
        return antal;

    }


    public int countBoys()
    {
        return antalForbrugere - countGirls();
    }


    public void navneDubletter()
    {
        for (int i = 0; i < antalForbrugere; i++)

            for (int j = i + 1; j < antalForbrugere; j++ )
                if (forbrugere.get(i).getNavn().equals(forbrugere.get(j).getNavn()))
                    System.out.println("Dublet: " + forbrugere.get(i).getNavn());
    }

    private void swap(int x, int y)
    {
        Forbruger f = new Forbruger();
        f = forbrugere.get(x);
        forbrugere.set(x, forbrugere.get(y));
        forbrugere.set(y, f);
    }

    public void sorterALForb()
    {
        for (int i = 0; i < antalForbrugere; i++)
            for (int j = 0; j < antalForbrugere - 1; j++ )
                if (forbrugere.get(j).getNavn().compareTo(forbrugere.get(j+1).getNavn()) > 0)
                    swap(j,j + 1);
    }

    public void udskrivForbrugere()
    {
        for (int i = 0; i < antalForbrugere; i++)
            System.out.println(forbrugere.get(i).getMaalerNr() + "  " + forbrugere.get(i).getNavn());
        System.out.println(forbrugere.size());
    }

    public ArrayList<Forbruger> getForbruger()
    {
        return forbrugere;
    }

    public void forbrugerInterval(int lowerBound, int upperBound)
    {
        boolean found = false;

        for(int i = 0; i < antalForbrugere; i++)
        {
            Forbruger f = forbrugere.get(i);
            int maalerNr = f.getMaalerNr();

            if (maalerNr >= lowerBound && maalerNr <= upperBound)
            {
                System.out.println("Forbruger: " + f.getNavn() + "MaalerNr: " + maalerNr);
                found = true;
            }

        }
        if (!found)
        {
            System.out.println("Ingen forbrugere med maalerNr mellem" + lowerBound + " - " + upperBound );
        }
    }





}



//
//10. Lav en metode som kan udskrive et interval af forbrugere på System.out, fx forbrugere med målernummer i intervallet 700-799.

// opgave 10
/*public void forbrugerInterval()
    {
        for (int i = 0 ; i < antalForbrugere; i++)
        {
            if (maalerNr > 1 || maalerNr < 20)

            System.out.println()

        }
    }*/


