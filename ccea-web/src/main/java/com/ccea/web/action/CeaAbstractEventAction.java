package com.ccea.web.action;


import org.springframework.webflow.action.MultiAction;
import org.springframework.webflow.execution.Event;

@SuppressWarnings("rawtypes")
public abstract class CeaAbstractEventAction extends MultiAction{

	
	private Class clazz;
	protected final Event success = new Event(clazz.getName(),"success");
	protected final Event error  = new Event(clazz.getName(),"error");
	
	/**
	 * constructor
	 * @param myClazz
	 */
	public CeaAbstractEventAction(Class myClazz) {
		clazz = myClazz;
	}

}
