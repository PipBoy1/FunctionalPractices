package org.examplex.functional;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class StreamExample {

    public StreamExample(){

    }
    public Long EncontrarCantVehPorNRuedas(List<Vehiculo> vehiculosList, Integer NWheels) {
        /*List<Vehiculo> lista = vehiculosList.stream()
                .filter(vehiculo -> vehiculo.getNWheels() == NWheels)
                .collect(Collectors.toList());*/
        return vehiculosList.stream()
                .filter(vehiculo -> vehiculo.getNWheels() == NWheels)
                .count();
    }
    public List<Vehiculo> Vehiculos4Ruedas(List<Vehiculo> vehiculosList){//cambiar
        //Traer vehiculos de 4 ruedas
        List<Vehiculo> result = vehiculosList.stream()
                .filter(vehiculo -> vehiculo.getNWheels()==4)
                .collect(Collectors.toList());
        return result;
    }
    public double EncontrarMasRapido(List<Vehiculo> vehiculosList){
        return vehiculosList.stream()
                .map(vehiculo -> vehiculo.get_0to100())
                .reduce(Double::min)
                //.get();
                .orElseThrow();
    }
    public List<Vehiculo> OrdenarPorFabricante(List<Vehiculo> vehiculosList){
        Comparator<Vehiculo> nameComparator = (Vehiculo v1, Vehiculo v2) -> v1.getFabricante().compareTo(v2.getFabricante());
        return vehiculosList.stream()
                .sorted(nameComparator)
                .collect(Collectors.toList());
    }

    public List<Vehiculo> EncontrarPorMarca(List<Vehiculo> vehiculosList, String fabricante) {
        return vehiculosList.stream()
                .filter(vehiculo -> vehiculo.getFabricante().equalsIgnoreCase(fabricante))
                .collect(Collectors.toList());
    }


}
