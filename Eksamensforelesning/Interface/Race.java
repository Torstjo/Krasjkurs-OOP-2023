package Eksamensforelesning.Interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Race implements Iterable<Post> {

	// TODO: necessary fields and initialisation
	private Post startPost;
	private Post finishPost;

	private List<Post> intermediatePosts = new ArrayList<>();

	/**
	 * Initializes this race with the provided start and finish post.
	 *
	 * @param startPost
	 * @param finishPost
	 * @throws IllegalArgumentException if one or both of the arguments are null
	 */
	public Race(final Post startPost, final Post finishPost) {
		// TODO: initialisation
		if (startPost == null || finishPost == null) {
			throw new IllegalArgumentException("The posts cannot be null!");
		}
		this.startPost = startPost;
		this.finishPost = finishPost;
	}

	/**
	 * Initializes this race with start and finish post being the same post.
	 *
	 * @param startFinishPost
	 * @throws IllegalArgumentException if the argument is null
	 */
	public Race(final Post startFinishPost) {
		// TODO: initialisation
		this(startFinishPost, startFinishPost);
	}

	/**
	 * @return the start post
	 */
	public Post getStartPost() {
		// TODO
		return this.startPost;
	}

	/**
	 * @return the finish post
	 */
	public Post getFinishPost() {
		// TODO
		return this.finishPost;
	}

	public List<Post> getIntermediatePosts() {
		return intermediatePosts;
	}

	/**
	 * @return the number of posts, including start and finish post
	 */
	public int getPostCount() {
		// TODO
		return intermediatePosts.size()+2;
	}

	/**
	 * @param num
	 * @return the post with index num, start post is index 0 and finish post comes last
	 */
	public Post getPost(final int num) {
		if (num == 0) {
			return startPost;
		}
		else if (num == getPostCount() - 1) {
			return finishPost;
		}
		// TODO
		return intermediatePosts.get(num-1);
	}

	/**
	 * @return all the posts in the order of index, i.e. start first, finish last
	 */
	public Post[] getPosts() {
		List<Post> allPosts = new ArrayList<>();
		allPosts.add(startPost);
		allPosts.addAll(intermediatePosts);
		allPosts.add(finishPost);
		return allPosts.toArray(new Post[allPosts.size()]);
	}

	public List<Post> getAllPosts() {
		List<Post> allPosts = new ArrayList<>();
		allPosts.add(startPost);
		allPosts.addAll(intermediatePosts);
		allPosts.add(finishPost);
		return allPosts;
	}

	/**
	 * @return an iterator that returns all the posts in index order
	 */
	@Override
	public Iterator<Post> iterator() {
		// TODO
		//return new Iterator<Post>() {

		//	private int pos = 0;

		//	@Override
		//	public boolean hasNext() {
		//		return pos < getPostCount();
		//	}

		//	@Override
		//	public Post next() {
		//		return getPost(pos++);
		//	}

		//};
		return getAllPosts().iterator();
	}

	/**
	 * Removes the provided post.
	 *
	 * @param post
	 * @throws IllegalArgumentException if this provided post isn't one of this race's intermediate posts
	 */
	public void removePost(final Post post) {
		// TODO
		if (!intermediatePosts.contains(post)) {
			throw new IllegalArgumentException("The provided post is not in this race!");
		}
		intermediatePosts.remove(post);
	}

	/**
	 * Finds all posts in this race within a certain distance from the provided reference point (coordinate pair)
	 *
	 * @param east the east coordinate of the reference point
	 * @param north the north coordinate of the reference point
	 * @param distance the maximum distance for the returned points
	 * @return an iterator that returns all posts within a certain distance from the reference point
	 */
	public Iterator<Post> findPostsNearby(final double east, final double north, final double distance) {
		// TODO
		Collection<Post> nearbyPosts = new ArrayList<>();
		for (Post post : getAllPosts()) {
			if (Post.distance(post, east, north) < distance) {
				nearbyPosts.add(post);
			}
		}
		return nearbyPosts.iterator();
	}

	/**
	 * The smallest allowed distance between two posts in a race.
	 */
	public final static double distanceEpsilon = 20.0;

	/**
	 * Adds a post at a specific point given by east and north coordinates
	 *
	 * @param east
	 * @param north
	 * @return the added post
	 * @throws IllegalArgumentException if the post is too close to another post (see distanceEpsilon)
	 */
	public Post addPost(final double east, final double north) {
		Iterator<Post> nearbyPosts = findPostsNearby(east, north, distanceEpsilon);
		if (nearbyPosts.hasNext()) {
			throw new IllegalArgumentException("This post is too close to another!");
		}

		Post newPost = new Post(east, north);
		intermediatePosts.add(newPost);
		return newPost;
	}

	/**
	 * Sets the post numbers to the corresponding index.
	 * I.e. if you add three posts, start will have number 0,
	 * the first added will have postNum=1, the second postNum=2,
	 * the third postNum=3 and the finish post postNum=4.
	 */
	public void assignPostNums() {
		for (int i = 0; i < getPostCount(); i++) {
			getPost(i).setPostNum(i);
		}
	}

	//

	//public static RouteFactory getMaxDistanceRouteFactory(final double maxDistance) {
	//	return new MaxDistanceRouteFactory(maxDistance);
	//}

	// for own testing

	public static void main(final String[] args) {
		final var start = new Post(0.0, 0.0);
		final var finish = new Post(3.0, 4.0);
		final var race = new Race(start, finish);
		race.addPost(15.0, 42.0);
		race.assignPostNums();
		// should print three posts, with the one at 0.0,0.0 first,
		// then the one at 15.0,42.0 and finally the one at 3.0,4.0
		System.out.println(List.of(race.getPosts()));
	}
}