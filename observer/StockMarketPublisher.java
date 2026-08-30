package observer;

import java.util.ArrayList;
import java.util.HashMap;

/** Publishes stock-price changes to registered trading applications. */
public class StockMarketPublisher implements Subject {
    private final ArrayList<Observer> observers = new ArrayList<>();
    private final HashMap<String, Stock> stocks = new HashMap<>();

    /** {@inheritDoc} */
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    /** {@inheritDoc} */
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Adds a stock to the market, using its ticker as the lookup key.
     *
     * @param symbol the ticker symbol
     * @param companyName the company name
     * @param sector the stock sector
     * @param price the initial price
     */
    public void addStock(String symbol, String companyName, Sector sector, double price) {
        stocks.put(symbol, new Stock(symbol, companyName, sector, price));
    }

    /**
     * Updates a stock price and informs observers.
     *
     * @param symbol the ticker of the stock to update
     * @param change the positive or negative price change
     * @throws IllegalArgumentException if no stock has the supplied ticker
     */
    public void updateStock(String symbol, double change) {
        Stock stock = stocks.get(symbol);
        if (stock == null) {
            throw new IllegalArgumentException("Unknown stock symbol: " + symbol);
        }

        stock.updatePrice(change);
        notifyObservers(stock, change >= 0 ? Direction.UP : Direction.DOWN);
    }

    /** {@inheritDoc} */
    @Override
    public void notifyObservers(Stock stock, Direction direction) {
        for (Observer observer : observers) {
            observer.update(stock, direction);
        }
    }
}
