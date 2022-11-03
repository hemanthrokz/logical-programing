package com.VendingMachine.vending.machine.service;

import java.util.List;
import java.util.Optional;

import com.VendingMachine.vending.machine.DAO.InventoryRepository;
import com.VendingMachine.vending.machine.Entity.Inventry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InventoryServiceImpl implements InventoryService {

	private InventoryRepository inventoryRepository;
	
	@Autowired
	public InventoryServiceImpl(InventoryRepository theInventoryRepository) {
		inventoryRepository = theInventoryRepository;
	}
	
	@Override
	public List<Inventry> findAll() {
		return inventoryRepository.findAll();
	}

	@Override
	public Inventry findById(int theId) {
		Optional<Inventry> result = inventoryRepository.findById(theId);

		Inventry product = null;
		
		if (result.isPresent()) {
			product = result.get();
			System.out.println("######################################################################");
			System.out.println("");

			System.out.println("product in find by id "+product);
			System.out.println("");

			System.out.println("######################################################################");


		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return product;
	}
	@Override
	public Inventry findByIdAndPurchase(int theId) {
		Optional<Inventry> result = inventoryRepository.findById(theId);

		Inventry product = null;

		if (result.isPresent()) {
			product = result.get();
			System.out.println("product in find by id"+product);
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}

		return product;
	}

	@Override
	public void save(Inventry inventry) {
		inventoryRepository.save(inventry);
	}

//	@Override
//	public void update(Inventry inventry) {
//		inventoryRepository.update(inventry);
//	}

	@Override
	public void deleteById(int theId) {
		inventoryRepository.deleteById(theId);
	}

}






