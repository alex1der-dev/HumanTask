package model;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Male extends Human {

    private final static Sex sex = Sex.MALE;

    @Override
    public boolean talk(Human person) {
        if (person instanceof Female) {
            return true;
        }

        return Math.random() <= 0.5d;
    }

    @Override
    public boolean tolerate(Human person) {
        if (person instanceof Female) {
            super.tolerate(person);
        }

        return Math.random() <= .056d;
    }

    @Override
    public Human hasRelationship(Human person) {
        Predicate<Human> p = h -> h instanceof Male;
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

        return ((Female) person).giveBirth(this);
    }

    @Override
    public String toString() {
        return "Male: " + super.toString();
    }
}
