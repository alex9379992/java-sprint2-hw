import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
    ArrayList<YearlyReportRecord> yearData;

     YearlyReport(){
       yearData = new ArrayList<>();
    }

    class YearlyReportRecord {
        int month;
        int amount;
        boolean isExpense;

        public YearlyReportRecord(int month, int amount, boolean isExpense) {
            this.month = month;
            this.amount = amount;
            this.isExpense = isExpense;
        }
    }
    public void yearlyReading() {
        ArrayList<YearlyReportRecord> record = new ArrayList<>();
        FileReader fileReader = new FileReader();
        int month = 0;
        int amount = 0;
        boolean isExpense = false;
        String content = fileReader.readFileContentsOrNull("resources/y.2021.csv");
        String[] lines = content.split("\n");
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i].trim();
            String[] lineContents = line.split(",");
            month = Integer.parseInt(lineContents[0]);
            amount = Integer.parseInt(lineContents[1]);
            isExpense = Boolean.parseBoolean(lineContents[2]);
            YearlyReportRecord yearlyReportRecord = new YearlyReportRecord(month, amount, isExpense);
            yearData.add(yearlyReportRecord);
        }
        System.out.println("Данные годового отчета сохранены.");
    }
}


