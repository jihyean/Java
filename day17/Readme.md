## 오전 9:14 2023-05-25

# VO가 2개 이상
회원 데이터
상품 데이터
좋아요 목록
리뷰 데이터
문의

C->M->V
회원가입

C->V->M
회원목록출력

V->M->C
상품목록출력

M->V->C
목록 검색 


// DAO가 아니라 View에서 접근해도 된다
// VO는 자료형 수행주체가 아님


실습) 목록 검색_가격으로 검색
   a) 버튼 입력시 가장 비싼 상품 출력	one	입력 없음
   b) 버튼 입력시 가장 싼 상품 출력	one	입력 없음
   c) 가격 입력시 해당 금액보다 비싼 상품들 출력	All 가격 1개
   d) 가격 입력시 해당 금액보다 싼 상품들 출력		All 가격 1개
   e) 가격을 2번 입력시 금액이 a ~ b까지의 상품들 출력	All 가격2개
      => 필터 검색 ★
