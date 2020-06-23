/*
 * Natalie Pham
 * 6/21/20
 * Profile Class
 */

package Final1;
import java.util.Scanner;
public class Profile {
	private String firstName, lastName;
	private String status;
	private AList<Profile> friendList;
	public static Scanner user = new Scanner(System.in);
	
	
	public static void main(String[] args){
		System.out.println("------------------------------------------");
		System.out.println("\tFriendship Maker: Facebook");
		System.out.println("------------------------------------------\n");  
		ProfileManager accounts = new ProfileManager();
		
		//user input 4 friends/status'
		String first, last, status;
		System.out.println("\tFirst Profile");
		System.out.println("Enter first name: ");
		first = user.nextLine().trim();
		System.out.println("Enter last name: ");
		last = user.nextLine().trim();
		System.out.println("Enter your status: ");
		status = user.nextLine().trim();
		System.out.println();
		
		System.out.println("\tSecond Profile");
		String first1, last1, status1;
		System.out.println("Enter first name: ");
		first1 = user.nextLine().trim();
		System.out.println("Enter last name: ");
		last1 = user.nextLine().trim();
		System.out.println("Enter your status: ");
		status1 = user.nextLine().trim();
		System.out.println();

		System.out.println("\tThird Profile");
		String first2, last2, status2;
		System.out.println("Enter first name: ");
		first2 = user.nextLine().trim();
		System.out.println("Enter last name: ");
		last2 = user.nextLine().trim();
		System.out.println("Enter your status: ");
		status2 = user.nextLine().trim();
		System.out.println();

		System.out.println("\tFourth Profile");
		String first3, last3, status3;
		System.out.println("Enter first name: ");
		first3 = user.nextLine().trim();
		System.out.println("Enter last name: ");
		last3 = user.nextLine().trim();
		System.out.println("Enter your status: ");
		status3 = user.nextLine().trim();
		System.out.println();

		//constructor usages
		Profile Frankie = new Profile(first, last, status);
		Profile Tommy = new Profile (first1, last1, status1);
		Profile James = new Profile (first2, last2, status2);
		Profile Sean = new Profile (first3, last3, status3);
		
		//use setters to add two new profiles instead of constructor
		Profile Kenny = new Profile();
		Kenny.setName("Kenny", "Boun");
		Kenny.setStatus("NYESSS");
		Profile Johnny = new Profile();
		Johnny.setName("Johnny", "Le");
		Johnny.setStatus("I like food.");
		
		accounts.addProfile(Frankie);
		accounts.addProfile(Tommy);
		accounts.addProfile(James);
		accounts.addProfile(Sean);
		accounts.addProfile(Kenny);
		accounts.addProfile(Johnny);
		accounts.addProfile(Frankie);
		
		//create
	    System.out.println("-----------");
	    System.out.println("Friendships");
	    System.out.println("-----------");
		createFriendShip(Frankie, James);
		createFriendShip(Kenny, Johnny);
		createFriendShip(James, Tommy);
		createFriendShip(Kenny, Frankie);
		
		displayProfile(Frankie);
		displayProfile(Tommy);
		displayProfile(James);
		displayProfile(Sean);  
		displayProfile(Kenny);
		displayProfile(Johnny);
		
		//read
		createFriendShip(James, Sean);
		System.out.println("\n--------------------");
	    System.out.println("Graph of All Friends");
		System.out.println("--------------------");
	    accounts.LinkedFriend(Frankie, James);
	    accounts.LinkedFriend(Kenny, Johnny);
	    accounts.LinkedFriend(James, Tommy);
	    accounts.LinkedFriend(Kenny, Frankie);
	    accounts.LinkedFriend(James, Sean);
	    System.out.println("\nSearching for Friends and Recommended Friends");
		System.out.println("Trying to look for Frankie");
		accounts.searchProfile(Frankie);
		
		System.out.println("\n--------------------");
	    System.out.println("Searching for Friend");
	    System.out.println("--------------------");
	    System.out.println("Searching Frankie in Kenny's list: ");
	    Kenny.searchFriend(Frankie);
	    System.out.println("Searching Johnny in James's list: ");
	    James.searchFriend(Johnny);
		
		//update
		System.out.println("\n-----------------");
        System.out.println("Updating Profiles");
        System.out.println("-----------------");
        Kenny.setStatus("Not single anymore");
        James.setStatus("Food outing anyone?");
        Frankie.setStatus("Finally engaged");
        Frankie.setName("Frankie", "Le");
        displayProfile(Kenny); 
		displayProfile(James);
		displayProfile(Frankie);
		System.out.println("\n-----------------------------------------");
		System.out.println("End relationship between Kenny and Johnny");
		System.out.println("-----------------------------------------");
		System.out.println();
		endFriendShip(Kenny, Johnny);
		accounts.unLinkedFriend(Kenny, Johnny); 
		System.out.println("Searching for Frankie for recommended acquaintances:");
		accounts.searchProfile(Frankie); 
		
		//delete
		System.out.println("\n----------------");
	    System.out.println("Deleting Account");
	    System.out.println("----------------");
	    System.out.println("Deleting Johnny from File...");
	    accounts.removeProfile(Johnny);
		System.out.println("Attempting to find Johnny...");
		accounts.searchProfile(Johnny);
		
    } 
	
	public Profile() {	 
		firstName = lastName = status = null;
		friendList = new AList<Profile>();
	}
	
