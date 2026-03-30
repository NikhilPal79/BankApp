package LearnWithNikhil.BankingApp.Dto;

import LearnWithNikhil.BankingApp.Entity.KycStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerCreatedResponse {

    private String externalID;
    private KycStatus kycStatus;
    private Integer version;
    private LocalDateTime createdAt;

}
