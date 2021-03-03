package databaseservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class DatabaseActivator implements BundleActivator {

	ServiceRegistration<?> publishServiceRegistration;

	public void start(BundleContext context) {
		
		System.out.println("Database Service Started !");
		
		ArtistDao artistDao = new ArtistDaoImpl();
		CustomerDao customerDao = new CustomerDaoImpl();
		
		publishServiceRegistration = context.registerService(ArtistDao.class.getName(), artistDao, null);
		publishServiceRegistration = context.registerService(CustomerDao.class.getName(), customerDao, null);
		
	}

	public void stop(BundleContext bundleContext) {
		
		System.out.println("Database Service Stopped !");
		publishServiceRegistration.unregister();
		
	}

}
