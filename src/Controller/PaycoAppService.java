package Controller;
import Model.Store.Store;
import Model.Store.Product;
import Model.Client;
import View.ClientView;

public class PaycoAppService {
    Store store;
    Product product;
    Client client;
    ClientView cv;

    public PaycoAppService(){
        store = new Store("홍길동 도매점");
        product = new Product();
        client = new Client("이현수");
        cv = new ClientView(store, product, client);
    }
    
}
