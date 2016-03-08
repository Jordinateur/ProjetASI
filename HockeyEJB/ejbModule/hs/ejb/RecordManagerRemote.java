package hs.ejb;

import hs.entity.Gardien;
import hs.entity.MatchHockey;
import hs.entity.Record;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface RecordManagerRemote {
	public Record findRecordByMatchAndGardien(MatchHockey match, Gardien gardien);
	public List<Record> findAll();
	public Record update(Record r);
}
