package com.sky._sb0402;

import com.sky._sb0402.entity.MyData;
import com.sky._sb0402.repository.MyDataRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
class Sb0402ApplicationTests {

    @Autowired
    MyDataRepository myDataRepository;

    @Test
    void contextLoads() {
        IntStream.rangeClosed(1, 10).forEach(i->{
            MyData myData = MyData.builder()
                    .age(20+i)
                    .mail("kim"+i+"@korea.com")
                    .name("Kim"+i)
                    .memo("이것은 메모"+i)
                    .build();
            myDataRepository.save(myData);
        });
    }

    @Test
    void updateMyData() {
        MyData myData = MyData.builder()
                .id(1L)
                .age(31)
                .mail("kim31@korea.com")
                .name("Kim31")
                .memo("이것은 메모31")
                .build();
        myDataRepository.save(myData);
    }

    @Test
    void selectAllMyData() {
        List<MyData> list = myDataRepository.findAll();
        list.stream().forEach(m->{
            System.out.println(m);
        });
//        for (MyData myData : list) {
//            System.out.println(myData);
//        }
    }
    @Test
    void selectOne() {
        Optional<MyData> myData = myDataRepository.findById(100L);
        if (myData.isPresent()) {
            System.out.println(myData.get());
        } else {
            System.out.println("자료 없음");
        }
    }

    @Test
    void deleteOne() {
        myDataRepository.deleteById(10L);
    }

}
