package bajp.playground.moviecatalogueapp.utils

import bajp.playground.moviecatalogueapp.R
import bajp.playground.moviecatalogueapp.data.CastEntity
import bajp.playground.moviecatalogueapp.data.MovieEntity

object DummyData {
    fun generateMovies(type:Int = 0):List<MovieEntity>{
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
                "https://play.google.com/store/movies/details/Aquaman?gl=ID&hl=en&id=e8bX5nLVkUo.P",
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
                "https://play.google.com/store/movies/details/Bohemian_Rhapsody?id=_VSkGHr5imQ&hl=en&gl=ID",
                1,
                arrayListOf(
                    CastEntity("Freddie Mercury","Rami Malek","https://www.themoviedb.org/t/p/w138_and_h175_face/2OuFzCbMibXGouG79tG1U4BLPbe.jpg"),
                    CastEntity("Brian May","Gwilym Lee","https://www.themoviedb.org/t/p/w138_and_h175_face/bHSmjJLJyrg5Q0tC0W2FFreuOnO.jpg"),
                    CastEntity("Roger Taylor","Ben Hardy","https://www.themoviedb.org/t/p/w138_and_h175_face/s8UEIomgY5AaEmPHkcPAScp68Fw.jpg"),
                    CastEntity("John Deacon","Joseph Mazzello","https://www.themoviedb.org/t/p/w138_and_h175_face/44gsv7TlXOOKDGg5aRtqxZjM9ae.jpg"),
                    CastEntity("Mary Austin","Lucy Boynton","https://www.themoviedb.org/t/p/w138_and_h175_face/9BSm1WVa6t0aj1cIHuVudkGVVy2.jpg"),
                    CastEntity("John Reid","Aidan Gillen","https://www.themoviedb.org/t/p/w138_and_h175_face/ju5ho6nnwOQ2QLGLnDP9yOZhGpb.jpg"),
                    CastEntity("Paul Prenter","Allen Leech","https://www.themoviedb.org/t/p/w138_and_h175_face/cJZSyKNUKwdNPEgkt2ocXohtUBH.jpg"),
                    CastEntity("Jim Beach","Tom Hollander","https://www.themoviedb.org/t/p/w138_and_h175_face/lGkENAqtbv5S1Fg7ax7qMFcjfhJ.jpg"),
                    CastEntity("Ray Foster","Mike Myers","https://www.themoviedb.org/t/p/w138_and_h175_face/gjfDl52Kk02MPgUYFjs9bOy33OY.jpg")
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
                "https://play.google.com/store/movies/details/Cold_Pursuit?id=5FD0F30A7895CF21MV&hl=en&gl=ID",
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
                "m6",
                "Creed II",
                R.drawable.poster_creed,
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "Steven Caple Jr",
                69,
                "11/21/2018",
                "Drama",
                "PG-13",
                "https://play.google.com/store/movies/details/Creed_2?id=CA82A0AEB0A76100MV&hl=en&gl=ID",
                1,
                arrayListOf(
                    CastEntity("Adonis Creed","Michael B. Jordan","https://www.themoviedb.org/t/p/w138_and_h175_face/hz9AOUWZ2zzS0dpPJ1yQv2grA35.jpg"),
                    CastEntity("Robert \"Rocky\" Balboa Sr.","Sylvester Stallone","https://www.themoviedb.org/t/p/w138_and_h175_face/qDRGPAcQoW8Wuig9bvoLpHwf1gU.jpg"),
                    CastEntity("Ivan Drago","Dolph Lundgren","https://www.themoviedb.org/t/p/w138_and_h175_face/jDLOU3Ay59NxLH8QDm5hcVTaKuC.jpg"),
                    CastEntity("Viktor Drago","Florian Munteanu","https://www.themoviedb.org/t/p/w138_and_h175_face/lE26A169mjuwW5x0zx2wW9Q9o2w.jpg"),
                    CastEntity("Bianca Taylor","Tessa Thompson","https://www.themoviedb.org/t/p/w138_and_h175_face/cJ64yI9OiQN8Edp4FgAHiLuoWiQ.jpg"),
                    CastEntity("Tony \"Little Duke\" Evers","Wood Harris","https://www.themoviedb.org/t/p/w138_and_h175_face/9gvwUEu1fZTSTkykaCx2fSdSDWK.jpg"),
                    CastEntity("Mary Anne Creed","Phylicia Rashād","https://www.themoviedb.org/t/p/w138_and_h175_face/orbTpG0jaYkPR167TNiEg0AKG3M.jpg"),
                    CastEntity("Danny \"Stuntman\" Wheeler","Andre Ward","https://www.themoviedb.org/t/p/w138_and_h175_face/plxnPnxaLiWTGmRwVUqdaVfUHkD.jpg"),
                    CastEntity("Ludmilla Drago","Brigitte Nielsen","https://www.themoviedb.org/t/p/w138_and_h175_face/lkP0qKkDOvVk0ETZX0bx3Qmufkm.jpg")
                )
            )
        )
        movies.add(
            MovieEntity(
                "m7",
                "Fantastic Beasts: The Crimes of Grindelwald",
                R.drawable.poster_crimes,
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "David Yates",
                69,
                "11/16/2018",
                "Adventure, Fantasy, Drama",
                "PG-13",
                "https://play.google.com/store/movies/details/Fantastic_Beasts_The_Crimes_Of_Grindelwald?gl=ID&hl=en&id=V7ow0KMvQyQ.P",
                1,
                arrayListOf(
                    CastEntity("Newt Scamander","Eddie Redmayne","https://www.themoviedb.org/t/p/w138_and_h175_face/fSvG7qzoBBnJUmgtIuMgrK3EQPN.jpg"),
                    CastEntity("Porpentina 'Tina' Katherine Waterston","Katherine Waterston","https://www.themoviedb.org/t/p/w138_and_h175_face/5xndFxJuB2QYmtoYwl1MFtFHM24.jpg"),
                    CastEntity("Jacob Kowalski","Dan Fogler","https://www.themoviedb.org/t/p/w138_and_h175_face/zJWbLEjfbDthBMucq9M6L4GJXL3.jpg"),
                    CastEntity("Queenie Goldstein","Alison Sudol","https://www.themoviedb.org/t/p/w138_and_h175_face/49DhpCxZkqpC6PZxQYWNDCZqUY0.jpg"),
                    CastEntity("Gellert Grindelwald","Johnny Depp","https://www.themoviedb.org/t/p/w138_and_h175_face/ilPBHd3r3ahlipNQtjr4E3G04jJ.jpg"),
                    CastEntity("Albus Dumbledore","Jude Law","https://www.themoviedb.org/t/p/w138_and_h175_face/A6Y0m7qEe04ZTHKyYDLbnyCHNzn.jpg"),
                    CastEntity("Credence Barebone","Ezra Miller","https://www.themoviedb.org/t/p/w138_and_h175_face/6wmTpbYpmhthaxzM5ss3377F9IV.jpg"),
                    CastEntity("Leta Lestrange","Zoë Kravitz","https://www.themoviedb.org/t/p/w138_and_h175_face/zx74kkI931iiQATJybvRKWYnOe9.jpg"),
                    CastEntity("Theseus Scamander","Callum Turner","https://www.themoviedb.org/t/p/w138_and_h175_face/hV8YXEJF2RkpOJIano3Dwn5V3dH.jpg")
                )
            )
        )
        movies.add(
            MovieEntity(
                "m8",
                "Glass",
                R.drawable.poster_glass,
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men",
                "M. Night Shyamalan",
                67,
                "01/18/2019",
                "Thriller, Drama, Science Fiction",
                "PG-13",
                "https://www.hotstar.com/id/movies/glass/1260014718",
                1,
                arrayListOf(
                    CastEntity("Patricia / Dennis / Hedwig / The Beast / Barry / Heinrich / Jade / Ian / Mary Reynolds / Norma / Jalin / Kat / B.T. / Kevin Wendell Crumb / Mr. Pritchard / Felida / Luke / Goddard / Samuel / Polly","James McAvoy","https://www.themoviedb.org/t/p/w138_and_h175_face/u4REKbm3zhFI2J5tVyqRovGRYUJ.jpg"),
                    CastEntity("David Dunn / The Overseer","Bruce Willis","https://www.themoviedb.org/t/p/w138_and_h175_face/caX3KtMU42EP3VLRFFBwqIIrch5.jpg"),
                    CastEntity("Elijah Price / Mr. Glass","Samuel L. Jackson","https://www.themoviedb.org/t/p/w138_and_h175_face/yYpPvzdEKud48En8wbtGXs4C9Kk.jpg"),
                    CastEntity("Casey Cooke","Anya Taylor-Joy","https://www.themoviedb.org/t/p/w138_and_h175_face/aSOvCmB1nsl19IqrjuuWwaguvDh.jpg"),
                    CastEntity("Dr. Ellie Staple","Sarah Paulson","https://www.themoviedb.org/t/p/w138_and_h175_face/jkhpv4oPNcMSvPPDUuCyPIFwYyS.jpg"),
                    CastEntity("Joseph Dunn","Spencer Treat Clark","https://www.themoviedb.org/t/p/w138_and_h175_face/bvq0KXSIc5PE6yHnpEDM8PR44Fe.jpg"),
                    CastEntity("Mrs. Price","Charlayne Woodard","https://www.themoviedb.org/t/p/w138_and_h175_face/jmKpxm7HIOYEYlqDH8eRq5FF91r.jpg"),
                    CastEntity("Pierce","Luke Kirby","https://www.themoviedb.org/t/p/w138_and_h175_face/timKh2BsMQFA6z2SuxOjsddKfOR.jpg"),
                    CastEntity("Daryl","Adam David Thompson","https://www.themoviedb.org/t/p/w138_and_h175_face/9Dr7qJ5wCzTp7KpA83lsO9YyBPh.jpg")
                )
            )
        )
        movies.add(
            MovieEntity(
                "m9",
                "Ralph Breaks the Internet",
                R.drawable.poster_ralph,
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
                "Phil Johnston",
                72,
                "11/21/2018",
                "Family, Animation, Comedy, Adventure",
                "PG",
                "https://www.hotstar.com/id/movies/wreckit-ralph-ralph-breaks-the-internet/1260014725",
                1,
                arrayListOf(
                    CastEntity("Wreck-It Ralph (voice)","John C. Reilly","https://www.themoviedb.org/t/p/w138_and_h175_face/nr8YDB5keLnmJcQr0HgzurcTJkQ.jpg"),
                    CastEntity("Vanellope von Schweetz (voice)","Sarah Silverman","https://www.themoviedb.org/t/p/w138_and_h175_face/xOffYDEzUa5objHrEXhRzabYhN0.jpg"),
                    CastEntity("Shank (voice)","Gal Gadot","https://www.themoviedb.org/t/p/w138_and_h175_face/fysvehTvU6bE3JgxaOTRfvQJzJ4.jpg"),
                    CastEntity("Yesss (voice)","Taraji P. Henson","https://www.themoviedb.org/t/p/w138_and_h175_face/rxnEvzGlRBsE94s7lC4cMAiLluH.jpg"),
                    CastEntity("Felix (voice)","Jack McBrayer","https://www.themoviedb.org/t/p/w138_and_h175_face/cbr26xDPEiOuYQxggtCPbu5xhDU.jpg"),
                    CastEntity("Calhoun (voice)","Jane Lynch","https://www.themoviedb.org/t/p/w138_and_h175_face/nye6D17ZfCHQzr9faYZYyz1CPsZ.jpg"),
                    CastEntity("KnowsMore (voice)","Alan Tudyk","https://www.themoviedb.org/t/p/w138_and_h175_face/jUuUbPuMGonFT5E2pcs4alfqaCN.jpg"),
                    CastEntity("Double Dan / Little Dan (voice)","Alfred Molina","https://www.themoviedb.org/t/p/w138_and_h175_face/nJo91Czesn6z0d0pkfbDoVZY3sg.jpg"),
                    CastEntity("Mr. Litwak (voice)","Ed O'Neill","https://www.themoviedb.org/t/p/w138_and_h175_face/uNXhu2ci4R1OwcMUTK9dluYzdQl.jpg")
                )
            )
        )
        movies.add(
            MovieEntity(
                "m10",
                "Spider-Man: Into the Spider-Verse",
                R.drawable.poster_spiderman,
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "Rodney Rothman",
                84,
                "12/14/2018",
                "Action, Adventure, Animation, Science Fiction, Comedy",
                "PG",
                "https://play.google.com/store/movies/details/Spider_Man_Into_the_Spider_Verse?gl=ID&hl=en&id=Mka3hs3FpWQ",
                1,
                arrayListOf(
                    CastEntity("Miles Morales / Spider-Man (voice)","Shameik Moore","https://www.themoviedb.org/t/p/w138_and_h175_face/uJNaSTsfBOvtFWsPP23zNthknsB.jpg"),
                    CastEntity("Peter B. Parker / Spider-Man (voice)","Jake Johnson","https://www.themoviedb.org/t/p/w138_and_h175_face/nUfiDAafxbxIqmjbZf0oEcmh3kn.jpg"),
                    CastEntity("Gwen Stacy / Spider-Woman (voice)","Hailee Steinfeld","https://www.themoviedb.org/t/p/w138_and_h175_face/dxSDWkiVaC6JYjrV3XRAZI7HOSS.jpg"),
                    CastEntity("Uncle Aaron / Prowler (voice)","Mahershala Ali","https://www.themoviedb.org/t/p/w138_and_h175_face/y9mf12rlZBlVJS6JYuCPpjTaLT6.jpg"),
                    CastEntity("Jefferson Davis (voice)","Brian Tyree Henry","https://www.themoviedb.org/t/p/w138_and_h175_face/8JtMLXctGCG9axXTaQXtQktiHMN.jpg"),
                    CastEntity("Aunt May (voice)","Lily Tomlin","https://www.themoviedb.org/t/p/w138_and_h175_face/zp2DDnaUenDDeoRJjrSCSDtYtxH.jpg"),
                    CastEntity("Rio Morales (voice)","Lauren Vélez","https://www.themoviedb.org/t/p/w138_and_h175_face/98BvmTJCZHx0jPv0oNcv04Jkmfb.jpg"),
                    CastEntity("Mary Jane (voice)","Zoë Kravitz","https://www.themoviedb.org/t/p/w138_and_h175_face/zx74kkI931iiQATJybvRKWYnOe9.jpg"),
                    CastEntity("Peter Porker / Spider-Ham (voice)","John Mulaney","https://www.themoviedb.org/t/p/w138_and_h175_face/dCvVHa6dI0zcavzzcaN2qNCYcoI.jpg")
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
                "https://www.primevideo.com/detail/Arrow/0JKU3ILHFADTSV4QBRQYC0YKYE",
                2,
                arrayListOf(
                    CastEntity("Oliver Queen / Green Arrow","Stephen Amell","https://www.themoviedb.org/t/p/w276_and_h350_face/gN8cpnUaPIzWhVufahmzV0dwOgp.jpg"),
                    CastEntity("John Diggle / Spartan","David Ramsey","https://www.themoviedb.org/t/p/w276_and_h350_face/sGyVpnbCrNOocgq57R33YdlevVa.jpg"),
                    CastEntity("Felicity Smoak","Emily Bett Rickards","https://www.themoviedb.org/t/p/w276_and_h350_face/3d9BB4P1hnnTXXxL8v1USCU0Eop.jpg"),
                    CastEntity("Quentin Lance","Paul Blackthorne","https://www.themoviedb.org/t/p/w276_and_h350_face/3OC1M0rKJO8B3JpwAeavk5EAscl.jpg"),
                    CastEntity("Thea Queen, Thea Queen / Speedy","Willa Holland","https://www.themoviedb.org/t/p/w276_and_h350_face/1GS8AZcIYHoShxaClaHBIelCMBd.jpg"),
                    CastEntity("Laurel Lance / Black Canary, Laurel Lance / Black Siren, Black Siren, Laurel Lance","Katie Cassidy","https://www.themoviedb.org/t/p/w276_and_h350_face/v7cs7RFcfoiL8W1YRkZK5lBc57H.jpg"),
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
                "https://www.primevideo.com/detail/Doom-Patrol/0N0GJFS20GE2DBNFJNGMW1FYI1",
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

        movies.add(
            MovieEntity(
                "tv3",
                "Family Guy",
                R.drawable.poster_family_guy,
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "Seth MacFarlane",
                71,
                "01/31/1999",
                "Animation, Comedy",
                "TV-14",
                "https://www.hotstar.com/id/tv/family-guy/1260024995/death-has-a-shadow/1260025508",
                2,
                arrayListOf(
                    CastEntity("Peter Griffin / Brian Griffin / Stewie Griffin / Glenn Quagmire / Tom Tucker (voice)","Seth MacFarlane","https://www.themoviedb.org/t/p/w138_and_h175_face/8oQJqM51Z0Qtdb7sE6ZfX1peNCB.jpg"),
                    CastEntity("Lois Griffin / Tricia Takanawa / Loretta Brown / Barbara Pewterschmidt (voice)","Alex Borstein","https://www.themoviedb.org/t/p/w138_and_h175_face/evbCnRe5Yfuy0B41PONLTIcvbem.jpg"),
                    CastEntity("Chris Griffin (voice)","Seth Green","https://www.themoviedb.org/t/p/w138_and_h175_face/l4No5Eu6j0U80hCIkaSn17AOWrj.jpg"),
                    CastEntity("Meg Griffin (voice","Mila Kunis","https://www.themoviedb.org/t/p/w138_and_h175_face/6Lp9qPkMO740Hcp8NBYZZLWWvJF.jpg"),
                    CastEntity("John Herbert / Consuela (voice), Cleveland Brown / Greased-up Deaf Guy (voice), John Herbert / Giant Mutant Rat (voice), Cleveland Brown (voice) ","Mike Henry","https://www.themoviedb.org/t/p/w138_and_h175_face/zCE9EAHyu2pgxDXxdK0k8PzVdaK.jpg"),
                    CastEntity("Joe (voice), Joe Swanson as Wise Man (voice), Joe Swanson as Imperial Probe Droid (voice), Joe Swanson (voice)","Patrick Warburton","https://www.themoviedb.org/t/p/w138_and_h175_face/eLqDtbFYmlTxov9vT9Dwldn839v.jpg")
                )
            )
        )
        movies.add(
            MovieEntity(
                "tv4",
                "The Flash ",
                R.drawable.poster_flash,
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "Greg Berlanti",
                74,
                "10/07/2014",
                "Drama, Sci-Fi & Fantasy",
                "TV-14",
                "https://www.netflix.com/id-en/title/80027042",
                2,
                arrayListOf(
                    CastEntity("Barry Allen / The Flash, Barry Allen / Savitar","Grant Gustin","https://www.themoviedb.org/t/p/w138_and_h175_face/kEGU1gGySIe63lyL7AnwXEw4rQn.jpg"),
                    CastEntity("Iris West-Allen","Candice Patton","https://www.themoviedb.org/t/p/w138_and_h175_face/7HUcygrInxDKrRbwCV3jpVwC75c.jpg"),
                    CastEntity("Caitlin Snow / Killer Frost / Frost","Danielle Panabaker","https://www.themoviedb.org/t/p/w138_and_h175_face/dpX6WMQjJDD93YYaC9Wd6tgucuZ.jpg"),
                    CastEntity("Joe West","Jesse L. Martin","https://www.themoviedb.org/t/p/w138_and_h175_face/enyC1P8DQThh1huqFQlVfdRuji1.jpg"),
                    CastEntity("Cisco Ramon / Vibe / Mecha-Vibe","Carlos Valdes","https://www.themoviedb.org/t/p/w138_and_h175_face/uDQWtrmSPsNsm2DL3TMMiAtVoTq.jpg"),
                    CastEntity("Harrison 'Nash' Wells / Pariah, Harrison Wells / Eobard Thawne / Reverse-Flash, Harrison 'Harry' Wells, Harrison 'Sherloque' Wells","Tom Cavanagh","https://www.themoviedb.org/t/p/w138_and_h175_face/ySArFxNLO43QJsWBUQ9I85TmnqW.jpg"),
                    CastEntity("Cecile Horton","Danielle Nicolet","https://www.themoviedb.org/t/p/w138_and_h175_face/jUcFFKOiwQzqos9X9cHmSbPbRn2.jpg")
                )
            )
        )
        movies.add(
            MovieEntity(
                "tv5",
                "NCIS",
                R.drawable.poster_ncis,
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                "Donald P. Bellisario",
                75,
                "09/23/2013",
                "Crime, Action & Adventure, Drama",
                "TV-14",
                "https://www.cbs.com/shows/ncis/",
                2,
                arrayListOf(
                    CastEntity("Leroy Jethro Gibbs","Mark Harmon","https://www.themoviedb.org/t/p/w138_and_h175_face/lMqKPig7zBoGfou7wWf88sZEGHo.jpg"),
                    CastEntity("Donald \"Ducky\" Mallard","David McCallum","https://www.themoviedb.org/t/p/w138_and_h175_face/47no2X4533Ehk2VO3BvVqUBqMUd.jpg"),
                    CastEntity("Donald \"Ducky\" Mallard","Sean Murray","https://www.themoviedb.org/t/p/w138_and_h175_face/r1kuDqWZbPR35Y2Ab7wQi72fgVk.jpg"),
                    CastEntity("Abby Sciuto","Pauley Perrette","https://www.themoviedb.org/t/p/w138_and_h175_face/scb8cQt9u6AdhEHg7RJDUtdhHkg.jpg"),
                    CastEntity("Tony DiNozzo","Michael Weatherly","https://www.themoviedb.org/t/p/w138_and_h175_face/o4UqLl3mx7SvFhr9xrpFv7VLpCS.jpg"),
                    CastEntity("Leon Vance","Rocky Carroll","https://www.themoviedb.org/t/p/w138_and_h175_face/pqjqmRChGqhDXXY7Etka3bmOatN.jpg"),
                    CastEntity("Jimmy Palmer","Brian Dietzen","https://www.themoviedb.org/t/p/w138_and_h175_face/e1hveayXLbgBi8Gu3zMs5tmxwpl.jpg"),
                    CastEntity("Ziva David","Cote de Pablo","https://www.themoviedb.org/t/p/w138_and_h175_face/py0I61VEXUyTvjHwWffClwfl9yb.jpg"),
                    CastEntity("Ellie Bishop","Emily Wickersham","https://www.themoviedb.org/t/p/w138_and_h175_face/oWxiSZFx4QO1VQZQFtLqzWKyiAK.jpg")
                )
            )
        )
        movies.add(
            MovieEntity(
                "tv6",
                "The Walking Dead",
                R.drawable.poster_the_walking_dead,
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "Frank Darabont",
                81,
                "10/31/2010",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                "TV-MA",
                "https://www.hotstar.com/id/tv/the-walking-dead/1260010420",
                2,
                arrayListOf(
                    CastEntity("Daryl Dixon","Norman Reedus","https://www.themoviedb.org/t/p/w138_and_h175_face/x0VtaRWYKPEegZJv7cxqKtB9k98.jpg"),
                    CastEntity("Carol Peletier","Melissa McBride","https://www.themoviedb.org/t/p/w138_and_h175_face/a1yjfKwaLbSpgzOfDdnNk2nxaQx.jpg"),
                    CastEntity("Maggie Greene","Lauren Cohan","https://www.themoviedb.org/t/p/w138_and_h175_face/zJ9nZ5jqQTUD55GLKbgfiKlUoBN.jpg"),
                    CastEntity("Michonne","Danai Gurira","https://www.themoviedb.org/t/p/w138_and_h175_face/z7H7QeQvr24vskGlANQhG43vozQ.jpg"),
                    CastEntity("Rick Grimes","Andrew Lincoln","https://www.themoviedb.org/t/p/w138_and_h175_face/bu1uBQM6ODGRE5TEm6l8gmyOApn.jpg"),
                    CastEntity("Carl Grimes","Chandler Riggs","https://www.themoviedb.org/t/p/w138_and_h175_face/w7LGO0SdH2w1vey52yksohI0BqQ.jpg"),
                    CastEntity("Rosita Espinosa","Christian Serratos","https://www.themoviedb.org/t/p/w138_and_h175_face/3odIVQPRdJ0aNuecrtciodBi0rL.jpg"),
                    CastEntity("Eugene Porter","Josh McDermitt","https://www.themoviedb.org/t/p/w138_and_h175_face/ueZwswzCiJ0KgLNCKnrBNQvl0aE.jpg")
                )
            )
        )
        movies.add(
            MovieEntity(
                "tv7",
                "Grey's Anatomy",
                R.drawable.poster_grey_anatomy,
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospita.",
                "Shonda Rhimes",
                82,
                "03/27/2005",
                "Drama",
                "TV-13",
                "https://www.hotstar.com/id/tv/greys-anatomy/14823/a-hard-days-night/1660010122",
                2,
                arrayListOf(
                    CastEntity("Meredith Grey","Ellen Pompeo","https://www.themoviedb.org/t/p/w138_and_h175_face/yPd4G2RcjXQPNWkKUPbWh5v1flC.jpg"),
                    CastEntity("Richard Webber","James Pickens Jr.","https://www.themoviedb.org/t/p/w138_and_h175_face/iddDcaysDQ6IVMUjJ97Bv3lTBCu.jpg"),
                    CastEntity("Miranda Bailey","Chandra Wilson","https://www.themoviedb.org/t/p/w138_and_h175_face/83Ynxlv3jV4ahkOiAEfunM7Rez2.jpg"),
                    CastEntity("Alex Karev","Justin Chambers","https://www.themoviedb.org/t/p/w138_and_h175_face/5UGtBemc4GPaCWjCwVR3YYmIlzV.jpg"),
                    CastEntity("Owen Hunt","Kevin McKidd","https://www.themoviedb.org/t/p/w138_and_h175_face/KtmEKOSehmQ35JfGjEjpqlypbP.jpg"),
                    CastEntity("Jackson Avery","Jesse Williams","https://www.themoviedb.org/t/p/w138_and_h175_face/hygNTzn3Ml92ear4ltTPYo5Pp2G.jpg"),
                    CastEntity("Derek Shepherd","Patrick Dempsey","https://www.themoviedb.org/t/p/w138_and_h175_face/oukjBHYzFzmaJ7g6aWXJbt3evFs.jpg"),
                    CastEntity("Callie Torres","Sara Ramirez","https://www.themoviedb.org/t/p/w138_and_h175_face/5hi4tZfMQe5Cw236c7eIFYi0D1F.jpg"),
                    CastEntity("Arizona Robbins","Jessica Capshaw","https://www.themoviedb.org/t/p/w138_and_h175_face/6WBZ11GL2JIUmEQq73MuuYquWiz.jpg")
                )
            )
        )
        movies.add(
            MovieEntity(
                "tv8",
                "Marvel's Iron Fist",
                R.drawable.poster_iron_fist,
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "Scott Buck",
                66,
                "03/17/207",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                "TV-MA",
                "https://www.netflix.com/id-en/title/80002612",
                2,
                arrayListOf(
                    CastEntity("Danny Rand","Finn Jones","https://www.themoviedb.org/t/p/w138_and_h175_face/rKzzQ7oc80xDYDmZykBjmXWt0VZ.jpg"),
                    CastEntity("Colleen Wing","Jessica Henwick","https://www.themoviedb.org/t/p/w138_and_h175_face/wVToQAASq6nAcAEBg5qOU9K8JkU.jpg"),
                    CastEntity("Joy Meachum","Jessica Stroup","https://www.themoviedb.org/t/p/w138_and_h175_face/sr01O3bY7fjZ3OaR9grC4gJAWeM.jpg"),
                    CastEntity("Ward Meachum","Tom Pelphrey","https://www.themoviedb.org/t/p/w138_and_h175_face/wgO6JambaLfiyUZtdMZRLx7YK0T.jpg"),
                    CastEntity("Davos","Sacha Dhawan","https://www.themoviedb.org/t/p/w138_and_h175_face/luEzDiMKYLW0rOXbLtAHG3BJsVY.jpg"),
                    CastEntity("Claire Temple","Rosario Dawson","https://www.themoviedb.org/t/p/w138_and_h175_face/8OTmgBzz6NzaOypUxUhfD1gsHZr.jpg"),
                    CastEntity("Harold Meachum","David Wenham","https://www.themoviedb.org/t/p/w138_and_h175_face/F7CWSqUE75HtrcdqIQ7UMZ9aTX.jpg"),
                    CastEntity("Mary Walker","Alice Eve","https://www.themoviedb.org/t/p/w138_and_h175_face/tJUSx0Cw7pCnRsCWbGTX2POiTKM.jpg"),
                    CastEntity("Madame Gao","Wai Ching Ho","https://www.themoviedb.org/t/p/w138_and_h175_face/sbEwwkKVcLJRi02ZCqx8JymmbTm.jpg")
                )
            )
        )
        movies.add(
            MovieEntity(
                "tv9",
                "The Simpsons",
                R.drawable.poster_the_simpson,
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "Matt Groening",
                79,
                "12/17/1989",
                "Family, Animation, Comedy",
                "TV-PG",
                "https://www.hotstar.com/id/tv/the-simpsons/1260023404/simpsons-roasting-on-an-open-fire/1260023430",
                2,
                arrayListOf(
                    CastEntity("Homer Simpson / Abe Simpson / Barney Gumble / Krusty (voice)","Dan Castellaneta","https://www.themoviedb.org/t/p/w138_and_h175_face/AmeqWhP4A46AWkM4kVphg6jOTQX.jpg"),
                    CastEntity("Marge Simpson / Patty Bouvier / Selma Bouvier (voice)","Julie Kavner","https://www.themoviedb.org/t/p/w138_and_h175_face/x3oG3OXtBfTFgqXPqxI1GKVEiaQ.jpg"),
                    CastEntity("Bart Simpson / Nelson Muntz / Ralph Wiggum (voice)","Nancy Cartwright","https://www.themoviedb.org/t/p/w138_and_h175_face/40qNhyYJhSE2Yiy4pnXSZhdufO6.jpg"),
                    CastEntity("Lisa Simpson (voice)","Yeardley Smith","https://www.themoviedb.org/t/p/w138_and_h175_face/9AjPwbb3uz4GfgOPBYsy2ILvwkB.jpg"),
                    CastEntity("Moe Szyslak / Chief Wiggum / Apu / Comic Book Guy / Carl (voice)","Hank Azaria","https://www.themoviedb.org/t/p/w138_and_h175_face/yFDw4b0jucuFWNnGcBPfpYUtn16.jpg"),
                    CastEntity("Ned Flanders / Mr. Burns / Smithers / Skinner / Lenny (voice)","Harry Shearer","https://www.themoviedb.org/t/p/w138_and_h175_face/au1mO0Mb9gni7h0rJCSokBTDnVf.jpg"),
                    CastEntity("Maya / Waitress / Baseball Player (voice), Ms. Albright / Churchgoer / Jimbo Jones (voice), Greta Wolfcastle / Mopey Mary (voice), Kumiko Nakamura (voice) / News Reporter (voice) / Dolph Starbeam (voice) / Wendell Borton (voice)","Tress MacNeille","https://www.themoviedb.org/t/p/w138_and_h175_face/mE8Fm9NKpCJTenzMNLB65imtvUS.jpg"),
                    CastEntity("Edna Krabappel / Ms. Melon (voice), Edna Krabappel (voice)","Marcia Wallace","https://www.themoviedb.org/t/p/w138_and_h175_face/bDCnZlPdUOyeQN0ewvoEjadBr9V.jpg"),
                    CastEntity("Maude Flanders (voice), Elizabeth Hoover (voice) / Luann Van Houten (voice), Helen Lovejoy / Singing Waiters (voice), Miss Hoover / Mrs. Winfield (voice)","Maggie Roswell","https://www.themoviedb.org/t/p/w138_and_h175_face/d71IVORYLBeBkqCby5ar7Rb4nb9.jpg")
                )
            )
        )
        movies.add(
            MovieEntity(
                "tv10",
                "Supergirl",
                R.drawable.poster_supergirl,
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "Greg Berlanti",
                74,
                "10/26/2015",
                "Drama, Sci-Fi & Fantasy, Action & Adventure",
                "TV-14",
                "https://maxstream.tv/tv-series/95810",
                2,
                arrayListOf(
                    CastEntity("J'onn J'onzz / Martian Manhunter, Cyborg Superman","David Harewood","https://www.themoviedb.org/t/p/w138_and_h175_face/8scO8ISd5UH6MNMr9kyb4H6aAWD.jpg"),
                    CastEntity("Kara Danvers / Supergirl / Kara Zor-El","Melissa Benoist","https://www.themoviedb.org/t/p/w138_and_h175_face/tmJsadF5ujTypPZtO54HsXTup3J.jpg"),
                    CastEntity("Alex Danvers / Sentinel","Chyler Leigh","https://www.themoviedb.org/t/p/w138_and_h175_face/yoL8HbWhnoTVugTV5qLJP8gVpIq.jpg"),
                    CastEntity("Lena Luthor","Katherine Elizabeth McGrath","https://www.themoviedb.org/t/p/w138_and_h175_face/cq9pc7qFRUKCrkXgsi5mJkb64U5.jpg"),
                    CastEntity("James 'Jimmy' Olsen / Guardian","Mehcad Brooks","https://www.themoviedb.org/t/p/w138_and_h175_face/etlE8YdFgYk6Nbe3uRQcc5uF0t2.jpg"),
                    CastEntity("Winn Schott / Computer Lad / Toyman, Winn Schott, Winn Schott / Toyman","Jeremy Jordan","https://www.themoviedb.org/t/p/w138_and_h175_face/idYjWWH7LbXFxQlqJes0DWbztpf.jpg"),
                    CastEntity("Querl 'Brainy' Dox / Brainiac-5","Jesse Rath","https://www.themoviedb.org/t/p/w138_and_h175_face/AphsaApS4dINg5y3oO9Y2qDDbeV.jpg"),
                    CastEntity("Nia Nal / Dreamer","Nicole Maines","https://www.themoviedb.org/t/p/w138_and_h175_face/4LBk3R26NpjH78hJ2W1T8h3luil.jpg"),
                    CastEntity("Mon-El","Chris Wood","https://www.themoviedb.org/t/p/w138_and_h175_face/z5A9PzvMSqOxsvSF2techq4buYb.jpg")
                )
            )
        )

        return if(type == 0){
            movies
        }else{
            movies.filter { x-> x.type == type }
        }
    }
}