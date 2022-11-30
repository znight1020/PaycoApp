package View;
import Model.Store.Store;
import Model.Store.Product;
import Model.Store.Seller;
import Model.Client;

public class ClientView {
    public ClientView(){
    }
    public void setup(Seller seller, Store store, Product product){
        setUpSellerView(seller);
        setUpStoreView(store);
        setUpProductView(product);
    }
    public void setUpStoreView(Store store){
        System.out.println("홍길동 도매점 가게 오픈!!");
        System.out.println(store.toString()+"\n");
    }
    public void setUpProductView(Product product){
        System.out.println("홍길동 도매점의 상품 준비중...");
        product.createProduct();
        System.out.println("상품 준비 완료...\n");
    }
    public void setUpSellerView(Seller seller){
        System.out.print("점원 출근 완료...  ");
        System.out.println(seller.toString() +"\n");
    }
    public void checkMenu(Product product){
        System.out.print("홍길동 도매점에 오신 것을 환영합니다.\n"+ product.toString() + "\n주문하실 상품의 이름을 입력해주세요: ");
    }


    public void serviceView(){
        System.out.print("1.홍길동 도매점 방문\t2.계좌 송금\t3.나의 프로필 조회\t4.계좌 입금\t5.해당가게 정보\t6.종료\n어떤 작업을 수행하시겠습니까(번호입력): ");
    }
    public void paySuccessView(){
        System.out.println("결제가 완료되었습니다. 포인트와 쿠폰을 적립해드리겠습니다.");
    }
    public void pointPaySuccessView(){
        System.out.println("결제가 완료되었습니다.");
    }
    public void couponUseSuccessView(){
        System.out.println("쿠폰 10개를 사용하여 결제가 완료되었습니다. 쿠폰 결제 시 포인트와 쿠폰 적립은 되지않습니다.");
    }
    public void payFailView(){
        System.out.print("상품을 구매하는데 실패하였습니다. 잔액이 부족합니다.");
    }
    public void couponUseFailView(){
        System.out.println("상품을 구매하는데 실패하였습니다. 쿠폰이 10개인지 확인해주세요.");
    }

    public void afterRemitCardBalanceView(Client client1, Client client2){ System.out.println("송금이 완료되었습니다. 현재 " +
            client1.getName() + "님의 카드잔액은 " + client1.getCardBalance() +"이고, "
            + client2.getName() + "님의 카드잔액은 " + client2.getCardBalance() + "입니다.");}

    public void CardBalanceView(Client client) {
            System.out.print("현재 고객님의 카드잔액은 " + client.getCardBalance() + "원 입니다.");
    }

    public void storeInfoView(Store store){
        System.out.println(store.toString());
    }
}
