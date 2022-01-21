package MovieDatabase;
//-----------------------------------------------------

// Title:Movie Object Class
// Author: Hamid Ahmadlouei-İbrahim İleri
// ID: 10007768278
// Section: 1
// Assignment: 3-BinarySearchTrees
// Description: This Class for Movie Objects and it holds movie's attributes.
//-----------------------------------------------------

public class Movie implements Comparable<Movie> {
    public String movieTitle, firstNameDirector, lastNameDirector;
    public int day, month, year;
    public BinarySearchTree<Actor, String> castList; //Actor Name and Actor fields

    /**
     * Constructor for Movie Object which "Initialize the CastList which is BST for Actor Objects.
     */
    public Movie(String movieTitle, String firstNameDirector, String lastNameDirector, int day, int month, int year) {
        this.movieTitle = movieTitle;
        this.firstNameDirector = firstNameDirector;
        this.lastNameDirector = lastNameDirector;
        this.day = day;
        this.month = month;
        this.year = year;
        castList = new BinarySearchTree<Actor, String>(); //actor name-actor fields.
    }

    public Movie(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    @Override
    public String toString() {
        return movieTitle + ", " +
                year + ", " +
                firstNameDirector +" "+
                lastNameDirector;
    }
    /**
     * Summary and Post condition:Actor Object compareTo() Method for comparing them in BST by their Release Years.
     * Precondition: Movie Object and the Movie Object in this Class.
     */
    @Override
    public int compareTo(Movie o) {
        if (this.year < o.year) return -1;
        if (this.year > o.year) return +1;
        /*if (this.month < o.month) return -1;
        if (this.month > o.month) return +1;
        if (this.day < o.day) return -1;
        if (this.day > o.day) return +1;*/
        return 0;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getFirstNameDirector() {
        return firstNameDirector;
    }

    public void setfirstNameDirector(String firstNameDirector) {
        this.firstNameDirector = firstNameDirector;
    }

    public String getLastNameDirector() {
        return lastNameDirector;
    }

    public void setLastNameDirector(String lastNameDirector) {
        this.lastNameDirector = lastNameDirector;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
