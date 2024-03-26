package application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import application.model.Compromisso;
import application.repository.CompromissoRepository;

@RestController
public class CompromissoController {
    @Autowired
    private CompromissoRepository compRepo;

    @GetMapping("/compromissos")
    public List<Compromisso> compromissos(){
        return (List<Compromisso>) compRepo.findAll();
    }

    @GetMapping("/compromissos/{id}")
    public Compromisso getCompromisso(@PathVariable Long id){
        return compRepo.findById(id).get();
    }

    @PostMapping("/compromissos")
    public Compromisso post(@RequestBody Compromisso compromisso){
        return compRepo.save(compromisso);
    }

    @PutMapping("/compromissos/{id}")
    public Compromisso putCompromisso(
        @RequestBody Compromisso compromisso,
        @PathVariable Long id){
            Compromisso resposta = compRepo.findById(id).get();
            resposta.setDescricao(compromisso.getDescricao());
            resposta.setDataInicio(compromisso.getDataInicio());
            resposta.setDataFim(compromisso.getDataFim());
            resposta.setHoraInicio(compromisso.getHoraInicio());
            resposta.setHoraFim(compromisso.getHoraFim());

            return compRepo.save(resposta);
   }
   
   @DeleteMapping("/compromissos/{id}")
   public void deleteCompromissos(@PathVariable Long id){
        compRepo.deleteById(id);
   }
}
