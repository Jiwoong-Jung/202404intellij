package com.example.securitystudy.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * packageName : com.example.securitystudy.config
 * fileName : SimplePasswordEncoder
 * author : SHW
 * date : 2023-06-15
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2023-06-15   SHW     최초 생성
 */

public class SimplePasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(encode(rawPassword));
    }
}
