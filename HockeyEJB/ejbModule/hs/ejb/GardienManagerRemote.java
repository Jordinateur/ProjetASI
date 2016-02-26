package hs.ejb;

import hs.entity.Gardien;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface GardienManagerRemote {
	public Gardien add(Gardien gardien);
	public Gardien findGardien(int id);
	public List<Gardien> allGardien();
}
