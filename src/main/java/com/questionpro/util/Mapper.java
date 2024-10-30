package com.questionpro.util;

import org.modelmapper.ModelMapper;

public class Mapper {
   public static final ModelMapper mapper = null;

   public static ModelMapper getModelMapperInstance() {
      return mapper == null ? new ModelMapper() : mapper;
   }
}
