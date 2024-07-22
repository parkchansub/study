JPA(자바 ORM 표준 JPA 프로그래밍 - 기본편(인프런))
=================

### SQL 중심적인 개발의 문제점

- 관계형 DB 사용시 sql에 의존적인 개발 피하기 어렵다
- 패러다임의 불일치 - 객체 vs 관계형 DB
  - 객체 -> sql 변환 -> SQL(RDB)관계형 DB
  - 계층형 아키텍처 진정한 의미의 계층 분할이 어렵다
  - 객체와 관계형 데이터베이스 차이
    - 상속
        - 관계형 DB에서 상속 된 하위 객체를 select, insert, update 할 경우 1번에 작업이 아닌 2번 이상의 동작으로 해당 객체에 접근하여 작업을 진행 해야 한다.
    - 연관관계
        - 객체는 참조를 사용 ex) member.getTeam()
        - 테이블은 외래 키를 사용 ex) join on m.team_id = t.team_id
        - 객체 지향 관계는 단방향 / 관계형 DB는 양방향 접근이 가능
    - 데이터 타입
    - 데이터 식별 방법

### JPA 소개

- JAVA Persistence API 
- 자바 진영의 ORM 기술 표준
- JPA는 인터페이스의 모음
- ORM
    - Object-relational mapping(객체 관계 매핑)
    - 객체는 객체대로 설계
    - 관계형 DB 는 관계형 DB대로 설계
    - ORM 프레임 워크가 중간에서 매핑
    - 대중적인 언어에는 대부분 ORM 기술이 존재
- JPA 사용해야 하는 이유
    - sql 중심적인 개발에서 객체 중심
    - 생산성
        - 저장 : jpa.persist(member)
        - 조회 : Member member = jpa.find(memberId)
        - 수정 : member.setName("변경할이름")
        - 삭제 : jpa.remove(member)
    - 유지보수
    - 패러다임 불일치 해결
        - JPA와 상속
            - jpa.persist(album)
            - insert into ITEM / insert into ALBUM
        - JPA와 연관관계
        - JPA와 객체 그래프 탐색
        - JPA와 비교하기
    - 성능
        - 1차 캐시와 동일성(identity) 보장
        <pre>
        <code>
        string memeberId = "100"
        Member m1 = jpa.find(Member.class, memberId) // SQL
        Member m2 = jpa.find(Member.class, memberId) // transaction 캐시
        println(m1 == m2) - sql 1번만 실행 캐시에 값을 반환함
        </code>
        </pre>
        - 트랜잭션을 지원하는 쓰기 지연(transactional write-behind)
        - 지연 로딩(Lazy Loading) / 즉시 로딩 (JPA 옵션으로 설정 가능)
            <pre>
                <code>
                 //지연로딩 : 객체가 실제 사용될 떄 로딩
                 Member member = memberDAO.find(memeberId);     //select * from MEMBER
                 Team team = member.getTeam();                  
                 String teamName = team.getName();              //select * from TEAM
                </code>
            </pre>
            <pre>
                <code>
                 //즉시로딩 : join sql로 한번에 연관된 객체까지 미리 조회
                 Member member = memberDAO.find(memeberId);     //select M.* , T.* from MEMBER join TEAM...
                 Team team = member.getTeam();                  
                 String teamName = team.getName();              
                 </code>
            </pre>
    - 데이터 접근 추상화와 벤더 독립성
    - 표준
    
 
   
    
  
