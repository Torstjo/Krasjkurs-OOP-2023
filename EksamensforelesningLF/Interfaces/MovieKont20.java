package EksamensforelesningLF.Interfaces;

public class MovieKont20 {
    	// See the README file for a description of what is required for this file.

        private String title = "";
        private int timesWatched;
        private int rating;

        public MovieKont20(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public int getTimesWatched() {
            return timesWatched;
        }

        public void watch() {
            this.timesWatched++;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            if (rating >= 1 && rating <= 6) {
                this.rating = rating;
            }
        }

	public static void main(String[] args) {

        //		Movie db = new Movie("Das Boot");
        //		assertEquals(0, db.getTimesWatched());
        //		assertEquals("Das Boot", db.getTitle());
        //		
        //		db.watch();
        //		assertEquals(1, db.getTimesWatched());
        //		
        //		assertEquals(null, db.getRating());
        //		db.setRating(4);
        //		assertEquals(4, (int)db.getRating());
            }
        
}
