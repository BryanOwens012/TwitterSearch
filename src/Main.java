import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main extends TwitterSearch {

	private final AtomicInteger counter = new AtomicInteger();

	@Override
	public boolean saveTweets(List<Tweet> tweets) {
		if (tweets != null) {
			for (Tweet tweet : tweets) {
				System.out.println(counter.getAndIncrement() + 1 + "["
						+ tweet.getCreatedAt() + "] - " + tweet.getText());
				if (counter.get() >= 500) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws InvalidQueryException {
		TwitterSearch twitterSearch = new Main();
		System.out
				.println("This program prints out a list of Twitter tweet search results for a word or phrase.");
		System.out.println("When you want to stop the program, press CTRL-C");
		System.out.println("Enter what you want to search for now:");
		Scanner in = new Scanner(System.in);
		String searchTerm = in.nextLine();
		System.out.println("Accepted \"" + searchTerm + "\".");
		System.out.println();
		twitterSearch.search(searchTerm, 2);
	}
}