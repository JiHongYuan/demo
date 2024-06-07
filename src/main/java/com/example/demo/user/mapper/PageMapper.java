package com.example.demo.user.mapper;

import com.example.demo.user.model.PageDo;
import com.example.demo.user.model.entity.Page;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PageMapper {
    PageMapper INSTANCE = Mappers.getMapper(PageMapper.class); // <2>

    Page toEntity(PageDo pageDo);

}
