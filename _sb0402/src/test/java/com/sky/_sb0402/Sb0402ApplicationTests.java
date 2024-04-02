package com.sky._sb0402;

import com.sky._sb0402.entity.MyData;
import com.sky._sb0402.repository.MyDataRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
