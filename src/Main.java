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
                if(monthlyReport.monthData.size() == 0 && yearlyReport.yearData.size() == 0){
                    System.out.println("Ошибка: годовой и месячные отчеты не загружены.");
                } else {
                    dataReconciliation.calculatingMonthlySum(monthlyReport.monthData);
                    dataReconciliation.calculatingYearly(yearlyReport.yearData);
                    dataReconciliation.reconciliation();
                }
            } else if (command == 4) {
                if(monthlyReport.monthData.size() == 0){
                    System.out.println("Ошибка: месячные отчеты не загружены.");
                } else {
                    statisticMonth.statisticPrint(monthlyReport.monthData);
                }
            } else if (command == 5) {
                if(yearlyReport.yearData.size() == 0){
                    System.out.println("Ошибка: годовой отчет не загружен.");
                } else {
                    statisticYear.printNameYear();
                    statisticYear.printProfit(yearlyReport.yearData);
                    statisticYear.printAverageIncomeAndExpense(statisticYear.dataIncome, statisticYear.dataExpense);
                }
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
