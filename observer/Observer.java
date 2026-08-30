package observer;

/** Receives stock-price updates from a {@link Subject}. */
public interface Observer {
    /**
     * Receives a price update for a stock the observer monitors.
     *
     * @param stock the stock whose price changed
     * @param direction whether the price moved up or down
     */
    void update(Stock stock, Direction direction);
}
