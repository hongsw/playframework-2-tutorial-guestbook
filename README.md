Title:  Guestbook Tutorial of Play 2.0 Framework  
Author: Seungwoo Hong
Date:   Nov 12, 2012  

Play! 2.0 Framework Tutorial - Guestbook
==================================

월간) 2013월 마이크로소프트 1월호 : Play! 2.0 프레임워크 - 방명록 투토리얼
---------------------------

### 투토리얼 레벨
자바를 어느정도 이해하고 있으며, 이클립스 및 개발 환경 구축에 문제가 없는 사람에 맞추어서 작성되었습니다.
또한, Git사용에 불편함이 없는 사람이면 추가 적인 개발에 도움이 많이 될듯 합니다.

### 추천하는 개발환경 구축하기
1. 자바 5.0 이상 8.0 이하 
> Play 프레임워크는 2.2버전에서 자바 8.0을 지원한다.
> [로드맵](https://docs.google.com/document/d/1OEt6gZ3a-daSkNXqXGAM4jBs5LtuDkLZIzsWN9aeM1g/preview?sle=true "roadmap") 참조 
2. 이클립스 최신 버전
> [Eclipse](http://www.eclipse.org/downloads/ ) 참조 
> [Setup and use Play framework 2.0 in Scala IDE 2.0](http://scala-ide.org/docs/tutorials/play20scalaide20/index.html "Setup and use Play framework 2.0 in Scala IDE 2.0") 참조 
3. 가벼운 개발환경을 원한다면, subline 과 play2.0 plugin
> [Sublime Text 2](http://www.sublimetext.com/2 "Sublime Text 2")
> Preference, Package Control, Install Package, type "play" 


  
Tutorial : 방명록(Guestbook)의 기능 요구사항 정리
---------------------------
1. 메인페이지에서 방명록의 리스트를 볼수 있다. 
2. 방명록 작성시 이름, 이메일주소, 내용, 비밀번호을 작성할 수 있다. 
3. 방명록은 자동 생성된 ID를 기준으로 읽을 수 있다.
4. 방명록은 등록시 입력한 비밀번호를 확인후 삭제를 한다.
2단계에서 진행할예정



### 참조 링크
1. [Scala API - template helper] (http://www.playframework.org/documentation/api/2.0/scala/views/html/helper/package.html "helper doc")
1. [Setup and use Play framework 2.0 in Scala IDE 2.0] (http://scala-ide.org/docs/tutorials/play20scalaide20/index.html)
