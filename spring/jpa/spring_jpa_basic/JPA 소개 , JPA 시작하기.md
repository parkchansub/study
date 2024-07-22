JPA 소개 / JPA 시작하기
=================

### SQL 중심적인 개발의 문제점

- 관계형 DB 사용시 sql에 의존적인 개발 피하기 어렵다
- 패러다임의 불일치 - 객체 vs 관계형 DB
  - 객체 -> sql 변환 -> SQL(RDB)관계형 DB
  - 계층형 아키텍처 진정한 의미의 계층 분할이 어렵다
  - 객체와 관계형 데이터베이스 차이
    - 상속
    - 연관관계
        - 객체는 참조를 사용 ex) member.getTeam()
        - 테이블은 외래 키를 사용 ex) join on ㅜm.team_id = t.team_id
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
    
    
### JPA 구동 방식

- Persistence 의 설정 정보 조회(META-INF/persistence.xml) - 생성 -> EntityManagerFactory - 생성 > EntityManager
 <pre>
    <code>
    Member findMember = em.find(Member.class, 1L);
    findMember.setName("HelloJPA")
    // 해당 findMember 객체를 따로 JPA 관리 하기 떄문에 setName 메소드를 통하여 id = 1 데이터가 수정됨
    </code>
</pre>

### JPA 사용시 주의 사항
 - 엔티티 매니저 팩토리는 하나만 생성해서 애플리케이션 전체에서 공유
 - 엔티티 매니저는 쓰레드간에 공유x
 - JPA의 모든 데이터 변경은 트랜잭션 안에서 실 
    
### JPQL 소개
 - 가장 단순한 조회 방법
    - EntityManager.find()
    - 객체 그래프 탐색(a.getB().getC())
 
 - JPA를 사용하면 엔티티 객체를 중심으로 개발
 - 문제는 검색 쿼리
 - 검색을 할 때도 테이블이 아닌 엔티티 객체를 대상으로 검색
 - 모든 DB 데이터를 객체로 변환해서 검색하는 것은 불가능
 - 애플리케이션이 피룡한 데이터만 DB에서 불러오려면 결국 검색 조건이 포함됨 SQL일 필요
 
 - JPA는 SQL을 추상화한 JPQL이라는 객체 지향 쿼리 언어 제공
 - SQL과 문법 유사, SELECT, FROM , WHERE, GROUP BY , HAVING,JION 지원
 - JPQL은 엔티티 객체를 대상으로 쿼리
 - SQL은 데이터베이스 테이블을 대상으로 쿼리
 

    
