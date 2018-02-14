package com.jjdev.eagle.api.repositories;

import com.jjdev.eagle.api.entities.JUser;
import com.jjdev.eagle.api.enums.EUserType;
import com.jjdev.eagle.api.utils.JPasswordUtils;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author JGilson
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class JUserRepositoryTest {
    
    @Autowired
    private IUserRepository userRepository;
    
    private static final String EMAIL = "eagle@eagle.com.br";
    private static final String PASSWORD = "123Mudar";
    
    @Before
    public void setUp() throws Exception {
        JUser user = new JUser();
        user.setName("User");
        user.setEmail(EMAIL);
        user.setPassword(JPasswordUtils.generateBCrypt(PASSWORD));
        user.setRole(EUserType.ROLE_USER.name());
        this.userRepository.save(user);
    }
    
    @After
    public final void tearDown() {
        this.userRepository.deleteAll();
    }
    
    @Test
    public void testFindByEmail() {
        JUser user = this.userRepository.findByEmail(EMAIL);
        assertEquals(EMAIL, user.getEmail());
    }
    
    @Test
    public void testPassordValue() {
        JUser user = this.userRepository.findByEmail(EMAIL);
        assertTrue(JPasswordUtils.validPassword(PASSWORD, user.getPassword()));
    }
}
