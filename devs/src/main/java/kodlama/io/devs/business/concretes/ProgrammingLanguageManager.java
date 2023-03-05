package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.ProgammingLanguageService;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguages;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgammingLanguageService {

    private ProgrammingLanguageRepository programmingLanguageRepository;

    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public List<ProgrammingLanguages> getAll() {
        return programmingLanguageRepository.getAll();
    }

    @Override
    public void add(ProgrammingLanguages programmingLanguage) throws Exception {
        if (programmingLanguage.getName().isEmpty()) {
            throw new Exception("The programming language name cannot be empty");
        } else {
            for (ProgrammingLanguages programmingLanguage2 : getAll()) {
                if (programmingLanguage2.getName().equals(programmingLanguage.getName())) {
                    throw new Exception("The programming language is already exist!"); // Ends the whole method.

                } else {
                    // Executes once for every single existing language.
                }
            }
            programmingLanguageRepository.add(programmingLanguage); // Only reaches this point, if there was no previous error.
        }
    }

    @Override
    public void delete(int id) {
        programmingLanguageRepository.delete(id);

    }

    @Override
    public ProgrammingLanguages update(int id, ProgrammingLanguages newProgrammingLanguage) throws Exception {
        for (ProgrammingLanguages programmingLanguages : getAll()) {
            if (newProgrammingLanguage.getName().equals(programmingLanguages.getName())) {
                throw new Exception("The programming language is already exist!");
            }
        }
        programmingLanguageRepository.update(id, newProgrammingLanguage);
        return newProgrammingLanguage;
    }

    @Override
    public ProgrammingLanguages getByID(int id) {
        return programmingLanguageRepository.getByID(id);
    }
}
