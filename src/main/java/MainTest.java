import java.util.Scanner;
import java.util.InputMismatchException;

public class MainTest {

    public static void main(String[] args) {

        System.out.println("Input parameters of first person: ");
        Human human1 = createHuman();

        System.out.println("Parameters of first person: ");
        System.out.println(human1);

        System.out.println("Input parameters of second person: ");
        Human human2 = createHuman();

        System.out.println("Parameters of second person: ");
        System.out.println(human2);

        human1.relations(human2);
    }

    private static Human createHuman() {
        Human newHuman = null;
        System.out.println("Sex: 1 - Male; 2 - Female: ");
        Scanner scan = new Scanner(System.in);
        int sexNew = scanSex();
        switch (sexNew) {
            case 1:
                newHuman = new Male();
                break;
            case 2:
                newHuman = new Female();
                break;
        }
        System.out.println("Input name: ");
        String nameNew = scan.nextLine();
        newHuman.setName(nameNew);

        System.out.println("Input surname: ");
        String surnameNew = scan.nextLine();
        newHuman.setSurname(surnameNew);

        System.out.println("Input height: ");
        boolean choice = false;
        float heightNew = 0.0F;
        while (!choice) {
            try {
                heightNew = scan.nextFloat();
                scan.nextLine();
            } catch (InputMismatchException exception) {
                System.out.println("Invalid input, try again");
                scan.nextLine();
                continue;
            }
            if (heightNew < 0)
                System.out.println("Invalid input, try again");
            choice = true;
        }
        newHuman.setHeight(heightNew);

        System.out.println("Input weight: ");
        choice = false;
        float weightNew = 0.0F;
        while (!choice) {
            try {
                weightNew = scan.nextFloat();
                scan.nextLine();
            } catch (InputMismatchException exception) {
                System.out.println("Invalid input, try again");
                scan.nextLine();
                continue;
            }
            if (weightNew < 0)
                System.out.println("Invalid input, try again");
            choice = true;
        }
        newHuman.setWeight(weightNew);
        return newHuman;
    }

    public static int scanSex() {
        Scanner scan = new Scanner(System.in);
        boolean choice = false;
        int sex = 0;
        while (!choice) {
            try {
                sex = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException exception) {
                System.out.println("Wrong choice, invalid input");
                scan.nextLine();
                continue;
            }
            if (sex < 1 || sex > 2) {
                System.out.println("Wrong choice");
            } else {
                choice = true;
            }
        }
        return sex;
    }
}