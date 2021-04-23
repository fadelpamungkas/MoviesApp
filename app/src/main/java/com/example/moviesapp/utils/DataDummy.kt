package com.example.moviesapp.utils

import com.example.moviesapp.R
import com.example.moviesapp.model.Movie
import java.util.ArrayList

object DataDummy {
    fun generateDummyMovies(): List<Movie> {

        val movies = ArrayList<Movie>()

        movies.add(
            Movie(1,
                R.drawable.poster_a_star,
            "A Star Is born",
            "75%",
            "October 5, 2018",
            "2h 15min",
            "Drama, Music, Romance",
            "Seasoned musician Jackson Maine discovers and falls in love with struggling artist Ally. She has just about given up on her dream to make it big as a singer until Jack coaxes her into the spotlight. But even as Ally career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons")
        )
        movies.add(
            Movie(2,
                R.drawable.poster_aquaman,
            "Aquaman",
            "68%",
            "December 21, 2018",
            "2h 23min",
            "Action, Adventure, Fantasy",
            "Once home to the most advanced civilization on Earth, the city of Atlantis is now an underwater kingdom ruled by the power hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Aquaman, Orm half human, half Atlantean brother and true heir to the throne. With help from royal counselor Vulko, Aquaman must retrieve the legendary Trident of Atlan and embrace his destiny as protector of the deep")
        )
        movies.add(
            Movie(3,
                R.drawable.poster_avengerinfinity,
            "Avenger Infinity",
            "83%",
            "October 30, 2018",
            "2h 29min",
            "Action, Adventure, Fantasy",
            "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment the fate of Earth and existence itself has never been more uncertain")
        )
        movies.add(
            Movie(4,
                R.drawable.poster_bohemian,
            "Bohemian Rhapsody",
            "81%",
            "December 21, 2018",
            "2h 15min",
            "Drama, Music",
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock n roll band Queen in 1970. Hit songs become instant classics. When Mercury increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet finding a way to keep the band together amid the success and excess")
        )
        movies.add(
            Movie(5,
                R.drawable.poster_bumblebee,
            "Bumblebee",
            "64%",
            "December 21, 2018",
            "1h 54min",
            "Action, Adventure, Science Fiction",
            "On the run in the year 1987, Bumblebee finds refuge in a junkyard in a small Californian beach town. Charlie, on the cusp of turning 18 and trying to find her place in the world, discovers Bumblebee, battle scarred and broken. When Charlie revives him, she quickly learns this is no ordinary yellow VW bug")
        )
        movies.add(
            Movie(6,
                R.drawable.poster_deadpool,
            "Deadpool",
            "71%",
            "December 11, 2018",
            "1h 57min",
            "Action, Comedy",
            "A kidnapped Fred Savage is forced to endure Deadpools PG 13 rendition of Deadpool 2 as a Princess Bride esque story thats full of magic, wonder and zero F")
        )
        movies.add(
            Movie(7,
                R.drawable.poster_dragon,
            "How To Train Your Dragon",
            "79%",
            "February 22, 2019",
            "1h 44min",
            "Adventure, Animation, Family",
            "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind")
        )
        movies.add(
            Movie(8,
                R.drawable.poster_mortalengine,
            "Mortal Engine",
            "59%",
            "December 14, 2018",
            "2h 9min",
            "Action, Adventure, Fantasy, Science Fiction",
            "Many thousands of years in the future, Earth cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever")
        )
        movies.add(
            Movie(9,
                R.drawable.poster_preman,
            "Preman Pensiun",
            "66%",
            "January 17, 2019",
            "1h 34min",
            "Comedy, Drama",
            "We dont have an overview translated in English. Help us expand our database by adding one")
        )
        movies.add(
            Movie(10,
                R.drawable.poster_venom,
            "Venom",
            "66%",
            "October 1, 2018",
            "1h 52min",
            "Action, Science Fiction",
            "Investigative journalist Eddie Brock attempts a comeback following a scandal, but accidentally becomes the host of Venom, a violent, super powerful alien symbiote. Soon, he must rely on his newfound powers to protect the world from a shadowy organization looking for a symbiote of their own")
        )

        return movies
    }

    fun generateDummyTVShow(): List<Movie> {

        val tvShow = ArrayList<Movie>()

        tvShow.add(
            Movie(
                101,
                R.drawable.invincible,
                "Invincible",
                "89%",
                "March 26, 2021",
                "45min",
                "Animation, Action & Adventure, Drama",
                "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his fathers tutelage."
            )
        )
        tvShow.add(
            Movie(
                103,
                R.drawable.gameofthrones,
                "Game Of Thrones",
                "84%",
                "April 17, 2011",
                "1h",
                "Sci-Fi, Fantasy, Drama, Action & Adventure",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to fullscale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night Watch, is all that stands between the realms of men and icy horrors beyond."
            )
        )
        tvShow.add(
            Movie(
                104,
                R.drawable.lucifer,
                "Lucifer",
                "85%",
                "Jan 25, 2016",
                "45min",
                "Crime, Sci-Fi, Fantasy",
                "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he is away from the underworld, the greater the threat that the worst of humanity could escape."
            )
        )
        tvShow.add(
            Movie(
                105,
                R.drawable.thewalkingdead,
                "The Walking Dead",
                "81%",
                "October 31, 2010",
                "42min",
                "Action, Adventure, Drama, Sci-Fi, Fantasy",
                "Sheriffs deputy Rick Grimes awakens from a coma to find a post apocalyptic world dominated by flesh eating zombies. He sets out to find his family and encounters many other survivors along the way."
            )
        )
        tvShow.add(
            Movie(
                106,
                R.drawable.wandavision,
                "Wanda Vision",
                "84%",
                "January 15, 2021",
                "36min",
                "Sci-Fi, Fantasy, Mystery, Drama",
                "Wanda Maximoff and Vision two superpowered beings living idealized suburban lives begin to suspect that everything is not as it seems."
            )
        )
        tvShow.add(
            Movie(
                107,
                R.drawable.theflash,
                "The Flash",
                "77%",
                "October 07, 2014",
                "44min",
                "Drama, Sci-Fi, Fantasy",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only meta-human who was created in the wake of the accelerator explosion and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it wont be long before the world learns what Barry Allen has become...The Flash."
            )
        )
        tvShow.add(
            Movie(
                108,
                R.drawable.vikings,
                "Vikings",
                "80%",
                "March 03, 2013",
                "44min",
                "Action, Adventure, Drama",
                "The adventures of Ragnar Lothbrok, the greatest hero of his age. The series tells the sagas of Ragnars band of Viking brothers and his family, as he rises to become King of the Viking tribes. As well as being a fearless warrior, Ragnar embodies the Norse traditions of devotion to the gods. Legend has it that he was a direct descendant of Odin, the god of war and warriors."
            )
        )
        tvShow.add(
            Movie(
                109,
                R.drawable.snowfall,
                "Snowfall",
                "81%",
                "July 05, 2017",
                "42min",
                "Crime, Drama",
                "Los Angeles. 1983. A storm is coming and its name is crack. Set against the infancy of the crack cocaine epidemic and its ultimate radical impact on the culture as we know it, the story follows numerous characters on a violent collision course."
            )
        )
        tvShow.add(
            Movie(
                102,
                R.drawable.mortalkombat,
                "Mortal Kombat",
                "74%",
                "April 7, 2021",
                "1h 50min",
                "Fantasy, Action, Adventure",
                "Washed up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung best warrior, Sub-Zero, seeks out and trains with Earths greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe."
            )
        )
        tvShow.add(
            Movie(
                110,
                R.drawable.riverdale,
                "Riverdale",
                "86%",
                "January 26, 2017",
                "45min",
                "Mystery, Drama, Crime",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small town life, the darkness and weirdness bubbling beneath Riverdales wholesome facade."
            )
        )

        return tvShow
    }
}