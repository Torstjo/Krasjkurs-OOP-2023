package EksamensforelesningLF.Interfaces;

import java.util.ArrayList;
import java.util.List;

public class MaxDistanceRouteFactory implements RouteFactory {

    private final double maxDistance;

	/**
	 * Initializes this MaxDistanceRouteFactory with the provided maximum distance.
	 *
	 * @param maxDistance the maximum distances that will be used by the createRoute method
	 */
	public MaxDistanceRouteFactory(final double maxDistance) {
		this.maxDistance = maxDistance;
	}

	/**
	 * Creates a route by including posts as long as the maximum distance isn't exceeded.
	 * In the minimal case the route will only include the start and ending point.
	 *
	 * @throws IllegalArgumentException if a route cannot be computed without exceeding the maximum
	 */
	@Override
	public Route createRoute(final Post start, final List<Post> posts, final Post finish) {
		// TODO: change/complete the code
		final List<Post> routePosts = new ArrayList<>();
		return new Route(routePosts);
	}

}
