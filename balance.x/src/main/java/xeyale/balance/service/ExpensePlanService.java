package xeyale.balance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xeyale.balance.entity.ExpensePlan;
import xeyale.balance.repository.ExpensePlanRepository;

@Service
public class ExpensePlanService {

    @Autowired
    private ExpensePlanRepository expensePlanRepository;

    public ExpensePlan createPlan(ExpensePlan plan) {
        return expensePlanRepository.save(plan);
    }

    public void deletePlan(Long id) {
        expensePlanRepository.deleteById(id);
    }
}
