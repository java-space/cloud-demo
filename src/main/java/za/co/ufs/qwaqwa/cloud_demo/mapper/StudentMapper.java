/*
 * Copyright 2023 , All Rights Reserved
 * Licensed under the Apache License, Version 2.0 (the "License");
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential
 * @author  Mothusi Molorane
 * @since 1.0
 */

package za.co.ufs.qwaqwa.cloud_demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import za.co.ufs.qwaqwa.cloud_demo.api.model.Student;
import za.co.ufs.qwaqwa.cloud_demo.api.model.StudentInput;
import za.co.ufs.qwaqwa.cloud_demo.entity.StudentEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface StudentMapper extends AbstractMapper<StudentEntity, Student> {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(target = "id", ignore = true)
    StudentEntity dtoToInternal(StudentInput input);

    Student internalToDto(StudentEntity entity);
}
