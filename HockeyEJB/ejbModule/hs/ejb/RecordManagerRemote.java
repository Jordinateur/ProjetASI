package hs.ejb;

import hs.entity.MatchHockey;
import hs.entity.Record;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface RecordManagerRemote {
	public Record add(Record record);
	public Record findRecord(int id);
	public Record findRcordByMatch(int id);
}
