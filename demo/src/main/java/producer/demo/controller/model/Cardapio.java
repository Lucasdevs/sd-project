package producer.demo.controller.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Cardapio {

    @NotBlank
    private String nome;

    @NotBlank
    private String comidas;
}
