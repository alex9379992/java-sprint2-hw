import java.util.ArrayList;
import java.util.HashMap;

public class StatisticMonth {
    public void callingMethods(HashMap<Integer, ArrayList<MonthlyReport.MonthlyReportRecord>> monthData) {
        if (monthData.size() == 0) {
            System.out.println("Ошибка: месячные отчеты не загружены.");
        } else {
            statisticPrint(monthData);
        }
    }

    void statisticPrint(HashMap<Integer, ArrayList<MonthlyReport.MonthlyReportRecord>> monthData){

        System.out.println("Статистика по месяцам:");

        ArrayList<MonthlyReport.MonthlyReportRecord> listMonth;
        for (int month : monthData.keySet()) {
            String nameProfit = "";
            String nameExpense = "";
            int maxProfit = 0;
            int maxExpense = 0;
            listMonth = monthData.get(month);
            for (int i = 0; i < listMonth.size(); i++) {
                MonthlyReport.MonthlyReportRecord record = listMonth.get(i);
                if (!record.isExpense){
                    int profit = record.quantity * record.sumOfOne;
                    if(profit > maxProfit){
                        maxProfit = profit;
                        nameProfit = record.itemName;
                    }
                } else {
                    int expense = record.quantity * record.sumOfOne;
                    if(expense > maxExpense){
                        maxExpense = expense;
                        nameExpense = record.itemName;
                    }
                }
            }
            System.out.println( monthName(month) + " :");
            System.out.println("Самый прибыльный товар: " + nameProfit + " на сумму " + maxProfit);
            System.out.println("Самая большая трата: " + nameExpense + " на сумму "   + maxExpense);
        }
    }


    public String monthName(int monthId) {
        String nameOfMonth = "";
        if (monthId == 1) {
            nameOfMonth = "Январь";
        } else if (monthId == 2) {
            nameOfMonth = "Февраль";
        } else if (monthId == 3) {
            nameOfMonth = "Март";
        }
        return nameOfMonth;
    }
}
