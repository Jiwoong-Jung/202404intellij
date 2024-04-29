package com.example.shop.item.dto;

import com.example.shop.item.entity.ItemImg;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@ToString
public class ItemImgDto {

    private Long id; //상품 코드

    private String imgName;

    private String oriImgName;

    private String imgUrl;

    private String repImgYn; //대표 이미지

    private static ModelMapper modelMapper = new ModelMapper();

    public static ItemImgDto of(ItemImg itemImg) {
//     아이템 이미지 디티오로 받아서 매핑한다는 뜻
        return modelMapper.map(itemImg, ItemImgDto.class);
    }
}
