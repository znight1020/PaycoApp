package Model.Store;

public class Seller {
    public Seller(){
        
    }

    public void payComplete(){
        plusStoreRevenue();
        setsellCount();

    }
    

    public void plusStoreRevenue(Store store, int price){
        store.setStoreRevenue(store.getStoreRevenue() + price);
    }
}
