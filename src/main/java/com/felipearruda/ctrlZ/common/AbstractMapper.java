package com.felipearruda.ctrlZ.common;

public abstract class AbstractMapper<E, D> {

    public abstract E toEntity(D dto);

    public abstract D toDto(E entity);

    public abstract E newEntity();

    public abstract D newDto();

}
