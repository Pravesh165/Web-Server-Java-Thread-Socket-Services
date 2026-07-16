# Java Web Server (Threads & Sockets)

This project is a simple **Java-based Web Server** built to learn and demonstrate the concepts of **threads, sockets, and concurrency models**.  
It implements different execution strategies to handle client requests:

- **Single-threaded server** – handles one client at a time.  
- **Multi-threaded server** – spawns a new thread per client.  
- **Thread Pool server** – uses a fixed-size thread pool to efficiently manage multiple client requests.  

## 🔹 Features
- Built using **Java Sockets** for networking.  
- Demonstrates **thread management** (Single, Multi, and Thread Pool).  
- Handles multiple client connections on the same port.  
- Simple request/response model for learning server-side Java.  
- Timeout handling for inactive clients.  

## 🛠️ Tech Stack
- **Language**: Java  
- **Concepts**: Threads, Concurrency, Socket Programming, ExecutorService  

## 📂 Project Structure
SingleThread
->Server.java
->Client.java
MultiThread
-> Server.java
-> Client.java

