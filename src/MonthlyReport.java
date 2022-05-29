import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    HashMap<Integer, ArrayList<MonthlyReportRecord>> monthData;

    public MonthlyReport(){
        monthData = new HashMap<>();
    }

    static class MonthlyReportRecord {
        String itemName;
        boolean isExpense;
        int quantity;
        int sumOfOne;

        public MonthlyReportRecord(String itemName,boolean isExpense,int quantity,int sumOfOne){
            this.itemName = itemName;
            this.isExpense = isExpense;
            this.quantity = quantity;
            this.sumOfOne = sumOfOne;
        }
    }
    public void monthlyReading() {
            FileReader fileReader = new FileReader();
            for (int month = 1; month <= 3; month++) {
                ArrayList<MonthlyReportRecord> record = new ArrayList<>();

                String itemName = "";
                boolean isExpense = false;
                int quantity = 0;
                int sumOfOne = 0;
                String content = fileReader.readFileContentsOrNull("resources/m.20210" + month + ".csv");
                String[] lines = content.split("\n");
                for (int i = 1; i < lines.length; i++) {
                    String line = lines[i];
                    String[] lineContents = line.split(",");
                    itemName = lineContents[0];
                    isExpense = Boolean.parseBoolean(lineContents[1]);
                    quantity = Integer.parseInt(lineContents[2]);
                    sumOfOne = Integer.parseInt(lineContents[3]);
                    MonthlyReportRecord monthlyReportRecord = new MonthlyReportRecord(itemName, isExpense, quantity, sumOfOne);
                    record.add(monthlyReportRecord);
                }
                monthData.put(month, record);
            }
            System.out.println("Данные месячных отчетов сохранены.");
    }
}



