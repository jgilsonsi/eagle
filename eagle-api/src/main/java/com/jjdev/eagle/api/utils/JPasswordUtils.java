package com.jjdev.eagle.api.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author JGilson
 */
public class JPasswordUtils {

    private static final Logger log = LoggerFactory.getLogger(JPasswordUtils.class);

    public JPasswordUtils() {
    }

    /**
     * Generate password using BCrypt.
     *
     * @param password
     * @return encoded password
     */
    public static String generateBCrypt(String password) {
        if (password == null) {
            log.error("Password generator received null value");
            return password;
        }
        BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
        return bCryptEncoder.encode(password);
    }

    /**
     * Verify that the password is valid.
     *
     * @param password
     * @param encodedPassword
     * @return boolean
     */
    public static boolean validPassword(String password, String encodedPassword) {
        BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
        return bCryptEncoder.matches(password, encodedPassword);
    }

}
