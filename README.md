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
