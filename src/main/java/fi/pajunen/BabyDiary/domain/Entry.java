package fi.pajunen.BabyDiary.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Entry {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotEmpty
    private String entrydate;
	
    private int nightnursing;
    private int daynursing;
    private int poopdiaper;
    private int peediaper;
    private String other;
    
    @ManyToOne
    @JoinColumn(name = "categoryid")
    @JsonIgnore
    private Category category;

	public Entry() {
		super();
	}

	public Entry(String entrydate, int nightnursing, int daynursing, int poopdiaper, int peediaper, String other, 
			Category category) {
		super();
		this.entrydate = entrydate;
		this.nightnursing = nightnursing;
		this.daynursing = daynursing;
		this.poopdiaper = poopdiaper;
		this.peediaper = peediaper;
		this.other = other;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(String entrydate) {
		this.entrydate = entrydate;
	}

	public int getNightnursing() {
		return nightnursing;
	}

	public void setNightnursing(int nightnursing) {
		this.nightnursing = nightnursing;
	}

	public int getDaynursing() {
		return daynursing;
	}

	public void setDaynursing(int daynursing) {
		this.daynursing = daynursing;
	}

	public int getPoopdiaper() {
		return poopdiaper;
	}

	public void setPoopdiaper(int poopdiaper) {
		this.poopdiaper = poopdiaper;
	}

	public int getPeediaper() {
		return peediaper;
	}

	public void setPeediaper(int peediaper) {
		this.peediaper = peediaper;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Entry [id=" + id + ", entrydate=" + entrydate + ", nightnursing=" + nightnursing + ", daynursing="
				+ daynursing + ", poopdiaper=" + poopdiaper + ", peediaper=" + peediaper + ", other=" + other
				+ ", category=" + category + "]";
	}

}
