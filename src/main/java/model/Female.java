package model;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Female extends Human {

    private final static Sex sex = Sex.FEMALE;

    @Override
    public boolean tolerate(Human person) {
        if (person instanceof Male) {
            super.tolerate(person);
        }

        return Math.random() <= .05d;
    }

    @Override
    public Human hasRelationship(Human person) {
        Predicate<Human> p = h -> h instanceof Female;
        if (p.test(person)) {
            return null;
        }
        BiPredicate<Human, Human> talk = Human::talk;
        BiPredicate<Human, Human> tolerate = Human::tolerate;
        BiPredicate<Human, Human> spendTimeTogether = Human::spendTimeTogether;
        BiPredicate<Human, Human> result = (p1, p2) -> talk.test(p1, p2) && tolerate.test(p1, p2)
                && spendTimeTogether.test(p1, p2);
        if (!result.test(this, person)) {
            return null;
        }

        return this.giveBirth((Male) person);
    }

    public Human giveBirth(Male male) {
        Human baby = Math.random() == 0.5d ? new Female() : new Male();
        baby.setLastName(male.getLastName());
        float resultHeight = baby instanceof Male ? .1f * this.getHeight() : .1f * male.getHeight();
        baby.setHeight(resultHeight);
        float resultWeight = baby instanceof Male ? .1f * this.getWeight() : .1f * male.getWeight();
        baby.setWeight(resultWeight);

        return baby;
    }

    @Override
    public String toString() {
        return "Female: " + super.toString();
    }
}
