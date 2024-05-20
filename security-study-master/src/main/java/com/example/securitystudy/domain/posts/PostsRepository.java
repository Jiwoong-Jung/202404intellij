package com.example.securitystudy.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * packageName : com.example.securitystudy.domain.posts
 * fileName : PostsRepository
 * author : SHW
 * date : 2023-07-09
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2023-07-09   SHW     최초 생성
 */

public interface PostsRepository extends JpaRepository<Posts, Long> {

}
