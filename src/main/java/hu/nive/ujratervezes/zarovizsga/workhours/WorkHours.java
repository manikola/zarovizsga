package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WorkHours {

    public String minWork(String file){
        int min = Integer.MAX_VALUE;
        String result = null;
        Path path = Path.of(file);

        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] temp = line.split(",");
                int hours = Integer.parseInt(temp[1]);
                if (hours < min) {
                    min = hours;
                    result = temp[0] + ": " + temp[2];
                }
            }

               return result;


            } catch (IOException e) {
            throw new IllegalStateException("Can not read file", e);
        }

    }

}

//A WorkHours osztályban implementáld a String minWork(String file) metódust! A metódus paraméterként megkapja egy fájl
// elérési útvonalát. A tesztesetben ez a src/test/resources/hu/nive/ujratervezes/zarovizsga/workhours/workhours.txt,
// így ebbe a könyvtárba tedd a fájlt!
//A dolgozó neve, mennyi órát dolgozott egy nap, és a nap. Azt kell visszaadni, hogy ki melyik nap dolgozott a
// legkevesebbet. A fenti fájl alapján John Doe 2021-01-04-én csak 2 órát dolgozott, így a következő Stringet kell
// visszaadni: John Doe: 2021-01-04. Egy napra, egy alkalmazotthoz mindig csak egy sor van.