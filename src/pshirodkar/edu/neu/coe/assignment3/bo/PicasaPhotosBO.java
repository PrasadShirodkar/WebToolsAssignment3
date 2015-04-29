package pshirodkar.edu.neu.coe.assignment3.bo;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import pshirodkar.edu.neu.coe.assignment3.bean.EventBean;
import pshirodkar.edu.neu.coe.assignment3.constants.ReferenceConstants;

import com.google.gdata.client.Query;
import com.google.gdata.client.photos.PicasawebService;
import com.google.gdata.data.photos.AlbumFeed;
import com.google.gdata.data.photos.PhotoEntry;
import com.google.gdata.util.ServiceException;

/**
 * This business object is used to retrieve the photos using the Flickr Photos
 * API.
 * 
 * @author Prasad
 * 
 */
public class PicasaPhotosBO {

	/**
	 * This method searches the photos for an event.
	 * 
	 * @param eventBean
	 * 
	 * @throws ServiceException
	 * @throws IOException
	 */
	public void searchPhoto(String userName, String password,
			List<EventBean> eventList) throws IOException, ServiceException {

		for (EventBean eventBean : eventList) {

			if (eventBean.getLocation() != null
					&& !eventBean.getLocation().trim().equals("")) {

				PicasawebService service = new PicasawebService(
						"picasa-web-albums-photos" + Math.random());
				service.setUserCredentials(userName, password);

				StringBuffer url = new StringBuffer();

				url.append(ReferenceConstants.PICASA_WEB_ALBUMS_DATA_API_URL);

				URL baseSearchUrl = new URL(url.toString());

				Query query = new Query(baseSearchUrl);

				/*query.setStringCustomParameter("kind", "photo");
				query.setStringCustomParameter("tag",
						eventBean.getLocation());*/
				query.setMaxResults(10);
				query.setFullTextQuery(eventBean.getLocation());

				query.setFullTextQuery(eventBean.getLocation());
				System.out.println(eventBean.getLocation());

				AlbumFeed searchResultsFeed = service.query(query,
						AlbumFeed.class);

				for (PhotoEntry photoEntry : searchResultsFeed
						.getPhotoEntries()) {
					eventBean.setImageUrl(photoEntry.getMediaThumbnails()
							.get(0).getUrl());
					break;
				}

				System.out.println(eventBean.getImageUrl());
			}
		}
	}
}