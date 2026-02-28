# ISP Refactor

## Problem
The original `Animal` interface had methods like `fly()` and `bark()` 
- Birds cannot bark  
- Dogs cannot fly  

This forced animals to implement methods that didn’t make sense

## Solution
Split the interface into smaller, specific ones:  
- `Animal` – shared method `run()`  
- `Flyable` – for animals that can fly  
- `Barkable` – for animals that can bark  

Now each animal only implements what it can actually do