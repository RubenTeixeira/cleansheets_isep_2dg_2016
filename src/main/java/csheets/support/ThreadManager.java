package csheets.support;

import java.util.Map;

/**
 *
 * @author Renato Machado
 */
public class ThreadManager {
    
    /**
     * Thread to key association.
     */
    private Map<String, Thread> threads;
    
    /**
     * Creates a new association with a key and a thread, without running the thread.
     * 
     * @param key Key to identify thread.
     * @param thread Thread.
     * @return self
     */
    public ThreadManager create(String key, Thread thread)
    {
        this.threads.put(key, thread);
        
        return this;
    }
    
    /**
     * Executes a thread.
     * 
     * @param key Thread key.
     */
    public void run(String key)
    {
        if (this.threads.containsKey(key)) {
            this.threads.get(key).start();
        }
    }
    
    /**
     * Destroys the given thread.
     * 
     * It can also destroy namespaced threads.
     * For example:
     *     destroy("group.*");
     * 
     * It will destroy every thread that starts with group.
     * 
     * @param key Thread key.
     */
    public void destroy(String key)
    {
        if (!key.contains("*")) {
            this.threads.get(key).interrupt();
        }
        
        String group = key.split("\\*")[0];
        
        this.threads.entrySet().stream()
            .filter((entry) -> (entry.getKey().startsWith(group)))
            .forEach((entry) -> {
                entry.getValue().interrupt();
        });
    }
    
}
