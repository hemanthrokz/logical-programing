package com.VendingMachine.vending.machine.service;

import java.util.List;

import com.VendingMachine.vending.machine.Entity.Inventry;

public interface InventoryService {

	public List<Inventry> findAll();
	public Inventry findByIdAndPurchase(int theId);
	public Inventry findById(int theId);
	
	public void save(Inventry inventry);

	//public void update(Inventry inventry);

	public void deleteById(int theId);
	
}
