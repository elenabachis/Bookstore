package main.observer;

public interface Observable {
    public void registerObserver(Observer observer);
    public boolean removeObserver(Observer observer);
    public void notifyObservers();
}

