package csheets.ext.macro_beanshell;

import java.io.Serializable;

/**
 *
 * @author José Barros
 */
public class Code implements Serializable {

	private String name;
	private String type;
	private String content;
	private boolean synchronous;

	public Code(String name, String type, String content, boolean synchronous) {
		this.name = name;
		this.type = type;
		this.content = content;
		this.synchronous = synchronous;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getContent() {
		return content;
	}

	public boolean isSynchronous() {
		return synchronous;
	}
}
