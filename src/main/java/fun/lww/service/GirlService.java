package fun.lww.service;

import fun.lww.entity.Girl;
import fun.lww.enums.ResultEnum;
import fun.lww.exception.GirlException;
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

    public void findAge(Integer id) throws GirlException{
        Girl girl = girlRepository.getOne(id);
        if (girl.getAge() <= 10) {
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (girl.getAge() > 10 && girl.getAge() <= 16) {
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    public Girl findGirl(Integer id) {
        return girlRepository.getOne(id);
    }
}