	public Profile(String first, String last, String sta){	
		firstName = first;
		lastName = last;
		status = sta;
		friendList = new AList<Profile>(); 
	} 
	
	public void searchFriend(Profile account){
		if (friendList.contains(account)){
			System.out.println("Found user!");
			displayProfile(account);	
		}
		else
			System.out.println("User not found!");
	} 
	
	public static void displayFriend(Profile account){
		if (account.friendList.getLength() == 0)
			System.out.println(account.getName() + " has no friends.");
		else{
			System.out.println("All Friends: " + account.friendList.getLength() + " friends.");
			System.out.println(account.getName() + " friends': ");
			for (int i = 1; i <= account.friendList.getLength(); i++)
				System.out.println("\t" + account.friendList.getEntry(i).getName());
		}
	}
	
	public static void displayProfile(Profile account) { 
		System.out.println("Profile Name: " + account.getName());
		System.out.println("Status: " + account.getStatus());
		displayFriend(account);
		System.out.println("\n");
	}
	  
	
	public void setName(String first, String last){
		firstName = first;
		lastName = last;
	} 
	
	public void setStatus(String sta){
		status = sta;
	}
	
	public String getName(){
		return firstName + " " + lastName;
	}
	
	public String getStatus(){
		return status;
	}
	
	
	public AList<Profile>getFriends(){
		return friendList;
	}
	
	public void addFriend(Profile friend){
		if (!friendList.contains(friend))
			friendList.add(friend);
		else 
			System.out.println("User is already in the friends list!");
	}
	
	public void removeFriend(Profile friend){
		if (friendList.contains(friend)){
			for (int i = 1; i < friendList.getLength(); i++){
				if (friendList.getEntry(i).equals(friend))
					friendList.remove(i);
				else
					System.out.println("User is not in the friends list!");			
			}
		}
	}  
	
	public static void createFriendShip(Profile acc1, Profile acc2){
		acc1.addFriend(acc2);
		acc2.addFriend(acc1); 
	}
	
	public static void endFriendShip(Profile acc1, Profile acc2){
		acc1.removeFriend(acc2);
		acc2.removeFriend(acc1);
	}
	
     
}

/**
 * Sample Output:
------------------------------------------
	Friendship Maker: Facebook
------------------------------------------

	First Profile
Enter first name: 
Natalie
Enter last name: 
Pham
Enter your status: 
Single

	Second Profile
Enter first name: 
Emma
Enter last name: 
Tran
Enter your status: 
Complicated

	Third Profile
Enter first name: 
James
Enter last name: 
Ta
Enter your status: 
No Clue

	Fourth Profile
Enter first name: 
Victoria
Enter last name: 
Lu
Enter your status: 
In a relationship

-----------
Friendships
-----------
Profile Name: Natalie Pham
Status: Single
All Friends: 2 friends.
Natalie Pham friends': 
	Emma Tran
	James Ta


Profile Name: Emma Tran
Status: Complicated
All Friends: 1 friends.
Emma Tran friends': 
	James Ta


Profile Name: James Ta
Status: No Clue
All Friends: 2 friends.
James Ta friends': 
	Natalie Pham
	Emma Tran


Profile Name: Victoria Lu
Status: In a relationship
Victoria Lu has no friends.


Profile Name: Vincent Cheng
Status: NYESSS
All Friends: 2 friends.
Vincent Cheng friends': 
	Victoria Lu
	Natalie Pham


Profile Name: Johnny Quang
Status: I like food.
All Friends: 1 friends.
Johnny Quang friends': 
	Vincent Cheng



--------------------
Graph of All Friends
--------------------

Searching for Friends and Recommended Friends
Trying to look for Vincent

Natalie Pham's timeline: 
	Natalie Pham
	Status: Single
All Friends: 2 friends.
Natalie Pham friends': 
	Johnny Quang 
	Vincent Cheng
List of Recommended Friends: 
	Emma Tran
	Victoria Lu
	James Ta

--------------------
Searching for Friend
--------------------
Searching Victoria in James's list: 
Found user!
Profile Name: James Ta
Status: Single
All Friends: 2 friends.
James Ta friends': 
	Johnny Quang 
	Vincent Cheng


Searching Victoria in James's list: 
User not found!

-----------------
Updating Profiles
-----------------
Profile Name: Vincent Cheng
Status: Not single anymore
All Friends: 2 friends.
Vincent Cheng friends': 
	Natalie Pham 
	James Ta


Profile Name:Johnny Quang 
Status: Food outing anyone?
All Friends: 3 friends.
Johnny Quang friends': 
	Vincent Cheng
	Emma Tran
	Victoria Lu


Profile Name: Emma Tran
Status: Finally engaged
All Friends: 2 friends.
Emma Tran friends': 
	Natalie Pham
	James Ta



-----------------------------------------
End relationship between Natalie and James
-----------------------------------------

Searching for Natalie for recommended acquaintance
Natalie Pham is found!

Natalie Pham's timeline: 
	Natalie Pham
	Status: Finally engaged
Natalie Pham friends': 
	Victoria Lu
	Emma Tran
List of Recommended Friends: 
	Johnny Quang
	Vincent Cheng

----------------
Deleting Account
----------------
Deleting Johnny from File...
Account removed.
Attempting to find Johnny...
User not found.
*/
