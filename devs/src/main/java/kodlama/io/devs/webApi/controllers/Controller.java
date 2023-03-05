package kodlama.io.devs.webApi.controllers;

import kodlama.io.devs.business.abstracts.ProgammingLanguageService;
import kodlama.io.devs.entities.concretes.ProgrammingLanguages;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/programminglanguages")
public class Controller {
    private ProgammingLanguageService progammingLanguageService;
    public Controller(ProgammingLanguageService progammingLanguageService) {
        this.progammingLanguageService = progammingLanguageService;
    }
    @GetMapping("/getall")
    public List<ProgrammingLanguages> getAll() {
        return progammingLanguageService.getAll();
    }
    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody ProgrammingLanguages programmingLanguage) throws Exception {
        try {
            progammingLanguageService.add(programmingLanguage);
            return ResponseEntity.created(null).body("created");
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {progammingLanguageService.delete(id);}

    @PutMapping("/update/{id}")
    public ResponseEntity<ProgrammingLanguages> update(@PathVariable("id") int id, @RequestBody ProgrammingLanguages newProgrammingLanguage) throws Exception {
        try {
            return ResponseEntity.ok(progammingLanguageService.update(id, newProgrammingLanguage));
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
            return ResponseEntity.badRequest().body(null);
        }
    }
    @GetMapping("/getbyid/{id}")
    public ProgrammingLanguages getById(@PathVariable("id") int id) {
        return progammingLanguageService.getByID(id);
    }


}
