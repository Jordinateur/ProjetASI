package hs.ejb;

import hs.entity.Equipe;

import java.util.List;

import javax.ejb.Remote;


@Remote
public interface HockeyManagerRemote {
	public List<Equipe> findAll();

}
