package kodlama.io.devs.dataAccess.abstracts;

import kodlama.io.devs.entities.concretes.ProgrammingLanguages;

import java.util.List;

public interface ProgrammingLanguageRepository {

    List<ProgrammingLanguages> getAll();
    void add(ProgrammingLanguages programmingLanguage);

    void delete(int id);

    ProgrammingLanguages update (int id, ProgrammingLanguages newProgrammingLanguage);

    ProgrammingLanguages getByID(int id);







}
