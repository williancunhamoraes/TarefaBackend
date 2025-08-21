package com.tarefas.gerenciador_tarefas.dto;

import com.tarefas.gerenciador_tarefas.model.enums.StatusTarefa;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TarefaRespostaDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private StatusTarefa status;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private String usuarioAtualizacao;
}
