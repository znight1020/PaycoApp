package Model.Store;

public class Store {
    private String StoreName; // 가게 이름
    private int StoreRevenue; // 가게 수익
    private int sellCount; // 판매량

    public Store(String StoreName){
        this.StoreName = StoreName;
        this.StoreRevenue = 0;
        this.sellCount = 0;
    }

    public String getStoreName() {
        return StoreName;
    }

    public void setStoreName(String storeName) {
        StoreName = storeName;
    }

    public int getStoreRevenue() {
        return StoreRevenue;
    }

    public void setStoreRevenue(int storeRevenue) {
        StoreRevenue = storeRevenue;
    }

    public int getSellCount() {
        return sellCount;
    }

    public void setSellCount(int sellCount) {
        this.sellCount = sellCount;
    }

    @Override
    public String toString() {
        return "현재 가게 정보: 금일 가게 매출 = " + StoreRevenue + ", 판매량 = " + sellCount;
    }
}
