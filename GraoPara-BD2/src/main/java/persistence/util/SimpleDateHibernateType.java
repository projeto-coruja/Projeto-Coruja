package persistence.util;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

import datatype.SimpleDate;

public class SimpleDateHibernateType implements UserType {

	
	@Override
	public int[] sqlTypes() {
		return new int[]{Types.VARCHAR};
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class returnedClass() {
		return SimpleDate.class;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		return (x != null & y != null ? x.equals(y) : false);
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
		return x.hashCode();
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names,
			SessionImplementor session, Object owner)
			throws HibernateException, SQLException {
		String formattedDate = rs.getString(names[0]);
		if(formattedDate == null || formattedDate.isEmpty()) {
			return null;
		}
		else {
			return SimpleDate.parse(formattedDate);
		}
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index,
			SessionImplementor session) throws HibernateException, SQLException {
		if(value == null) {
			st.setNull(index, Types.VARCHAR);
		}
		else if(!(value instanceof SimpleDate)) {
			throw new UnsupportedOperationException("Can't convert " + value.getClass());
		}
		else {
			st.setString(index, value.toString());
		}
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		return value;
	}

	@Override
	public boolean isMutable() {
		return false;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		if(!(value instanceof SimpleDate)) {
			throw new UnsupportedOperationException("Can't convert " + value.getClass());
		}
		else {
			return (Serializable) value;
		}
	}

	@Override
	public Object assemble(Serializable cached, Object owner)
			throws HibernateException {
		return cached;
	}

	@Override
	public Object replace(Object original, Object target, Object owner)
			throws HibernateException {
		return original;
	}

}
