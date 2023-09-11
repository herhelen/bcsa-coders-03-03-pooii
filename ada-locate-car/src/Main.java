import domain.vehicle.Medium;
import domain.vehicle.SUV;
import domain.vehicle.Small;
import domain.vehicle.Vehicle;

public class Main {
    public static void main(String[] args) {

        Vehicle teste = new Medium(1, "AAA1234", "Nissan", "Azul");
        System.out.println(teste);

    }
}