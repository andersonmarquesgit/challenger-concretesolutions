package br.com.cs.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Phone {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	@ManyToOne
	private User user;
	
	private short ddd;
	private short number;
	
	public Phone(String phoneNumber) {
        // converte a string recebida para os dados internos
    }
	
    public Phone(long phoneNumber) {
        // converte o número recebido para os dados internos
    }
    
    public String getAsString() {
        return "" + " (" + ddd + ") " + number;
    }
    
    public Long getAsLong() {
		return new Long(ddd+number);
    }
    
    public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	public short getDdd() {
		return ddd;
	}
	
	public void setDdd(short ddd) {
		this.ddd = ddd;
	}
	
	public short getNumber() {
		return number;
	}
	
	public void setNumber(short number) {
		this.number = number;
	}
}
