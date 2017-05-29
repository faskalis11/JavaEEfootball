package lt.vu.controllers;

import lt.vu.api.TaxesCalculator;
import lt.vu.dao.TaxesDAO;
import lt.vu.entities.Taxes;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public class IncomeTaxesCalculator implements TaxesCalculator {

    @Inject
    @Delegate
    @Any
    TaxesCalculator taxes;

    @Inject
    TaxesDAO taxesDAO;

    public int takeTaxes(int salary){
        //taxes.takeTaxes(salary);
        Taxes taxes = new Taxes();
        taxes.setTaxes_sum(salary*2);
        taxesDAO.create(taxes);
        return salary;
    }

}
