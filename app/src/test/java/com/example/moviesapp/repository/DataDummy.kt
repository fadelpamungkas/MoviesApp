package com.example.moviesapp.repository

import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.TVShow
import java.util.ArrayList

object DataDummy {
    fun generateDummyMovies(): List<Movie> {

        val movies = ArrayList<Movie>()

        movies.add(
                Movie(332562,
                        "/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
                        "A Star Is Born",
                        7.5f,
                        "2018-10-03",
                        136,
                        "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons."
                )
        )
        movies.add(
                Movie(297802,
                        "/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
                        "Aquaman",
                        6.8f,
                        "2018-12-07",
                        143,
                        "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne."
                        )
        )

        return movies
    }

    fun generateDummyTVShow(): List<TVShow> {

        val tvShow = ArrayList<TVShow>()

        tvShow.add(
                TVShow(
                        95557,
                        "/yDWJYRAwMNKbIYT8ZB33qy84uzO.jpg",
                        "Invincible",
                        8.9f,
                        "2021-03-26",
                        8,
                        "Mark Grayson is a normal teenager except for the fact that his father is the most powerful superhero on the planet. Shortly after his seventeenth birthday, Mark begins to develop powers of his own and enters into his father’s tutelage."
                        )
        )
        tvShow.add(
                TVShow(
                        1399,
                        "/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                        "Game of Thrones",
                        8.4f,
                        "2011-04-17",
                        73,
                        "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond."
                )
        )
        
        return tvShow
    }
}