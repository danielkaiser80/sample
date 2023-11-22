package com.efass.bank;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class EfassBankMapService {
    private final EfassBankMapRepository efassBankMapRepository;
    public EfassBankDto add(EfassBankDto efassBankDto) {
        EfassBankMap efassBankMap = mapDtoToEntity(efassBankDto);
        efassBankMap = efassBankMapRepository.save(efassBankMap);
        return mapEntityToDto(efassBankMap);
    }

    private EfassBankDto mapEntityToDto(EfassBankMap efassBankMap) {
        return EfassBankDto.builder()
                .id(efassBankMap.getId())
                .accountNumber(efassBankMap.getAccount_number())
                .glCode(efassBankMap.getGl_code())
                .institutionCode(efassBankMap.getInstitution_code())
                .institutionName(efassBankMap.getInstitution_name())
                .build();
    }

    private EfassBankMap mapDtoToEntity(EfassBankDto efassBankDto) {
        return EfassBankMap.builder()
                .id(efassBankDto.getId())
                .account_number(efassBankDto.getAccountNumber())
                .gl_code(efassBankDto.getGlCode())
                .institution_name(efassBankDto.getInstitutionName())
                .institution_code(efassBankDto.getInstitutionCode())
                .build();
    }

    public void delete(Integer id) {
        efassBankMapRepository.findById(id).ifPresent(efassBankMapRepository::delete);
    }

    public EfassBankDto edit(EfassBankDto efassBankDto) {
        EfassBankMap efassBankMap = efassBankMapRepository.findById(efassBankDto.getId()).orElseThrow(()-> new NoSuchElementException("No such ID !!!"));
        efassBankMap.setGl_code(efassBankDto.getGlCode());
        efassBankMap.setAccount_number(efassBankDto.getAccountNumber());
        efassBankMap.setInstitution_code(efassBankDto.getInstitutionCode());
        efassBankMap.setInstitution_name(efassBankDto.getInstitutionName());
        efassBankMap = efassBankMapRepository.save(efassBankMap);
        return mapEntityToDto(efassBankMap);
    }

    public Iterable<EfassBankMap> getAll() {
        return efassBankMapRepository.findAll();
    }

    public EfassBankMap getOne(Integer id) {
        return efassBankMapRepository.findById(id).orElseThrow(()-> new NoSuchElementException("No such ID !!!"));
    }
}
