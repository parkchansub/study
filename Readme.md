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
 
 ### JPA에서 가장 중요한 2가지
 
  - 객체와 관계형 데이터베이스 매핑하기
    - 엔티티 매니저 팩토리 / 엔티티 매니저
  - 영속성 컨텍스트   
    - JPA를 이해하는데 가장 중요한 용어
    - 엔티티를 영구 저장하는 환경 이라는 뜻
    - EntityManager.persist(entity)
  - 엔티티 매니저 ? 영속성 컨텍스트 ?
    - 영속성 컨텍스트는 논리적인 개념
    - 눈에 보이지 않는다.
    - 엔티티 매니저를 통해서 영속성 컨텍스트에 접근 
    - EntityManager = > PersistenceContext (엔티티 매니저와 영속성 컨테스트가 1:1)
        
        - 비영속(new/transient) 영속성 컨텍스트와 전혀 관계가 없는 새로운 상태
            <pre>
                <code>
                //객체를 생성한 상태(비영속)
                Member member = new Member();
                member.setId("member1");
                member.setUserName("회원1");
                </code>
            </pre>
        - 영속(managed) 영속성 컨텍스트에 관리되는 상태
            <pre>
                <code>
                Member member = new Member();
                member.setId("member1");
                member.setUserName("회원1");
                
                EntityManager em = emf.creatEntityManager();
                em.getTransaction().begin();
                
                //영속(실제 쿼리 실행 되지 않음)
                em.persist(memeber); 
                
                tx.commit(); // 실제 쿼리 실행 시
                </code>
            </pre>
        - 준영속(detached) 영속성 컨텍스트에 저장되었다가 분리된 상태 ex) em.detach(member);
            
        - 삭제(removed) 삭제된 상태 ex) em.remove(memeber);

### 영속성 컨텍스트의 이점
   - 1차 캐시
        - transaction 단위로 영속성 컨텍스트에 생성 되며 데이터 접근시 
          1차 캐쉬에 해당 entity 존재 유무를 확인한후 있으면 캐쉬에서 데이터를 없다면 그때 DB 접근하여 해당 데이터 캐쉬에 등록 
   - 동일성(identity) 보장
     <pre>
        <code>
            Member a = em.find(Member.class, "member1");
            Member b = em.find(Member.class, "memeber1");
            
            System.out.println(a==b);
            
            //1차 캐시로 반복 가능한 읽기(REPEATABLE READ) 등급의 트랜잭션 격리 수준을
              데이터베이스가 아닌 애플리케이션 차원에서 제공
        </code>
     </pre>
   - 트랜잭션을 지원하는 쓰기 지연(transaction write-behind)
     <pre>
        <code>
           EntityManager em = emf.CreateEntityManager();
           EntityTransaction transaction = em.getTransaction();
           //엔티티 매니저는 데이터 변경시 트랜잭션을 시작해야 한다.
           transaction.begin(); // 트랜잭션 시작
           
           em.persist(memberA);
           em.persist(memberB);
           //여기까지 INSERT SQL을 데이터베이스에 보내지 않는다.
             1차 캐쉬에 삽입 후에 쓰기 지연 sql에 해당 INSERT 쿼리 저
           
           //커밋하는 순간 데이터베이스에 INSERT SQL을 보낸다.
           transaction.commit(); // 트랜잭션 커밋
        </code>
     </pre>
                
   - 변경 감지(Dirty Checking) 
        
        - 실행 순서 
            1. flush() (flush : 영속성 컨텍스트의 변경내용을 데이터베이스에 반영)
            2. 엔티티와 스냅샷 비교(스냅샷 : 1차 캐쉬에 데이터 생성 최초 시점 Entity 값)
            3. UPDATE SQL 생성(쓰기 지연 SQL 저장소 저장)
            4. UPDATE 쿼리 DB 반영(flush())
            5. COMMIT
             
     <pre>
        <code>
            EntityManager em = emf.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin(); // 트랜잭션 시작
            
            //영속 엔티티 조회
            Member memberA = em.find(Member.class, "memberA");
            
            // 영속 엔티티 데이터 수정
            memberA.setUsername("hi");
            memberA.setAge(10);
            
            //em.update(member) 이런 코드가 있어야 하지 않을까?
            
            transaction.commit();
        </code>
     </pre>
   - 지연 로딩(Lazy Loading)
   
### 플러시(FLUSH)

- 플러시 발생
    - 변경 감지
    - 수정된 엔티티 쓰기 지연 SQL 저장소에 등록
    - 쓰기 지연 SQL 저장소의 쿼리를 데이터베이에 전송(등록, 수정, 삭제 쿼리)

- 영속성 컨텍스트를 플러시하는 방법
    - em.flush() - 직접 호출
    - 트랜잭션 커밋 - 플러시 자동 호출
    - JPQL 쿼리 실행 - 플러시 자동 호출
        <pre>
            <code>
            em.persist(memberA);
            em.persist(memberB);
            em.persist(memberC);
            
            //중간에 JPQL 실행 실제 insert 쿼리가 실해 되지 않아 아래 select 값이 없어야 하지만 
             JPQL 실행시 flush가 자동으로 실행 되기 때문에 정상 작
            query = em.createQuery("select m from Member m", Member.class);
            List<>  members = query.getResultList();
            
            </code>
        </pre>

- 플러시 모드 옵션
    - em.setFlushMode(FlushModeType.COMMIT)
    
        - FlushModeType.AUTO 커밋이나 쿼리를 실행할 떄 플러시(기본값)
        - FlushModeType.COMMIT 커밋할 때만 플러쉬
        

- 주의 사항
    - 플러시는 영속성 컨텍스트를 비우지 않음
    - 영속성 컨텍스트의 변경내용을 데이터베이스에 동기화ㅣ
    - 트랜잭션이라는 작업 단위가 중요 -> 커밋 직전에만 동기화 하면 됨
    

### 준영속 상태

- 영속 -> 준영속
- 영속 상태의 엔티티가 영속성 컨텍스트에서 분리(detached)
- 영속 컨텍스트가 제공하는 기능을 사용 못함

- 준영속 상태로 만드는 방법
    1. em.detach(entity) 특정 엔티티만 준영속 상태로 전환
        <pre>
            <code>
            Member member = em.find(Member.class, 150L);
            member.setName("AAAA");
            
            em.detach(member); // 영속성 제거(영속성에서 비속성 상태로 바꾸는 행위 == 준영속)
            
            tx.commit() // SELECT 쿼리만 실행되고 UPDATE 실행(X) 
            
            </code>
        </pre>
    
    2. em.clear() 영속성 컨텍스트를 완전히 초기화
        <pre>
            <code>
            Member member = em.find(Member.class, 150L);
            member.setName("AAAA");
            
            em.clear(); // 1차 캐쉬 전체 삭제
            
            tx.commit() // SELECT 쿼리만 실행 
            
            </code>
        </pre>
    3. em.close() 영속성 컨텍스트 종료
        <pre>
            <code>
            Member member = em.find(Member.class, 150L);
            member.setName("AAAA");
            
            em.close(); // 영속성 컨텍스트 종료
            
            tx.commit() // SELECT 쿼리만 실행 
            
            </code>
        </pre>
    
