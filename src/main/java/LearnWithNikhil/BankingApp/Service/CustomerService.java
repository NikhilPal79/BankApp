package LearnWithNikhil.BankingApp.Service;

import LearnWithNikhil.BankingApp.Dto.CustomerCreatedResponse;
import LearnWithNikhil.BankingApp.Dto.CustomerRequest;
import LearnWithNikhil.BankingApp.Entity.Customer;
import LearnWithNikhil.BankingApp.Entity.KycStatus;
import LearnWithNikhil.BankingApp.Mapper.CustomerMapper;
import LearnWithNikhil.BankingApp.Repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomerService {


    private final CustomerRepo customerRepo;


    private final CustomerMapper  customerMapper;




    public CustomerCreatedResponse create(CustomerRequest request) {

        Customer entity = customerMapper.toEntity(request);
        entity.setActive(false);
        entity.setKycStatus(KycStatus.PENDING);
        entity.setRequestFingerprint("abc");

        Customer saved = customerRepo.saveAndFlush(entity);
        return customerMapper.toCreatResponse(saved);
    }




}
