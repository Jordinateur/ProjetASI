package hs.ejb;

import java.util.List;

public interface AbstractManagerRemote {
	public Object findOne();
	public List<?> findAll();
}
