package bajp.playground.moviecatalogueapp.utils

import bajp.playground.moviecatalogueapp.R
import bajp.playground.moviecatalogueapp.data.CastEntity
import bajp.playground.moviecatalogueapp.data.MovieEntity

object DummyData {
    fun generateMovies():ArrayList<MovieEntity>{
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                "m1",
                "Aquaman",
                R.drawable.poster_aquaman,
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "James Wan",
                69,
                "12/26/2018",
                "Action,Adventure,Fantasy",
                "PG-13",
                "https://www.netflix.com/id-en/title/81004278",
                1,
                arrayListOf(
                    CastEntity("Arthur Curry / Aquaman","Jason Momoa","https://www.themoviedb.org/t/p/w276_and_h350_face/6dEFBpZH8C8OijsynkSajQT99Pb.jpg"),
                    CastEntity("Mera","Amber Heard","https://www.themoviedb.org/t/p/w276_and_h350_face/ik0cfqudGTYBBRKF0x4gl2rSUQx.jpg"),
                    CastEntity("Nuidis Vulko","Willem Dafoe","https://www.themoviedb.org/t/p/w276_and_h350_face/ui8e4sgZAwMPi3hzEO53jyBJF9B.jpg"),
                    CastEntity("King Orm Marius / Ocean Master","Patrick Wilson","https://www.themoviedb.org/t/p/w276_and_h350_face/tc1ezEfIY8BhCy85svOUDtpBFPt.jpg"),
                    CastEntity("Atlanna","Nicole Kidman","https://www.themoviedb.org/t/p/w276_and_h350_face/lfW2cDigTcvuoe4k6UfCdGVE1R6.jpg"),
                    CastEntity("King Nereus","Dolph Lundgren","https://www.themoviedb.org/t/p/w276_and_h350_face/jDLOU3Ay59NxLH8QDm5hcVTaKuC.jpg"),
                    CastEntity("David Kane / Black Manta","Yahya Abdul-Mateen II","https://www.themoviedb.org/t/p/w276_and_h350_face/aBDebGZs2pAucyaK4EhHVJGm0Xu.jpg"),
                    CastEntity("Thomas Curry","Temuera Morrison","https://www.themoviedb.org/t/p/w276_and_h350_face/1ckHDFgKXJ8pazmvLCW7DeOKqA0.jpg"),
                    CastEntity("Captain Murk","Ludi Lin","https://www.themoviedb.org/t/p/w276_and_h350_face/9Ila4K8POeuVWRO9hzyekFjvCDk.jpg")
                )
            )
        )
        movies.add(
            MovieEntity(
                "m2",
                "Alita: Battle Angel",
                R.drawable.poster_alita,
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past",
                "Robert Rodriguez",
                72,
                "02/14/2019",
                "Action, Science Fiction, Adventure",
                "PG-13",
                "https://www.hotstar.com/id/movies/alita-battle-angel/1260015998",
                1,
                arrayListOf(
                    CastEntity("Alita","Rosa Salazar","https://www.themoviedb.org/t/p/w276_and_h350_face/pc2tCeB99HtmrghAoPKksZkbzUU.jpg"),
                    CastEntity("Dr. Dyson Ido","Christoph Waltz","https://www.themoviedb.org/t/p/w276_and_h350_face/2Hhztd4mUEV9Y25rfkXDwzL9QI9.jpg"),
                    CastEntity("Chiren","Jennifer Connelly","https://www.themoviedb.org/t/p/w276_and_h350_face/3oYDftEbM3YgBiHYcbbIPRNZrTL.jpg"),
                    CastEntity("Vector","Mahershala Ali","https://www.themoviedb.org/t/p/w276_and_h350_face/9ZmSejm5lnUVY5IJ1iNx2QEjnHb.jpg"),
                    CastEntity("Zapan","Ed Skrein","https://www.themoviedb.org/t/p/w276_and_h350_face/c5PSRY9xbwJFCVCEeDIcx9SiJI1.jpg"),
                    CastEntity("Grewishka","Jackie Earle Haley","https://www.themoviedb.org/t/p/w276_and_h350_face/qVPNzBEm9xF4YX1SwkXhxgsuqCt.jpg"),
                    CastEntity("Hugo","Keean Johnson","https://www.themoviedb.org/t/p/w276_and_h350_face/qYslz07HQUW1bAqdYSa3dUbnglb.jpg"),
                    CastEntity("Koyomi","Lana Condor","https://www.themoviedb.org/t/p/w276_and_h350_face/vWn27Fk2GLwH7o9fBG9hBWZI6OR.jpg"),
                    CastEntity("Tanji","Jorge Lendeborg Jr.","https://www.themoviedb.org/t/p/w276_and_h350_face/1633mS58BuM33No4kTPsusePEJa.jpg"),
                )
            )
        )
        movies.add(
            MovieEntity(
                "m3",
                "A Star Is Born",
                R.drawable.poster_a_start_is_born,
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "Bradley Cooper",
                75,
                "10/05/2018",
                "Drama, Romance",
                "R",
                "https://www.catchplay.com/id/video/2c361807-eb47-4c57-8066-a039b292abdb",
                1,
                arrayListOf(
                    CastEntity("Jackson Maine","Bradley Cooper","https://www.themoviedb.org/t/p/w276_and_h350_face/DPnessSsWqVXRbKm93PtMjB4Us.jpg"),
                    CastEntity("Ally Campana","Lady Gaga","https://www.themoviedb.org/t/p/w276_and_h350_face/unNh9e9CEEx2VYZttKuAh1XVMWW.jpg"),
                    CastEntity("Bobby Maine","Sam Elliott","https://www.themoviedb.org/t/p/w276_and_h350_face/1K2IvGXFbKsgkExuUsRvy4F0c9e.jpg"),
                    CastEntity("Lorenzo Campana","Andrew Dice Clay","https://www.themoviedb.org/t/p/w276_and_h350_face/kq6APbPUbx0Mzoh6mK7k8Xoiw5m.jpg"),
                    CastEntity("Rez Gavron","Rafi Gavron","https://www.themoviedb.org/t/p/w276_and_h350_face/avCWoO9fLwEhbT6cvu0TJcSj49g.jpg"),
                    CastEntity("Ramon","Anthony Ramos","https://www.themoviedb.org/t/p/w276_and_h350_face/ityTHqIXFT3laID4j4ptlnc84zq.jpg"),
                    CastEntity("George \"Noodles Stone\" ","Dave Chappelle","https://www.themoviedb.org/t/p/w276_and_h350_face/hDVe67wjmjtbOTzDrFaJfcobcE.jpg"),
                    CastEntity("Himself","Marlon Williams","https://www.themoviedb.org/t/p/w276_and_h350_face/4EuZVy5jYm1YCFuNRngqeZVHLdD.jpg"),
                    CastEntity("Herself","Brandi Carlile","https://www.themoviedb.org/t/p/w276_and_h350_face/4FlGvdzs6isbMerhq6aSj49W3FP.jpg")
                )
            )
        )
        movies.add(
            MovieEntity(
                "m4",
                "Bohemian Rhapsody",
                R.drawable.poster_bohemian,
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "Bryan Singer",
                80,
                "10/30/2018",
                "Action, Science Fiction, Adventure",
                "PG-13",
                "https://www.netflix.com/id-en/title/80994899",
                1,
                arrayListOf(
                    CastEntity("Freddie Mercury","Rami Malek",""),
                    CastEntity("Brian May","Gwilym Lee",""),
                    CastEntity("Roger Taylor","Ben Hardy",""),
                    CastEntity("John Deacon","Joseph Mazzello",""),
                    CastEntity("Mary Austin","Lucy Boynton",""),
                    CastEntity("John Reid","Aidan Gillen",""),
                    CastEntity("Paul Prenter","Allen Leech",""),
                    CastEntity("Jim Beach","Tom Hollander",""),
                    CastEntity("Ray Foster","Mike Myers","")
                )
            )
        )
        movies.add(
            MovieEntity(
                "m5",
                "Cold Pursuit",
                R.drawable.poster_cold_persuit,
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "Hans Petter Moland",
                57,
                "02/08/2019 ",
                "Action, Crime, Thriller",
                "R",
                "https://www.netflix.com/id-en/title/81079733",
                1,
                arrayListOf(
                    CastEntity("Nels Coxman","Liam Neeson","https://www.themoviedb.org/t/p/w276_and_h350_face/bboldwqSC6tdw2iL6631c98l2Mn.jpg"),
                    CastEntity("Grace Coxman","Laura Dern","https://www.themoviedb.org/t/p/w276_and_h350_face/2Ryt0SsExqWrLTzBu6sZcbLwoDJ.jpg"),
                    CastEntity("Kim Dash","Emmy Rossum","https://www.themoviedb.org/t/p/w276_and_h350_face/aJ8bzA1WJOBFx0Ppdo1fLMiNxLh.jpg"),
                    CastEntity("Steve 'Speedo' Milliner","Michael Eklund","https://www.themoviedb.org/t/p/w276_and_h350_face/la3J6E12pbZHe0sE73EipKkzQOp.jpg"),
                    CastEntity("Kyle Coxman","Micheál Richardson","https://www.themoviedb.org/t/p/w276_and_h350_face/z9uCzTIAy9pi3r3X2fDGiYuLCXK.jpg"),
                    CastEntity("Jacob 'Limbo' Rutman","Bradley Stryker","https://www.themoviedb.org/t/p/w276_and_h350_face/3h0F6HRz4He5ESx9mIIIGV90MF2.jpg"),
                    CastEntity("Trevor 'Viking' Calcote","Tom Bateman","https://www.themoviedb.org/t/p/w276_and_h350_face/xD8dL5f5DyxchvGFi9ScKDnf45e.jpg"),
                    CastEntity("Mustang","Domenick Lombardozzi","https://www.themoviedb.org/t/p/w276_and_h350_face/IKNcS1KQqICetjCZSZ8IYqGl7h.jpg"),
                    CastEntity("Dante Ferstel","Wesley MacInnes","https://www.themoviedb.org/t/p/w276_and_h350_face/qpRTthbWkHa5aQTq0Zjbp1uiWvD.jpg")
                )
            )
        )

        movies.add(
            MovieEntity(
                "tv1",
                "Arrow",
                R.drawable.poster_arrow,
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "Greg Berlanti, Marc Guggenheim,Andrew Kreisberg",
                67,
                "10/10/2012",
                "Crime, Drama, Mystery, Action & Adventure",
                "TV-14",
                "https://www.netflix.com/id-en/title/70242081",
                2,
                arrayListOf(
                    CastEntity("Oliver Queen / Green Arrow","Stephen Amell","https://www.themoviedb.org/t/p/w276_and_h350_face/gN8cpnUaPIzWhVufahmzV0dwOgp.jpg"),
                    CastEntity("John Diggle / Spartan","David Ramsey","https://www.themoviedb.org/t/p/w276_and_h350_face/sGyVpnbCrNOocgq57R33YdlevVa.jpg"),
                    CastEntity("Felicity Smoak","Emily Bett Rickards","https://www.themoviedb.org/t/p/w276_and_h350_face/3d9BB4P1hnnTXXxL8v1USCU0Eop.jpg"),
                    CastEntity("Quentin Lance","Paul Blackthorne","https://www.themoviedb.org/t/p/w276_and_h350_face/3OC1M0rKJO8B3JpwAeavk5EAscl.jpg"),
                    CastEntity("Thea Queen, Thea Queen / Speedy","Willa Holland","https://www.themoviedb.org/t/p/w276_and_h350_face/1GS8AZcIYHoShxaClaHBIelCMBd.jpg"),
                    CastEntity("Laurel Lance / Black Canary, Laurel Lance / Black Siren, Black Siren, Laurel Lance","Katie Cassidy","ttps://www.themoviedb.org/t/p/w276_and_h350_face/v7cs7RFcfoiL8W1YRkZK5lBc57H.jpg"),
                    CastEntity("Rene Ramirez, Rene Ramirez / Wild Dog","Rick Gonzalez","https://www.themoviedb.org/t/p/w276_and_h350_face/pVHDPq1a2oCZktgI3VumMRzGBd3.jpg"),
                    CastEntity("Malcolm Merlyn","John Barrowman","https://www.themoviedb.org/t/p/w276_and_h350_face/kDx4ynZwEUtBgomulnCEO9mLobU.jpg"),
                    CastEntity("Tina Boland / Dinah Drake, Dinah Drake / Black Canary, Dinah Drake, Tina Boland","Juliana Harkavy","https://www.themoviedb.org/t/p/w276_and_h350_face/mO8gTYhjrVO2N2dtjwWt1PEYjoo.jpg")
                )
            )
        )
        movies.add(
            MovieEntity(
                "tv2",
                "Doom Patrol",
                R.drawable.poster_doom_patrol,
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find",
                "Jeremy Carver",
                77,
                "02/15/2019",
                "Sci-Fi & Fantasy, Drama",
                "TV-MA",
                "https://hbogoasia.id/series/sr536",
                2,
                arrayListOf(
                    CastEntity("Crazy Jane","Diane Guerrero","https://www.themoviedb.org/t/p/w276_and_h350_face/5LXvRYdxKLWROAD2KDSXzRNNSdE.jpg"),
                    CastEntity("Rita Farr / Elasti-Woman","April Bowlby","https://www.themoviedb.org/t/p/w276_and_h350_face/c5Yk2tqApmbmKXHoPbYQauXssED.jpg"),
                    CastEntity("Victor Stone / Cyborg","Joivan Wade","https://www.themoviedb.org/t/p/w276_and_h350_face/7tPro9hPR54m3zbLIfypsDDUDCI.jpg"),
                    CastEntity("Cliff Steele / Robotman","Riley Shanahan","https://www.themoviedb.org/t/p/w276_and_h350_face/rrCGuR7aXGFbO6NcdSFHQIHrc0A.jpg"),
                    CastEntity("Larry Trainor / Negative Man","Matthew Zuk","https://www.themoviedb.org/t/p/w276_and_h350_face/jifQz74EU8qsigSgNZR2u2SDhek.jpg"),
                    CastEntity("Larry Trainor / Negative Man (voice)","Matt Bomer","https://www.themoviedb.org/t/p/w276_and_h350_face/jvYzsP08M9H76eHu0k1ALdmNnoM.jpg"),
                    CastEntity("Cliff Steele / Robotman (voice)","Brendan Fraser","https://www.themoviedb.org/t/p/w276_and_h350_face/tFj5PaWWQbb8rHBBhu1EHklznph.jpg"),
                    CastEntity("Dr. Niles Caulder / The Chief","Timothy Dalton","https://www.themoviedb.org/t/p/w276_and_h350_face/lpmsHv6YrOlODjNdSgr5DEBH2gJ.jpg"),
                    CastEntity("Kay Challis","Skye Roberts","https://www.themoviedb.org/t/p/w276_and_h350_face/7sSiLdxA4berqw9n8RxthlqAGwA.jpg")
                )
            )
        )

        return movies
    }
}