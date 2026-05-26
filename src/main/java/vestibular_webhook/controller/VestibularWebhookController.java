package vestibular_webhook.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import vestibular_webhook.dto.VestibularWebhookRequest;
import vestibular_webhook.service.VestibularWebhookService;

@RestController
@RequestMapping("/webhook/vestibular")
public class VestibularWebhookController {

    private final VestibularWebhookService service;

    @Value("${webhook.token}")
    private String webhookToken;

    public VestibularWebhookController(VestibularWebhookService service) {
        this.service = service;
    }

    @PostMapping("/aprovacao")
    public ResponseEntity<String> receberWebhook(

            @RequestHeader(value = "Authorization", required = false)
            String authorization,

            @RequestBody VestibularWebhookRequest request
    ) {

        if (authorization == null ||
                !authorization.equals("Bearer " + webhookToken)) {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Token inválido");
        }

        service.processarAprovacao(request);

        return ResponseEntity.ok("Webhook processado com sucesso");
    }
}