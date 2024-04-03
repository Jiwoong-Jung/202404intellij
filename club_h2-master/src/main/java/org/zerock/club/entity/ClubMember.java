package org.zerock.club.entity;


import lombok.*;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ClubMember extends BaseEntity {

    @Id
    private String email;

    private String password;

    private String name;

    private boolean fromSocial;
    //이 어노테이션은 지정된 속성이 컬렉션을 사용할 것이라는 의미이다.
    //Entity가 아닌 단순한 형태의 객체 집합을 정의하고 관리하는 방법이다.
    //한 테이블에서 연관된 다른 테이블에 대한 정보를 다루는데 One-To-Many관계를 다룬다

    //Fetch Type은 크게 Eager와 Lazy 두 가지의 전략이 있습니다. Eager 전략은 엔티티를 조회할 때,
    // 연관 관계에 있는 엔티티도 함께 가져오고,
    // 반대로 Lazy 전략은 연관 관계 엔티티를 참조할 때 그때서야
    // 가져오게 됩니다.
    @ElementCollection(fetch = FetchType.LAZY)
    private Set<ClubMemberRole> roleSet;

    public void addMemberRole(ClubMemberRole clubMemberRole){
        roleSet.add(clubMemberRole);
    }

}
