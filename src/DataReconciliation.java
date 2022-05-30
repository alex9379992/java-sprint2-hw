import java.util.ArrayList;
import java.util.HashMap;

public class DataReconciliation {
    StatisticMonth statisticMonth = new StatisticMonth();
    HashMap<Integer, Integer> sumProfitMonth;
    HashMap<Integer, Integer> sumExpenseMonth;
    HashMap<Integer, Integer> sumProfitYear;
    HashMap<Integer, Integer> sumExpenseYear;

    public void calculatingMonthlySum(HashMap<Integer, ArrayList<MonthlyReport.MonthlyReportRecord>> monthData) {

        sumProfitMonth = new HashMap<>();
        sumExpenseMonth = new HashMap<>();

        ArrayList<MonthlyReport.MonthlyReportRecord> listMonth;
        for (int month : monthData.keySet()) {
            int sumProfit = 0;
            int sumExpense = 0;
            listMonth = monthData.get(month);
            for (int i = 0; i < listMonth.size(); i++) {
                MonthlyReport.MonthlyReportRecord record = listMonth.get(i);
                if ( !record.isExpense) {
                    sumProfit += record.quantity * record.sumOfOne;
                } else {
                    sumExpense += record.quantity * record.sumOfOne;
                }
            }
            sumProfitMonth.put(month, sumProfit);
            sumExpenseMonth.put(month, sumExpense);
        }
    }
    public void calculatingYearly(ArrayList<YearlyReport.YearlyReportRecord> yearData) {
        sumProfitYear = new HashMap<>();
        sumExpenseYear = new HashMap<>();

        for (int i = 0; i < yearData.size(); i++) {
            YearlyReport.YearlyReportRecord record = yearData.get(i);
            if (record.isExpense) {
                sumExpenseYear.put(record.month, record.amount);
            } else {
                sumProfitYear.put(record.month, record.amount);
            }
        }
    }

    public void reconciliation(){
        boolean incongruity = false;
        for(Integer month : sumProfitMonth.keySet()) {
            if(!(sumProfitMonth.get(month).equals(sumProfitYear.get(month)))) {
                incongruity = true;
                 System.out.println("Обнаружено несоответствие! В месяце " +
                     statisticMonth.monthName(month) + " несоответствуют доходы.");
             }
        }
        for(Integer month : sumExpenseMonth.keySet()) {
             if(!(sumExpenseMonth.get(month).equals(sumExpenseYear.get(month)))) {
                 incongruity = true;
                 System.out.println("Обнаружено несоответствие! В месяце " +
                     statisticMonth.monthName(month) + " несоответствуют расходы.");
             }
        }
        if(!incongruity){
            System.out.println("Несоответсвий не обнаружено");
        }
    }
}

