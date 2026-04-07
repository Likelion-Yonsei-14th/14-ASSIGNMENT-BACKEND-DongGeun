# 📌 결제 시스템 리팩토링 과제

## 🎯 과제 개요

기존의 결제 시스템 코드를 분석하고,
객체지향적으로 구조를 개선하는 것을 목표로 합니다

---

## 1️⃣ 기존 코드의 문제점

* encapsulation 위반
  - 외부에서 payment class의 field (type, amount) 접근 가능

* SRP (Single Responsibility Principle) 위반
  - PamentService class에서 amount의 유효성 확인, type에 따른 결제 확인 등
    여러 개의 로직이 한 번에 구현되고 있음
    > 추후에 class 내부를 수정해야할 때, 코드가 꼬일 수 있음
  - PaymentService class가 결제를 요청하는 역할만 수행하도록 구성


👉 (힌트: 캡슐화, 책임 분리, Service 역할 등을 중심으로 작성)

---

## 2️⃣ 로직 이동 내용

### 🔹 변경 전

* PaymentService class 내부에서 amount 관련 조건문 구현
* PaymentService class 내부에서 type 분류 및 결제 수행 조건문 구현

### 🔹 변경 후

* method 1 - checkValidAmount
  - Payment class 내부에 amount가 음수인지 판정하는 기능
  - amount의 유효값 조건이 추가/삭제될 시, Payment class 내의 해당 method만 수정하면 됨
    > PaymentService class에서는 amount가 유효한지, 아닌지만 판정하면 됨

* method 2 - payByType
  - Payment class 내부에 type에 따라 적절한 메시지를 띄우고 결제를 진행하거나,
    잘못된 타입인 경우 에러 메시지를 띄우는 기능
  - 새로운 type이 추가 혹은 삭제될 시, Payment class 내의 해당 method만 수정하면 됨
    > PaymentService class에서는 결제를 요청하는 기능만 구현
    > 로직 수정 시에는 Payment class를 수정하면 됨

👉 (어떤 로직을 어디로 옮겼는지 작성)

---

## 3️⃣ 구조 개선 내용

* encapsulation
  - 외부에서 payment class의 field에 직접 접근하지 못하도록 keyword : public -> private
  - constructor 도입

* SRP
  - amount의 유효성, type의 종류를 판별하고 결제 수행 혹은 에러 메시지를 띄우는 기능을
    Payment object가 직접 수행하도록 변경
  - PaymentService class는 오직 결제 요청 기능만 담당
  - 기능을 분리하여 내부 로직이 꼬이는 일을 사전에 방지


👉 (예: 객체가 직접 일을 하도록 변경, Service 단순화 등)


# 📌 3주차 객체지향 & DI 과제

## 1️⃣ 문제 상황 분석

다음과 같은 상황 가정

> “알림(Notification) 시스템을 만들고 있다.
> 
> 
> 현재는 이메일 알림만 지원하며,
> 
> 서비스 내부에서 EmailSender를 직접 생성해서 사용하고 있다.”
>

1. 이 구조의 문제점
  서비스가 EmailSender라는 하나의 구현체에 의존하고 있다.

2. 추후 SMS, 푸시 알림 등이 추가될 경우 발생할 문제
  SMS, 푸시 알림 서비스와 관련된 기존 구현체를 직접적으로 수정해야 한다.

---

## 2️⃣ 인터페이스 도입 이유

1. 알림 기능에 인터페이스를 도입하면 좋아지는 점
  인터페이스로 메서드의 규칙을 선언하기만 하고, 메서드의 기능 구현은 구현체 내부에서 이루어진다.
  따라서 확장이 더욱 용이해지게 된다.

2. 인터페이스만 도입했을 때도 여전히 남는 문제점
  구현체를 직접 생성하고 있으며, 비즈니스 로직이 구현체에 강하게 의존하고 있다.
  따라서 다른 구현으로 변경하려면 해당 객체를 생성하는 코드를 전부 수정해야 한다.

---

## 3️⃣ DIP & DI

1. DIP(의존성 역전 원칙)를 적용한다는 것이 무엇인지 설명하세요
  비즈니스 로직이 구현체에 의존하지 않고, 둘 다 추상화(인터페이스)에 의존하도록 설계하는 것이다. 


