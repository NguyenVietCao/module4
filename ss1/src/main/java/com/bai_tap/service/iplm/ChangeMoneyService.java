package com.bai_tap.service.iplm;

import org.springframework.stereotype.Service;
import com.bai_tap.service.IChangeMoneyService;

@Service
public class ChangeMoneyService implements IChangeMoneyService {

    @Override
    public double convertMoney(Double money) {
        return money * 2300;
    }
}
