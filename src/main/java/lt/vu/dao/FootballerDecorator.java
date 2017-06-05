package lt.vu.dao;


import lt.vu.api.DAOapi;
import lt.vu.entities.Footballer;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public class FootballerDecorator implements DAOapi{

    @Inject
    @Delegate
    @Any
    DAOapi daOapi;

    @Override
    public void create(Footballer footballer) {

        footballer.setSalary(footballer.getSalary() + 100);
        daOapi.create(footballer);
    }
}
