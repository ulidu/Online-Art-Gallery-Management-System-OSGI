package com.account.publisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import com.database.service.CustomerDao;
import com.database.service.CustomerDaoImpl;

public class AccountActivator implements BundleActivator {
	
	ServiceRegistration<?> publishCustomerRegistration;
	ServiceReference<?> serviceReference;

	public void start(BundleContext context) throws Exception {
		
		serviceReference = context.getServiceReference(CustomerDao.class.getName());
		CustomerDao customerDao = (CustomerDaoImpl) context.getService(serviceReference);
		
		System.out.println("Account Publisher Started !");
		
		AccountPublish publisherService = new AccountPublishImpl(customerDao);
		publishCustomerRegistration = context.registerService(AccountPublish.class.getName(), publisherService, null);
		
	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Account Publisher Stopped !");
		
		publishCustomerRegistration.unregister();
		context.ungetService(serviceReference);
		
	}
	
}
