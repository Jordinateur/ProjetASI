package hs.ejb;

import hs.entity.Record;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface RecordManagerRemote {
	public Record findRecordByMatchAndGardien(int idMatch, int idGardien);
	public List<Record> findAll();
}
