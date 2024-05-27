package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.dtos.AtualizarNotasRequest;
import br.com.alunoonline.api.model.Disciplina;
import br.com.alunoonline.api.model.MatriculaAluno;
import br.com.alunoonline.api.service.DisciplinaService;
import br.com.alunoonline.api.service.MatriculaAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matricula-aluno")
public class MatriculaAlunoController {

    @Autowired
    MatriculaAlunoService matriculaAlunoService;
    @Autowired
    private DisciplinaService disciplinaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void created(@RequestBody MatriculaAluno matriculaAluno)
        { matriculaAlunoService.create(matriculaAluno);
    }

    @GetMapping("/professor/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Disciplina> findByProfessorId(@PathVariable Long id){
        return disciplinaService.findByProfessorId(id);
    }

    @PatchMapping("/update-grades/{matriculaAlunoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGrades(@RequestBody AtualizarNotasRequest atualizarNotasRequest,
                             @PathVariable Long matriculaAlunoId) {
        matriculaAlunoService.updateGrades(matriculaAlunoId, atualizarNotasRequest);
    }

    @PatchMapping("/update-status-to-break/{matriculaAlunoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatusToBreak(@PathVariable Long matriculaAlunoId) {
        matriculaAlunoService.updateStatusToBreak(matriculaAlunoId);
    }
}