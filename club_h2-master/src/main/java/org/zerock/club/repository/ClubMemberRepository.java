package org.zerock.club.repository;


import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.zerock.club.entity.ClubMember;

import java.util.Optional;

public interface ClubMemberRepository extends JpaRepository<ClubMember, String> {

    //EntityGraph는 연관 엔티티의 특정한 속성을 같이 로딩하도록 표시한다
    //기본적으로 JPA를 이용하는 경우에는 연관 관계의 FATCH 속성값은 LAZY로 지정하는 것이 일반적이다
    //@EntityGraph는 이러한 상황에서 특정 기능을 수행할 때만 EAGER 로딩을 하도록 지정할 수 있다.
    //attirubtePaths: 로딩 설정을 변경하고 싶은 속성의 이름을 배열로 명시한다
    //type: @EntityGraph를 어떤 방식으로 적용할 것인지를 설정
    //FATCH 속성값은 attributePaths에 명시한 속성은 EAGER로 처리하고 나머지는 LAZY로 처리한다.
    //LOAD 속성값은 attributePaths에 명시한 속성은 EAGER로 처리하고 나머지는 엔티티 클래스에 명시되거나 기본 방식으로 처리한다.
    //EntityGraph를 이용해서 'left outer join'으로 ClubMemberRole이 처리될 수 있도록 한다.
    @EntityGraph(attributePaths = {"roleSet"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("select m from ClubMember m where m.fromSocial = :social and m.email =:email")
    Optional<ClubMember> findByEmail(String email, boolean social);
    //Optional은 non-null 값을 가지고 있거나 안 가지고 있을 수 있는 컨테이너 오브젝트이다
    // 값이 존재하면 isPresent()는 true를 반환하고
    //값이 존재하지 않으면 false를 반환한다. 객체를 감싸고 그 안에 값이 있는지 없는지 유무를 판별하기 좋다.
}
