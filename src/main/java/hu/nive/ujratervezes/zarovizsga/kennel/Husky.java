package hu.nive.ujratervezes.zarovizsga.kennel;

public class Husky extends Dog {


    public Husky(String name) {
        super(name);
    }

    @Override
    void feed() {
        super.happiness = happiness + 4;
    }

    @Override
    void play(int hours) {
        super.happiness = happiness + (hours * 3);
    }
}
//Ha meghívod a Husky feed() metódusát, akkor a boldágságértéke néggyel nőjjön! Ha a play() metódusát, akkor a
// paraméterként átadott órák száma szorozva hárommal nőjjön a boldogságértéke!