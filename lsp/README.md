# LSP Refactor

## Problem
Originally, `Vehicle` had both `fillUpWithFuel()` and `chargeBattery()` as abstract methods.  
- Electric cars can’t be refueled  
- Petrol cars can’t be recharged  

## Solution
Split responsibilities with interfaces:  
- `Vehicle` – shared stuff like starting and stopping engine  
- `Fuelable` – vehicles that can be refueled  
- `Chargeable` – vehicles that can be recharged  

Now each car only implements what it can actually do