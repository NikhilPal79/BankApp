package LearnWithNikhil.BankingApp.Controller;

import LearnWithNikhil.BankingApp.Dto.CustomerCreatedResponse;
import LearnWithNikhil.BankingApp.Dto.CustomerRequest;
import LearnWithNikhil.BankingApp.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CustomerController {


    private  final CustomerService  customerService;

    @PostMapping("/customers")
    public ResponseEntity<CustomerCreatedResponse> createCustomer(@Valid @RequestBody CustomerRequest request){

        CustomerCreatedResponse body = customerService.create(request);
        URI loc = URI.create("/api/v1/customers/" + body.getExternalID());
        return ResponseEntity.created(loc).body(body);
    }
}
