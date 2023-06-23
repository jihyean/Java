## tmpPrice 라는 변수를 쓰는 이유

원래는 그냥 남는 인자에 값을 저장해서 보낸다
근데 프로그램의 기능이 많아질수록 어떤인자가 비어있고 써도 되는지 헷갈리며 쓸 수 있는 인자가 없을 수도 있다
또한 가독성이 떨어져 코드의 의도를 읽기 어려진다
그래서 새로운 변수를 만들어서 그냥 "인자 전달용", "기능 선택용"으로 사용
단, 이러한 변수들은 객체와 직접적 상관이 있지 않는다
즉, 객체와 무관 = 생성자에 쓰지 않는다
그래서 private 선언 후 getter setter로 값 지정한다
똑같이 pVO, mVO에 값을 넣어 전달하지만 생성자로 값을 초기화 하지 않는다는 차이가 있다