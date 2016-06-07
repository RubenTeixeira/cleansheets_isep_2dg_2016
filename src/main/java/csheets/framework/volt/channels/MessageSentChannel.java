package csheets.framework.volt.channels;

import csheets.framework.volt.Channel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Observer;

/**
 * This channel allows to notify every observer of the messages sent.
 * 
 * @author Renato Machado
 */
public class MessageSentChannel extends Channel {
    
    /**
     * Where the message is being sent from.
     */
    private final String from;
    
    /**
     * The observer that wants to know about the sent messages.
     */
    private final List<Observer> observers;
    
    public MessageSentChannel(String from, Observer... observers)
    {
        this.from = from;
        
        this.observers = new ArrayList<>();
        this.observers.addAll(Arrays.asList(observers));
    }
    
    @Override
    public void after(Map<String, Object> args, Map<String, Object> dependencies) {
        String message = this.from + ";" + (String) args.get("message");
        
        for (Observer observer : this.observers) {
            observer.update(null, message);
        }
    }
    
}
