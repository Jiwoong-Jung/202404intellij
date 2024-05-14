package com.harrybro.courseregistration.global.infra.mail.util;

import java.util.Random;

public class EmailAuthCodeGenerator {

    private final int authCodeLength = 8;
    private final char[] characterTable = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };

    public String generateAuthCode() {
        Random random = new Random(System.currentTimeMillis());
        StringBuffer buffer = new StringBuffer();

        for(int i = 0; i < authCodeLength; i++)
            buffer.append(characterTable[random.nextInt(characterTable.length)]);

        return buffer.toString();
    }

}
