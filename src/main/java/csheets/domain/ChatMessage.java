/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;

/**
 *
 * @author nervousdev
 */
@Embeddable
public class ChatMessage implements Serializable {

	private String otherUserNickname;

	private String messageText;

	@GeneratedValue
	private int messageIndex;

	protected ChatMessage() {

	}

	public ChatMessage(String nickname, String text) {
		this.otherUserNickname = nickname;
		this.messageText = text;
	}
}
