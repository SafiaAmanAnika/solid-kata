package com.codurance.srp;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.toCollection;

public class StatementPrinter {

    private static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";

    private final TransactionRepository transactionRepository;
    private final StatementFormatter formatter;
    private final Console console;

    public StatementPrinter(TransactionRepository transactionRepository,
                            StatementFormatter formatter,
                            Console console) {
        this.transactionRepository = transactionRepository;
        this.formatter = formatter;
        this.console = console;
    }

    public void print() {
        console.printLine(STATEMENT_HEADER);

        List<Transaction> transactions = transactionRepository.all();
        final AtomicInteger balance = new AtomicInteger(0);

        transactions.stream()
                .map(transaction ->
                        formatter.formatLine(
                                transaction,
                                balance.addAndGet(transaction.getAmount())))
                .collect(toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(console::printLine);
    }
}
// Responsibility: Generate and print the statement.