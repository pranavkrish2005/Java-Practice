import java.util.*;

public class MusicDownloads {
	/**
	 * The list of downloaded information. Guaranteed not to be null and not to
	 * contain duplicate titles.
	 */
	private List<DownloadInfo> downloadList;

	/** Creates the list of downloaded information. */
	public MusicDownloads() {
		downloadList = new ArrayList<DownloadInfo>();
	}
	
	public void addTitle(DownloadInfo element) {
		downloadList.add(element);
	}
	
	/** Returns a reference to the DownloadInfo object with the requested title if it exists.
	 *  @param title the requested title
	 *  @return a reference to the DownloadInfo object with the
	 *          title that matches the parameter title if it exists in the list;
	 *          null otherwise.
	 *  Postcondition:
	 *   - no changes were made to downloadList.
	 */
	 public DownloadInfo getDownloadInfo(String title)
	 {
		 for(int i = 0; i < downloadList.size(); i++)
			 if(downloadList.get(i).getTitle().equals(title))
				 return downloadList.get(i);
		 return null;
	 }
	
	 /** Updates downloadList with information from titles.
	  *  @param titles   a list of song titles
	  *  Postcondition:
	  *   - there are no duplicate titles in downloadList.
	  *   - no entries were removed from downloadList.
	  *   - all songs in titles are represented in downloadList.
	  *   - for each existing entry in downloadList, the download count is increased by
	  *     the number of times its title appeared in titles.
	  *   - the order of the existing entries in downloadList is not changed.
	  *   - the first time an object with a title from titles is added to downloadList, it
	  *     is added to the end of the list.
	  *   - new entries in downloadList appear in the same order
	  *     in which they first appear in titles.
	  *   - for each new entry in downloadList, the download count is equal to
	  *     the number of times its title appeared in titles.
	  */
		public void updateDownloads(List<String> titles)
		{
			DownloadInfo one;
			for(int i = 0; i < titles.size(); i++)
			{
				one = getDownloadInfo(titles.get(i));
				if(one == null)
					downloadList.add(new DownloadInfo(titles.get(i)));
				else
					one.incrementTimesDownloaded();
			}
		}
	  

		public String toString() {
			String acc = "";
			for(DownloadInfo d : downloadList) {
				acc += d + "\n";
			}
			return acc;
		}
		
	public static void main(String[] args) {
		//Creating and printing the original downloadList of three songs
		MusicDownloads master = new MusicDownloads();

		master.addTitle(new DownloadInfo("Hey Jude", 5));
		master.addTitle(new DownloadInfo("Soul Sister", 3));
		master.addTitle(new DownloadInfo("Aqualung", 10));
		System.out.println(master);
		
		//Calling the suggested testers for part (a)
		System.out.println(master.getDownloadInfo("Aqualung"));
		System.out.println(master.getDownloadInfo("Happy Birthday"));
		System.out.println();
		
		//Calling the suggested testers for part (b)
		String[] songNames = new String[] {"Lights", "Aqualung", "Soul Sister", "Go Now", "Lights", "Soul Sister"};
		List<String> songs = Arrays.asList(songNames);
		master.updateDownloads(songs);
		System.out.println(master);
		
		

	}

}