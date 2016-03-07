package hs.ejb;

import hs.entity.MatchHockey;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface MatchHockeyManagerRemote {
	public List<MatchHockey> findAll();
}
