package co.edu.udea.basededatos.service;

import co.edu.udea.basededatos.entity.Ciudad;
import co.edu.udea.basededatos.exception.BusinessException;
import co.edu.udea.basededatos.repository.CiudadRepository;
import co.edu.udea.basededatos.util.Messages;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class CiudadService {

    private final CiudadRepository ciudadRepository;
    private final Messages messages;

    public CiudadService(CiudadRepository ciudadRepository, Messages messages){
        this.ciudadRepository=ciudadRepository;
        this.messages=messages;
    }

    public Ciudad guardarCiudad(Ciudad ciudad){
        Optional<Ciudad> ciudadConsulta=ciudadRepository.findByNombre(ciudad.getNombre());
        if(ciudadConsulta.isPresent()){
            throw new BusinessException(messages.get("ciudad.nombre.duplicado"));
        }
        return ciudadRepository.save(ciudad);
    }

    public Ciudad actualizarCiudad(Ciudad ciudad){
        if(Objects.isNull(ciudad.getId())){
            throw new BusinessException(messages.get("ciudad.id.vacio"));
        }
        consultarPorId(ciudad.getId());
        return ciudadRepository.save(ciudad);
    }

    public Ciudad consultarPorId(Long id){
        return ciudadRepository.findById(id).orElseThrow(
                () -> new BusinessException(messages.get("ciudad.id.no_encontrada")));
    }

    public void eliminarCiudad(Long id){
        consultarPorId(id);
        ciudadRepository.deleteById(id);
    }
}
