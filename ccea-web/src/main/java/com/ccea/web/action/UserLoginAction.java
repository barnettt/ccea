package com.ccea.web.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;




import com.ccea.persistence.model.pojo.User;
import com.ccea.persistence.report.UIDataManager;

public class UserLoginAction extends CeaAbstractEventAction {
	
	protected static Logger logger = LoggerFactory
            .getLogger(UserLoginAction.class);
	
	@Autowired
	UIDataManager uiDataManager;
	
	public UserLoginAction() {
		super(UserLoginAction.class);
	}

	
	public Event checkUserLogin(RequestContext requestContext) throws Exception {
		logger.info("enter UserLoggerAction");
		String serverTime  = getToday();
		requestContext.getRequestScope().put("serverTime", serverTime);
		User user = (User)requestContext.getFlowScope().get("userBean");

		if(uiDataManager.checkLoginDetails(user.getLogin(), user.getPassword())) {
			logger.info("exit succcess UserLoggerAction");
			return success;
		}
		requestContext.getFlowScope().put("userLoginMessage", "Error occurred while validating user login, check dat and try again or see administrator.");		
		logger.info("exit error UserLoggerAction");
		return error;
	}

	private String getToday() {
		Calendar cal = Calendar.getInstance();		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH24:mm:ss");
		return formatter.format(cal.getTime());
		
		
	}
}
