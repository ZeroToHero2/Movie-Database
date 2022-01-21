package MovieDatabase;
//-----------------------------------------------------

// Title:Actor Object Class
// Author: Hamid Ahmadlouei-İbrahim İleri
// ID: 10007768278
// Section: 1
// Assignment: 3-BinarySearchTrees
// Description: This Class for Actor Objects and it holds actor's attributes.
//-----------------------------------------------------

public class Actor implements Comparable<Actor> {
    public String firstName, lastName, movieTitle, roleTitle;

    /**
     * Constructor for Actor Object.
     */
    public Actor(String firstName, String lastName, String movieTitle, String roleTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.movieTitle = movieTitle;
        this.roleTitle = roleTitle;
    }

    /**
     * Getter Setter Methods for Actor Object.
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getRoleTitle() {
        return roleTitle;
    }

    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }

    /**
     * Summary and Post condition:Actor Object compareTo() Method for comparing them in BST by their First and Last Name
     * Precondition: Actor Object and the Actor Object in this Class.
     */
    @Override
    public int compareTo(Actor o) {
        if (this.firstName.compareTo(o.firstName) < 0) return -1;
        if (this.firstName.compareTo(o.firstName) > 0) return +1;
        if (this.lastName.compareTo(o.lastName) < 0) return -1;
        if (this.lastName.compareTo(o.lastName) > 0) return +1;
        return 0;
    }
}
