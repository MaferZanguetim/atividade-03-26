package application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.model.Tarefa;
import application.repository.TarefaRepository;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    @Autowired
    private TarefaRepository tarefaRepo;

    @GetMapping
    public List<Tarefa> tarefas(){
        return(List<Tarefa>) tarefaRepo.findAll();
    }

    @GetMapping("/{id}")
    public Tarefa getTarefa(@PathVariable Long id){
        return tarefaRepo.findById(id).get();
    }

    @PostMapping
    public Tarefa post()
}
