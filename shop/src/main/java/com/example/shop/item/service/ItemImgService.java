package com.example.shop.item.service;

import com.example.shop.item.entity.ItemImg;
import com.example.shop.item.repository.ItemImgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemImgService {

    @Value(value = "${itemImgLocation}")
    private String itemImgLocation;

    private final ItemImgRepository itemImgRepository;

    private final FileService fileService;
//      이미지를 저장합니다
    public void saveItemImg(ItemImg itemImg, MultipartFile itemImgFile) throws IOException {
        String oriImgName = itemImgFile.getOriginalFilename();
//        fileService에서 만든 imgName임
        String imgName = "";
//        이미지 경로
        String imgUrl = "";
//        파일 업로드
//        원래 경로가 값이 비어있는지 타임리프 유틸을 이용해서 확인
        if(!StringUtils.isEmpty(oriImgName)) {
//            진짜 이미지 이름 받아오기
//            파일의 정보는 itemImgFile에 다 있으니까 이걸 byte 배열로 가져온다
            imgName = fileService.uploadFile(itemImgLocation, oriImgName, itemImgFile.getBytes());
            //이미지 경로 받아오기
            imgUrl = "/images/item/" + imgName;
        }
//        실제 상품 이지미 저장
        itemImg.updateItemImg(oriImgName, imgName, imgUrl);
//        이미지만 저장 그러니까 아이템도 저장해줘야한다
        itemImgRepository.save(itemImg);
    }

    public void updateItemImg(Long ItemImgId, MultipartFile itemImgFile) throws IOException {
        if(!itemImgFile.isEmpty()) {
            ItemImg itemImg = itemImgRepository.findById(ItemImgId).orElseThrow(EntityNotFoundException::new);
            //기존 이미지 파일 삭제
            if(!StringUtils.isEmpty(itemImg.getImgName())) {
                fileService.deletFile(itemImgLocation + "/" + itemImg.getImgName());
            }

            String oriName = itemImgFile.getOriginalFilename();
            String imgName = fileService.uploadFile(itemImgLocation, oriName, itemImgFile.getBytes());
            String imgUrl = "/images/item/" + imgName;

            itemImg.updateItemImg(oriName, imgName, imgUrl);
        }
    }
}
