package com.example.shop.item.entity;

import com.example.shop.item.constant.ItemSellStatus;
import com.example.shop.item.dto.ItemFormDto;
import com.example.shop.item.exception.OutOfStockException;
import com.example.shop.utils.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "item")
@Getter // 필수
@Setter // 옵션(선택)
@ToString
@NoArgsConstructor // 빈 생성자
@AllArgsConstructor // 모든 생성자
@Builder
public class Item extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;            // 상품 코드

    @Column(nullable = false, length = 50)
    private String itemNm;      // 상품 이름

    @Column(nullable = false)
    private int price;          // 상품 가격

    @Column(nullable = false)
    private int stockNumber;    // 재고 수량

//    열거형은 기본적으로 숫자로 다루는 것이 원칙. 해당 어노테이션은 열거형을 나타내는 어노테이션
//    ORDINAL = 숫자로 다룬다. STRING = 문자로 다룬다.
    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus; //상품 판매 상태

    @Lob // @Lob은 일반적인 데이터베이스에서 저장하는 길이인 255개 이상의 문자를 저장하고 싶을 때 지정한다.
    @Column(nullable = false)
    private String itemDetail;  // 상품 상세 설명

    public void updateItem(ItemFormDto itemFormDto) {
        this.itemNm = itemFormDto.getItemNm();
//        setItemNm(itemFormDto.getItemNm()); 위의 코드와 같다
        this.price = itemFormDto.getPrice();
        this.stockNumber = itemFormDto.getStockNumber();
        this.itemDetail = itemFormDto.getItemDetail();
        this.itemSellStatus = itemFormDto.getItemSellStatus();
    }

    public void removeStock(int stockNumber) {
        int restStock = this.stockNumber - stockNumber;
        if(restStock < 0) {
            throw new OutOfStockException("상품의 재고가 부족합니다. (현재 재고 수량: " + this.stockNumber + ")" );
        }
        this.stockNumber = restStock;
    }

    public void addStock(int stockNumber) {
        this.stockNumber += stockNumber;
    }
}

