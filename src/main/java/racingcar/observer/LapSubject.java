package racingcar.observer;

public interface LapSubject {
    void addObserver(LapObserver observer);
    void removeObserver(LapObserver observer);
    void notifyObservers(String message);
}
