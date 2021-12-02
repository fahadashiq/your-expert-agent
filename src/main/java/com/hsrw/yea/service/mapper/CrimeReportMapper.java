package com.hsrw.yea.service.mapper;

import com.hsrw.yea.domain.*;
import com.hsrw.yea.service.dto.CrimeReportDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link CrimeReport} and its DTO {@link CrimeReportDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CrimeReportMapper extends EntityMapper<CrimeReportDTO, CrimeReport> {}
