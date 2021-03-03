package com.customer.consumer;

import databaseservice.CustomerDao;
import databaseservice.CustomerDaoImpl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class CustomerActivator implements BundleActivator {

	ServiceRegistration<?> publishCustomerRegistration;
	ServiceReference<?> serviceReference;

	public void start(BundleContext context) throws Exception {
		
		serviceReference = context.getServiceReference(CustomerDao.class.getName());
		CustomerDao customerDao = (CustomerDaoImpl) context.getService(serviceReference);
		
		System.out.println("Customer Subscriber Started !");
		
		CustomerConsume publisherService = new CustomerConsumeImpl(customerDao);
		publishCustomerRegistration = context.registerService(CustomerConsume.class.getName(), publisherService, null);
		
	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Customer Subscriber Stopped !");
		
		publishCustomerRegistration.unregister();
		context.ungetService(serviceReference);
		
	}

}
