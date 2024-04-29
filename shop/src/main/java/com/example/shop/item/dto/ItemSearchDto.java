package com.example.shop.item.dto;

import com.example.shop.item.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ItemSearchDto {

    private String searchDateType; // 날짜 형태 

    private ItemSellStatus searchSellStatus; //판매중 or 솔드아웃

    private String searchBy; // 어떤 방법

    private String searchQuery = ""; // 검색어(키워드)

}