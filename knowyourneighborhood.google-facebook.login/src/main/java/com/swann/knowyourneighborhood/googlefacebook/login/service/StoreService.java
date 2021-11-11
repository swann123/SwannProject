package com.swann.knowyourneighborhood.googlefacebook.login.service;

import java.util.List;
import com.swann.knowyourneighborhood.googlefacebook.login.dao.Store;

public interface StoreService {
	public List<Store> viewStore();
	
	public List<Store> searchByKey(String key);

}

















