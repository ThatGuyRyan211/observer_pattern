Stock Mania - Observer Pattern

Run the program

From this project folder, compile and run:

javac -d out observer/*.java
java -cp out observer.Driver

The two applications register themselves with StockMarketPublisher. When the
publisher updates a stock price, it notifies every observer. Each app displays
only stocks in the sector it monitors.