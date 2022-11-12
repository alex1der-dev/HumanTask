package view;

import control.AppController;
import control.HumanController;
import model.Human;
import model.Sex;

import java.util.Scanner;

public class AppView {
    private AppController appController = new AppController();
    private HumanController humanController = new HumanController();
    private final Scanner scanner = new Scanner(System.in);

    public void registerPerson() {
        String inputSex;
        String inputName;
        String inputLastName;
        float inputHeight;
        float inputWeight;

        System.out.println("Enter person's sex:");
        inputSex = scanner.nextLine();
        System.out.println("Enter person's name:");
        inputName = scanner.nextLine();
        System.out.println("Enter person's last name:");
        inputLastName = scanner.nextLine();
        System.out.println("Enter person's height:");
        inputHeight = scanner.nextFloat();
        System.out.println("Enter person's weight:");
        inputWeight = scanner.nextFloat();
        Sex sexDefinedOnInput = humanController.defineSex(inputSex);
        Human registeredPerson = humanController.registerHuman(sexDefinedOnInput, inputName, inputLastName,
                inputHeight, inputWeight);
        System.out.println(registeredPerson +"\nSuccessfully registered.");
        scanner.nextLine();
        appController.setPersons(registeredPerson);
    }

    public void registerPersonResult() {
        Human personFirst = appController.getPersonFirst();
        Human personSecond = appController.getPersonSecond();
        Human personResult = humanController.registerPersonResult(personFirst, personSecond);
        if (personResult == null) {
            System.out.println("Nothing happened.");
            scanner.close();
            return;
        }
        System.out.println("Born person's sex: " + personResult.getSex());
        System.out.println("Enter new person's name: ");
        String inputName = scanner.nextLine();
        personResult.setName(inputName);
        System.out.println(personResult +"\nSuccessfully registered.");
        scanner.close();
    }
}



