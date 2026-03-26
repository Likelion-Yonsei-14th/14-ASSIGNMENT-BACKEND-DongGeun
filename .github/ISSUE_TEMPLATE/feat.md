---
name: feat issue template 
about: feat 템플릿입니다.
title: '[FEAT] 제목 작성'
labels: feat
assignees: ''
---

## 🧩 기능/작업 설명
- 어떤 기능을 개발하는지 한 줄로 설명

ex)
- 상품 생성 API 구현

---

## 🎯 작업 목적 (Why)
- 왜 이 기능이 필요한지
- 어떤 문제를 해결하는지

ex)
- 상품 등록 기능이 없어 관리자 기능이 동작하지 않음
- API 구조 통일 필요

---

## 🧱 작업 범위 (Scope)
- 어디까지 구현하는지 명확히 작성 (과도한 확장 방지)

ex)
- 상품 생성 API (POST /items)
- DB 저장까지 포함
- 응답 DTO 반환까지

❌ 제외
- 상품 수정 기능
- 이미지 업로드

---

## 🛠️ 작업 목록 (Checklist)
- 구현해야 할 작업들을 체크리스트 형태로 작성

- [ ] API 엔드포인트 설계
- [ ] Request DTO 정의
- [ ] Response DTO 정의
- [ ] Service 로직 구현
- [ ] Repository(DB) 연동
- [ ] Validation 적용
- [ ] 테스트 코드 작성

---

## 🛠️ 구현 상세 (How)

### 1. API 설계
- Method: POST
- URL: /items

### 2. Request
```json
{
  "name": "상품명",
  "price": 10000
}

### 3. Response (선택)
{
  "id": 1,
  "name": "상품명",
  "price": 10000
}

---

## 🔗 참고 자료 (Optional)
<!-- 참고 링크, 문서 -->

---

## ⚠️ 고려 사항 (Optional)
<!-- 주의할 점 -->
ex) 
- price는 0 이상
- name은 null 불가