package com.BusManagementSystem.bms.models.mappers;

import java.util.List;

public interface EntityMapper<E, D> extends SimpleEntityMapper<E, D> {

    List<D> mapToDtos(List<E> entities);

    List<E> mapToEntities(List<D> dtos);
}
