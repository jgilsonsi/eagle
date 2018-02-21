package com.jjdev.eagle.api.utils;

import com.jjdev.eagle.api.json.button.JChatButton;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author JGilson
 */
public class JJsonUtilsTest {

    private static final String JSONINSTRING = "{\"messages\":[{\"attachment\""
            + ":{\"type\":\"template\",\"payload\":{\"text\":\"Hello!\",\"buttons\""
            + ":[{\"type\":\"show_block\",\"title\":\"Show Block\",\"block_names\""
            + ":[\"name of block\"]}],\"template_type\":\"button\"}}}]}";

    @Test
    public void testJsonToObject() throws Exception {
        JChatButton chatButton = (JChatButton) JJsonUtils.jsonToObject(JSONINSTRING, JChatButton.class);
        assertTrue(chatButton.getMessages().get(0).getAttachment().getPayload()
                .getButtons().get(0).getBlockNames().get(0).equals("name of block"));
    }

    @Test
    public void testObjectToJson() throws Exception {
        JChatButton chatButton = (JChatButton) JJsonUtils.jsonToObject(JSONINSTRING, JChatButton.class);
        String jsonReturned = JJsonUtils.objectToJson(chatButton);
        assertTrue(jsonReturned.equals(JSONINSTRING));
    }

}
