package com.example.community.repository.core;

import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface CommonRepository<T, I extends Serializable> extends BaseRepository<T,I> {
}
