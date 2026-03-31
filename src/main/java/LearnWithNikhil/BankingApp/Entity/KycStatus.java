package LearnWithNikhil.BankingApp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.stereotype.Component;


public enum KycStatus {

    PENDING,        // customer registered, KYC not started
    IN_PROGRESS,    // KYC documents submitted, under review
    VERIFIED,       // KYC approved ✅
    REJECTED,       // KYC rejected ❌
    EXPIRED         // KYC was verified but expired
}
