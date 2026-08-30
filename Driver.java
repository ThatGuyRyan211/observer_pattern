package observer;

public class Driver {

	public void run() {
		clear();
		System.out.println("*** Stock Mania ***");
		StockMarketPublisher market = new StockMarketPublisher();

        // Add stocks
        market.addStock("AAPL", "Apple", Sector.TECHNOLOGY, 150.00);
        market.addStock("MSFT", "Microsoft", Sector.TECHNOLOGY, 320.00);
        market.addStock("JPM", "JPMorgan Chase", Sector.FINANCE, 180.00);
        market.addStock("BAC", "Bank of America", Sector.FINANCE, 35.00);

        // Create and register observers
        new TechTradingApp(market, "TechTrade Pro");
        new FinanceTradingApp(market, "FinanceFlow");

        // Update stocks
        market.updateStock("AAPL", 5.25);
        market.updateStock("JPM", 3.40);
        market.updateStock("BAC", -1.15);
		market.updateStock("MSFT", -8.10);
	}

	public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

	public static void main(String[] args) {
		Driver driver = new Driver();
		driver.run();
	}
}
