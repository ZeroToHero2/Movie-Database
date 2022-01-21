package MovieDatabase;
//-----------------------------------------------------

// Title:Tester(Trial) Class
// Author: Hamid Ahmadlouei-İbrahim İleri
// ID: 10007768278
// Section: 1
// Assignment: 3-BinarySearchTrees
// Description: It's challenging that propagate different inputs for such a project.
// But at least I tried to append my personal inputs even if a little.
//-----------------------------------------------------
public class TrialClass {
    public static void main(String[] args) {
        MovieDatabase md = new MovieDatabase();
        md.addMovie("intersteller", "Enes", "Yardım", 11, 8, 2019);
        md.addMovie("Baharda Aşk", "Enes", "Yardım", 11, 8, 2021);
        md.addMovie("Baharda Aşk farklıdır", "Enes", "Yardım", 11, 8, 2019);
        md.addMovie("Baharda Aşk ovaldir", "bahadır", "Ünal", 12, 9, 2014);

        md.addActor("intersteller", "Bahadır", "Ünaş", "star");
        md.addActor("intersteller", "Serap", "İlhan", "boom");
        md.addActor("intersteller", "Hasan", "Tek", "damn");
        md.addActor("Baharda Aşk", "Bahadır", "Ünaş", "star");
        md.addActor("Baharda Aşk", "Bahadır", "Ünaş", "star");
        md.addActor("Baharda Aşk farklıdır", "ali", "veli", "star");
        // md.removeActor("Baharda Aşk","Bahadır","Ünaş");
        //md.removeActor("Baharda Aşk","Bahadır","Ünaş");
        md.removeActor("Baharda Aşk ovaldir", "bahadır", "Ünal");
        md.removeActor("Baharda Aşk farklıdır", "ünal", "barış");
        md.showAllMovies();
        md.showMovie("Baharda Aşk ovaldir");
        md.showActorRoles("Bahadır", "Ünaş");
        // md.showActorRoles("bahadır","Ünal");
        System.out.println();
        md.showDirectorMovies("Enes", "Yardım");
        md.showMovies(2019);
        System.out.println();
        md.showMovies(2013,2021);


    }

}
