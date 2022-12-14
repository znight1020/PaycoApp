package Model.Store;

public class Product {
    private String productNames[];
    private int productPrices[];

    public Product(){
        createProduct();
    }
    public void createProduct() {
        productNames = new String[]{"티비", "냉장고", "노트북", "컴퓨터", "세탁기", "아메리카노"};
        productPrices = new int[]{250000, 700000, 300000, 400000, 2500000, 3000};
    }
    public String toString(){
        String menu = "상품 리스트:\n\t----------------------------------------";
        for(int i = 0; i < productNames.length; i++){
            menu += "\n\t[상품 " + (i+1) + "의 정보] 이름: "+ productNames[i] + ", 가격 : " + productPrices[i] + "원";
        }
        menu +="\n\t----------------------------------------";

        return menu;
    }
    public int isProduct(String productName){
        boolean flag = false;
        for(int i = 0; i < productNames.length; i++){
            if(productNames[i].equals(productName)) {
                return productPrices[i];
            }
        }
        return 0;
    }
}
