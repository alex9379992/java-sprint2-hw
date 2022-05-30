import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport= new YearlyReport();
        StatisticMonth statisticMonth = new StatisticMonth();
        StatisticYear statisticYear = new StatisticYear();
        DataReconciliation dataReconciliation = new DataReconciliation();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Здравствуй пользователь!");
        while (true){
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                monthlyReport.monthlyReading();
            } else if (command == 2) {
                yearlyReport.yearlyReading();
            } else if (command == 3) {
               dataReconciliation.callingMethods(monthlyReport.monthData, yearlyReport.yearData);
            } else if (command == 4) {
                    statisticMonth.callingMethods(monthlyReport.monthData);
            } else if (command == 5) {
                statisticYear.callingMethods(yearlyReport.yearData);
            } else if (command == 0) {
                System.out.println("Выход.");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("\nВыберете действие, которое хотите выполнить:");
        System.out.println("1 --> Считать все месячные отчёты");
        System.out.println("2 --> Считать годовой отчёт");
        System.out.println("3 --> Сверить отчёты");
        System.out.println("4 --> Вывести информацию о всех месячных отчётах");
        System.out.println("5 --> Вывести информацию о годовом отчёте");
        System.out.println("0 --> Выйти");
    }
}
