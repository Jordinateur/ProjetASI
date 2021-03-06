package hs.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@SuppressWarnings("serial")
@Entity
@NamedQueries ({ 
	@NamedQuery(name="findAllMatchHockey", query="SELECT m FROM MatchHockey m"),
})
public class MatchHockey implements Serializable{
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "equipe1_id")
	private Equipe equipe1;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "equipe2_id")
	private Equipe equipe2;
	
	
	private String stade;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Equipe getEquipe1() {
		return equipe1;
	}


	public void setEquipe1(Equipe equipe1) {
		this.equipe1 = equipe1;
	}


	public Equipe getEquipe2() {
		return equipe2;
	}


	public void setEquipe2(Equipe equipe2) {
		this.equipe2 = equipe2;
	}


	public String getStade() {
		return stade;
	}


	public void setStade(String stade) {
		this.stade = stade;
	}


	public String toString(){
		return "Match : " + this.equipe1.getNom() + " VS " + this.equipe2.getNom();
	}


	public String toJson() {
		String json = "{";
		json += "id : " + Integer.toString(this.id) + ",";
		json += "stade : '" + this.stade + "',";
		json += "equipe1 : '" + this.equipe1.getNom() + "',";
		json += "equipe2 : '" + this.equipe2.getNom() + "',";
		return json + " }";
	}
	
	
}
