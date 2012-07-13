package control.DAO;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="event")
public class Event implements Serializable {
	
	@Id
	@GeneratedValue
    private Long id;
    private int duration;
    private String name;
    @Column(name="start_date")
    private Date startDate;

    public Event() { }
    public Event(String name) {  this.name = name;  }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name;   }

    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

}