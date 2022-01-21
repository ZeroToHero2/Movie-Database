package MovieDatabase;

import java.util.ArrayList;
import java.util.Iterator;
//-----------------------------------------------------
// Title:MovieDatabase Class
// Author: Bahadır Ünal
// Description: Create MovieDatabase with Movies and CastList.
// Also it consist of methods which can be used for adding displaying ad deleting information.
//-----------------------------------------------------
public class MovieDatabase implements Iterable {
    BinarySearchTree<Movie, Integer> movieList; // release year-Movie
  
    /**
     * Summary and Post condition:Constructor which initialize the BST for Movies.
     * Precondition: None
     */
    public MovieDatabase() {
        movieList = new BinarySearchTree<Movie, Integer>();
    }


    /**
     * Summary and Post condition:This method for Adding Movie into the MovieDatabase(actually in the Movie BST).
     * If the Movies already exist in the BST overwrites onto old information.
     * Precondition: movieTitle ,directorFirstName ,directorLastName ,releaseDay, releaseMonth, releaseYear of the Movie.
     */
    public void addMovie(String movieTitle, String directorFirstName, String directorLastName, int releaseDay, int releaseMonth, int releaseYear) {
        /**
         * Traverse the tree if we have no existing movie add it to tree, if we have, overwrites it.
         */  
        boolean found = false;
        ArrayList<Movie> movies = movieList.keys();
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getMovieTitle().equals(movieTitle)) {
                found = true;
                Movie addedMovie = movies.get(i);
                movieList.add(addedMovie, addedMovie.year);
                System.out.println("INFO: Movie " + addedMovie.movieTitle + " overwritten");
                //overwrite onto it.
            }
        }
        if (found == false) {
            Movie addedMovie = new Movie(movieTitle, directorFirstName, directorLastName, releaseDay, releaseMonth, releaseYear);
            movieList.put(addedMovie, releaseYear);
            System.out.println("INFO: Movie " + addedMovie.movieTitle + " has been added");
        }
    }

    /**
     * Summary and Post condition:This method for Deleting Movie into the MovieDatabase(actually in the Movie BST).
     * If there is no Movie in the BST give warning message.
     * Precondition: movieTitle of the Movie.
     */
    public void removeMovie(String movieTitle) {
/**
 * traverse the tree if we have no  movie like that give warning,if yes remove it.
 */
        boolean found = false;
        ArrayList<Movie> movies = movieList.keys();
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).movieTitle.equals(movieTitle)) {
                found = true;
                Movie removedMovie = movies.get(i);
                movieList.delete(removedMovie); // modify delete method.
                System.out.println("INFO: Movie " + removedMovie.movieTitle + " has been removed");
            }
        }
        if (found == false) {
            System.out.println("You cannot remove the non-existing Movie.");
        }

    }

    /**
     * Summary and Post condition:This method for Adding Actor into the MovieDatabase(actually in the Actor BST-CastList-).
     * If the Actor already exist in the BST (same movie and same cast) overwrites onto old information.
     * Also if there is no Movie in the BST give warning message.
     * Precondition: movieTitle,FirstName,LastName,Role of the Actor.
     */
    public void addActor(String movieTitle, String actorFirstName, String actorLastName, String actorRole) {
        boolean found = false;
        boolean isoverwritten = false;

        ArrayList<Movie> movies = movieList.keys();
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).movieTitle.equals(movieTitle)) {
                // System.out.println("if in içi");
                found = true;
                ArrayList<Actor> actors = movies.get(i).castList.keys();
                Actor addedActor = new Actor(actorFirstName, actorLastName, movieTitle, actorRole);
                if (actors.isEmpty()) {
                    movies.get(i).castList.put(addedActor, actorFirstName + " " + actorLastName);
                    System.out.println("INFO: " + addedActor.firstName + " " + addedActor.lastName + " has been added to the movie " + movies.get(i).movieTitle);
                } else {
                    for (int j = 0; j < actors.size(); j++) {

                        //System.out.println("for un içi");
                        if (actors.get(j).getFirstName().equals(addedActor.getFirstName()) && actors.get(j).getLastName().equals(addedActor.getLastName())) {
                            isoverwritten = true;
                            movies.get(i).castList.add(addedActor, actorFirstName + " " + actorLastName);
                            System.out.println("INFO: " + actors.get(j).firstName + " " + actors.get(j).lastName + " has been overwritten the movie " + movies.get(i).movieTitle);
                        }
                    }
                    if(isoverwritten==false){
                        movies.get(i).castList.put(addedActor, actorFirstName + " " + actorLastName);
                        System.out.println("INFO: " + actorFirstName + " " + actorLastName  + " has been added to the movie " + movies.get(i).movieTitle);
                    }
                }
            }
        }
        if (found == false) {
            System.out.println("INFO: Movie " + movieTitle + " does not exist");
        }
    }

    /**
     * Summary and Post condition:This method for Deleting Actor into the MovieDatabase(actually in the Actor BST-CastList-).
     * If the Actor does not exist in the BST give warning message.
     * Also if there is no "CastList" for given Movie give warning message.
     * Also if there is no Movie in the BST give warning message.
     * Precondition: movieTitle,FirstName,LastName of the Actor.
     */
    public void removeActor(String movieTitle, String actorFirstName, String actorLastName) {
        // Note that after calling this function, the cast should remain sorted in ascending
        //order.
        boolean found = false;
        boolean foundactor = false;
        ArrayList<Movie> movies = movieList.keys();
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).movieTitle.equals(movieTitle)) {
                found = true;
                ArrayList<Actor> actors = movies.get(i).castList.keys();
                if (actors.size() == 0) {
                    System.out.println("There is no existing cast group for this movie.So you cannot remove.");
                } else {
                    for (int j = 0; j < actors.size(); j++) {
                        if (actors.get(j).getFirstName().equals(actorFirstName) && actors.get(j).getLastName().equals(actorLastName)) {
                            foundactor = true;
                            movies.get(i).castList.delete(actors.get(j)); // can be modify
                            System.out.println("INFO: " + actors.get(j).firstName + " " + actors.get(j).lastName + " has been removed from the movie " + movies.get(i).movieTitle);
                        }

                    }
                     if(foundactor == false) {
                        System.out.println("There is no actor with this name in this movies' cast.");
                    }
                }
            }
        }
        if (found == false) {
            System.out.println("You cannot remove the non-existing Movies Actor.");
        }
    }

    /**
     * Summary and Post condition: Show all movies with their informations.
     * If there is no movie like that,give "---none---" message.
     * Precondition: None
     */
    public void showAllMovies() {
        System.out.println();
        boolean found = false;
        ArrayList<Movie> movies = movieList.keys();
        for (int i = 0; i < movies.size(); i++) {
            found = true;
            System.out.println(movies.get(i));
        }
        if (found == false) {
            System.out.println("---none---");
        }
        System.out.println();
    }

    /**
     * Summary and Post condition:Show particular movie with  informations of it.
     * If there is no movie like that,give "---none---" message.
     * Precondition: None
     */
    public void showMovie(String movieTitle) { //isimleri yazdırırken birden fazla yazdırıyor.
        boolean found = false;
        System.out.println();
        ArrayList<Movie> movies = movieList.keys();

        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getMovieTitle().equals(movieTitle)) {
                ArrayList<Actor> actors = movies.get(i).castList.keys();
                found = true;
                System.out.println(movies.get(i).movieTitle);
                System.out.println(movies.get(i).day + "/" + movies.get(i).month + "/" + movies.get(i).year);
                System.out.println(movies.get(i).firstNameDirector + " " + movies.get(i).lastNameDirector);
                
                for (int j = 0; j < actors.size(); j++) {
                    System.out.println(actors.get(j).getFirstName() + " " + actors.get(j).getLastName() + ", " + actors.get(j).getRoleTitle());
                }
            }
        }
        if (found == false) {
            System.out.println(movieTitle);
            System.out.println("---none---");
        }
        System.out.println();
    }

    /**
     * Summary and Post condition:Show particular Actor with information's of it.
     * * If Actor has not a role in any Movie ,give "---none---" message.
     * Precondition: FirstName,LastName of Actor.
     */
    public void showActorRoles(String actorFirstName, String actorLastName) {
        //bu isme sahip aktörün oynadığı movie title ını bulup
        // ona ait movie objesini çağır ve özelliklerini yazdır.
        boolean found = false;
        System.out.println();
        System.out.println(actorFirstName + " " + actorLastName);
        ArrayList<Movie> movies = movieList.keys();
        for (int i = movies.size() - 1; i >= 0; i--) { //Arrayliste dizdiğim için tersten okuyunca descending oldu.
            //ÇOK ÖNEMLİ FOR UN İÇİNDEKİ "i" küçük eşit mi küçük mü. (BOUNDS)
            ArrayList<Actor> actors = movies.get(i).castList.keys();
            for (int j = 0; j < actors.size(); j++) {
                if (actors.get(j).firstName.equals(actorFirstName) && actors.get(j).lastName.equals(actorLastName)) {
                    found = true;
                    //System.out.println(actors.get(j).firstName + " " + actors.get(j).lastName);
                    System.out.println(actors.get(j).getRoleTitle() + ", " + actors.get(j).getMovieTitle() + ", " + movies.get(i).year);
                }

            }
        }
        if (found == false) {
            System.out.println("---none---");
        }
        System.out.println();

    }

    /**
     * Summary and Post condition:Show particular Director with information's of it.
     * * If Director does not direct any Movie ,give "---none---" message.
     * Precondition: FirstName,LastName of Director.
     */
    public void showDirectorMovies(String directorFirstName, String directorLastName) {
        boolean found = false;
        System.out.println();
        ArrayList<Movie> movies = movieList.keys();
        System.out.println(directorFirstName + " " + directorLastName);
        for (int i = movies.size()-1; i >= 0; i--) { 
            if (movies.get(i).getFirstNameDirector().equals(directorFirstName) && movies.get(i).getLastNameDirector().equals(directorLastName)) {
                found = true;
                System.out.println(movies.get(i).movieTitle + ", " + movies.get(i).day + "/" + movies.get(i).month + "/" + movies.get(i).year);
            }

        }
        if (found == false) {
            System.out.println("---none---");
        }
        System.out.println();
    }

    /**
     * Summary and Post condition:Show particular(enrolled in the given year) movie with  informations of it.
     * If there is no movie in the given year ,give "---none---" message.
     * Precondition: releaseYear of Intended Movies.
     */
    public void showMovies(int releaseYear) {
        
        boolean found = false;
        System.out.println();
        ArrayList<Movie> movies = movieList.keys();
        System.out.println(releaseYear);
        for (int i = movies.size() - 1; i >= 0; i--) {
            if (movies.get(i).getYear() == releaseYear) {
                found = true;
                System.out.println(movies.get(i).movieTitle + ", " + movies.get(i).firstNameDirector + " " + movies.get(i).lastNameDirector + ", " + movies.get(i).day + "/" + movies.get(i).month);
            }
        }
        if (found == false) {
            System.out.println("---none---");
        }
        System.out.println();
    }

    /**
     * Summary and Post condition:Show particular(enrolled between in the given years) movies with  informations of it.
     * If there is no movie in the given interval ,give "---none---" message.
     * Precondition: startYear-endYear of Intended Movies.
     */
    public void showMovies(int startYear, int endYear) {
        
        boolean found = false;
        System.out.println();
        ArrayList<Movie> movies = movieList.keys();
        System.out.println(startYear + "-" + endYear);
        for (int i = movies.size() - 1; i >= 0; i--) {
            int currentMovieReleasedYear = movies.get(i).year;
            if (currentMovieReleasedYear >= startYear && currentMovieReleasedYear <= endYear) {
                found = true;
                System.out.println(movies.get(i).movieTitle + ", " + movies.get(i).firstNameDirector + " " + movies.get(i).lastNameDirector + ", " + movies.get(i).year);
            }
            
        }
        if (found == false) {
            System.out.println("---none---");
        }
        System.out.println();
    }
}
