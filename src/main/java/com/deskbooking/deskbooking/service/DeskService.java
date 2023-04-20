package com.deskbooking.deskbooking.service;

import com.deskbooking.deskbooking.dto.DeskDTO;
import com.deskbooking.deskbooking.mapper.DeskMapper;
import lombok.RequiredArgsConstructor;
import com.deskbooking.deskbooking.model.Desk;
import org.springframework.stereotype.Service;
import com.deskbooking.deskbooking.repository.DeskRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeskService {
    private final DeskRepository deskRepository;
    private final DeskMapper deskMapper;

    public Desk createDesk(Desk desk){
        return deskRepository.save(desk);
    }

    public Desk findDeskById(Integer deskId){
        return deskRepository.findById(deskId).get();
    }

    public Desk findDeskByName(String name){
        return deskRepository.findDeskByName(name);
    }

    public List<DeskDTO> getAllDesks(){
        return deskRepository.findAll().stream()
                .map(deskMapper::toDeskDTO)
                .collect(Collectors.toList());
    }
}
