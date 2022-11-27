package Model;

public class Store {
    private String StoreName; // 가게 이름
    private int StoreRevenue; // 가게 수익
    private int visitCount; // 팔린 물건 수

    public Store(String StoreName){
        this.StoreName = StoreName;
        this.StoreRevenue = 0;
        this.visitCount = 0;
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

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    @Override
    public String toString() {
        return "현재 가게 정보:\n\t금일 가게 매출: " + StoreRevenue +"\n\tvisitCount=" + visitCount;
    }
}
