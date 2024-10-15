import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ForbrugerPersistens {
    public ForbrugerPersistens() // default
    {
    }


    public static void writeForbruger(Forbruger f) {
        String forbrugerFile = "forbrugerFile.txt";

        try (FileWriter writer = new FileWriter(forbrugerFile)) {
            String navn = f.getNavn();
            int maalerNr = f.getMaalerNr();
            int maalerMax = f.getMaalerMax();

            writer.append(navn + ", ");
            writer.append(Integer.toString(maalerNr) + ", ");
            writer.append(Integer.toString(maalerMax) + '\n');

            System.out.println("Forbruger file is written succesfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readForbruger() {
        //skilletegn mellem attributter er et komma
        String komma = ",";
        String line = "";
        String forbrugerFile = "forbrugerFile.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(forbrugerFile))) {
            while ((line = br.readLine()) != null) {
                String[] forbrugerR = line.split(komma);

                System.out.println("Navn: " + forbrugerR[0] + ", MålerNr: " + forbrugerR[1] + ", MaalerMax: " + forbrugerR[2]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//9. Skriv en metode som kan skrive en ArrayList af forbrugere i en txt.fil.

    public static void writeForbrugerArray(List<Forbruger> forbrugerList) {
        String forbrugerfile = "forbrugerFile.txt";
        try (FileWriter writer = new FileWriter(forbrugerfile, true)) {
            for (int i = 0; i < forbrugerList.size(); i++) {
                Forbruger f = forbrugerList.get(i);

                String navn = f.getNavn();
                int maalerNr = f.getMaalerNr();
                int maalerMax = f.getMaalerMax();

                writer.append(navn + ", ");
                writer.append(Integer.toString(maalerNr) + ", ");
                writer.append(Integer.toString(maalerMax) + '\n');

                System.out.println(f.getNavn() + ", " + f.getMaalerNr() + ", " + f.getMaalerMax());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

