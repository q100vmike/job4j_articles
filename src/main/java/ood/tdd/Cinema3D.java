package ood.tdd;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class Cinema3D implements Cinema {

    @Override
    public List<Session> find(Predicate<Session> filter) {
        return List.of(new Session3D());
    }

    @Override
    public Ticket buy(Account account, int row, int column, Calendar date) {
        return new Ticket3D();
    }

    @Override
    public void add(Session session) {

    }

    @Override
    public void addMovie(Movie movie) {

    }

    @Override
    public List<Movie> getAllMovies() {
        return List.of(new Movie3D());
    }
}
