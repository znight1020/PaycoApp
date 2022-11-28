package Model.Store;

public class Product {
    private String productName;
    private int price;

    private String productNames[];
    private int productPrices[];

    public Product(){
        createProduct();
    }
    public void createProduct() {
        productNames = new String[]{"티비", "냉장고", "노트북", "컴퓨터", "세탁기"};
        productPrices = new int[]{250000, 700000, 300000, 400000, 2500000};
    }
}
