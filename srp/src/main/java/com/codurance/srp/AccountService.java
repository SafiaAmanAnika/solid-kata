package com.codurance.srp;

public class AccountService {

    private final TransactionRepository transactionRepository;
    private final Clock clock;

    public AccountService(TransactionRepository transactionRepository, Clock clock) {
        this.transactionRepository = transactionRepository;
        this.clock = clock;
    }

    public void deposit(int amount) {
        transactionRepository.add(new Transaction(clock.today(), amount));
    }

    public void withdraw(int amount) {
        transactionRepository.add(new Transaction(clock.today(), -amount));
    }
}
//Now it has ONE responsibility: Managing account transactions.