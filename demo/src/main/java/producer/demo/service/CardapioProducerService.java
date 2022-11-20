package producer.demo.service;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import io.awspring.cloud.messaging.core.QueueMessageChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class CardapioProducerService {

    private String fila;

    private AmazonSQSAsync amazonSqs;

    public CardapioProducerService(@Autowired AmazonSQSAsync amazonSQSAsync,
                                    @Value("http://localhost:4566/000000000000/sqs-cardapios") String fila) {

        this.fila = fila;
        this.amazonSqs = amazonSQSAsync;
    }

    public void enviarMensagem(String mensagem) {
        MessageChannel messageChannel = new QueueMessageChannel(amazonSqs, fila);
        Message<String> message = MessageBuilder.withPayload(mensagem).setHeader("sender", "cardapio")
                .setHeaderIfAbsent("country", "AE").build();
        long waitTimeoutMillis = 1000;
        messageChannel.send(message, waitTimeoutMillis);
    }
}
