package lt.vu.api;


import lt.vu.entities.Footballer;

public interface SalaryCalculator {
    public Footballer calculateSalaryClub(Footballer player);
}
