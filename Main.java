public class Main extends Transport {
    public Main(String model, int year) {
        super(model, year);
    }
    @Override
    public void start() {
        System.out.println("Bicycle " + model + " started.");
        speed = 5;
    }

    @Override
    public void stop() {

    }

    @Override
    public void move() {

    }

    @Override
    public String getInfo() {
        return null;
    }

    // ... (реализация остальных методов)
}
//Car

public final class Bicycle extends Transport {
    public sealed static class CarEngine extends Engine{
        public CarEngine(EngineType engineType, double enginePower) {
            super(engineType, enginePower);
        }
    }

    CarEngine engine;

    public Bicycle(String model, int year, EngineType engineType, double enginePower) {
        super(model, year);
        this.engine = new CarEngine(engineType, enginePower);
    }

    @Override
    public void start() {
        System.out.println("Car " + model + " started.");
        speed = 20;
    }

    @Override
    public void stop() {
    }

    @Override
    public void move() {
    }

    @Override
    public String getInfo() {
        return null;
    }

}

//Engine.javaTask _ name to clipboard
public sealed class Engine permits Car.CarEngine {
    EngineType type;
    double power;

    public Engine(EngineType type, double power) {
        this.type = type;
        this.power = power;
    }
}

//EngineType.java
public enum EngineType {
    DIESEL, ELECTRIC
}

//Main.javaTask
public class main {
    public static void main(String[] args) {
        Car car = new Car("BMW", 2022, EngineType.DIESEL, 200);
        Bicycle bicycle = new Bicycle("Trek", 2023);

        car.start();
        car.move();
        bicycle.getInfo();
        bicycle.stop();
    }
}

//Transport.java
public abstract class Transport {
    String model;
    int year;
    double speed;
    public Transport(String model, int year) {
        this.model = model;
        this.year = year;
        this.speed = 0;
    }

    public abstract void start();
    public abstract void stop();
    public abstract void move();
    public abstract String getInfo();
}