package LearnWithNikhil.BankingApp.Dto;

import LearnWithNikhil.BankingApp.Entity.KycStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String externalId;

    @Enumerated(EnumType.STRING)
    private KycStatus kycStatus;

    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
