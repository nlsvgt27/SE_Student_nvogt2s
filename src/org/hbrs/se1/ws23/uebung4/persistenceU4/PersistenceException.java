package org.hbrs.se1.ws23.uebung4.persistenceU4;

public class PersistenceException extends Exception {

    private PersistenceException.ExceptionType exceptionType;

    public PersistenceException.ExceptionType getExceptionTypeType() {
        return this.exceptionType;
    }

    public PersistenceException(PersistenceException.ExceptionType exceptionType, String message) {
        super(message);
        this.exceptionType = exceptionType;
    }

    /**
     * ExceptionTypes for declaring the type of an exception.
     * Please feel free to extend this list!
     * Hint: If an internal Exception of type java.lang.UnsupportedOperationException is thrown,
     * then this exception must be caught and transformed to an object of this exception-type, consisting
     * of Type 'ImplementationNotAvailable'. Re-throw the new exception e.g. to a client
     */
    public enum ExceptionType {
        ImplementationNotAvailable,
        ConnectionNotAvailable,
        NoStrategyIsSet,
        SaveFailure,
        LoadFailure,
        ClosingFailure,
        NO_FILE_FOUND
    }
}