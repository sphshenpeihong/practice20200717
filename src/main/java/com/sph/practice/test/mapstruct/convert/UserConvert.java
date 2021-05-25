package com.sph.practice.test.mapstruct.convert;

import com.sph.practice.test.mapstruct.convert.worker.TypeConversionWorker;
import com.sph.practice.test.mapstruct.pojo.bo.MapStructBO;
import com.sph.practice.test.mapstruct.pojo.bo.MapStructSonBO;
import com.sph.practice.test.mapstruct.pojo.bo.Source1BO;
import com.sph.practice.test.mapstruct.pojo.dto.MapStructDTO;
import com.sph.practice.test.mapstruct.pojo.dto.Source1DTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Shen Peihong
 * @version 1.0
 * @since 1.0.0.1
 */
@Mapper(uses = {TypeConversionWorker.class})
public interface UserConvert {

    UserConvert mapper = Mappers.getMapper(UserConvert.class);

    MapStructBO toMapStructBO(MapStructDTO mapStructDTO);

    @Mapping(source = "son", target = "son", qualifiedByName = "jsonStringToObject")
    Source1BO toSource1BO(Source1DTO source1DTO);

}
