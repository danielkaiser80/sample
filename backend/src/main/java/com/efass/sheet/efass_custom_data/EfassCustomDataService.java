package com.efass.sheet.efass_custom_data;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class EfassCustomDataService {
    private final EfassCustomRepository efassCustomRepository;

    public EfassCustomDataApiResponse updateEfassCustomData(String refCd, String newRefDesc, String newRefType, String newRefValue) {
        EfassCustomData efassCustomData = efassCustomRepository.findByRefCd(refCd);
        EfassCustomDataResponse response;

        if (efassCustomData != null && efassCustomData.getRefCd() != null) {
            EfassCustomData updatedData = EfassCustomData.builder()
                    .refType(newRefType)
                    .refDesc(newRefDesc)
                    .refValue(newRefValue)
                    .refCd(refCd)
                    .build();

            efassCustomRepository.save(updatedData);
            response = mapEfassCustomDataToEfassResponseData(updatedData);
            log.info(response);
        } else {
            throw new RuntimeException("Record does not exist");
        }

        return EfassCustomDataApiResponse.builder()
                .responseMessage("Record Updated Successfully")
                .efassCustomDataResponse(response)
                .build();
    }

    private EfassCustomDataResponse mapEfassCustomDataToEfassResponseData(EfassCustomData customData) {
        return EfassCustomDataResponse.builder()
                .newRefDesc(customData.getRefDesc())
                .newRefType(customData.getRefType())
                .newRefValue(customData.getRefValue())
                .build();
    }
}
