package behnam.springframework.sfgpetclinic.services.map;

import behnam.springframework.sfgpetclinic.model.Speciality;
import behnam.springframework.sfgpetclinic.model.Vet;
import behnam.springframework.sfgpetclinic.services.CrudService;
import behnam.springframework.sfgpetclinic.services.SpecialtyService;
import behnam.springframework.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.function.Consumer;
@Service
@Profile({"default","map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService{
    private final SpecialtyService specialtyService;
    @Autowired
    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(new Consumer<Speciality>() {
                @Override
                public void accept(Speciality speciality) {
                    if (speciality.getId() == null) {
                        Speciality savedSpecialty =specialtyService.save(speciality);
                        speciality.setId(savedSpecialty.getId());
                    }
                }
            });
        }
        return super.save(object.getId(), object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
