# Car-Rental2

## What It Does

This program simulates a small vehicle rental system. A customer can:

Log in with a username and password (3 attempts allowed).

See information about available vehicles (Car, SUV, Truck).

Calculate rental costs for a set number of days.

## How It Works

### Customer Login

Checks if the username and password match the stored values.

Maximum 3 attempts; exits if login fails.

### Vehicle Classes

Vehicle → abstract base class with common info (make, model, year).

Car, SUV, Truck → subclasses that calculate rental cost differently and show extra details.

Car: number of doors

SUV: 4-wheel drive yes/no

Truck: cargo capacity

### Rental Cost Calculation

Car: $50/day

SUV: $80/day + $20 if 4WD

Truck: $100/day + $10 per ton of cargo

Display Info

Shows details for each vehicle and rental cost.

### How to Use

Run the program.

Log in (default username: Remo, password: pass123).

After login, vehicle details and rental costs are shown automatically.