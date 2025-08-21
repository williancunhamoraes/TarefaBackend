package com.tarefas.gerenciador_tarefas.repository;

import com.tarefas.gerenciador_tarefas.model.Tarefa;
import org.springframework.data.jpa.domain.Specification;

public class TarefaEspecificacoes {
    public static Specification<Tarefa> textoContem(String q) {
        if (q == null || q.isBlank()) return null;
        String like = "%" + q.toLowerCase() + "%";
        return (root, cq, cb) -> cb.or(
                cb.like(cb.lower(root.get("titulo")), like),
                cb.like(cb.lower(root.get("descricao")), like)
        );
    }
}
