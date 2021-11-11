package com.swann.knowyourneighborhood.googlefacebook.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swann.knowyourneighborhood.googlefacebook.login.dao.Store;
import com.swann.knowyourneighborhood.googlefacebook.login.service.StoreService;

@RestController
@RequestMapping("/knowyourneighborhood")
public class StoreController {
	@Autowired
	private StoreService storeService;
	
	@GetMapping("/view-stores")
	@PreAuthorize("hasRole('USER')")
		public List<Store> viewStore(){
				List<Store> stores = storeService.viewStore();
			return stores;
	}
	
	@GetMapping(value = "/store/search/{key}")
	@PreAuthorize("hasRole('USER')")
	public List<Store> searchByKey(@PathVariable String key) {
		return storeService.searchByKey(key);

	}
	
	
}





