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
    public String toString(){
        String menu = "상품 리스트:\n\t----------------------------------------";
        for(int i = 0; i < productNames.length; i++){
            menu += "\n\t[상품 " + (i+1) + "의 정보] 이름: "+ productNames[i] + ", 가격 : " + productPrices[i] + "원";
        }
        menu +="\n\t----------------------------------------";

        return menu;
    }
}
