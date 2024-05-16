package com.sky.restapi0516.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Todo")
public class TodoEntity {
  @Id
  @GeneratedValue(generator="system-uuid")
  @GenericGenerator(name="system-uuid", strategy = "uuid")
  private String id; // 이 오브젝트의 아이디
  private String userId; // 이 오브젝트를 생성한 유저의 아이디
  private String title; // Todo 타이틀 예) 운동 하기
  private boolean done; // true - todo를 완료한 경우(checked)
}
