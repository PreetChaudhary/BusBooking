package booking.service;

import booking.payload.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);

    List<CustomerDto> getAllCustomer();


    CustomerDto getCustomerById(Long id);


    CustomerDto updateCustomerById(CustomerDto customerDto, Long id);

    void deleteCustomerById(Long id);
}