2. DI(의존성 주입)는 DIP를 어떻게 구현하는 방법인지 설명하세요
  DI는 객체가 직접 의존 객체를 생성하지 않고, 외부에서 의존성을 주입받도록 하는 방식

3. “객체를 직접 생성하는 방식”과 “DI 방식”의 차이를 설명하세요
| 구분     | 객체 직접 생성 방식       | DI 방식           |
| ------ | ----------------- | --------------- |
| 의존성 관리 | 내부에서 직접 생성        | 외부에서 주입         |
| 결합도    | 높음 (구현체 클래스 의존)    | 낮음 (인터페이스 의존)   |
| 확장성    | 구현 변경 시 코드 수정 필요  | 구현체만 교체하면 됨     |
| 책임 분리  | 생성 + 사용 모두 담당     | 생성과 사용 분리       |


---

## 4️⃣ 수동 DI 설계

다음 상황을 가정 :

> “우리는 알림 방식을 외부에서 선택할 수 있도록 구조를 변경하려고 한다.”
>

1. 어떤 클래스(또는 구성 요소)가 추가로 필요할지 작성하세요
  - 인터페이스 : NotificationSender
  - 구현체 : SmsSender, PushSender
  - AppConfig class (객체 생성 및 연결 담당)

2. 각 구성 요소의 역할을 설명하세요
  1) NotificationSender interface
  알림 전송 기능에 대한 공통 규약 정의하는 인터페이스로,
구현체들을 추상화하여 서비스가 구현에 의존하지 않도록 한다.

  2) 구현체 (SmsSender, PushSender)
  실제 알림 전송 로직을 담당하며, 각 알림 방식에 맞는 구체적인 기능을 수행한다.

  3) AppConfig (또는 설정 클래스)
  객체를 생성하고 의존성을 연결하는 역할을 한다.
  어떤 구현체를 사용할지 결정하고, 객체 생성 및 주입을 담당한다. (DI 수행)

3. 객체 생성과 의존성 연결은 어디서 이루어져야 하는지 설명하세요
  객체 생성과 의존성 연결은 비즈니스 로직 내부가 아닌 AppConfig에서 이루어져야 한다.
  AppConfig에서 구현체 선택(EmailSender 등)하고, 해당 객체를 생성한 후
  NotificationService 생성 시 주입하는 형태로 연결이 이루어진다.

---

## 5️⃣ Spring DI

1. 수동 DI 방식의 한계는 무엇인가요?
  1) 객체 관리의 복잡성 증가
  객체 수가 많아질수록 AppConfig가 비대해진다.
  결과적으로 코드가 복잡해지고 유지보수가 어려워진다.

  2) 확장 시 설정 코드 수정 필요
  새로운 구현체 추가 시 설정 코드도 함께 수정해야 한다.

  3) 공통 기능 처리의 어려움
  객체 생성 과정에서 공통적으로 필요한 처리 (로깅, 트랜잭션 등)를 적용하기 어렵다.

2. Spring을 사용하면 어떤 점이 해결되나요?
  1) 객체(Bean)가 싱글톤으로 관리
  수동 DI의 경우 DI 과정에서 새로운 객체가 계속 생겨난다.
    -> 메모리 낭비, 같은 객체 상태 보장 안 됨
  Spring을 사용하면 자동 DI를 통해 spring container가 이 객체 하나만 만들고 
  계속 재사용한다.

  2) 객체 생성 및 관리 자동화
  Spring container가 생성, 주입, 재사용, 소멸 등 객체 생명 주기를 관리한다.

  3) 확장성
  Spring의 다양한 기능과 연동되어 확장할 수 있다.

3. @Configuration, @Bean, @ComponentScan의 역할을 각각 설명하세요

  1) @Configuration
    - 설정 클래스(AppConfig) 임을 나타내는 annotation
    - Spring이 해당 class를 설정 정보로 인식
    - 내부에서 객체 생성 및 DI 설정 수행

  2) @Bean
    - 메서드의 반환 객체를 스프링 컨테이너에 등록
    - 개발자가 직접 생성한 객체를 Bean으로 관리
    - Spring container에서 객체 관리

  3) @ComponentScan
    - 지정한 패키지 하의 모든 파일을 스캔
    - @Component, @Service, @Repository, @Controller 등이 붙은 class를 자동으로 Bean으로 등록
    - 개발자가 일일이 @Bean으로 등록하지 않아도 됨
