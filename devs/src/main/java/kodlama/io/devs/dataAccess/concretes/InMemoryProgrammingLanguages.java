package kodlama.io.devs.dataAccess.concretes;


import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguages;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class InMemoryProgrammingLanguages implements ProgrammingLanguageRepository {

    List<ProgrammingLanguages> programmingLanguages;


    public InMemoryProgrammingLanguages() {
        programmingLanguages = Collections.synchronizedList(new ArrayList<>());
        programmingLanguages.add(new ProgrammingLanguages(1, "C#"));
        programmingLanguages.add(new ProgrammingLanguages(2, "Java"));
        programmingLanguages.add(new ProgrammingLanguages(3, "Python"));
    }

    @Override
    public List<ProgrammingLanguages> getAll() {
        return programmingLanguages;
    }

    @Override
    public void add(ProgrammingLanguages programmingLanguage) {
        programmingLanguages.add(programmingLanguage);
    }

    @Override
    public void delete(int id) {
        ProgrammingLanguages current = null;
        for (ProgrammingLanguages programmingLanguage : programmingLanguages) {
            if (programmingLanguage.getId() == id) {
                current = programmingLanguage;
                break;
            }
        }
            if (current != null) {
                programmingLanguages.remove(current);
            }

    }

    @Override
    public ProgrammingLanguages update(int id, ProgrammingLanguages newProgrammingLanguage) {
        for (ProgrammingLanguages programmingLanguage : programmingLanguages) {
            if (programmingLanguage.getId() == id) {
                programmingLanguage.setName(newProgrammingLanguage.getName());
            }
        }
        return newProgrammingLanguage;
    }

    @Override
    public ProgrammingLanguages getByID(int id) {
        for (ProgrammingLanguages programmingLanguage : programmingLanguages) {
            if (programmingLanguage.getId() == id) {
                return programmingLanguage;
            }
        }
        return null;
    }
}
