package org.miguel;

import java.util.List;

public interface Searcher {

	<T> List<T> findMatching(Criteria criteria);
	
	
}
