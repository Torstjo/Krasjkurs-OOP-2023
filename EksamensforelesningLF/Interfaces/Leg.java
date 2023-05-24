package EksamensforelesningLF.Interfaces;

public class Leg {
    // TODO: necessary fields and initialisation

    private Post startPost;
    private Post endPost;

	/**
	 * Initializes this Leg with the provided start and end post.
	 *
	 * @param startPost the starting post
	 * @param endPost the ending post
	 */
	public Leg(final Post startPost, final Post endPost) {
		// TODO: initialization
        this.startPost = startPost;
        this.endPost = endPost;
	}

	/**
	 * Returns the string representation of this leg.
	 * Includes the number of the start and end posts, as well as the distance between them.
	 */
	@Override
	public String toString() {
		// TODO: return a suitable String
		return "Startpost: "+startPost.getPostNum()+" \nEndpost: "+endPost.getPostNum()+" \nAvstand: "+Post.distance(startPost, endPost);
	}

	/**
	 * @return the starting Post of this leg
	 */
	public Post getStartPost() {
		// TODO
		return startPost;
	}

	/**
	 * @return the end post of this leg
	 */
	public Post getEndPost() {
		// TODO
		return endPost;
	}

	// TODO: methods including getters og setters, that you find necessary and useful

	/**
	 * Computes the distance between the start and end posts.
	 *
	 * @return the distance between the start and end posts
	 */
	public double distance() {
		// TODO: return correct value
		return Post.distance(startPost, endPost);
	}

}
