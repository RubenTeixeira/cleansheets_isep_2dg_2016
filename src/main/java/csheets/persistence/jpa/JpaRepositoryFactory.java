package csheets.persistence.jpa;

import csheets.persistence.CalendarRepository;
import csheets.persistence.ChatUserRepository;
import csheets.persistence.ContactRepository;
import csheets.persistence.EmailRepository;
import csheets.persistence.EventRepository;
import csheets.persistence.ListRepository;
import csheets.persistence.NoteRepository;
import csheets.persistence.ReminderRepository;
import csheets.persistence.RepositoryFactory;
import csheets.persistence.TaskRepository;

/**
 *
 * Created by nuno on 21/03/16.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

	@Override
	public ContactRepository contacts() {
		return new JpaContactRepository();
	}

	@Override
	public EventRepository events() {
		return new JpaEventRepository();
	}

	@Override
	public ReminderRepository reminders() {
		return new JpaReminderRepository();
	}

	public CalendarRepository calendars() {
		return new JpaCalendarRepository();
	}

	@Override
	public NoteRepository notes() {
		return new JpaNoteRepository();
	}

	@Override
	public ListRepository lists() {
		return new JpaListRepository();
	}

	@Override
	public ChatUserRepository chatUsers() {
		return new JpaChatUserRepository();
	}

	@Override
	public TaskRepository task() {
		return new JpaTaskRepository();
	}

	@Override
	public EmailRepository emails() {
		return new JpaEmailRepository();
	}
}
