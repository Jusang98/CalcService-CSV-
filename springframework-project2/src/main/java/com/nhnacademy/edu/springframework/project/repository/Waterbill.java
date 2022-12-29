package com.nhnacademy.edu.springframework.project.repository;

public class Waterbill {
    private final String city;
    private final String sector;
    private final int start;
    private final int finish;
    private int unitPrice;
    private int billTotal;


    public Waterbill(String city, String sector, int start, int finish, int unitPrice) {
        this.city = city;
        this.sector = sector;
        this.start = start;
        this.finish = finish;
        this.unitPrice = unitPrice;

    }
    public int getStart(){
        return start;
    }
    public int getFinish(){
        return finish;
    }
    public void setUnitPrice(){
        this.unitPrice = unitPrice;
    }
    public int getUnitPrice() {
        return unitPrice;
    }
    public void setBillTotal(int billTotal){
        this.billTotal = billTotal;
    }

    public int getBillTotal(){
        return billTotal;
    }
//    public boolean pass1(int i){
//        return (i<=this.start);
//    }
//    public boolean pass2(int i){
//        return (i>=this.finish);
//    }

    @Override
    public String toString() {
        return "city=" +city+
                "sector=" + sector +
                "utilPrice='" + unitPrice + '\'' +
                "billTotal=" + getBillTotal() +
                '}'+ '\n';
    }


}
