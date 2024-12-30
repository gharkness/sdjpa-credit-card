package guru.springframework.creditcard.domain;

import guru.springframework.creditcard.interceptors.EncryptedString;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EntityListeners(CreditCardJPACallback.class)
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @EncryptedString
    private String creditCardNumber;

    private String cvv;

    private String expirationDate;

    @PrePersist
    public void prePersistCallback() {
        System.out.println("JPA @PrePersist callback");
    }
}
