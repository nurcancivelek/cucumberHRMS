package com.hrms.testbase;

import com.hrms.pages.AddEmployeePageElements;
import com.hrms.pages.DashboardPageElements;
import com.hrms.pages.LeaveListPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsPageElements;
import com.hrms.pages.ReportsPageElements;


public class PageInitiliazer  extends BaseClass{
	
	
	public static DashboardPageElements dash;
	public static LoginPageElements login;
	public static AddEmployeePageElements add;
	public static LeaveListPageElements leave;
	public static PersonalDetailsPageElements person;
	public static ReportsPageElements report;

	public static void initializeAll() {
		login = new LoginPageElements();
		dash = new DashboardPageElements();
		add = new AddEmployeePageElements();
		leave = new LeaveListPageElements();
		person = new PersonalDetailsPageElements();
		report=new ReportsPageElements();

	}

}
