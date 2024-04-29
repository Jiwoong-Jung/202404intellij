package com.example.shop.item.dto;

import com.example.shop.item.constant.ItemSellStatus;
import com.example.shop.item.entity.Item;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ItemFormDto {

    private Long id;            // 상품 코드

    @NotBlank(message = "상품명은 필수 항목 입니다.")
    private String itemNm;      // 상품 이름

    @NotNull(message = "가격은 필수 항목 입니다.")
    private int price;          // 상품 가격

    @NotNull(message = "재고는 필수 항목 입니다.")
    private int stockNumber;    // 재고 수량

    private ItemSellStatus itemSellStatus;

    @NotBlank(message = "상품 설명은 필수 항목 입니다.")
    private String itemDetail;  // 상품 상세 설명
//    아이디 정보를 받아오려고 함
    private List<ItemImgDto> itemImgDtoList = new ArrayList<>();

    private List<Long> itemImgIds = new ArrayList<>();

    private static ModelMapper modelMapper = new ModelMapper();

    //디펜던시에서 ModelMapper 추가 후 아래처럼 간단히 변환가능(변환 기준은 entity 또는 dto 클래스 중 자기가 정하여서 설정)
    //dto -> entity 변환
    public Item createItem() {
        return modelMapper.map(this, Item.class);
    }
    //entity -> dto 변환
    public static ItemFormDto of(Item item) {
        return modelMapper.map(item, ItemFormDto.class);
    }
}
