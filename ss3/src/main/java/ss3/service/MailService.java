package ss3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ss3.model.Mail;
import ss3.repository.IMailRepository;

import java.util.List;

@Service
public class MailService implements IMailService {
    @Autowired
    private IMailRepository iMailRepository;

    @Override
    public List<Mail> findAll() {
        return iMailRepository.findAll();
    }

    @Override
    public void update(Mail mail) {
        iMailRepository.update(mail);
    }

    @Override
    public Mail findById(int id) {
        return iMailRepository.findById(id);
    }

    @Override
    public List<String> findLanguages() {
        return iMailRepository.findLanguages();
    }

    @Override
    public List<Integer> findPageSize() {
        return iMailRepository.findPageSize();
    }
}
