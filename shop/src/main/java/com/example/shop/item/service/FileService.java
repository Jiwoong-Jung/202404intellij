package com.example.shop.item.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;


//두가지 동작 기능: 파일을 만들고 지우는 동작
@Service
@Slf4j
public class FileService {

    public String uploadFile(String uploadPath, String oriFileName, byte[] fileData) throws IOException {
//        임의의 UUID를 자동으로 만들어준다.
        UUID uuid = UUID.randomUUID();
//        file의 확장자를 떼기 위함
//        요즘 파일은 중간중간에도 .을 찍기 때문에 맨 마지막에 있는 확장자만 지운다.
        String extension = oriFileName.substring(oriFileName.lastIndexOf("."));
//        uuid는 문자열이 아니니까 toString 을 꼭 해줘야 함 거기에 확장자만 붙여주면 된다.
        String savedFileName = uuid.toString() + extension;

//        실제 파일 경로 -> D:// 어쩌고~ / uuid로 만든 파일 이름.extension으로 저장됨
        String fileUploadUrl = uploadPath + "/" + savedFileName; // 경로 준비
        FileOutputStream fos = new FileOutputStream(fileUploadUrl);
        fos.write(fileData);
        fos.close();
        return savedFileName;
    }

    public void deletFile(String filePath) {
        File deleteFile = new File(filePath);

        if(deleteFile.exists()) {
            deleteFile.delete();
            log.info("파일을 삭제했습니다.");
        } else {
            log.info("파일이 존재하지 않습니다.");
        }
    }
}
