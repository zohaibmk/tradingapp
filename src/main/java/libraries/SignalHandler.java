/**
 * This is an upcall from our trading system, and we cannot change it.
 */
package libraries;

public interface SignalHandler {

    void handleSignal(int signal);
}