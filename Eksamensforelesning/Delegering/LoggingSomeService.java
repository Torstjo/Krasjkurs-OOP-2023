package Eksamensforelesning.Delegering;

public class LoggingSomeService implements SomeService {
    // Add needed fields here

    private SomeService delegate;
    private Logger logger;    
 
    /*
     * Creates a LoggingSomeService object with the given delegate and logger
     */
    public LoggingSomeService(SomeService delegate, Logger logger) {
        this.delegate = delegate;
        this.logger = logger;
    }
 
    @Override
    /**
     * Delegates the job of calculating a magic string to the delegate, and logs the
     * result before returning it
     *
     * @return A string
     */
    public String getAMagicString() {
        String string = delegate.getAMagicString();
        logger.log(string);
        return string;
    }
 
    /**
     * Delegates the job of calculating a magic number to the delegate, and logs the
     * result before returning it
     *
     * @return An integer
     */
    @Override
    public int getAMagicNumber() {
        int number = delegate.getAMagicNumber();
        logger.log(Integer.toString(number));
        return number;
    }

    public static void main(String[] args) {
        SomeService delegate = new SomeServiceImpl();
        Logger logger = new Logger();
        SomeService service = new LoggingSomeService(delegate, logger);

        service.getAMagicString();
        service.getAMagicNumber();
    }
}
