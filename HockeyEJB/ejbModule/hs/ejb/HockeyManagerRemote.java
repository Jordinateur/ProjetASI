package hs.ejb;

import hs.entity.Equipe;

import java.util.List;

import javax.ejb.Remote;


@Remote
public interface HockeyManagerRemote {
	public Equipe add(Equipe equipe);
	public Equipe findEquipe(int id);
	public List<Equipe> allEquipe();

}
