package com.example.shop.item.repository;

import com.example.shop.item.entity.ItemImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemImgRepository extends JpaRepository<ItemImg, Long> {
//  JPQL 방식
//  @Query("select i from ItemImg i where i.item = :itemId")

//  쿼리메소드 방식
   List<ItemImg> findByItemIdOrderByIdAsc(Long itemId);

   ItemImg findByItemIdAndRepImgYn(Long itemId, String repImgYn);
}
