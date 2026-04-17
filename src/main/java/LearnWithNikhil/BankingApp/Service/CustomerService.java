package LearnWithNikhil.BankingApp.Service;

import LearnWithNikhil.BankingApp.Dto.CustomerCreatedResponse;
import LearnWithNikhil.BankingApp.Dto.CustomerRequest;
import LearnWithNikhil.BankingApp.Entity.Customer;
import LearnWithNikhil.BankingApp.Entity.KycStatus;
import LearnWithNikhil.BankingApp.Mapper.CustomerMapper;
import LearnWithNikhil.BankingApp.Repo.CustomerRepo;
import LearnWithNikhil.BankingApp.Utility.Fingerprints;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepo customerRepo;
    private final CustomerMapper  customerMapper;


    public CustomerCreatedResponse create(CustomerRequest request) {

        String externalId = request.getExternalId();
        String fp = Fingerprints.customerCreate(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPhone(),
                        request.getAddress());

        /// FAST PATH: SAME EXTERNAL ID ALREADY PRESENT ?

        Optional<Customer> byExt = customerRepo.findByExternalId(externalId);

        if (byExt.isPresent()) {
            Customer ex = byExt.get();

            if (fp.equals(ex.getRequestFingerprint())) {
                return customerMapper.toCreatResponse(ex); ///idempotent replay
            }
            System.out.println(" CONFLICT DISCOVERED. THIS EXTERNAL ID EXISTS ");

        }

        ///  NEW ENTRY
        Customer entity = customerMapper.toEntity(request);
        entity.setActive(false);
        entity.setKycStatus(KycStatus.PENDING);
        entity.setRequestFingerprint(fp);

        Customer saved = customerRepo.saveAndFlush(entity);
        return customerMapper.toCreatResponse(saved);
    }




}
