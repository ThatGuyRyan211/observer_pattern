package observer;

/** Represents a company stock and its current market price. */
public class Stock {
    private final String symbol;
    private final String companyName;
    private final Sector sector;
    private double price;

    /**
     * Creates a stock.
     *
     * @param symbol the stock ticker symbol
     * @param companyName the company's name
     * @param sector the company's market sector
     * @param price the initial stock price
     */
    public Stock(String symbol, String companyName, Sector sector, double price) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.sector = sector;
        this.price = price;
    }

    /**
     * Changes the stock price by the supplied amount.
     *
     * @param delta the positive or negative change in price
     */
    public void updatePrice(double delta) {
        price += delta;
    }

    /** @return the ticker symbol */
    public String getSymbol() {
        return symbol;
    }

    /** @return the company name */
    public String getCompanyName() {
        return companyName;
    }

    /** @return the market sector */
    public Sector getSector() {
        return sector;
    }

    /** @return the current price */
    public double getPrice() {
        return price;
    }
}
