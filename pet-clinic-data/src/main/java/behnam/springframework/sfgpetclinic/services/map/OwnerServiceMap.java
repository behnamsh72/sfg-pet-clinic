package behnam.springframework.sfgpetclinic.services.map;

import behnam.springframework.sfgpetclinic.model.Owner;
import behnam.springframework.sfgpetclinic.model.Pet;
import behnam.springframework.sfgpetclinic.services.CrudService;
import behnam.springframework.sfgpetclinic.services.OwnerService;
import behnam.springframework.sfgpetclinic.services.PetService;
import behnam.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.function.Consumer;

@Service
@Profile({"default","map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(new Consumer<Pet>() {
                    @Override
                    public void accept(Pet pet) {
                        if (pet.getPetType() != null) {
                            if (pet.getPetType().getId() == null) {
                                pet.setPetType(petTypeService.save(pet.getPetType()));
                            }
                        } else {
                            throw new RuntimeException("Pet Type is Required");
                        }
                        if (pet.getId() == null) {
                            Pet savedPet = petService.save(pet);
                            pet.setId(savedPet.getId());
                        }
                    }
                });
            }
            return super.save(object.getId(), object);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findById(Long id) {
        return this.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
