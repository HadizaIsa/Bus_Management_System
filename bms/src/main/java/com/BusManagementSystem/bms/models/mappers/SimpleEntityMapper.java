package com.BusManagementSystem.bms.models.mappers;

public interface SimpleEntityMapper<E, D> {
    D mapToDto(E entity);

    E mapToEntity(D dto);
}
