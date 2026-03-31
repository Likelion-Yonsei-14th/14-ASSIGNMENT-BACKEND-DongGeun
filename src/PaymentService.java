public class PaymentService {
    
    // 결제 처리 메서드
    public void pay(String type, int amount) {

        // 결제 정보를 담는 객체 생성
        Payment payment = new Payment(type, amount);

        // call checkValidAmount method
        if(!payment.checkValidAmount()) {
            System.out.println("금액이 올바르지 않습니다.");
            return;
        }
        
        // pay properly by the type of payment
        payment.payByType();
    }
}
