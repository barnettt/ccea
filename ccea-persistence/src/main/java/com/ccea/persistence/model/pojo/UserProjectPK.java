package com.ccea.persistence.model.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Compound primary key for projects
 * 
 * @author abuayyub
 * 
 */
public class UserProjectPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8912551252918215694L;
	Integer id;
	Date date;
	Integer user;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the user
	 */
	public Integer getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(Integer user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		int seed = 17;
		int result = id.hashCode() * seed;
		result = (result * seed) + date.hashCode();
		result = (result * seed) + user.hashCode();
		result = result >>> 17;
		System.out.println("Returning hashcode" + result);
		return result;
	}

	@Override
	public boolean equals(Object o) {

		UserProjectPK up = null;
		if (o instanceof UserProjectPK) {
			up = (UserProjectPK) o;
		} else {
			return false;
		}
		if (this.id.equals(up.getId()) && this.date.equals(up.getDate())
				&& this.user.equals(up.getUser())) {
			return true;
		}
		return false;
	}

	public String toString() {
		StringBuilder buff = new StringBuilder("\n");

		buff.append(id);
		buff.append(",");
		buff.append(date);
		buff.append(",");
		buff.append(user);
		buff.append("\n");

		return buff.toString();
	}

}
