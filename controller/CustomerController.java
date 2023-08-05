package booking.controller;

import booking.payload.CustomerDto;
import booking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //http://localhost:8080/api/customer
    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
      CustomerDto dto =   customerService.createCustomer(customerDto);
      return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }

    //http://localhost:8080/api/customer
    @GetMapping
    public List<CustomerDto> getAllCustomer(){
        return customerService.getAllCustomer();

    }
//http://localhost:8080/api/customer/id  testing 
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") Long id){
      return new ResponseEntity<>(customerService.getCustomerById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomerById(@PathVariable("id") Long id,@RequestBody CustomerDto customerDto){
      CustomerDto updateDto =  customerService.updateCustomerById(customerDto,id);
      return ResponseEntity.ok(updateDto);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable("id") Long id){
        customerService.deleteCustomerById(id);
        return new ResponseEntity<String>("Customer is Deleted!!..", HttpStatus.OK);
    }






}
