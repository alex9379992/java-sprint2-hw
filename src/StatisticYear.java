import java.util.ArrayList;
import java.util.HashMap;

public class StatisticYear {
    HashMap<Integer, Integer> dataIncome = new HashMap<>();
    HashMap<Integer, Integer> dataExpense = new HashMap<>();
    StatisticMonth statisticMonth = new StatisticMonth();

    public void callingMethods(ArrayList<YearlyReport.YearlyReportRecord> yearData) {
        if(yearData.size() == 0){
            System.out.println("Ошибка: годовой отчет не загружен.");
        } else {
            printNameYear();
            printProfit(yearData);
            printAverageIncomeAndExpense(dataIncome, dataExpense);
        }
    }

    public void printNameYear() {
        final int nameYear = 2021;
        System.out.println("Статистика за " + nameYear + " год:");
    }

    public void printProfit(ArrayList<YearlyReport.YearlyReportRecord> yearData) {
        int profit = 0;
        for (int i = 0; i < yearData.size(); i++) {
            YearlyReport.YearlyReportRecord record = yearData.get(i);
            if (record.isExpense){
                dataExpense.put(record.month, record.amount);
            } else {
                dataIncome.put(record.month, record.amount);
            }
            if(!(dataExpense.get(record.month) == null) && !(dataIncome.get(record.month) == null)) {
                profit = dataIncome.get(record.month) - dataExpense.get(record.month);
                System.out.println("В месяце " + statisticMonth.monthName(record.month) + " прибыль составила: " + profit);
            }
        }
    }
    public void printAverageIncomeAndExpense(HashMap<Integer, Integer> dataIncome, HashMap<Integer, Integer> dataExpense) {
        double averageIncome = 0;
        int sumIncome = 0;
        for(Integer income : dataIncome.values()){
            sumIncome += income;
        }
        averageIncome = sumIncome / dataIncome.size();
        System.out.println("Средний доход за все месяцы в году: "+ averageIncome);

        double avarageExpense = 0;
        int sumExpense = 0;
        for(Integer expense : dataExpense.values()) {
            sumExpense += expense;
        }
        avarageExpense = sumExpense / dataExpense.size();
        System.out.println("Средний расход за все месяцы в году: " + avarageExpense);
    }
}
