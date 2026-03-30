package LearnWithNikhil.BankingApp.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequest {


    /// dto means what api accepts  and returns
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String externalId;
}
