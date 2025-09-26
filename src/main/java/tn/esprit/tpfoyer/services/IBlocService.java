package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Chambre;

import java.util.List;

public interface IBlocService {
    public List<Bloc> retrieveAllBlocs();
    public Bloc retrieveBloc(Long blocId);
    public void removeBloc(Long blocId);
    public Bloc modifyBloc(Bloc bloc);

    public Bloc addBloc(Bloc b);
}
