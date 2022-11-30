package Model.Store;

public class Seller {
    private String name;
    private Store store;
    public Seller(String name, Store store){
        this.name = name;
        this.store = store;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void payComplete(int price){
        plusStoreRevenue(price);
        plusSellCount();
    }


    public void plusStoreRevenue(int price)
    {
        store.setStoreRevenue(store.getStoreRevenue() + price);
    }
    public void plusSellCount(){
        store.setSellCount(store.getSellCount() + 1);
    }

    @Override
    public String toString() {
        return "점원 정보 : " + "이름 = " + name + ", 계약된 가게 = " + store.getStoreName();
    }
}