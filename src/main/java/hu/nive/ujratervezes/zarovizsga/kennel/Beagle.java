package hu.nive.ujratervezes.zarovizsga.kennel;

public class Beagle extends Dog {



    public Beagle(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHappiness() {
        return happiness;
    }

    @Override
    void feed() {
        super.happiness = happiness + 2;
    }

    @Override
    void play(int hours) {
        super.happiness = happiness + (hours * 2);

    }


}
//Legyen két leszármazottja, a Beagle és a Husky! Konstruktornak meg lehessen adni a nevet! Ha meghívod a Beagle feed()
// metódusát, akkor a boldágságértéke kettővel nőjjön! Ha a play() metódusát, akkor a paraméterként átadott órák száma
// szorozva kettővel nőjjön a boldogságértéke!