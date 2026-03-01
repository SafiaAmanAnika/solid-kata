# SRP Refactor

## Problem
The original `AccountService` class handled multiple responsibilities:
- Managing deposits and withdrawals  
- Calculating running balances  
- Formatting dates and amounts  
- Building statement lines  
- Printing to the console  

This violates SRP because the class had multiple reasons to change
A class should have only one reason to change

## Solution

Responsibilities were separated into focused classes.

### AccountService
Responsible only for business logic:
- `deposit(int amount)`
- `withdraw(int amount)`

### StatementPrinter
Responsible for generating and printing statements:
- Retrieves transactions
- Calculates running balance
- Sends formatted lines to the console

### StatementFormatter
Responsible only for formatting:
- Date formatting
- Amount formatting
- Statement line formatting

### Console
Responsible only for output:
- Prints lines to the console

### Clock
Responsible for providing the current date.

### Transaction
Represents transaction data only.

### TransactionRepository
Responsible for transaction storage.

The design properly follows the **Single Responsibility Principle (SRP)**.