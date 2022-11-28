package View;
import Model.Store.Store;
import Model.Store.Product;
import Model.Client;
public class PaycoApp {
    Store store;
    Product product;
    Client client;

    public PaycoApp(){
        store = new Store("홍길동 도매점");
        setUpStore();

        product = new Product();
        setUpProductView();

        client = new Client("이현수");


    }
    void setUpStore(){
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
