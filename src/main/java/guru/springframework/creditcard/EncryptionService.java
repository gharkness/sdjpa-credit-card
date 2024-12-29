package guru.springframework.creditcard;

public interface EncryptionService {

    String encrypt(String freeText);

    String decrypt(String encryptedText);
}
