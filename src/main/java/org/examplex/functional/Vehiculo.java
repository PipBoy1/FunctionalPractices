package org.examplex.functional;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vehiculo {
    String id;
    String fabricante;
    String name;
    Integer NWheels;
    Integer NPassengers;
    Double _0to100;
}
