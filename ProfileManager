/*
 * Natalie Pham 
 * 6/21/20
 * ProfileManager Class
 */


package Final1;
import java.util.Iterator;
public class ProfileManager {
	private final ArrayBag<Profile> allProfiles;
	private UndirectedGraph<Profile> friendGraph;
	
	public ProfileManager(){
		allProfiles = new ArrayBag<>(); 
		friendGraph = new UndirectedGraph<>(); 
	}
	
	public UndirectedGraph<Profile> getFriendGraph(){
		return friendGraph;
	}
	
	public void addProfile (Profile account){
		if (!allProfiles.contains(account)){
			allProfiles.add(account); 
			friendGraph.addVertex(account); 
		}
	}
	
	public void LinkedFriend (Profile account1, Profile account2){
		if (allProfiles.contains(account1) && allProfiles.contains(account2)
				&& account1.getFriends().contains(account2)){
			friendGraph.addEdge(account1, account2);   
		}
		
		else
			System.out.println("Cannot create link for those two accounts.");
	}
	
	public void removeProfile (Profile account){
		if (allProfiles.contains(account)){
			friendGraph.removeVertex(account);
			allProfiles.remove(account);
			System.out.println("Account removed.");
		}
		
		else
			System.out.println("Profile does not exist.");		
	} 
	
	public void unLinkedFriend(Profile account1, Profile account2){
		if (!allProfiles.contains(account1) || !allProfiles.contains(account2)
				|| !account1.getFriends().contains(account2) || 
				(friendGraph.getVertex(account1) == null) || 
				(friendGraph.getVertex(account2)==null)){
			friendGraph.removeEdge(account1, account2); 
		} 
		else 
			System.out.println("Cannot unlink two accounts of some sort.");
	}
		
	public void searchProfile(Profile account){
		if (allProfiles.contains(account)){
			System.out.println(account.getName() + " is found!");
			display(account);
			Profile.displayFriend(account);
			displayRecFriend(account); 
		}
		else  
			System.out.println("User not found.");
			
	}

	public AList<Profile>recommendedFriend(Profile account){
		AList<Profile> recommendedFriend = new AList<>();
		Iterator<VertexInterface<Profile>> Neighbor = friendGraph.getVertex(account).getNeighborIterator();
		Iterator<VertexInterface<Profile>> Recommended = null;
		Profile user = null;
		VertexInterface<Profile> neighbor = null;
		if (allProfiles.contains(account)){
			while (Neighbor.hasNext()){
				neighbor = Neighbor.next();
				Recommended = neighbor.getNeighborIterator();
				while (Recommended.hasNext()){
					user = Recommended.next().getLabel();
					if (!recommendedFriend.contains(user) && !user.equals(account) 
							&& !account.getFriends().contains(user)){
						recommendedFriend.add(user);
					} 
				}
			}
				
		}  
		else
			System.out.println("User not found in network.");
		
		return recommendedFriend;
	}
	
	public void display(Profile account) {
		System.out.println("\n" + account.getName() + "'s timeline: ");
		System.out.println("\t" + account.getName());
		System.out.println("\tStatus: " + account.getStatus());
	}
	
	public void displayRecFriend(Profile account){
		AList<Profile>recommend = recommendedFriend(account);
		if (recommend.getLength() != 0){
			System.out.println("List of Recommended Friends: ");
			for (int i = 1; i <= recommend.getLength(); i++)
				System.out.println("\t" + recommend.getEntry(i).getName());
		}
		
		else
			System.out.println("No Recommended Friends at the moment.");
	} 
}
