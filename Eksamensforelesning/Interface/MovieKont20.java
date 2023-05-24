package Eksamensforelesning.Interface;

public class MovieKont20 {
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
}
