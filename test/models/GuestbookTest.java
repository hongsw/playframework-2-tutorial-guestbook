package models;


import static org.junit.Assert.*;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.start;

import java.util.List;

import models.Guestbook;
import models.User;

import org.junit.Before;
import org.junit.Test;

import play.libs.Yaml;

import com.avaje.ebean.Ebean;

public class GuestbookTest {

	@Before
    public void setUp() {
        start(fakeApplication(inMemoryDatabase()));
    }
	
	@Test
    public void createAndRetrieveGuestbook() {
        new Guestbook("Bob","bob@ajinsys.com", "password", "Hello~ Play Framework 2.0." ).save();
        Guestbook bob = Guestbook.find.where().eq("email", "bob@ajinsys.com").findUnique();
        assertNotNull(bob);
        assertEquals("Bob", bob.name);
    }
	
}