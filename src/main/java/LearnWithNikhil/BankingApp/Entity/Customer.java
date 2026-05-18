package LearnWithNikhil.BankingApp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "version", nullable = false)
    private Integer version;  /// for optimistic concurrency
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name",  nullable = false)
    private String lastName;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address", nullable = false)
    private String address;

}
