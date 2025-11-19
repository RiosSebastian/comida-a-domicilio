package com.RiosTech.PlataformaDeComidaADomicilio.util;

public enum OrderStatus {
    PENDING,        // cliente creó el pedido
    ACCEPTED,       // restaurante aceptó
    ASSIGNED,       // repartidor asignado
    ON_THE_WAY,     // repartidor está en camino
    DELIVERED       // entregado
}
