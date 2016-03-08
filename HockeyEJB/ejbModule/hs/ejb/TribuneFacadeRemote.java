package hs.ejb;

import hs.entity.Gardien;
import hs.entity.MatchHockey;
import hs.entity.ZonesBut;
import hs.entity.ZonesTerrain;

import javax.ejb.Remote;

@Remote
public interface TribuneFacadeRemote {
	
	public void update();
	public void create(MatchHockey m,Gardien g);
	public ZonesTerrain getZTMr();
	public ZonesTerrain getZTMn();
	public ZonesBut getZBMr();
	public ZonesBut getZBMn();
	void addScore(int ZoneT, int ZoneB);

}
