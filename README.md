# Trading App Git Repository

This project is about a Trading App that uses an algo and a signal handler to process a signal.

### Libraries
This project use pre-defined library code snippets like **SignalHandler** and **Algo** that are placed in library package.

### How It Works
- This is a spring boot project that runs on port **8080**.
- To process the signal, one can call the **GET: /signal/{anyPositiveInt}** endpoint that takes any positive
  integer value from path and process it.
- If there is a Signal Processor associated with that signal then that will be processed,
  otherwise the default processor will be processed.
- More Signal Processors can be added in future by implementing the **SignalProcessor Interface**.

