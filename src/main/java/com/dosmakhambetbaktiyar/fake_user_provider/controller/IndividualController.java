package com.dosmakhambetbaktiyar.fake_user_provider.controller;

import com.dosmakhambetbaktiyar.fake_user_provider.mapper.IndividualMapper;
import com.dosmakhambetbaktiyar.fake_user_provider.mapper.UserMapper;
import com.dosmakhambetbaktiyar.fake_user_provider.service.IndividualService;
import com.dto.IndividualDto;
import com.dto.RegisterIndividualDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/individual")
public class IndividualController {
    private final IndividualService service;
    private final IndividualMapper mapper;
    private final UserMapper userMapper;

    @GetMapping("/all")
    public Flux<IndividualDto> getAll() {
        Pageable pageable = PageRequest.of(0, 10);
        return service.findAll(pageable).map(mapper::toDto);
    }

    @PostMapping("/")
    public Mono<IndividualDto> create(@RequestBody RegisterIndividualDto registerDto) {
        return service.save(mapper.toEntity(registerDto), userMapper.toEntity(registerDto)).map(mapper::toDto);
    }

    @GetMapping("/{id}")
    public Mono<IndividualDto> getById(@PathVariable UUID id) {
        return service.findById(id).map(mapper::toDto);
    }

    @PutMapping("/{id}")
    public Mono<IndividualDto> update(@PathVariable UUID id, @RequestBody IndividualDto individualDto) {
        return service.update(id, mapper.toEntity(individualDto)).map(mapper::toDto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}
