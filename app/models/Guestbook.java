package models;

import java.util.*;
import javax.persistence.*;

import org.apache.commons.codec.digest.DigestUtils;

import play.db.ebean.*;
import play.data.format.Formats.*;
import play.data.validation.Constraints.*;

@Entity 
@Table(name="guestbook")
public class Guestbook extends Model {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
    public Long id;

    @Required
    @MinLength(4)
    public String name;
    
    @Required
    @Email
    public String email;
    
    @Required
    @MinLength(6)
    public String password;

    @NonEmpty
    public String content;
    
    @DateTime(pattern="MM/dd/yy")
    public Date postAt;
    
    // -- Querie  //
    public static Model.Finder<Long,Guestbook> find = new Model.Finder(Long.class, Guestbook.class);

	public static Guestbook findbyIDPW(Long id2, String password2) {
		return find.where()
	            .eq("email", id2)
	            .eq("password", DigestUtils.md5Hex( password2 ))
	            .findUnique();
	}
    
}