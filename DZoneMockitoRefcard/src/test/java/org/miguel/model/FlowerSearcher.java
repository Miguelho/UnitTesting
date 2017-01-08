package org.miguel.model;

import java.util.Arrays;
import java.util.List;

import org.miguel.Criteria;
import org.miguel.Flower;
import org.miguel.Searcher;

public class FlowerSearcher implements Searcher {

	public <T> List<T> findMatching(Criteria criteria) {
			List<Flower> flowerList = Arrays.asList(new Flower(),new Flower());
		return (List<T>) flowerList;
	}


	
}
