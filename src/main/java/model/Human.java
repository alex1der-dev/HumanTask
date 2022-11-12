package model;

import java.util.function.BiFunction;
import java.util.function.Predicate;

public abstract class Human {

    private String name;
    private String lastName;
    private float height;
    private float weight;
    private Sex sex;

    public boolean talk(Human person) {
        return true;
    }

    public boolean tolerate(Human person) {
        return Math.random() <= .7d;
    }

    public boolean spendTimeTogether(Human person) {
        BiFunction<Human, Human, Float> b1 = (h1, h2) -> {
            Float heightBigger = Math.max(h1.getHeight(), h2.getHeight());
            Float heightLess = Math.min(h1.getHeight(), h2.getHeight());
            return heightBigger / heightLess;
        };
        Predicate<Float> p = s -> s - 1f > .1f ? Math.random() <= .85 : Math.random() <= .95;

        return p.test(b1.apply(this, person));
    }

    public abstract Human hasRelationship(Human person);

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public String getLastName() {
        return lastName;
    }

    public float getWeight() {
        return weight;
    }

    public Sex getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' + ", lastName='" + lastName + '\'' +
                ", height=" + height + ", weight=" + weight;
    }
}
