package Model;

import java.util.ArrayList;

public class Client {
    private String name;
    private ArrayList<Integer> inventory;

    private int cardId;
    private int cardBalance; // default 100만원 카드잔액 : 카드결제 시 사용
    private int cash; // default 5만원 현금 : 현금결제 시 사용
    private int point; // default = 0, 포인트 : 포인트결제 시 사용
    private int coupon; // default = 1, 쿠폰 : 할인 시 적용

    public Client(String name){
        this.name = name;
        this.inventory = new ArrayList<Integer>();
        this.cardId = 1;
        this.cardBalance = 1000000;
        this.cash = 50000;
        this.point = 0;
        this.coupon = 1;
    }

    // getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Integer> inventory) {
        this.inventory = inventory;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(int cardBalance) {
        this.cardBalance = cardBalance;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getCoupon() {
        return coupon;
    }

    public void setCoupon(int coupon) {
        this.coupon = coupon;
    }

    public String toString(){
        return name + "님의 현재 정보: \n\t현금: " + cash + "\n\t카드잔액: " + cardBalance +
                "\n\t포인트: " + point + "\n\tCoupon 개수: " + coupon + "\n\t소지품 : " + inventory;
    }

    private boolean flag;

    public void clientPay(String payMehtod, String menuName, int price){
        flag = false;
        switch (payMehtod){
            case "카드결제":
                cardPay(menuName, price);
                break;
            case "현금결제":
                cashPay(menuName, price);
                break;
            case "포인트결제":
                pointPay(menuName, price);
                break;
        }
        if(flag == true) {
            saveCoupon();
        }
    }

    public void cardPay(String menuName, int price ){
        if(getCardBalance()>= price){
            setCardBalance(getCardBalance() - price);
            savePoint(price);
            flag = true;
        }
        else{
            System.out.println("카드 잔액이 부족합니다.");
        }
    }
    public void cashPay(String menuName, int price){
        if(getCash()>= price){
            setCash(getCash() - price);
            savePoint(price);
            flag = true;
        }
        else{
            System.out.println("현금이 부족합니다.");
        }
    }
    
    public void couponUsePay(){
        setCoupon(getCoupon() - 1);
    }

    public void pointPay(String menuName, int price){ // 포인트로 결제 시 포인트 적립이 안된다.
        if(getPoint()>= price){
            setPoint(getPoint() - price);
            flag = true;
        }
        else{
            System.out.println("포인트가 부족합니다.");
        }
    }
    public void savePoint(int price){
        int pointCalculator = price / 2;
        setPoint(getPoint() + pointCalculator);
    }
    public void saveCoupon(){
        setCoupon(getCoupon()+1);
    }
}
