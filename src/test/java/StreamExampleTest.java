import org.examplex.functional.StreamExample;
import org.examplex.functional.Vehiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StreamExampleTest {
    @InjectMocks
    StreamExample streamExample;

    private final List<Vehiculo> vehiculosList;

    public StreamExampleTest(){
        vehiculosList = List.of(
                new Vehiculo("0", "Chevy", "A", 4, 5, 6.3),
                new Vehiculo("1", "Ford", "B", 4, 4, 10.2),
                new Vehiculo("2", "Suzuki", "C", 2, 1, 3.2),
                new Vehiculo("3", "Suzuki", "D", 2, 2, 4.2),
                new Vehiculo("4", "Ducati", "E", 2, 2, 3.8),
                new Vehiculo("5", "Renault", "F", 4, 5, 5.7),
                new Vehiculo("6", "Nissan", "G", 4, 2, 8.3),
                new Vehiculo("7", "Chevy", "H", 4, 7, 9.2)
        );
    }

    @Test
    void EncontrarCantVehPorNRuedasTest(){
        var cantVehiculos = streamExample.EncontrarCantVehPorNRuedas(vehiculosList, 4);
        Assertions.assertEquals(5, cantVehiculos);
    }

    @Test
    void Vehiculos4RuedasTest(){
        List<Vehiculo> valor = streamExample.Vehiculos4Ruedas(vehiculosList);
        Assertions.assertEquals(5, valor.size());
    }

    @Test
    void EncontrarMasRapidoTest(){
        var valor = streamExample.EncontrarMasRapido(vehiculosList);
        Assertions.assertEquals(3.2, valor);
    }

    @Test
    void EncontrarPorMarcaTest(){
        var valor = streamExample.EncontrarPorMarca(vehiculosList, "Suzuki");

        List<Vehiculo> expectedList = List.of(
                new Vehiculo("2", "Suzuki", "C", 2, 1, 3.2),
                new Vehiculo("3", "Suzuki", "D", 2, 2, 4.2)
        );

        Assertions.assertEquals(expectedList, valor);
    }

    @Test
    void OrdenarPorFabricanteTest(){
        List<Vehiculo> valor = streamExample.OrdenarPorFabricante(vehiculosList);
        valor.forEach(System.out::println);

        valor.forEach(item -> System.out.println(item));

        for (Vehiculo item : valor) {
            System.out.println(item);
        }

        for (int i = 0; i < valor.size(); i++) {
            System.out.println(valor.get(i));
        }
        
        List<Vehiculo> expectedList = List.of(
                new Vehiculo("0", "Chevy", "A", 4, 5, 6.3),
                new Vehiculo("7", "Chevy", "H", 4, 7, 9.2),
                new Vehiculo("4", "Ducati", "E", 2, 2, 3.8),
                new Vehiculo("1", "Ford", "B", 4, 4, 10.2),
                new Vehiculo("6", "Nissan", "G", 4, 2, 8.3),
                new Vehiculo("5", "Renault", "F", 4, 5, 5.7),
                new Vehiculo("2", "Suzuki", "C", 2, 1, 3.2),
                new Vehiculo("3", "Suzuki", "D", 2, 2, 4.2)
                );

        Assertions.assertEquals(expectedList, valor);
    }
}
