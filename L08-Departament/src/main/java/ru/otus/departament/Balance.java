package ru.otus.departament;
public class Balance implements Command {
    Listener listener;

    public Balance(Listener listener) {
        this.listener = listener;
    }

    @Override
    public long execute() {
        return listener.notifyLong();
    }

}
