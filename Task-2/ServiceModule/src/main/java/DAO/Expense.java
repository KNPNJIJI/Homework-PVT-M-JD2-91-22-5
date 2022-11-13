package DAO;


import java.util.Scanner;

public class Expense {
    private int id;
    private String pay_date;
    private int receiver;
    private double amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPay_date() {
        return pay_date;
    }

    public void setPay_date(String pay_date) {
        this.pay_date = pay_date;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int  receiver) {
        this.receiver = receiver;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amountStr) {
        this.amount = amountStr;
    }
}
