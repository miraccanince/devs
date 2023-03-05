package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.entities.concretes.ProgrammingLanguages;

import java.util.List;

public interface ProgammingLanguageService {

    List<ProgrammingLanguages> getAll();
    void add(ProgrammingLanguages programmingLanguage) throws  Exception;

    void delete(int id) ;

    ProgrammingLanguages update (int id, ProgrammingLanguages newProgrammingLanguage) throws Exception;

    ProgrammingLanguages getByID(int id);
}
