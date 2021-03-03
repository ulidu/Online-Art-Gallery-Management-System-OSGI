package customerconsumer;

import com.artist.publisher.ArtistPublish;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class CustomerActivator implements BundleActivator {

	ServiceReference customerReference;

	public void start(BundleContext context) throws Exception {
		
		System.out.println("Start customer service");
		customerReference = context.getServiceReference(ArtistPublish.class.getName());
		
		ArtistPublish artistPublish = (ArtistPublish)context.getService(customerReference);
		System.out.println(artistPublish.publishArtist());
		
	}

	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Good Bye");
		context.ungetService(customerReference);
		
	}

}
