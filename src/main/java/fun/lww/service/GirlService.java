package fun.lww.service;

import fun.lww.entity.Girl;
import fun.lww.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertGirl() {
        Girl girl = new Girl();
        girl.setCupSize("A");
        girl.setAge(123);
        girlRepository.save(girl);

        Girl girl1 = new Girl();
        girl1.setCupSize("AA");
        girl1.setAge(123);
        girlRepository.save(girl1);
    }
}
