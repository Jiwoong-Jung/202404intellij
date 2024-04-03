package org.zerock.club.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

//AuditingEntityListener을 사용하기 위해선 어플리케이션 구동 클래스에  @EnableJpaAuditing을 달아줘야 한다.
//어노테이션으로 @CreatedBy(작성자) , @CreatedDate(작성일) @LastModifiedDate(수정일) @LastModifiedBy(수정자)
//을 자동으로 넣어 주는 기능을  제공한다.
//생성 시간과 수정시간을 저장하는 엔티티이다 해당 필드는 모든 엔티티에 적용될 것이기 때문에 다른 클래스에서 상속받아서
//사용하는 BaseEntity 가 된다 baseEntity 임을 알리기 위해선
//@MappedSuperClass를 붙혀줘야한다 . 해당 클래스를 상속받는 엔티티에서 해당 클래스 필드를 컬럼으로 사용하게 한다
@MappedSuperclass
@EntityListeners(value = { AuditingEntityListener.class })
@Getter
abstract class BaseEntity {

    @CreatedDate
    @Column(name = "regdate" , updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column(name ="moddate" )
    private LocalDateTime modDate;

}
