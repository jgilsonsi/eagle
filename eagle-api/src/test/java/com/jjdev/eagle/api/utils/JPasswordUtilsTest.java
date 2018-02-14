package com.jjdev.eagle.api.utils;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author JGilson
 */
public class JPasswordUtilsTest {

    private static final String PASSWORD = "123Mudar";
    private final BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();

    @Test
    public void testNullPassword() throws Exception {
        assertNull(JPasswordUtils.generateBCrypt(null));
    }

    @Test
    public void testGenPassword() throws Exception {
        String hash = JPasswordUtils.generateBCrypt(PASSWORD);
        assertTrue(bCryptEncoder.matches(PASSWORD, hash));
    }

}
