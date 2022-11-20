package producer.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import producer.demo.controller.model.Cardapio;
import producer.demo.service.CardapioProducerService;

import javax.validation.Valid;

@RestController
@RequestMapping("/cardapios")
public class CardapioController {

    @Autowired
    private CardapioProducerService cardapioProducerService;

    @PostMapping
    public void criarCardapio(@RequestBody @Valid Cardapio cardapio) throws JsonProcessingException {
        cardapioProducerService.enviarMensagem(new ObjectMapper().writeValueAsString(cardapio));
    }
}
