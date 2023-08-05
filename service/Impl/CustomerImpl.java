package booking.service.Impl;

import booking.Repository.CustomerRepository;
import booking.entities.Customer;
import booking.exception.CustomerNotFoundException;
import booking.payload.CustomerDto;
import booking.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerImpl implements CustomerService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        //Convert Dto to entity
     Customer customer =   mapToEntity(customerDto);

        Customer newCustomer = customerRepository.save(customer);
        //convert Entity to dto
      CustomerDto customerResponse =  mapToDto(newCustomer);
        return customerResponse;
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        List<Customer> all = customerRepository.findAll();
        return all.stream().map(allcustomer->mapToDto(allcustomer)).collect(Collectors.toList());

    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        Customer customerFoundById = customerRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException("Customer not found by id")
        );
        return mapToDto(customerFoundById);
    }

    @Override
    public CustomerDto updateCustomerById(CustomerDto customerDto, Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException("updated customer not found")
        );

        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());

        customer.setMobile(customerDto.getMobile());
        customer.setAddress(customerDto.getAddress());
        Customer updatedCustomer = customerRepository.save(customer);

        return mapToDto(updatedCustomer);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.findById(id).orElseThrow(
                ()->new CustomerNotFoundException("customer is not deleted")
        );
        customerRepository.deleteById(id);


    }

    private CustomerDto mapToDto(Customer newCustomer) {
        CustomerDto dto = mapper.map(newCustomer, CustomerDto.class);
        return dto;
    }


    private Customer mapToEntity(CustomerDto customerDto) {
        Customer customer = mapper.map(customerDto, Customer.class);
        return customer;


    }
}
