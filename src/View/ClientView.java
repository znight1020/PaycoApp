package View;
import Model.Store.Store;
import Model.Store.Product;
import Model.Client;

public class ClientView {
    Store store;
    Product product;
    Client client;

    public ClientView(Store store, Product product, Client client){
        setUpStoreView();
        setUpProductView();
    }
    void setUpStoreView(){
        System.out.println("홍길동 도매점 가게 오픈!!");
        System.out.println(store.toString());
    }
    void setUpProductView(){
        System.out.println("홍길동 도매점의 상품 준비중...");
        product.createProduct();
        System.out.println("상품 준비 완료...");
        System.out.println(product.toString());
    }
}
