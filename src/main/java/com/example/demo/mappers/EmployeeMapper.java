package com.example.demo.mappers;

import com.example.demo.entities.PersistableEmployee;
import com.example.demo.models.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mappings({
            @Mapping(target = "id", source = "persistableEmployee.id"),
            @Mapping(target = "name", source = "persistableEmployee.name")
    })
    Employee toDto(PersistableEmployee persistableEmployee);

    @Mappings({
            @Mapping(target = "id", source = "employee.id"),
            @Mapping(target = "name", source = "employee.name")
    })
    PersistableEmployee toEntity(Employee employee);
}