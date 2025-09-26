package tn.esprit.tpfoyer.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.repository.FoyerRepository;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.BlocRepository;


import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService {
    FoyerRepository foyerRepository;
    BlocRepository blocRepository;

    public List<Foyer> retrieveAllFoyers() {
        return foyerRepository.findAll();
    }

    public Foyer retrieveFoyer(Long foyerId) {
        return foyerRepository.findById(foyerId).orElse(null);
    }

    public Foyer addFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    public void removeFoyer(Long foyerId) {
        foyerRepository.deleteById(foyerId);
    }

    public Foyer modifyFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }
    @Override
    public Bloc desaffecterBlocDeFoyer(Long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);

        if (bloc != null) {
            bloc.setFoyer(null); // retirer le bloc de foyer
            return blocRepository.save(bloc); // On sauvegarde
        }

        return null;
    }

    @Override
    public Foyer addFoyerWithBloc(Foyer foyer) {
        if (foyer.getBlocs() != null) {
            for (Bloc bloc : foyer.getBlocs()) {
                bloc.setFoyer(foyer);
            }
        }
        return foyerRepository.save(foyer);
    }

    @Override
    public Bloc affecterBlocAFoyer(Long idBloc, Long idFoyer) {
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);
        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);

        if (bloc != null && foyer != null) {
            bloc.setFoyer(foyer); // affectation
            return blocRepository.save(bloc); // on sauvegarde le bloc mis à jour
        }

        return null;
    }



}
