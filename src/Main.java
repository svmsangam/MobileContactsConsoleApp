import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Mobile myMobile = new Mobile();
        boolean quit = false;
        int choice;
        myMobile.getMenu();

        while (!quit) {
            choice = sc.nextInt();
            if(choice == 6){
                quit = true;
            }else {
                myMobile.selectMenu(choice - 1);
                myMobile.getMenu();
            }
        }

    }
}