package observer;

/** A trading application that monitors technology stocks. */
public class TechTradingApp extends TradingApp {
    private static final String YELLOW = "\u001B[33m";

    /**
     * Creates a technology-stock observer and registers it with the publisher.
     *
     * @param publisher the publisher to observe
     * @param name the app's display name
     */
    public TechTradingApp(Subject publisher, String name) {
        super(publisher, name, Sector.TECHNOLOGY, YELLOW);
    }
}
