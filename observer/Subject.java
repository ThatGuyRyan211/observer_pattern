package observer;

/** Defines the operations a stock-market publisher provides to observers. */
public interface Subject {
    /**
     * Adds an observer to receive future stock-price updates.
     *
     * @param observer the observer to register
     */
    void registerObserver(Observer observer);

    /**
     * Stops an observer from receiving updates.
     *
     * @param observer the observer to remove
     */
    void removeObserver(Observer observer);

    /**
     * Sends a stock update to every registered observer.
     *
     * @param stock the stock whose price changed
     * @param direction whether the price increased or decreased
     */
    void notifyObservers(Stock stock, Direction direction);
}
