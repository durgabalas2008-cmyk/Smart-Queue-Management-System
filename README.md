# Smart Queue Management System

## Project Description
A console-based Java application designed to streamline customer service queues by generating tokens, tracking waiting counts, searching tokens, and managing customer flow efficiently.

## Student Details
- **Name:** Jeya Durga B
- **Register Number:** 2503917720522162

## Features Implemented
1. **Generate Token:** Assigns unique sequential tokens with customer name and service type.
2. **Call Next Customer:** Serves the next customer in FIFO order.
3. **Display Queue:** Lists all currently waiting customers and their positions.
4. **Search Token:** Finds a specific token's position and details in the active queue.
5. **Skip Customer:** Moves the current front customer to the end of the queue if unavailable.
6. **Show Waiting Count:** Displays the total number of customers currently waiting.

## Technology Stack
- **Language:** Java (JDK)
- **Data Structure:** Java Collections (`LinkedList`)
- **Version Control:** Git & GitHub

## How to Run
1. Compile the program:
   ```bash
   javac Main.java