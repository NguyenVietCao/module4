package ss3.repository;

import ss3.model.Mail;

import java.util.List;

public interface IMailRepository {
    List<Mail> findAll();

    void update(Mail mail);

    Mail findById(int id);

    List<String> findLanguages();

    List<Integer> findPageSize();

}
