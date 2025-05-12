package oop.strategyTemplateObserver;

public class TemplateMethodPattern {

    public static void main(String[] args) {
        SalesReport sr = new SalesReport();
        sr.generate();
    }

}

abstract class ReportGenerator {
    public final void generate() {
        prepareData();
        formatData();
        export();
    }
    abstract void prepareData();
    abstract void formatData();
    void export() {
        System.out.println("PDF로 출력");
    }
}

class SalesReport extends ReportGenerator {
    void prepareData() {
        System.out.println("매출 데이터 준비");
    }
    void formatData() {
        System.out.println("테이블 형식 포맷팅");
    }
}
