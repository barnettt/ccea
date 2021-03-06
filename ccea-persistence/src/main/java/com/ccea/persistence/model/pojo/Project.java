package com.ccea.persistence.model.pojo;

import java.util.Date;

/**
 * Represents a project in the system
 * 
 * @author abuayyub
 * 
 */
public class Project {

	private Integer code;
	private String name;
	private String owner;
	private Date dateStarted;
	private Double estimatedDuration;
	private Double actualDuration;

	/**
	 * Constructor
	 */
	public Project() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param i
	 * @param string
	 * @param string2
	 * @param time
	 * @param valueOf
	 * @param valueOf2
	 */
	public Project(Integer i, String name, String owner, Date dateStarted,
			Double estimatedDuration, Double actualDuration) {
		//
		super();
		this.code = i;
		this.name = name;
		this.owner = owner;
		this.dateStarted = dateStarted;
		this.estimatedDuration = estimatedDuration;
		this.actualDuration = actualDuration;
	}

	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner
	 *            the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the dateStarted
	 */
	public Date getDateStarted() {
		return dateStarted;
	}

	/**
	 * @param dateStarted
	 *            the dateStarted to set
	 */
	public void setDateStarted(Date dateStarted) {
		this.dateStarted = dateStarted;
	}

	/**
	 * @return the estimatedDuration
	 */
	public Double getEstimatedDuration() {
		return estimatedDuration;
	}

	/**
	 * @param estimatedDuration
	 *            the estimatedDuration to set
	 */
	public void setEstimatedDuration(Double estimatedDuration) {
		this.estimatedDuration = estimatedDuration;
	}

	/**
	 * @return the actualDuration
	 */
	public Double getActualDuration() {
		return actualDuration;
	}

	/**
	 * @param actualDuration
	 *            the actualDuration to set
	 */
	public void setActualDuration(Double actualDuration) {
		this.actualDuration = actualDuration;
	}

	/*
	 * private Integer code;
	private String name;
	private String owner;
	private Date dateStarted;
	private Double estimatedDuration;
	private Double actualDuration;
	 */
	
	public String toString() {
			StringBuilder buff = new StringBuilder("\n");

			buff.append(code);
			buff.append(",");
			buff.append(name);
			buff.append(",");
			buff.append(owner);
			buff.append(",");
			buff.append(dateStarted);
			buff.append(",");
			buff.append(estimatedDuration);
			buff.append(",");
			buff.append(actualDuration);
			
			
			return buff.toString();
	}
}
