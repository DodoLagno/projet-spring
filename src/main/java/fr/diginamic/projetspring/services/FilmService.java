package fr.diginamic.projetspring.services;

import fr.diginamic.projetspring.entities.Film;
import fr.diginamic.projetspring.entities.Genre;
import fr.diginamic.projetspring.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Service gérant les opérations liées à l'entité Film.
 */
@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    public List<Film> getFilmsByGenre(String genreName) {
        return filmRepository.findByGenres_Name(genreName);
    }
    /**
     * Récupère tous les films.
     *
     * @return Une liste de tous les films.
     */
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    /**
     * Récupère un film par son identifiant.
     *
     * @param filmId L'identifiant du film.
     * @return Le film correspondant à l'identifiant, ou un Optional vide s'il n'existe pas.
     */
    public Film getFilmById(Integer filmId) {
        return filmRepository.findById(filmId).orElse(null);
    }

    /**
     * Crée un nouveau film.
     *
     * @param film Le film à créer.
     * @return Le film créé.
     */
    public Film createFilm(Film film) {
        return filmRepository.save(film);
    }

    /**
     * Met à jour un film existant.
     *
     * @param filmId L'identifiant du film à mettre à jour.
     * @param film   Les nouvelles données du film.
     * @return Le film mis à jour, ou un Optional vide si le film avec l'ID spécifié n'existe pas.
     */
    public Film updateFilm(Integer filmId, Film film) {
        if (filmRepository.existsById(filmId)) {
            film.setFilmId(filmId);
            return filmRepository.save(film);
        }
        return null;
    }

        /**
         * Supprime un film par son identifiant.
         *
         * @param filmId L'identifiant du film à supprimer.
         */
        public void deleteFilm(Integer filmId) {
            filmRepository.deleteById(filmId);
        }

        // Ajoutez d'autres méthodes en fonction des besoins

        public List<Film> findByAnneeSortie (Integer anneeSortie){
            return filmRepository.findAllByAnneeSortie(anneeSortie);
        }

        public List<Film> findByLangue (String langue){
            return filmRepository.findAllByLangue(langue);
        }

        public List<Film> findByLieuTournage (String lieuTournage){
            return filmRepository.findAllByLieuTournage(lieuTournage);
        }

        public List<Film> findByNom (String nom){
            return filmRepository.findAllByNom(nom);
        }

        public List<Film> findByPays (String pays){
            return filmRepository.findAllByPays(pays);
        }

        public List<Film> findByRating (String rating){
            return filmRepository.findAllByRating(rating);
        }

        public List<Film> findByResume (String resume){
            return filmRepository.findAllByResume(resume);
        }

        public List<Film> findByUrlProfile (String urlProfile){
            return filmRepository.findAllByUrlProfile(urlProfile);
        }

   



        /*public List<Film> findByRealisateurId (Integer realisateurId){
            return filmRepository.findAllByRealisateurId(realisateurId);
        }*/

    public Film findByIdIMDB(String idIMDB){
        return filmRepository.findByIdIMDB(idIMDB);
    }

    public List<Film> getFilmsByGenreNames(Set<String> genreNames) {
        Set<Genre> genres = genreNames.stream().map(Genre::new).collect(Collectors.toSet());
        return filmRepository.findAllByGenresIn(genres);
    }
}

