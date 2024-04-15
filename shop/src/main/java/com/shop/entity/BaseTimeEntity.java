/* 등록 및 수정시간 자동 저장용 */

package com.shop.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@EntityListeners(value = {AuditingEntityListener.class})
@MappedSuperclass
@Getter
@Setter
public class BaseTimeEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regTime;

    @LastModifiedDate
    private LocalDateTime updateTime;
}
