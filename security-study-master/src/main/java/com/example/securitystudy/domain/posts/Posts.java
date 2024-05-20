package com.example.securitystudy.domain.posts;

import com.example.securitystudy.domain.comment.Comment;
import com.example.securitystudy.domain.member.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * packageName : com.example.securitystudy.domain.posts
 * fileName : Posts
 * author : SHW
 * date : 2023-07-09
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2023-07-09   SHW     최초 생성
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String writer;

    @Column(columnDefinition = "integer default 0")
    private int view;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Member member;

    @OneToMany(mappedBy = "posts", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @OrderBy("id asc") // 댓글 정렬
    private List<Comment> comments;

    /* 게시글 수정 메소드 */
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
