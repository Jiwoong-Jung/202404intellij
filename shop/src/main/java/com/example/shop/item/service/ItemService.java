package com.example.shop.item.service;

import com.example.shop.item.dto.ItemFormDto;
import com.example.shop.item.dto.ItemImgDto;
import com.example.shop.item.dto.ItemSearchDto;
import com.example.shop.item.entity.Item;
import com.example.shop.item.entity.ItemImg;
import com.example.shop.item.repository.ItemImgRepository;
import com.example.shop.item.repository.ItemRepository;
import com.example.shop.main.dto.MainItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
//여기도 마찬가지로 서비스 등록하다가 깨지면 처음부터 다시해야하니까 Transactional을 해줘야한다
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemImgRepository itemImgRepository;
    private final ItemImgService itemImgService;

//   아이템을 등록했으니까 아이템 아디이가 넘어왔을 것이다
//    itemDto 값을 넘겨 받고, multipart 형식으로 되어있는 리스트를 받아온다
    public Long saveItem(ItemFormDto itemFormDto, List<MultipartFile> itemImgFileList) throws IOException {
//        상품등록
//      DTO를 entity로 바꾼다. createItem에서 maaper로 바꿨으니까
        Item item = itemFormDto.createItem();
        itemRepository.save(item);

//        이미지 등록
//        내가 저장한 이미지의 갯수만큼 돌린다
        for (int i = 0; i < itemImgFileList.size(); i++) {
            ItemImg itemImg = new ItemImg();
            itemImg.setItem(item);

            if(i == 0) {
                itemImg.setRepImgYn("Y");
            } else {
                itemImg.setRepImgYn("N");
            }
//            실제로 DB에 집어넣어야한다. 파일 리스트에 있는 애들 중 i번째에 있는 애들을 꺼내서 등록
            itemImgService.saveItemImg(itemImg, itemImgFileList.get(i));
        }
//        아이디를 반환한다
        return item.getId();
    }

    @Transactional(readOnly = true)
    public ItemFormDto getItemDetail(Long itemId) {

        List<ItemImg> itemImgList = itemImgRepository.findByItemIdOrderByIdAsc(itemId);
        List<ItemImgDto> itemImgDtoList = new ArrayList<>();

        for (ItemImg itemImg : itemImgList) {
//          entity를 dto로 변환
            ItemImgDto itemImgDto = ItemImgDto.of(itemImg);
            itemImgDtoList.add(itemImgDto);
        }

        Item item = itemRepository.findById(itemId).orElseThrow(EntityNotFoundException::new);

        ItemFormDto itemFormDto = ItemFormDto.of(item);
        itemFormDto.setItemImgDtoList(itemImgDtoList);

        return itemFormDto;
    }

    public Long updateItem(ItemFormDto itemFormDto, List<MultipartFile> itemImgFileList) throws IOException {
//        상품수정
        Item item = itemRepository.findById(itemFormDto.getId()).orElseThrow(EntityNotFoundException::new);

        item.updateItem(itemFormDto);

        List<Long> itemImgIds = itemFormDto.getItemImgIds();
//        이미지 등록
        for (int i = 0; i < itemImgFileList.size(); i++) {
            itemImgService.updateItemImg(itemImgIds.get(i), itemImgFileList.get(i));
        }

        return item.getId();
    }
    @Transactional(readOnly = true)
    public Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable) {
        return itemRepository.getAdminItemPage(itemSearchDto, pageable);
    }

    @Transactional(readOnly = true)
    public Page<MainItemDto> getMainItemPage(ItemSearchDto itemSearchDto, Pageable pageable) {
        return itemRepository.getMainItemPage(itemSearchDto, pageable);
    }
}
