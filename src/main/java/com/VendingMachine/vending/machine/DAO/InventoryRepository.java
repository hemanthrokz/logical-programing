package com.VendingMachine.vending.machine.DAO;
    import com.VendingMachine.vending.machine.Entity.Inventry;
    import org.springframework.data.jpa.repository.JpaRepository;

   // import java.util.List;


public interface InventoryRepository extends JpaRepository<Inventry, Integer> {

        // that's it ... no need to write any code!

    // METHOD TO SORT PRODUCT ID IN ASCENDING ORDER .ITS A SPRING DATA JPA PRE DEFINED METHODS.
       // public List<Inventry> findAllByOrderByProductIdAsc();

    }


