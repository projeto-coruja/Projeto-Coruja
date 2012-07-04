package model;

import java.io.Serializable;
@SuppressWarnings("serial")
public abstract class Entity implements Serializable{
	
	private long id;

	public abstract long getId();
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity other = (Entity) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public abstract String getSearchColumnTable();
	public abstract String getSearchColumnEntity();
}

