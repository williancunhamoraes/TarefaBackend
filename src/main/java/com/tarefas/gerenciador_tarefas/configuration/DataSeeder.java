package com.tarefas.gerenciador_tarefas.configuration;

import com.tarefas.gerenciador_tarefas.model.Tarefa;
import com.tarefas.gerenciador_tarefas.model.enums.StatusTarefa;
import com.tarefas.gerenciador_tarefas.repository.TarefaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(TarefaRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                IntStream.rangeClosed(1, 11).forEach(i -> {
                    Tarefa t = Tarefa.builder()
                            .titulo("Tarefa " + i)
                            .descricao("Descrição da tarefa número " + i)
                            .status(i % 3 == 0 ? StatusTarefa.CONCLUIDA
                                    : i % 2 == 0 ? StatusTarefa.EM_ANDAMENTO
                                    : StatusTarefa.PENDENTE)
                            .dataCriacao(LocalDateTime.now())
                            .usuarioAtualizacao("seeder")
                            .build();
                    repo.save(t);
                });
            }
        };
    }
}
