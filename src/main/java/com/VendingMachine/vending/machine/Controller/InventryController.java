package com.VendingMachine.vending.machine.Controller;



import java.math.BigDecimal;
        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;

        import javax.annotation.PostConstruct;

        import com.VendingMachine.vending.machine.Entity.Inventry;
        import com.VendingMachine.vending.machine.service.InventoryService;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/products")
public class InventryController {


    private InventoryService inventoryService;
    // load employee data
    //public HashMap<Integer, Inventry> product = new HashMap<Integer, Inventry>();
    private BigDecimal BalanceAmount;


    public InventryController(InventoryService theInventoryService) {
        inventoryService=theInventoryService;      //constructor injection
    }

    public BigDecimal getBalanceAmount() {
        return BalanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        BalanceAmount = balanceAmount;
    }
//    public HashMap<Integer, Inventry> getProduct() {
//        return product;
//    }
//
//    public void setProduct(HashMap<Integer, Inventry> product) {
//        this.product = product;
//    }
//    @PostConstruct
//    private void loadData() {
//
//        // create employees
//        product.put(1,new Inventry("coke", 1, 3, 3.0));
//        product.put(2,new Inventry("pepsi", 2, 7, 2.0));
//        product.put(3,new Inventry("mazza", 3, 4, 5.0));
//        BalanceAmount=new BigDecimal(100);
//
//    }

    // add mapping for "/list"

    @GetMapping("/home")
    public String homeEmployees(Model theModel) {

        // get products details from db
        List<Inventry> products = inventoryService.findAll();

        // add to the spring model
        theModel.addAttribute("products", products);
        return "home-products";
    }
    @GetMapping("/showFormForPurchase")
    public String showFormForPurchase(@RequestParam("productId") int theId,
                                    Model theModel) {

        // get the employee from the service
        Inventry inventry = inventoryService.findByIdAndPurchase(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("product_showFormForAdd", inventry);

        // send over to our form
        return "purchase-form";
    }
    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        // get products details from db
        List<Inventry> products = inventoryService.findAll();

        // add to the spring model
        theModel.addAttribute("products", products);
        return "list-products";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Inventry product = new Inventry();

        theModel.addAttribute("product_showFormForAdd", product);

        return "product-form";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("productId") int theId,
                                    Model theModel) {

        // get the employee from the service
        Inventry inventry = inventoryService.findById(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("product_showFormForAdd", inventry);

        // send over to our form
        return "product-form";
    }

    @PostMapping("/save")
    public String saveInventory(@ModelAttribute("product_showFormForAdd") Inventry inventry) {

        // save the employee
        inventoryService.save(inventry);

        // use a redirect to prevent duplicate submissions
        return "redirect:list";
    }

    @PostMapping("/update")
    public String updateInventory(@ModelAttribute("product_showFormForAdd") Inventry inventry) {

        // save the employee
        inventoryService.save(inventry);

        // use a redirect to prevent duplicate submissions
        return "redirect:list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("productId") int theId) {

        // delete the employee
        inventoryService.deleteById(theId);

        // redirect to /employees/list
        return "redirect:list";

    }
}









