package Model;

import java.util.ArrayList;

public class Client {
    private static ArrayList<Client> clientGroup = new ArrayList<Client>();
    private String name;
    private ArrayList<String> inventory;

    private int cardId;
    private int cardBalance; // default 100만원 카드잔액 : 카드결제 시 사용
    private int cash; // default 5만원 현금 : 현금결제 시 사용
    private int point; // default = 0, 포인트 : 포인트결제 시 사용
    private int coupon; // default = 1, 쿠폰 : 할인 시 적용

    public Client(String name){
        this.name = name;
        this.inventory = new ArrayList<String>();
        this.cardId = 1;
        this.cardBalance = 1000000;
        this.cash = 50000;
        this.point = 1000;
        this.coupon = 0;
    }

    // getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getInventory() {
        return inventory;
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



    public void addClient(Client client){
        clientGroup.add(client);
    }




    private boolean flag;
    public boolean clientPay(String payMethod, int price, String productName){
        switch (payMethod){
            case "카드":
                cardPay(price, productName);
                break;
            case "현금":
                cashPay(price, productName);
                break;
            case "포인트":
                pointPay(price, productName);
                break;
            case "쿠폰":
                couponUsePay(productName);
                break;
        }
        return flag;
    }
    public boolean cardPay(int price, String productName){
        if(getCardBalance()>= price){
            flag = true;
            setCardBalance(getCardBalance() - price);
            savePoint(price);
            saveCoupon();
            addInventory(productName);
        }
        else{
            flag = false;
        }
        return flag;
    }
    public void cashPay(int price, String productName){
        if(getCash()>= price){
            flag = true;
            setCash(getCash() - price);
            savePoint(price);
            saveCoupon();
            addInventory(productName);
        }
        else{
            flag = false;
        }
    }
    public void pointPay(int price, String productName){ // 포인트로 결제 시 포인트, 쿠폰 적립이 안된다.
        if(getPoint()>= price){
            flag = true;
            setPoint(getPoint() - price);
            addInventory(productName);
        }
        else{
            flag = false;
        }
    }
    public void couponUsePay(String productName){
        if(coupon >= 10){
            setCoupon(getCoupon() - 10);
            addInventory(productName);
            flag = true;
        }
        else{
            flag = false;
        }

    }

    public void savePoint(int price){
        int pointCalculator = price / 20;
        setPoint(getPoint() + pointCalculator);
    }
    public void saveCoupon(){
        setCoupon(getCoupon()+1);
    }
    public void addInventory(String productName){
        inventory.add(productName);
    }

    public boolean isNameOfClientGroup(String targetName){
        for(int i = 0; i < clientGroup.size(); i++){
            if(clientGroup.get(i).getName().equals(targetName)) {
                return true;
            }
        }
        return false;
    }
    public boolean remit(int money, Client client1, Client client2){
        if(client1.getCardBalance() >= money){
            client1.setCardBalance(client1.getCardBalance() - money);
            client2.setCardBalance(client2.getCardBalance() + money);
            return true;
        }
        return false;
    }
    public String inventoryToString(){
        String inventoryStr = "";
        for(int i = 0; i < inventory.size(); i++){
            inventoryStr += " " + inventory.get(i);
        }
        return inventoryStr;
    }

    public String toString(){
        return name + "님의 현재 정보: \n\t현금: " + cash + "\n\t카드잔액: " + cardBalance +
                "\n\t포인트: " + point + "\n\tCoupon 개수: " + coupon + "\n\t소지품 : " + inventoryToString();
    }
}
