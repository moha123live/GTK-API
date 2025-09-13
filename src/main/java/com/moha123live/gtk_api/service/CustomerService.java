package com.moha123live.gtk_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moha123live.gtk_api.dto.requestDto.CustomerRequestDto;
import com.moha123live.gtk_api.dto.responseDto.CustomerResponseDto;
import com.moha123live.gtk_api.mapper.CustomerMapper;
import com.moha123live.gtk_api.model.Customer;
import com.moha123live.gtk_api.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerResponseDto> getAllCustomers() {
        List<Customer> customers= customerRepository.findAll();
        List<CustomerResponseDto> responseList = new ArrayList<>();
        for(Customer customer : customers){
            responseList.add(CustomerMapper.toResponseDto(customer));
        }
        return responseList;
    }

    public CustomerResponseDto getCustomerById(Integer id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
        CustomerResponseDto response = CustomerMapper.toResponseDto(customer);
        return response;
    }

    public CustomerResponseDto createCustomer(CustomerRequestDto request) {
        Customer customer = CustomerMapper.toEntity(request);
        Customer data = customerRepository.save(customer);
        System.out.println("data  ==  " + data);
        return CustomerMapper.toResponseDto(data);
    }

    public CustomerResponseDto updateCustomer(CustomerRequestDto request,Integer id) {
        Customer customer = CustomerMapper.toEntity(request);
        customer.setCusId(id);
        Customer data = customerRepository.save(customer);
        return CustomerMapper.toResponseDto(data);
    }

    public String deleteCustomer(int id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer is not found"));
        customer.setIsDeleted(true);
        customerRepository.save(customer);
        return "Deleted Successfully";
    }

    public List<CustomerResponseDto> getCustomersByName(String name) {
        List<Customer> customers = customerRepository.findByNameContainingIgnoreCase(name);
        List<CustomerResponseDto> responseList = new ArrayList<>();
        for (Customer customer : customers) {
            responseList.add(CustomerMapper.toResponseDto(customer));
        }
        return responseList;
    }

    public List<CustomerResponseDto> createAllCustomers(List<CustomerRequestDto> requests) {
        List<Customer> customersToSave = new ArrayList<>();
        for (CustomerRequestDto request : requests) {
            Customer customer = CustomerMapper.toEntity(request);
            customersToSave.add(customer);
        }
        List<Customer> savedCustomers = customerRepository.saveAll(customersToSave);
        List<CustomerResponseDto> responseList = new ArrayList<>();
        for (Customer customer : savedCustomers) {
            responseList.add(CustomerMapper.toResponseDto(customer));
        }
        return responseList;
    }
}
