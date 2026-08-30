package observer;

/** Shared behavior for a sector-specific stock trading application. */
public abstract class TradingApp implements Observer {
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";

    private final String name;
    private final Sector sector;
    private final String appColor;

    /**
     * Creates and registers a trading application.
     *
     * @param publisher the publisher that sends updates
     * @param name the name displayed for this app
     * @param sector the sector this app monitors
     * @param appColor the ANSI color used for the app name
     */
    protected TradingApp(Subject publisher, String name, Sector sector, String appColor) {
        this.name = name;
        this.sector = sector;
        this.appColor = appColor;
        publisher.registerObserver(this);
        System.out.println(appColor + name.toUpperCase() + RESET + " is monitoring the market");
    }

    /** {@inheritDoc} */
    @Override
    public void update(Stock stock, Direction direction) {
        if (stock.getSector() != sector) {
            return;
        }

        String color = direction == Direction.UP ? GREEN : RED;
        String arrow = direction == Direction.UP ? "^" : "v";
        System.out.printf("%s%s%s: %s(%s) is now priced at %s$%.2f %s%s%n",
                appColor, name.toUpperCase(), RESET,
                stock.getCompanyName(), stock.getSymbol(),
                color, stock.getPrice(), arrow, RESET);
    }
}
