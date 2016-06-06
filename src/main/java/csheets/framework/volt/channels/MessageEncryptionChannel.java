package csheets.framework.volt.channels;

import csheets.framework.volt.Channel;
import csheets.framework.volt.encryption.Encrypter;
import java.util.Map;

/**
 * This channel allows the encryption of a message before the action is executed.
 * 
 * @author Renato Machado
 */
public class MessageEncryptionChannel extends Channel {
    
    /**
     * Encryption key.
     */
    private final String key;
    
    public MessageEncryptionChannel(String key)
    {
        this.key = key;
    }
    
    @Override
    public void before(Map<String, Object> args, Map<String, Object> dependencies) {
        String request = (String) args.get("message");
        
        try {
            args.put("message", Encrypter.encrypt(request, key));
        } catch (Exception e) {
            // Ignore the exception and don't do anything with the message.
        }
    }
    
}
