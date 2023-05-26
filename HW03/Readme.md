## model

# VO
class ProductVO// 상품
생성자
변수
- 인스턴스 변수
PK int num
이름 String name
가격 int price
재고int cnt


//- 클래스 변수 : PK지정값 - DAO

getter setter
getNum()
getName()
getPrice()
getCnt()

toString() 오버라이딩


# DAO
class ProductDAO
private ArrayList<ProductVO> datas;
private static int PK = 1001;

생성자
public ProductDAO() {
	datas = new ArrayList<ProductVO>();
	// 기본 데이터 테스트용으로 추가
	// datas.add()
}

전부 ProductVO를 인자로 받는다
// 여러가지의 기능을 하나의 메서드에 작성
// 높은 응집도를 위해
// boolean 타입으로 리턴

- insert //create
public boolean insert(ProductVO pVO) {
	return true;
}
: 상품 생성 
이름 가격 재고 입력받아 상품 등록

- selectAll(getAll) //read
public ArrayList<ProductVO> selectAll(ProductVO pVO) {
	return true;
}
: 상품 전체 목록 출력
사용자 입력 없음 	> (pVO가 널이면)

: 상품 구매 내역 출력(장바구니) > (pVO.getNum()을 받아와서 해당 상품 정보 따로 저장하고 출력)

: 이름으로 검색
이름 입력값 받음 	> (pVO.getName()이 null이 아니면)
pVO.getName()이 포함된 상품들 출력

:가격 2개 입력 받아 범위 검색(필터 검색)
가격 입력 2개 	> (pVO.getName()이 "필터검색"이면)
		> (pVO.getPrice()와 pVO.getCnt()로 가격을 가져옴)

- selectOne(getOne) //read
public ProductVO selectOne(ProductVO pVO) {
}
//상품 검색 > 요구사항 없음


- update //update
public ProductVO update(ProductVO pVO) {
}
: 구매하기(재고 변경과 유사)
번호를 입력 받아서 해당 상품의 재고를 변경 > (pVO.getNum()으로 상품번호, pVO.getCnt 구매할 개수 가져옴)

: 상품 재고 변경 
번호를 입력 받아서 해당 상품의 재고를 변경 > (pVO.getNum()으로 상품번호, pVO.getCnt 구매할 개수 가져옴)

둘이 같은 기능이므로 View로 안내만 다르게
(어떤 상품의 번호를 받아서 입력받은 만큼 제거)
단, 재고변경은 +가 되나 구매는 재고가 -만 됩니다
구매하기 후 장바구니(목록 출력)

- delete //delete
public boolean delete(ProductVO pVO) {
}
: 상품삭제
번호를 입력 받아서 해당 상품 삭제 > (pVO.getNum()으로 번호 가져옴)



[ 기능 구현 순서 ]
VO

DAO
1.상품 추가
2.상품 전체 목록 출력
3.상품 삭제
4.상품 재고 변경
5. 상품 이름으로 검색
6.상품 범위 검색

주의사항
모든 변수는 private
상품 정보 출력 - toString() 오버라이딩
로그 작성
재고 등의 값 검사






