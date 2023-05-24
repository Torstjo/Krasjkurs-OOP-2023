package EksamensforelesningLF.Interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Race implements Iterable<Post> {
    
    // TODO: necessary fields and initialisation
    private Post startPost;
    private Post finishPost;
    private List<Post> racePosts = new ArrayList<>();

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
            throw new IllegalArgumentException("Ugyldige poster");
        }

        this.startPost = startPost;
        this.finishPost = finishPost;
        racePosts.add(startPost);
        racePosts.add(finishPost);
	}

	/**
	 * Initializes this race with start and finish post being the same post.
	 *
	 * @param startFinishPost
	 * @throws IllegalArgumentException if the argument is null
	 */
	public Race(final Post startFinishPost) {
		if (startFinishPost == null) {
            throw new IllegalArgumentException("Ugyldige poster");
        }

        this.startPost = startFinishPost;
        this.finishPost = startFinishPost;
        racePosts.add(startFinishPost);
        racePosts.add(startFinishPost);
	}

	/**
	 * @return the start post
	 */
	public Post getStartPost() {
		// TODO
		return startPost;
	}

	/**
	 * @return the finish post
	 */
	public Post getFinishPost() {
		// TODO
		return finishPost;
	}

	/**
	 * @return the number of posts, including start and finish post
	 */
	public int getPostCount() {
		// TODO
		return racePosts.size();
	}

	/**
	 * @param num
	 * @return the post with index num, start post is index 0 and finish post comes last
	 */
	public Post getPost(final int num) {
		// TODO
		return getPosts()[num];
	}

	/**
	 * @return all the posts in the order of index, i.e. start first, finish last
	 */
	public Post[] getPosts() {
		// TODO
        class PostComparator implements Comparator<Post> {

            @Override
            public int compare(Post o1, Post o2) {
                return o1.getPostNum() - o2.getPostNum();
            }

        };
        List<Post> sortedList = racePosts;
        Collections.sort(sortedList, new PostComparator());
        Post[] postArray = sortedList.toArray(new Post[sortedList.size()]);
		return postArray;
	}

	/**
	 * @return an iterator that returns all the posts in index order
	 */
	@Override
	public Iterator<Post> iterator() {
		// TODO
        Collection<Post> posts = Arrays.asList(getPosts());
		return posts.iterator();
	}

	/**
	 * Removes the provided post.
	 *
	 * @param post
	 * @throws IllegalArgumentException if this provided post isn't one of this race's intermediate posts
	 */
	public void removePost(final Post post) {
		// TODO
        if (!racePosts.contains(post)) {
            throw new IllegalArgumentException("Invalid post");
        }
        racePosts.remove(post);
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
        Collection<Post> nearbyPosts = new ArrayList<>();
		Iterator<Post> posIterator = iterator();
		while (posIterator.hasNext()) {
            if (Post.distance(posIterator.next(), east, north) <= distance) {
                nearbyPosts.add(posIterator.next());
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
		if (findPostsNearby(east, north, distanceEpsilon).hasNext()) {
            throw new IllegalArgumentException("This post is too close to another!");
        }
        Post newPost = new Post(east, north);
        racePosts.add(newPost);
		return newPost;
	}

	/**
	 * Sets the post numbers to the corresponding index.
	 * I.e. if you add three posts, start will have number 0,
	 * the first added will have postNum=1, the second postNum=2,
	 * the third postNum=3 and the finish post postNum=4.
	 */
	public void assignPostNums() {
		// TODO
		if (startPost.equals(finishPost)) {
			startPost.setPostNum(0);
		}
		else {
			startPost.setPostNum(0);
			finishPost.setPostNum(getPostCount()-1);
		}
		for (int i = 1; i < getPostCount()-1; i++) {
			racePosts.get(i+1).setPostNum(i);
		}
	}

	//

	public static RouteFactory getMaxDistanceRouteFactory(final double maxDistance) {
		return new MaxDistanceRouteFactory(maxDistance);
	}

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
