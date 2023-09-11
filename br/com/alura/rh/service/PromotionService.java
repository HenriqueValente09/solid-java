package br.com.alura.rh.service;

import br.com.alura.rh.ValidationException;
import br.com.alura.rh.model.Employee;
import br.com.alura.rh.model.Position;

public class PromotionService {

    public void promote(Employee employee, boolean goalAchieved) {
        Position currentPosition = employee.getPosition();
        if(Position.MANAGER == currentPosition){
            throw new ValidationException("Managers cannot be promoted!");
        };

        if (goalAchieved) {
            Position newPosition = currentPosition.getNextPosition();
            employee.promote(newPosition);
        } else {
            throw new ValidationException("The employee didn't achieve the goal!");
        }
    }
}
