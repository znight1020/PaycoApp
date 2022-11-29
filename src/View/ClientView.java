package View;
import Model.Store.Store;
import Model.Store.Product;
import Model.Store.Seller;
import Model.Client;

public class ClientView {
    public ClientView(Seller seller, Store store, Product product, Client client){
        setUpSeller(seller);
        setUpStoreView(store);
        setUpProductView(product);

    }
    void setUpStoreView(Store store){
        System.out.println("홍길동 도매점 가게 오픈!!");
        System.out.println(store.toString());
    }
    void setUpProductView(Product product){
        System.out.println("홍길동 도매점의 상품 준비중...");
        product.createProduct();
        System.out.println("상품 준비 완료...");
        System.out.println(product.toString());
    }
    void setUpSeller(Seller seller){
        System.out.println("점원 출근 완료...");
        System.out.println(seller.toString());
    }
}
