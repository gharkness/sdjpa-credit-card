package guru.springframework.creditcard.listeners;

import guru.springframework.creditcard.EncryptionService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.springframework.stereotype.Component;

@Component
public class PreInsertListener extends AbstractEncryptionListener implements PreInsertEventListener {

    public PreInsertListener(EncryptionService encryptionService) {
        super(encryptionService);
    }

    @Override
    public boolean onPreInsert(PreInsertEvent event) {

        System.out.println("I'm in onPreInsert");

        this.encrypt(event.getState(), event.getPersister().getPropertyNames(), event.getEntity());

        return false;
    }
}
