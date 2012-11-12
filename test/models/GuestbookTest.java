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
    public void createAndRetrieveUser() {
        new User("bob@gmail.com", "Bob", "secret").save();
        User bob = User.find.where().eq("email", "bob@gmail.com").findUnique();
        assertNotNull(bob);
        assertEquals("Bob", bob.name);
    }
	
	@Test
    public void tryAuthenticateUser() {
        new User("bob@gmail.com", "Bob", "secret").save();

        assertNotNull(User.authenticate("bob@gmail.com", "secret"));
        assertNull(User.authenticate("bob@gmail.com", "badpassword"));
        assertNull(User.authenticate("tom@gmail.com", "secret"));
    }
	
	@Test
    public void findGuestbookInvolving() {
        new User("bob@gmail.com", "Bob", "secret").save();
        new User("jane@gmail.com", "Jane", "secret").save();

        Guestbook.create("안녕하세요.", "bob@gmail.com");
        Guestbook.create("반갑습니다.", "jane@gmail.com");

        List<Guestbook> results = Guestbook.findbyAuthor("bob@gmail.com");
        assertEquals(1, results.size());
        assertEquals("안녕하세요.", results.get(0).contents);
    }
	
	@Test
    public void findGuestbookLikerInvolving() {
        User bob = new User("bob@gmail.com", "Bob", "secret");
        bob.save();

        Guestbook guestbook = Guestbook.create("안녕하세요.", "bob@gmail.com");
        Guestbook.like(guestbook.id, "bob@gmail.com");
        
        List<Guestbook> results = Guestbook.findLikedGuestbook("bob@gmail.com");
        assertEquals(1, results.size());
        assertEquals("bob@gmail.com", results.get(0).liker.get(0).email);
    }
	
	
	
}