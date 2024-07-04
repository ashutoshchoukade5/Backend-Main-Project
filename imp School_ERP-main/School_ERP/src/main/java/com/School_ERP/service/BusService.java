package com.School_ERP.service;


import com.School_ERP.dto.BusDto;
import com.School_ERP.dto.StudentDto;

import java.util.List;


public interface BusService {

    List<BusDto> getAllBuses();
    BusDto addBus(BusDto busDto);
    String deleteBus(Long id);
    List<StudentDto> getStudentsByBusId(Long busId);
    BusDto updateBus(Long id, BusDto busDto);

    BusDto getBusById(Long id);
}

