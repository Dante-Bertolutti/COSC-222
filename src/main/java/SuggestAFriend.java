import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class SuggestAFriend {

	/**
	 * Given social network g and name s, returns an ArrayList of all
	 * the names that this social network would suggest s may know
	 * @param g
	 * @param s
	 */
	public static ArrayList<String> suggest(Graph g, String s) {
		// First, let's make sure name s exists in this graph g
		if (g.containsName(s) == false) {
			System.err.println(s + " does not exist in this graph");
			return null;
		}
		
		// Done: Find and store the friends of s
		ArrayList<String> sfriends = g.getNbrs(s);
		HashSet<String> friendsset = new HashSet<>(sfriends);

		// Done: Find the friends of the friends of s
		// Don't forget to exclude s and s's friends from this layer
		HashMap<String,Integer> possibleFriends = new HashMap<>();
		for (String friend : sfriends){
			ArrayList<String> friendOfFriend = g.getNbrs(friend);
			for (String friendOf: friendOfFriend){
				if (!friendOf.equals(s) && !friendsset.contains(friendOf)){
					possibleFriends.put(friendOf, possibleFriends.getOrDefault(friendOf,0) + 1);
				}
			}
		}

		// Done: Of all the friends of friends of s, find the ones with
		// the largest number of common friends with s
		ArrayList<String> suggestedFriends = new ArrayList<>();
		int maxCommonFriends = 0;
		for (String potentialFriend: possibleFriends.keySet()){
			int commonFriends = possibleFriends.get(potentialFriend);
			if (commonFriends > maxCommonFriends){
				suggestedFriends.clear();
				suggestedFriends.add(potentialFriend);
				maxCommonFriends = commonFriends;
			} else if (commonFriends == maxCommonFriends) {
				suggestedFriends.add(potentialFriend);
			}
		}
		// Done: return an ArrayList of all the names with most common friends
		return suggestedFriends;
	}

}
