package models;

import java.util.*;
import javax.persistence.*;

import org.apache.commons.codec.digest.DigestUtils;

import play.db.ebean.*;
import play.data.validation.*;

@Entity 
@Table(name="guestbook")
public class Guestbook extends Model {
    
    @Id
    public Long id;

    @Constraints.MinLength(4)
    public String name;
    
    @Constraints.Email
    public String email;
    
    @Constraints.Required
    public String password;

    public String content;
    public Date postAt;
    public static Model.Finder<Long,Guestbook> find = new Model.Finder<Long, Guestbook>(Long.class, Guestbook.class);
    public static Guestbook findbyIDPW(Long id2, String password2) {
		return find.where()
	            .eq("email", id2)
	            .eq("password", DigestUtils.md5Hex( password2 ))
	            .findUnique();
	}
    
    
}