package LearnWithNikhil.BankingApp.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateCustomerRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
}
