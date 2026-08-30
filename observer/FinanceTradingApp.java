package observer;

/** A trading application that monitors finance stocks. */
public class FinanceTradingApp extends TradingApp {
    private static final String MAGENTA = "\u001B[35m";

    /**
     * Creates a finance-stock observer and registers it with the publisher.
     *
     * @param publisher the publisher to observe
     * @param name the app's display name
     */
    public FinanceTradingApp(Subject publisher, String name) {
        super(publisher, name, Sector.FINANCE, MAGENTA);
    }
}
