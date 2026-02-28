package com.codurance.dip;

import java.time.MonthDay;

public class BirthdayGreeter {
    private final EmployeeRepository employeeRepository;
    private final Clock clock;
    private final GreetingSender greetingSender;

    public BirthdayGreeter(EmployeeRepository employeeRepository, Clock clock, GreetingSender greetingSender) {
        this.employeeRepository = employeeRepository;
        this.clock = clock;
        this.greetingSender = greetingSender;
    }

    public void sendGreetings() {
        MonthDay today = clock.monthDay();
        employeeRepository.findEmployeesBornOn(today)
                .stream()
                .map(employee -> emailFor(employee))
                .forEach(email -> greetingSender.send(email));  // UPDATED
    }

    private Email emailFor(Employee employee) {
        String message = String.format("Happy birthday, dear %s!", employee.getFirstName());
        return new Email(employee.getEmail(), "Happy birthday!", message);
    }
}