package vestibular_webhook.service;

import org.springframework.stereotype.Service;
import vestibular_webhook.dto.VestibularWebhookRequest;

@Service
public class VestibularWebhookService {

    public void processarAprovacao(VestibularWebhookRequest request) {

        System.out.println("=== WEBHOOK RECEBIDO ===");

        System.out.println("CPF: " + request.getCpf());
        System.out.println("IDPS: " + request.getIdps());
        System.out.println("Nota: " + request.getNota());
        System.out.println("Status: " + request.getStatus());
    }
}