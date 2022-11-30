package Controller;
import Model.Store.Seller;
import Model.Store.Store;
import Model.Store.Product;
import Model.Client;
import View.ClientView;

import java.util.Scanner;

public class PaycoAppService {
    Scanner scan = new Scanner(System.in);
    Seller seller;
    Store store;
    Product product;
    Client client;
    Client testClient;
    ClientView cv = new ClientView();

    public PaycoAppService(){
        store = new Store("홍길동 도매점");
        seller = new Seller("임꺽정",store);
        product = new Product();

        client = new Client("이현수");
        testClient = new Client("아무개");
        client.addClient(client);
        testClient.addClient(testClient);

        cv.setup(seller, store, product);
        service();
    }

    public void service(){
        boolean serviceFlag = true;
        while(serviceFlag){
            cv.serviceView();
            int exec;
            exec = scan.nextInt();
            switch (exec){
                case 1 :
                    visitStore();
                    break;
                case 2 :
                    accountSend();
                    break;
                case 3 :
                    infoLookUp();
                    break;
                case 4 :
                    deposit();
                    break;
                case 5 :
                    storeInfo();
                    break;
                case 6 :
                    exit();
                    serviceFlag = false;
            }
            System.out.println("\n");
        }
    }
    public void visitStore(){ // case 1 가맹점 방문
        String productName;
        String continueOrder;
        cv.checkMenu(product);
        productName = scan.next();
        int productPrice = product.isProduct(productName);
        if(productPrice > 0){
            System.out.print("주문하신 상품 " + productName + "의 가격은 " + productPrice +
                    "입니다. 어떤 결제를 진행 하시겠습니까?(카드/현금/포인트/쿠폰): ");

            continueOrder = scan.next();

            switch (continueOrder){
                case "카드":
                    if(client.clientPay("카드", productPrice, productName)){
                        cv.paySuccessView();
                        seller.payComplete(productPrice);
                    }
                    else cv.payFailView();
                    break;
                case "현금":
                    if(client.clientPay("현금", productPrice, productName)){
                        cv.paySuccessView();
                        seller.payComplete(productPrice);
                    }
                    else cv.payFailView();
                    break;
                case "포인트":
                    if(client.clientPay("포인트", productPrice, productName)) {
                        cv.pointPaySuccessView();
                        seller.plusSellCount(); // 구매자가 포인트와 쿠폰 사용으로 구매할 시 판매량은 올라가지만 매출에는 변화가 없음
                    }
                    else cv.payFailView();
                    break;
                case "쿠폰":
                    if(client.clientPay("쿠폰", productPrice, productName)) {
                        cv.couponUseSuccessView();
                        seller.plusSellCount();
                    }
                    else cv.couponUseFailView();
                    break;
            }

        }
        else{
            System.out.println("찾으시는 상품이 없습니다.");
        }
    }
    public void accountSend(){ // case 2 계좌 송금
        String targetName;
        int money;
        System.out.print("송금 할 상대방 이름 입력 : ");
        targetName = scan.next();

        if(client.isNameOfClientGroup(targetName)){ // 상대방이 있을 때
            System.out.print("송금 할 금액 입력 : ");
            money = scan.nextInt();

            if(client.remit(money, client, testClient) == true){ // 송금을 한다.
                cv.afterRemitCardBalanceView(client, testClient);
            }
            else{
                System.out.println("송금 실패하였습니다. 잔액을 확인해주세요.");
            }

        } else{
            System.out.println("송금 대상을 찾지 못하였습니다. 다시 한번 확인해주세요.");
        }
    }

    public void infoLookUp(){ // case 3 나의 프로필 조회
        System.out.println(client.toString());
    }
    public void exit(){ // case 4
        System.out.println("프로그램을 종료합니다...");
    }
    public void storeInfo(){
        cv.storeInfoView(store);
    }
    public void deposit(){
        cv.CardBalanceView(client);
        System.out.print(" 얼마를 입금하시겠습니까?");
        int depositMoney = scan.nextInt();
        client.setCardBalance(client.getCardBalance() + depositMoney);
        System.out.print("입금 후 ");
        cv.CardBalanceView(client);
    }
    
}
