/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.task;

import csheets.domain.CompanyContact;
import csheets.domain.Contact;
import csheets.domain.Event;
import csheets.domain.PersonContact;
import csheets.domain.Reminder;
import csheets.domain.Task;
import csheets.ui.ctrl.UIController;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hicham Abahri <1141042.isep.ipp.pt>
 */
public class TaskControllerTest {

    private Task task;
    private TaskController taskController;
    private Reminder reminder;
    private Event event;
    private Contact contact;
    private UIController uicontroller;

    public TaskControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of showContacts method, of class TaskController.
     */
    @Test
    public void testShowContacts() {
//        System.out.println("showContacts");
//        TaskController instance = null;
//        Iterable<Contact> expResult = null;
//        Iterable<Contact> result = instance.showContacts();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of createTask method, of class TaskController.
     */
//    @Test
//    public void testCreateTask() throws Exception {
//        String taskName = "Task";
//        String description = "TaskDescription";
//        String descriptionCampany = "ISEP";
//        String expResult = "newTaskDescription";
//        int priority = 3;
//        float percentageofcompletion = 50.0F;
//        byte[] photo = {0};
//        boolean state = true;
//
//        String reminderName = "reminder";
//        String reminderDescription = "reminderDescription";
//        Calendar data = Calendar.getInstance();
//
//        System.out.println("createTask");
//        CompanyContact companyContact = new CompanyContact(descriptionCampany, photo);
//        contact = new PersonContact(taskName, taskName, description, companyContact, photo);
//
//        this.reminder = new Reminder(reminderName, reminderDescription, data, state);
//
//        taskController = new TaskController(uicontroller);
//        Task result = taskController.createTask(taskName, description, priority, percentageofcompletion, contact, data);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of editTask method, of class TaskController.
     */
    @Test
    public void testEditDescriptionTask() {
        System.out.println("editDescriptionTask");
        String taskName = "Task";
        String description = "TaskDescription";
        String expResult = "newTaskDescription";
        int priority = 3;
        float percentageofcompletion = 50.0F;
        byte[] photo = {0};
        boolean state = true;

        String reminderName = "reminder";
        String reminderDescription = "reminderDescription";
        Calendar data = Calendar.getInstance();
        contact = new PersonContact(taskName, taskName, description, contact, photo);
        this.reminder = new Reminder(reminderName, reminderDescription, data, state);

        TaskController instance = new TaskController(uicontroller);

        task = new Task(reminderName, description, priority, percentageofcompletion, contact);
        Task newTask = new Task(reminderName, expResult, priority, percentageofcompletion, contact);

        instance.editTask(newTask);
        String result = newTask.Description();

        assertEquals(expResult, result);

    }

//    @Test
//    public void testEditPercentageTask() {
//
//        System.out.println("editNameTask");
//
//        System.out.println("editDescriptionTask");
//        String name = "Hicham", lastName = "Abahri", profession = "Student";
//        String taskName = "Task";
//        String description = "TaskDescription";
//        // String expResult = "newTaskDescription";
//        int priority = 3;
//        float percentageofcompletion = 50.0F, Newpercentageofcompletion = 80.0F;
//        byte[] photo = {0};
//        boolean state = true;
//
//        String reminderName = "reminder";
//        String reminderDescription = "reminderDescription";
//        Calendar data = Calendar.getInstance();
//
//        contact = new PersonContact(name, lastName, profession, contact, photo);
//        this.reminder = new Reminder(reminderName, reminderDescription, data, state);
//        TaskController instance = new TaskController(uicontroller);
//        task = new Task(taskName, description, priority, percentageofcompletion, contact);
//        Task newTask = new Task(reminderName, description, priority, Newpercentageofcompletion, contact);
//
//        instance.editTask(newTask);
//        float result = newTask.Percentage();
//        assertEquals(Newpercentageofcompletion, result, 0.0000);
//
//    }

    /**
     * Test of removeTask method, of class TaskController. //
     */
//    @Test
//    public void testRemoveTask() {
//        System.out.println("removeTask");
//        task = new Task(taskName, description, priority, percentageofcompletion, contact);
//        TaskController instance = new TaskController(uicontroller);
//        instance.removeTask(task);
//
//    }
    /**
     * Test of allTasksContact method, of class TaskController. //
     */
//    @Test
//    public void testAllTasksContact() {
//        System.out.println("allTasksContact");
//        contact = new PersonContact(taskName, taskName, description, contact, photo);
//        TaskController instance = new TaskController(uicontroller);
//        List<Task> expResult = instance.allTasks();
//        List<Task> result = instance.allTasksContact(contact);
//        assertEquals(expResult, result);
//
//    }

    /**
     * Test of allTasks method, of class TaskController.
     */
//    @Test
//    public void testAllTasks_0args() {
//        System.out.println("allTasks");
//        TaskController instance = null;
//        List<Task> expResult = null;
//        List<Task> result = instance.allTasks();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of allTasks method, of class TaskController.
//     */
//    @Test
//    public void testAllTasks_String_String() {
//        System.out.println("allTasks");
//        String left = "";
//        String right = "";
//        TaskController instance = null;
//        List<Task> expResult = null;
//        List<Task> result = instance.allTasks(left, right);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of allContacts method, of class TaskController.
//     */
//    @Test
//    public void testAllContacts() {
//        System.out.println("allContacts");
//        TaskController instance = null;
//        Iterable<Contact> expResult = null;
//        Iterable<Contact> result = instance.allContacts();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of allEvents method, of class TaskController.
//     */
//    @Test
//    public void testAllEvents() {
//        System.out.println("allEvents");
//        TaskController instance = null;
//        Iterable<Event> expResult = null;
//        Iterable<Event> result = instance.allEvents();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of allReminders method, of class TaskController.
//     */
//    @Test
//    public void testAllReminders() {
//        System.out.println("allReminders");
//        TaskController instance = null;
//        Iterable<Reminder> expResult = null;
//        Iterable<Reminder> result = instance.allReminders();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
