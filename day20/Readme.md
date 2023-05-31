## 오전 9:12 2023-05-31

협업
MVC

# 웹크롤링
	> 코드 분석
	> 데이터 가공
	> 문서화
		: 예시 블로그

스크랩핑
	인터넷상에 존재하는 데이터를
	프로그램을 이용하여 자동화된 방법으로
	수집하는 작업

유효한 정보로 '가공'
		: 크롤링
		: 수집한 데티터들을 분류하여 별도로 저장하는 작업

파싱	유효한 정보로 '가공'하는 작업
	데이터를 이용할 형식에 맞게 추출하여
	의미있는 값으로 변형하는 작업

=> 대충 크롤링

웹크롤링

내가 웹 브라우저로 보는 화면을
웹페이지라고 부름
코드롤 작성한 페이지를 브라우저로 출력한 결과이기 때문에
		==console
		==GUI
		(아이콘, 마우스 활용)

HTML
<!DOCTYPE HTML>
이 문서는 html 문서이다

HTML: 대소문자 구분 없음
	마크업 ---> 태그 언어 <>
	<> </>
	요소(element)

alt 속성(property) ---> 스크린리더가 읽음
	웹 표준 접근성 지침을 준수하는 속성
	-> 남녀노소 모두가 차별없이 웹페이지를 잘 이용할 수 있게
	코더는 페이지를 작성하여 제공해야 한다
 : alt를 사용하지 않아도 페이지 구성 자체에는 문제가 없으나
	스크린리더와 같은 보조기구를 활용하는 사람들에게는 제공 자체가 안됨


CSS : 코드를 작성해두면
	페이지의 스타일에 변화를 줄 수 있는 언어

웹의 요청 흐름
사용자(Client, 브라우저)가 버튼을 통해 요청(request)을 함
해당 요청은 URL에 표시

https://comic.naver.com/webtoon/list?titleId=799267
프로토콜://서버(도메인)/위치/위치?변수명=값&변수명=값&변수명=값&변수명=값&......
	00서버 XX위치에서 요청

(URL로 직접 요청이 가능함)
: 서버는 요청이 무엇인지 확인하여 사용자에게 응답할 준비를 함
	VCMDBMCV
: 받은 데이터 화면에 응답(response)

400대 에러
	클라이언트 에러(사용자 특 에러)
	404 없거나 권한이 없음
	> try catch

500대 에러
	서버 에러
	500 코드 예외가 발생한 경우
		NPE 80%


자바 사용자 console 입력
V C M C V console 출력

라이브러리
	: 자바 코드 묶음(.jar)
	: 미리 구현한 코드를 제공하는 파일
	: 라이브러리 분석XXX
	: 잘 활용

웹 크롤링
 => 샘플데이터














	
#container > div.component_wrap.type2 > div.WeekdayMainView__daily_all_wrap--UvRFc > div:nth-child(5) > ul > li:nth-child(6) > div > a > span > span
#container > div.component_wrap.type2 > div.WeekdayMainView__daily_all_wrap--UvRFc > div:nth-child(5) > ul > li:nth-child(6) > div > a > span > span
#content > div:nth-child(1) > ul > li:nth-child(1) > a > div > img
//*[@id="container"]/div[3]/div[2]/div[5]/ul/li[6]/div/a/span/span


<div class="NJU16b">바빌론</div>

<p title="범죄도시3" class="tit">범죄도시3</p>
#movieList > li:nth-child(1) > div.tit-area > p.tit




<p title="범죄도시3" class="tit">범죄도시3</p>

#movieList > li:nth-child(1) > div.tit-area > p.tit
document.querySelector("#movieList > li:nth-child(1) > div.tit-area > p.tit")
//*[@id="movieList"]/li[1]/div[2]/p[2]

div.movie-list-info

#contents > div.wrap-movie-chart > div.sect-movie-chart > ol:nth-child(2) > li:nth-child(1) > div.box-contents > div > strong > span



<em data-v-44509aec="">426,550</em>
#prod-detail-recommend > div > div.recommend-widget__list > ul:nth-child(1) > li:nth-child(1) > div > div > a > div.descriptions > div.price-info > span > em
//*[@id="prod-detail-recommend"]/div/div[2]/ul[1]/li[1]/div/div/a/div[2]/div[2]/span/em



















254
//*[@id="ct"]/div[2]/div[2]/ul/li[2]/a/div[1]/span/text()

#ct > div.press_ranking_home > div:nth-child(3) > ul > li:nth-child(2) > a > div.list_content > span > span
//*[@id="ct"]/div[2]/div[2]/ul/li[2]/a/div[1]/span/span
//*[@id="ct"]/div[2]/div[2]/ul/li[2]/a/div[1]/span/text()











	

