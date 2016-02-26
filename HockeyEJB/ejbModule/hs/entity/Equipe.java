package hs.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
@Entity
@NamedQueries ({ 
	@NamedQuery(name="findAllEquipe", query="SELECT e FROM Equipe e"),
})
public class Equipe implements Serializable {
	
	
	public Equipe() {}
	public Equipe(String nom) {
		this.nom = nom;
	}
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int id;
	private String nom;
	@OneToMany(mappedBy="equipe", fetch = FetchType.EAGER)
	private Set<Gardien> gardiens;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Set<Gardien> getGardiens() {
		return gardiens;
	}
	public void setGardiens(Set<Gardien> gardiens) {
		this.gardiens = gardiens;
	}
	@Override
	public String toString(){
		return "Equipe " + this.id + ": " + this.nom;
	}
	

}
