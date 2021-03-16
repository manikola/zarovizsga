package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {
    private List<Dog> dogs = new ArrayList<>();


    public List<Dog> getDogs() {
        return new ArrayList<>(dogs);
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public void feedAll() {
        for (Dog item : dogs) {
            item.feed();
        }
    }

    public Dog findByName(String name) {
        for (Dog item : dogs) {
            if (item.getName().equals(name)) {
                return item;
            }

        }
        throw new IllegalArgumentException("No result");
    }

    public void playWith(String name, int hours){
        findByName(name).play(hours);
    }

    public List<String> getHappyDogNames(int minHappiness){
        List<String> results = new ArrayList<>();
        for(Dog item : dogs){
            if(item.getHappiness() > minHappiness){
                results.add(item.getName());
            }
        }
        return results;
    }
}
//Legyen egy Kennel osztály, mely nyilvántartja a kutyákat. A következő metódusokat implementáld:
//
//void addDog(Dog dog) - hozzáaad egy kutyát
//feedAll() - összes kutya feed() metódusát meghívja
//Dog findByName(String name) - kikeresi a kutyát név alapján, kivételt dob, ha nem találja
//void playWith(String name, int hours) - a paraméterként megadott kutyát kikeresi, és meghívja a play() metódusát az átadott hours paraméterrel
//List<String> getHappyDogNames(int minHappiness) - visszaadja azon kutyák neveit, melyeknek boldogsága nagyobb, mint a paraméterként átadott érték

