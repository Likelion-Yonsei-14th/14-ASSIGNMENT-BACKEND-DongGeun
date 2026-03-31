public class Payment {
    // 결제 방식 (카드, 카카오페이 등)
    private String type;
    
    // 결제 금액
    private int amount;

    // constructor
    public Payment(String typeVal, int amountVal) {
        this.type = typeVal;
        this.amount = amountVal;
    }

    // method : check whether the amount value is valid
    public boolean checkValidAmount() {
        return amount > 0;
    }

    // private boolean checkValidType() {
    //     return (type.equals("card") || type.equals(type == "kakao"));
    // }

    // method : check the type of payment and pay properly
    public void payByType() {
        if (type.equals("card")) {
            System.out.println("카드 결제: " + amount);
        } else if (type.equals("kakao")) {
            System.out.println("카카오페이 결제: " + amount);
        } else {
            System.out.println("지원하지 않는 결제 방식");
        }
    }
}