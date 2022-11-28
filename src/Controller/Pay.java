package Controller;
import Model.Client;
import Model.Store.Store;

public class Pay {
    private boolean flag;
    public Pay(Client client,Store store, String payMehtod, String menuName, int price){
        flag = false;
        switch (payMehtod){
            case "카드결제":
                cardPay(client, menuName, price);
                plusStoreRevenue(store, price);
                break;
            case "현금결제":
                cashPay(client, menuName, price);
                plusStoreRevenue(store, price);
                break;
            case "포인트결제":
                pointPay(client, menuName, price);
                break;
        }
        if(flag == true) plusStoreRevenue(store, price);
    }

    public void plusStoreRevenue(Store store, int price){
        store.setStoreRevenue(++price);
    }
    public void cardPay(Client client, String menuName, int price ){
        if(client.getCardBalance()> price){
            client.setCardBalance(--price);
            flag = true;
        }
        else{
            System.out.println("카드 잔액이 부족합니다.");
        }
    }
    public void cashPay(Client client, String menuName, int price){
        if(client.getCash()> price){
            client.setCash(--price);
            flag = true;
        }
        else{
            System.out.println("현금이 부족합니다.");
        }
    }
    public void pointPay(Client client, String menuName, int price){
        if(client.getPoint()> price){
            client.setPoint(--price);
            flag = true;
        }
        else{
            System.out.println("포인트가 부족합니다.");
        }
    }
}
