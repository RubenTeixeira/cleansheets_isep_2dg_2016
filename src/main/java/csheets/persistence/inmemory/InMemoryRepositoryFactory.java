package csheets.persistence.inmemory;

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
 * Created by nuno on 20/03/16.
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

	private static ContactRepository contactRepository = null;
	private static EventRepository eventRepository = null;
	private static ReminderRepository reminderRepository = null;
	private static CalendarRepository calendarRepository = null;
	private static NoteRepository noteRepository = null;
	private static ListRepository listRepository = null;
	private static TaskRepository taskRepository = null;
	private static ChatUserRepository chatUserRepository = null;
	private static EmailRepository emailRepository = null;

	@Override
	public ContactRepository contacts() {
		if (contactRepository == null) {
			contactRepository = new InMemoryContactRepository();
		}
		return contactRepository;
	}

	@Override
	public EventRepository events() {
		if (eventRepository == null) {
			eventRepository = new InMemoryEventRepository();
		}
		return eventRepository;
	}

	@Override
	public ReminderRepository reminders() {
		if (reminderRepository == null) {
			reminderRepository = new InMemoryReminderRepository();
		}
		return reminderRepository;
	}

	@Override
	public CalendarRepository calendars() {
		if (calendarRepository == null) {
			calendarRepository = new InMemoryCalendarRepository();
		}
		return calendarRepository;
	}

	@Override
	public NoteRepository notes() {
		if (noteRepository == null) {
			noteRepository = new InMemoryNoteRepository();
		}
		return noteRepository;
	}

	@Override
	public ListRepository lists() {
		if (listRepository == null) {
			listRepository = new InMemoryListRepository();
		}
		return listRepository;
	}

	@Override
	public TaskRepository task() {
		if (taskRepository == null) {
			taskRepository = new InMemoryTaskRepository();
		}
		return taskRepository;
	}

	@Override
	public ChatUserRepository chatUsers() {
		if (chatUserRepository == null) {
			chatUserRepository = new InMemoryChatUserRepository();
		}
		return chatUserRepository;
	}

	@Override
	public EmailRepository emails() {
		if (emailRepository == null) {
			emailRepository = new InMemoryEmailRepository();
		}
		return emailRepository;
	}
}
