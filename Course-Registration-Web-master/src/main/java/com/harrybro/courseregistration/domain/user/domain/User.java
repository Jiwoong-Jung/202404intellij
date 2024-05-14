package com.harrybro.courseregistration.domain.user.domain;

import com.harrybro.courseregistration.domain.university.domain.Basket;
import com.harrybro.courseregistration.domain.university.domain.Enrollment;
import com.harrybro.courseregistration.domain.university.domain.Lecture;
import com.harrybro.courseregistration.domain.user.exception.LackOfCreditException;
import com.harrybro.courseregistration.domain.user.exception.UserExceptionMessage;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private int credit;

    @Setter
    @OneToOne
    private Basket basket;

    @Setter
    @OneToOne
    private Enrollment enrollment;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleType role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserStateType state;

    @CreationTimestamp
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp updatedDate;

    @Builder
    public User(String email, String password, Basket basket, Enrollment enrollment, RoleType role) {
        this.email = email;
        this.password = password;
        this.basket = basket;
        this.enrollment = enrollment;
        this.role = role;
        this.state = UserStateType.WAIT;
        this.credit = 17;
    }

    public void enroll(Lecture lecture) {
        if (this.credit >= lecture.getCredit()) {
            boolean result = this.enrollment.saveLecture(lecture);
            if (result) this.credit -= lecture.getCredit();
        } else throw new LackOfCreditException(UserExceptionMessage.LACK_OF_CREDIT);
    }

    public void cancelEnrollment(Lecture lecture) {
        boolean result = this.enrollment.deleteLecture(lecture);
        if (result) this.credit += lecture.getCredit();
    }

    public void emailVerificationCompleted() {
        this.state = UserStateType.NORMAL;
    }

}
