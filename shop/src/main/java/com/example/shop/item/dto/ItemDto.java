package com.example.shop.item.dto;

import com.example.shop.utils.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto extends BaseEntity {

    private Long id;            // 상품 코드

    private String itemNm;      // 상품 이름

    private Integer price;          // 상품 가격

    private String itemDetail;  // 상품 상세 설명

    private String itemSellStatus;

    private int stockNumber;    // 재고 수량



}
