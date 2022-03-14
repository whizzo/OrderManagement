package com.example.OrderManagement.System.Service;



import com.example.OrderManagement.System.Entity.Supplier;
import com.example.OrderManagement.System.HttpExceptions.HttpRequestHandler;
import com.example.OrderManagement.System.Repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository){this.supplierRepository = supplierRepository;}

    public List<Supplier> getSuppliers(){ return supplierRepository.findAll(); }

    public Optional<Supplier> getSupplier(Long id) throws Exception{
        Optional<Supplier> supplierOptional = supplierRepository.findById(id);
        if(supplierRepository.findById(id).isPresent()){
            throw new HttpRequestHandler("Supplier with this id does not exist!");
        }
        return supplierOptional;
    }

    public void addNewSupplier(Supplier supplier) throws Exception {
        if(supplierRepository.findByName(supplier.getName()).isPresent()){
            throw new HttpRequestHandler("Supplier with this name exists!");
        }else{
            supplierRepository.save(supplier);
        }
    }

    public void deleteSupplier(Long id){
        if(supplierRepository.findById(id).isPresent()){
            supplierRepository.deleteById(id);
        }else{
            throw new HttpRequestHandler("Supplier does not exist! ");
        }
    }

    @Transactional
    public void updateSupplier(Long id, Supplier supplier){
        Supplier supplier1 = supplierRepository.getById(id);
        supplier1.setName(supplier.getName());
        supplierRepository.save(supplier1);
    }

}
