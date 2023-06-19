package ss3.repository;

import org.springframework.stereotype.Repository;
import ss3.model.Mail;

import java.util.ArrayList;
import java.util.List;

@Repository

public class MailRepository implements IMailRepository {

    private static final List<Mail> mailList = new ArrayList<>();
static {
    mailList.add(new Mail(1,"English",5,true,"thor"));
    mailList.add(new Mail(2,"VietNamese",10,true,"thor"));
    mailList.add(new Mail(3,"Janpanese",15,true,"thor"));
    mailList.add(new Mail(4,"Chinese",25,true,"thor"));
}
    @Override
    public List<Mail> findAll() {
        return mailList;
    }

    @Override
    public void update(Mail mail) {
        for (Mail m:mailList) {
            if (mail.getId() == m.getId()){
                m.setLanguages(mail.getLanguages());
                m.setPageSize(mail.getPageSize());
                m.setSpamsFilter(mail.getSpamsFilter());
                break;
            }
        }
    }

    @Override
    public Mail findById(int id) {
        for (Mail m:mailList) {
            if (m.getId() == id){
                return m;
            }
        }
    return null;
    }

    @Override
    public List<String> findLanguages() {
    List<String>stringList = new ArrayList<>();
    stringList.add("English");
    stringList.add("Vietnamese");
    stringList.add("Janpanese");
    stringList.add("Chinese");

    return stringList;
    }

    @Override
    public List<Integer> findPageSize() {
    List<Integer>integerList = new ArrayList<>();
    integerList.add(5);
    integerList.add(10);
    integerList.add(15);
    integerList.add(25);
    integerList.add(50);
    integerList.add(100);

    return integerList;
    }
}
