
package com.School_ERP.service.serviceImpl;

import com.School_ERP.dto.BusDto;
import com.School_ERP.dto.StudentDto;
import com.School_ERP.entity.Bus;
import com.School_ERP.entity.Student;
import com.School_ERP.repository.BusRepository;
import com.School_ERP.service.BusService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepository;

    @Override
    public List<BusDto> getAllBuses() {
        List<Bus> buses = busRepository.findAll();
        return buses.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public BusDto addBus(BusDto busDto) {
        Bus bus = convertToEntity(busDto);
        bus = busRepository.save(bus);
        return convertToDto(bus);
    }

    @Override
    public String deleteBus(Long id) {
        busRepository.deleteById(id);
        return "Bus deleted successfully!";
    }

    @Override
    public BusDto getBusById(Long id) {
        Bus bus = busRepository.findById(id).orElse(null);
        return convertToDto(bus);
    }
    public List<StudentDto> getStudentsByBusId(Long busId) {
        Optional<Bus> busOptional = busRepository.findById(busId);
        if (busOptional.isPresent()) {
            Bus bus = busOptional.get();
            List<Student> students = bus.getStudents();
            ModelMapper modelMapper = new ModelMapper(); // Create an instance of ModelMapper
            return students.stream()
                    .map(student -> modelMapper.map(student, StudentDto.class))
                    .collect(Collectors.toList());
        } else {
            // Handle case when bus with given ID is not found
            return Collections.emptyList();
        }
    }

    private BusDto convertToDto(Bus bus) {
        if (bus == null) {
            return null;
        }
        BusDto busDto = new BusDto();
        busDto.setBusNo(bus.getBusNo());
        busDto.setTotalSeat(bus.getTotalSeat());
        busDto.setAvailableSeat(bus.getAvailableSeat());
        busDto.setDriverContact(bus.getDriverContact());
        busDto.setDriverName(bus.getDriverName());
        busDto.setRoute(bus.getRoute());
        return busDto;
    }

    @Override
    public BusDto updateBus(Long id, BusDto busDto) {
        Bus existingBus = busRepository.findById(id).orElse(null);
        if (existingBus != null) {
            existingBus.setBusNo(busDto.getBusNo());
            existingBus.setTotalSeat(busDto.getTotalSeat());
            existingBus.setAvailableSeat(busDto.getAvailableSeat());
            existingBus.setDriverContact(busDto.getDriverContact());
            existingBus.setDriverName(busDto.getDriverName());
            existingBus.setRoute(busDto.getRoute());
            existingBus = busRepository.save(existingBus);
            return convertToDto(existingBus);
        }
        return null; // Or throw an exception
    }

    private Bus convertToEntity(BusDto busDto) {
        Bus bus = new Bus();
        bus.setBusNo(busDto.getBusNo());
        bus.setTotalSeat(busDto.getTotalSeat());
        bus.setAvailableSeat(busDto.getAvailableSeat());
        bus.setDriverContact(busDto.getDriverContact());

        bus.setDriverName(busDto.getDriverName());
        bus.setRoute(busDto.getRoute());
        return bus;
    }
}