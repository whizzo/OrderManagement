package com.example.OrderManagement.System.Controller;


import com.example.OrderManagement.System.Entity.Supplier;
import com.example.OrderManagement.System.Service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/supplier")

public class SupplierController {

    private final SupplierService supplierService;


    @Autowired
    public SupplierController(SupplierService supplierService) {this.supplierService = supplierService;}


    @GetMapping
    public List<Supplier> getSuppliers(){return supplierService.getSuppliers();}


    @GetMapping(path = "{supplierID}")
    public Optional<Supplier> getSupplier(@PathVariable ("supplierID") Long id) throws Exception{
        return supplierService.getSupplier(id);
    }

    @PostMapping
    public void registerNewSupplier(@RequestBody Supplier supplier) throws Exception{
        supplierService.addNewSupplier(supplier);
    }

    @DeleteMapping(path = "{supplierID}")
    public void deleteSupplier(@PathVariable("supplierID") Long id) {supplierService.deleteSupplier(id);}


    @PutMapping(path = "{supplierID}")
    public void updateSupplier(
            @PathVariable("supplierID") Long id,
            @RequestBody Supplier supplier){
            supplierService.updateSupplier(id, supplier);
    }

}
