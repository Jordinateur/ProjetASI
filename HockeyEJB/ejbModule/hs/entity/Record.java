package hs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
@Entity
@NamedQueries ({ 
	@NamedQuery(name="findRecordByMatchAndGardien", query="SELECT r FROM Record r WHERE r.gardien = :gardien AND r.match = :match"),
	@NamedQuery(name="findAllRecord", query="SELECT r FROM Record r")
})
public class Record {
	
	public MatchHockey getMatch() {
		return match;
	}

	public void setMatch(MatchHockey match) {
		this.match = match;
	}

	public Gardien getGardien() {
		return gardien;
	}

	public void setGardien(Gardien gardien) {
		this.gardien = gardien;
	}

	public ZonesBut getZoneButMarque() {
		return zoneButMarque;
	}

	public void setZoneButMarque(ZonesBut zoneButMarque) {
		this.zoneButMarque = zoneButMarque;
	}

	public ZonesBut getZoneButManque() {
		return zoneButManque;
	}

	public void setZoneButManque(ZonesBut zoneButManque) {
		this.zoneButManque = zoneButManque;
	}

	public ZonesTerrain getZoneTerrainMarque() {
		return zoneTerrainMarque;
	}

	public void setZoneTerrainMarque(ZonesTerrain zoneTerrainMarque) {
		this.zoneTerrainMarque = zoneTerrainMarque;
	}

	public ZonesTerrain getZoneTerrainManque() {
		return zoneTerrainManque;
	}

	public void setZoneTerrainManque(ZonesTerrain zoneTerrainManque) {
		this.zoneTerrainManque = zoneTerrainManque;
	}

	public Record(){
		this.zoneButManque = new ZonesBut();
		this.zoneButMarque = new ZonesBut();
		this.zoneTerrainManque = new ZonesTerrain();
		this.zoneTerrainMarque = new ZonesTerrain();
	}
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "match_id")
	private MatchHockey match;
	
	@OneToOne
	private Gardien gardien;
	
	@OneToOne
	private ZonesBut zoneButMarque;
	
	@OneToOne
	private ZonesBut zoneButManque;
	
	@OneToOne
	private ZonesTerrain zoneTerrainMarque;
	
	@OneToOne
	private ZonesTerrain zoneTerrainManque;
}
