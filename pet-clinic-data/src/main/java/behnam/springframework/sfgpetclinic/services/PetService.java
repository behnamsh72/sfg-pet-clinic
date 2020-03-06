package behnam.springframework.sfgpetclinic.services;

import behnam.springframework.sfgpetclinic.model.Owner;
import behnam.springframework.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
