package com.ccea.web.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.ccea.persistence.report.UIDataManager;
import com.ccea.web.beans.UserReportBeanWrapper;


/**
 * collect Data for report
 * @author abuayyub
 *
 */
public class ViewProjectReportAction extends CceaAbstractEventAction {
	
	@Autowired
	UIDataManager uiDataManager;
	
	public ViewProjectReportAction(Class myClazz) {
		super(myClazz);
	
	}
	
	public UserReportBeanWrapper getProjectReport() {
		
				
		
		return null;
		
	}

}
