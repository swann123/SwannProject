package com.swann.knowyourneighborhood.googlefacebook.login.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swann.knowyourneighborhood.googlefacebook.login.dao.Store;
import com.swann.knowyourneighborhood.googlefacebook.login.repository.StoreRepository;

@Service
@Transactional
public class StoreServiceImpl implements StoreService{
	
	@Autowired
	private StoreRepository storeRepo;
	
	@Override
	public List<Store> viewStore() {
		return storeRepo.findAll();
	}

	@Override
	public List<Store> searchByKey(String key) {
		return storeRepo.searchByKey(key);
	}

}






