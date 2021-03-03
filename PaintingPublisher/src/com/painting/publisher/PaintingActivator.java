package com.painting.publisher;

import com.artist.publisher.ArtistPublish;
import com.artist.publisher.ArtistPublishImpl;
import com.customer.consumer.CustomerConsume;
import com.customer.consumer.CustomerConsumeImpl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class PaintingActivator implements BundleActivator {
	
	ServiceReference<?> artistServiceReference;
	ServiceReference<?> deliveryServiceReference;
	ServiceReference<?> customerServiceReference;

	public void start(BundleContext context) throws Exception {
			
			System.out.println("Painting Service Starts!");
			
			artistServiceReference = context.getServiceReference(ArtistPublish.class.getName());
			ArtistPublish artistPublish = (ArtistPublishImpl) context.getService(artistServiceReference);
			
			deliveryServiceReference = context.getServiceReference(DeliveryPublish.class.getName());
			DeliveryPublish deliveryPublish = (DeliveryPublishImpl) context.getService(deliveryServiceReference);
			
			customerServiceReference = context.getServiceReference(CustomerConsume.class.getName());
			CustomerConsume customerConsume = (CustomerConsumeImpl) context.getService(customerServiceReference);
			
			PaintingPublish publishPainting = new PaintingPublishImpl(artistPublish, deliveryPublish, customerConsume);
			publishPainting.init();
				
	}

	public void stop(BundleContext context) throws Exception {
			
			System.out.println("Painting Service Stops !");
			
			context.ungetService(artistServiceReference);
			context.ungetService(deliveryServiceReference);
			context.ungetService(customerServiceReference);
			
	}

}
