import java.util.*;

public class Female extends Human {

    public Female() {
        super(false);
    }

    public Human giveLife(Human a) {
        double rand = Math.random();
        Human child;
        if (rand < 0.5) {
            child = createChild(a, true);
        } else {
            child = createChild(a, false);
        }
        return child;
    }

    private Human createChild(Human father, boolean sex){
        Scanner scan = new Scanner(System.in);
        Human child;
        if (sex){
            child = new Male();
            child.setHeight(calcHeight(father, this));
            child.setWeight(calcWeight(father, this));
            System.out.println("Human1 and Human2 will have a boy");
            System.out.println("Input name of the boy: ");
        }
        else {
            child = new Female();
            child.setHeight(calcHeight(this, father));
            child.setWeight(calcWeight(this, father));
            System.out.println("Human1 and Human2 will have a girl");
            System.out.println("Input name of the girl: ");
        }

        String s = scan.nextLine();
        child.setName(s);
        child.setSurname(father.getSurname());

        System.out.println(child);
        return child;
    }

    private float calcHeight(Human human1, Human human2){
        return (float)(human1.getHeight() + 0.1 * (human2.getHeight() - human1.getHeight()));
    }

    private float calcWeight(Human human1, Human human2){
        return (float)(human1.getWeight() + 0.1f * (human2.getWeight() - human1.getWeight()));
    }
}