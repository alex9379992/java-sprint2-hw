import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport= new YearlyReport();
        Scanner scanner = new Scanner(System.in);
        while (true){
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                monthlyReport.monthReading();
            } else if (command == 2) {
                yearlyReport.yearlyReading();
            } else if (command == 3) {

            } else if (command == 4) {

            } else if (command == 5) {

            } else if (command == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }

    }

    public static void printMenu() {
        System.out.println("Выберете действие, которое хотите выполнить:");
        System.out.println("1 --> Считать все месячные отчёты");
        System.out.println("2 --> Считать годовой отчёт");
        System.out.println("3 --> Сверить отчёты");
        System.out.println("4 --> Вывести информацию о всех месячных отчётах");
        System.out.println("5 --> Вывести информацию о годовом отчёте");
        System.out.println("0 --> Выйти");
    }
}
