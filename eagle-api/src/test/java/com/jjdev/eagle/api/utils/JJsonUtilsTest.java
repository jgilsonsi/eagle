package com.jjdev.eagle.api.utils;

import com.jjdev.eagle.api.json.quickreply.JQuickReplyChat;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author JGilson
 */
public class JJsonUtilsTest {

    private static final String JSONINSTRING = "{\"messages\":[{\"text\":"
            + "\"Escolha uma das opções:\",\"quick_replies\":[{\"title\":\"MTB\","
            + "\"set_attributes\":{\"equipment_type_id\":1,\"equipment_type_name\":"
            + "\"MTB\"}},{\"title\":\"Speed\",\"set_attributes\":{\"equipment_type_id\""
            + ":2,\"equipment_type_name\":\"Speed\"}},{\"title\":\"Urbana\",\"set_attributes\":"
            + "{\"equipment_type_id\":3,\"equipment_type_name\":\"Urbana\"}}]}]}";

    @Test
    public void testJsonToObject() throws Exception {
        JQuickReplyChat quickReplyChat = (JQuickReplyChat) JJsonUtils.jsonToObject(JSONINSTRING, JQuickReplyChat.class);
        assertTrue(quickReplyChat.getMessages().get(0).getQuickReplies().get(2).getTitle().equals("Urbana"));
    }

    @Test
    public void testObjectToJson() throws Exception {
        JQuickReplyChat quickReplyChat = (JQuickReplyChat) JJsonUtils.jsonToObject(JSONINSTRING, JQuickReplyChat.class);
        String jsonReturned = JJsonUtils.objectToJson(quickReplyChat);
        assertTrue(jsonReturned.equals(JSONINSTRING));
    }

}
