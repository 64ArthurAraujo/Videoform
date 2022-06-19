package org.videoform.api.service.interf;

public abstract interface IService<T1, T2> {
	T1 getById(Long id);
	
	T2 insert(T1 entity);
}
