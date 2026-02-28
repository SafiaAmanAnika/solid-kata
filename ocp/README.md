# OCP Refactor

## Problem
The original `Employee` class used a `switch` on `EmployeeType` to calculate pay:  
- Adding a new employee type required modifying the existing `payAmount()` method.  
- This breaks OCP because the class is not closed for modification

## Solution
Use **polymorphism** instead of type checks:  
- `Employee` is now an abstract class with `payAmount()` as an abstract method  
- `Engineer` and `Manager` are subclasses that implement their own `payAmount()` logic  

Now you can add new employee types without touching existing code
- `Engineer` returns salary  
- `Manager` returns salary + bonus  