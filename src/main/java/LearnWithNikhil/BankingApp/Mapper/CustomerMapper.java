package LearnWithNikhil.BankingApp.Mapper;


import LearnWithNikhil.BankingApp.Dto.CustomerCreatedResponse;
import LearnWithNikhil.BankingApp.Dto.CustomerRequest;
import LearnWithNikhil.BankingApp.Dto.CustomerResponse;
import LearnWithNikhil.BankingApp.Dto.UpdateCustomerRequest;
import LearnWithNikhil.BankingApp.Entity.Customer;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import org.springframework.stereotype.Component;



@Mapper(componentModel = "spring")
public interface CustomerMapper {


    /// use to convert dto into entity

    Customer toEntity(CustomerRequest customerRequest);

    CustomerResponse toResponse(Customer customer);

    CustomerCreatedResponse toCreatResponse(Customer customer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCustomerFromRequest(UpdateCustomerRequest request, @MappingTarget Customer customer);




}
