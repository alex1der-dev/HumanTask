package control;

import model.Female;
import model.Human;
import model.Male;
import model.Sex;

public class HumanController {

    public Sex defineSex(String sexLetter) {
        switch (sexLetter) {
            case "F": {
                return Sex.FEMALE;
            }
            case "M": {
                return Sex.MALE;
            }
            default:
                throw new IllegalArgumentException();
        }
    }

    public Human registerHuman(Sex sex,String name, String lastName, float height, float weight){
        Human person = null;
        switch(sex){
            case MALE:
                person = new Male();
                break;
            case FEMALE:
                person = new Female();
                break;
        }
        person.setName(name);
        person.setLastName(lastName);
        person.setHeight(height);
        person.setWeight(weight);
        return person;
    }

    public Human registerPersonResult(Human personFirst, Human personSecond){
        return personFirst.hasRelationship(personSecond);
    }
}
