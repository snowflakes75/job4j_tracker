package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport report1 = new TextReport();
        String text1 = report1.generate("Report's name", "Report's body");
        System.out.println(text1);

        System.out.println();

        HtmlReport report = new HtmlReport();
        String text = report.generate("Report's name", "Report's body");
        System.out.println(text);

        System.out.println();

        JSONReport report2 = new JSONReport();
        String text2 = report2.generate("name", "body");
        System.out.println(text2);
    }
}
