package EksamensforelesningLF.Interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 * A functional interface for creating a route from a starting post,
 * through some or all of a set of posts to a finishing post.
 */

 @FunctionalInterface
 public interface RouteFactory {
 
	 /**
	  * Creates a route from a starting post, through a set of posts to a finishing post.
	  *
	  * @param startPost the starting post
	  * @param posts the intermediate posts
	  * @param finishPost the final post
	  * @return the route through the provided posts
	  */
	 Route createRoute(Post startPost, List<Post> posts, Post finishPost);
 
	 /**
	  * Utility method that creates a route from
	  * a starting post, through a set of posts back to the starting post.
	  *
	  * @param startPost the starting post
	  * @param posts the intermediate posts
	  * @param finishPost the final post
	  * @return the route through the provided posts
	  */
	 default Route createRoute(final Post startPost, final List<Post> posts) {
		 return createRoute(startPost, posts, startPost);
	 }
 
	 /**
	  * Utility method that creates a route through a set of posts.
	  *
	  * @param startPost the starting post
	  * @param posts the intermediate posts
	  * @param finishPost the final post
	  * @return the route through the provided posts
	  */
	 default Route createRoute(final List<Post> posts) {
		 final int lastIndex = posts.size() - 1;
		 return createRoute(posts.get(0), posts.subList(1, lastIndex), posts.get(lastIndex));
	 }
 
	 public final static RouteFactory ALL_POSTS_IN_ORDER = (start, between, finish) -> {
		 final List<Post> posts = new ArrayList<>(between);
		 posts.add(0, start);
		 posts.add(finish);
		 return new Route(posts);
	 };
 
	 public final static RouteFactory ALL_POSTS_REVERSED = (start, between, finish) -> {
		 final ArrayList<Post> copyReversed = new ArrayList<>(between);
		 Collections.reverse(copyReversed);
		 return ALL_POSTS_IN_ORDER.createRoute(start, copyReversed, finish);
	 };
 

	// for own testing
	public static void main(final String[] args) {
		final Post post1 = new Post(0.0, 0.0);
		final Post post2 = new Post(3.0, 4.0);
		final Post post4 = new Post(90, 120);
		final Post post3 = new Post(5.0, 12.0);

		List<Post> posts = new ArrayList<>();
		posts.add(post2);
		posts.add(post4);

		System.out.println(RouteFactory.ALL_POSTS_IN_ORDER.createRoute(post1, posts, post3));
		System.out.println(RouteFactory.ALL_POSTS_REVERSED.createRoute(post1, posts, post3));
	}

}
