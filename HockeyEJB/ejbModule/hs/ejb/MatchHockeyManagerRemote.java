package hs.ejb;

import hs.entity.MatchHockey;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface MatchHockeyManagerRemote {
	public MatchHockey add(MatchHockey matchHockey);
	public MatchHockey findMatchHockey(int id);
	public List<MatchHockey> allMatchHockey();
}
