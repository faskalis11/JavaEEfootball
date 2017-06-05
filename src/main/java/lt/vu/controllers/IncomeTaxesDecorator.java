package lt.vu.controllers;

import lombok.Getter;
import lt.vu.api.TaxesCalculator;
import lt.vu.dao.TaxesDAO;
import lt.vu.entities.Taxes;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Decorator
public class IncomeTaxesDecorator implements TaxesCalculator {

    @Inject
    @Delegate
    @Any
    TaxesCalculator taxes;

    @Inject
    TaxesDAO taxesDAO;

//    @PersistenceContext
//    EntityManager em;

    @Getter
    private double taxCollected;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public double takeTaxes(int salary){
        //taxes.takeTaxes(salary);
        Taxes taxes = new Taxes();
        taxes.setTaxes_sum(salary);
        taxCollected += salary * 0.2;
        //taxesDAO.create(taxes);
        return salary * 0.2;
    }

}
