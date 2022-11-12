package control;

import model.Human;

public class AppController {

    private Human personFirst;
    private Human personSecond;
    private Human personResult;

    public Human getPersonFirst() {
        return personFirst;
    }

    public Human getPersonSecond() {
        return personSecond;
    }

    public void setPersons(Human person) {
        if (personFirst == null) {
            personFirst = person;
        } else if (personSecond == null) {
            personSecond = person;
        }
    }
}
