package behnam.springframework.sfgpetclinic.services.map;

import behnam.springframework.sfgpetclinic.model.PetType;
import behnam.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.findById(id);
    }

    @Override
    public void delete(PetType object) {
        super.delete(object);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object.getId(), object);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
