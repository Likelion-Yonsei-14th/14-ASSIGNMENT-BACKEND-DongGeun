---
name: fix template 
about: fix 템플릿입니다.
title: '[FIX] 제목 작성'
labels: fix
assignees: ''
---

## 🧩 기능/작업 설명
- 어떤 버그 또는 작업인지 간단히 설명

ex)
- 상품 생성 시 price가 음수여도 저장되는 문제 수정

---

## 🎯 작업 목적 (Why)
- 왜 이 작업이 필요한지
- 어떤 문제를 해결하는지

ex)
- 잘못된 데이터 저장을 방지하기 위함
- 서비스 데이터 무결성 유지

---

## 🧱 작업 범위 (Scope)
- 수정이 영향을 미치는 범위

ex)
- 상품 생성 API (POST /items)
- 상품 DTO 및 validation 로직
- DB 저장 로직

---

## 🛠️ 작업 목록 (Checklist)
- 수행해야 할 작업들을 체크리스트 형태로 작성

- [ ] DTO validation 추가
- [ ] Service 레벨 검증 로직 구현
- [ ] 예외 처리 로직 추가
- [ ] 테스트 코드 작성
- [ ] 기존 데이터 영향 여부 확인

---

## 🔍 버그 설명 (What)
- 발생한 문제를 구체적으로 설명

ex)
- price에 음수를 입력해도 validation 없이 DB에 저장됨
- 잘못된 데이터가 서비스에 노출될 가능성 있음

---

## 🔁 재현 방법 (Steps to Reproduce)
- 버그를 재현하는 단계

ex)
1. 상품 생성 API 요청
2. price를 -100으로 설정
3. 응답 확인

---

## 🤔 예상 결과 (Expected Behavior)
- 정상적으로 동작했을 경우 기대 결과

ex)
- price가 0 미만일 경우 예외 발생

---

## 🧨 실제 결과 (Actual Behavior)
- 실제로 발생한 결과

ex)
- price가 음수여도 정상적으로 저장됨

---

## 🛠️ 구현 상세 (How)
- 어떤 방식으로 문제를 해결할지 구체적으로 설명

ex)
- DTO에 @Min(0) validation 추가
- Service 레이어에서 추가 방어 로직 구현
- Global Exception Handler에서 validation 예외 처리
- 기존 API 응답 형식에 맞게 에러 응답 통일

---

## ⚠️ 고려사항
- 작업 시 주의할 점

ex)
- 기존 데이터 중 음수 price 존재 여부 확인 필요
- validation 추가로 인해 API 사용처 영향 검토
- 프론트와 에러 응답 포맷 사전 협의 필요

---

## 🔗 참고 자료 (Optional)
<!-- 참고 링크, 문서 -->