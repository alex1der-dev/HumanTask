public abstract class Human {

    private boolean sex;
    private String name;
    private String surname;
    private float height;
    private float weight;

    public Human(boolean sex) {
        this.sex = sex;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "{sex: " + sex + "; name: " + name + "; surname: " + surname + "; height: " + height + "; weight: " + weight + "}";
    }

    public boolean speak(Human human) {
        boolean speak = false;
        if (!this.sex & !human.sex) {
            speak = true;
        } else if (!this.sex & human.sex) {
            speak = true;
        } else if (this.sex & !human.sex) {
            speak = true;
        } else if (this.sex & human.sex) {
            double rand = Math.random();
            if (rand <= 0.5) {
                speak = true;
            } else {
                speak = false;
            }
        }
        return speak;
    }

    public boolean tolerate(Human human) {
        boolean tolerate = false;
        if (!this.sex & !human.sex) {
            double rand = Math.random();
            if (rand <= 0.05) {
                tolerate = true;
            }
        } else if (!this.sex & human.sex) {
            double rand = Math.random();
            if (rand <= 0.7) {
                tolerate = true;
            }
        } else if (this.sex & !human.sex) {
            double rand = Math.random();
            if (rand <= 0.7) {
                tolerate = true;
            }
        }
        double rand = Math.random();
        if (rand <= 0.056) {
            tolerate = true;
        }
        return tolerate;
    }

    public boolean timeTogether(Human human) {
        boolean timeTogether = false;
        double rand = Math.random();
        if (Math.abs(this.height - human.height) > this.height * 0.1) {
            if (rand <= 0.85) {
                timeTogether = true;
            }
        } else {
            if (rand <= 0.95) {
                timeTogether = true;
            }
        }
        return timeTogether;
    }

    public void relations(Human human) {
        Human child = null;
        boolean isSpeak = this.speak(human);
        if (isSpeak) {
            System.out.println("Human 1 and Human 2 have Speak-compatibility");
        } else System.out.println("Human 1 and Human 2 have no Speak-compatibility");
        boolean isTolerate = this.tolerate(human);
        if (isTolerate) {
            System.out.println("Human 1 and Human 2 can tolerate");
        } else System.out.println("Human 1 and Human 2 can't tolerate");
        boolean isTimeTogether = this.timeTogether(human);
        if (isTimeTogether) {
            System.out.println("Human 1 and Human 2 can spend time together");
        } else System.out.println("Human 1 and Human 2 can't spend time together");
        if (isSpeak & isTolerate & isTimeTogether) {
            if (this.sex&&!human.sex) {
                Female female = (Female) human;
                child = female.giveLife(this);
            } else if (!this.sex&&human.sex){
                Female female = (Female) this;
                child = female.giveLife(human);
            }

        } else {
            System.out.println("Relations are failed");
        }
    }
}
