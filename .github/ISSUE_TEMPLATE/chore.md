---
name: chore issue template 
about: chore 템플릿입니다.
title: '[CHORE] 제목 작성'
labels: chore
assignees: ''
---

## 🧩 기능/작업 설명
- 어떤 설정/기타 작업인지 한 줄로 설명

ex)
- 프로젝트 초기 설정 및 eslint, prettier 적용

---

## 🎯 작업 목적 (Why)
- 왜 이 작업이 필요한지
- 어떤 문제를 해결하는지

ex)
- 코드 스타일 통일을 위해 lint 설정 필요  
- 개발 환경 표준화를 통해 협업 효율 향상

---

## 🧱 작업 범위 (Scope)
- 어디까지 작업하는지 명확히 작성 (과도한 확장 방지)

ex)
- eslint, prettier 설정 적용
- 프로젝트 기본 디렉토리 구조 정리
- 공통 개발 환경 설정

❌ 제외
- 비즈니스 로직 구현
- 신규 기능 개발

---

## 🛠️ 작업 목록 (Checklist)
- 수행해야 할 작업들을 체크리스트 형태로 작성

- [ ] eslint 설정 파일 추가
- [ ] prettier 설정 적용
- [ ] husky 및 pre-commit hook 설정
- [ ] 환경 변수 구성
- [ ] 프로젝트 구조 정리
- [ ] 의존성 설치 및 정리
- [ ] CI/CD 설정 (필요 시)
- [ ] 관련 문서 업데이트

---

## 🛠️ 구현 상세 (How)

### 1. 설정 대상

ex)
- eslint
- prettier
- husky

### 2. 주요 내용

ex)
- eslint rule 정의 및 커스터마이징
- prettier formatting 규칙 설정
- pre-commit hook으로 lint 자동 실행

---

## ⚠️ 고려사항
- 작업 시 주의할 점

ex)
- 기존 코드와 lint 규칙 충돌 여부 확인
- 팀 컨벤션과 일관성 유지
- 불필요한 의존성 추가 방지
- 환경별 설정(dev/prod) 분리 고려

---

## 🔗 참고 자료 (Optional)
<!-- 참고 링크, 문서 -->