package org.videoform.api.json;

public abstract interface JsonRequest<T> {
	public T convertJsonToEntity();
}
