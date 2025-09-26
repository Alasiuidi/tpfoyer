package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Foyer;

import java.util.List;

public interface IFoyerService {
    List<Foyer> retrieveAllFoyers();
    Foyer retrieveFoyer(Long foyerId);
    Foyer addFoyer(Foyer foyer);
    void removeFoyer(Long foyerId);
    Foyer modifyFoyer(Foyer foyer);
    public Bloc desaffecterBlocDeFoyer(Long idBloc);
    public Foyer addFoyerWithBloc(Foyer foyer);
    public Bloc affecterBlocAFoyer(Long idBloc, Long idFoyer);
}
