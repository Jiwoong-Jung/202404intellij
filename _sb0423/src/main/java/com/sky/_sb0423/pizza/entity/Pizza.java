package com.sky._sb0423.pizza.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer total;
    private Integer pickle;
    private Integer chilly;
    private Integer deeping;
    private Integer stick;
    private Integer salad;

    private Boolean complete = false;

}
