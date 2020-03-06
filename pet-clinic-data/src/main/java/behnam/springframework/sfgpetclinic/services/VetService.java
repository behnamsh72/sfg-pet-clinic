package behnam.springframework.sfgpetclinic.services;

import behnam.springframework.sfgpetclinic.model.Owner;
import behnam.springframework.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
