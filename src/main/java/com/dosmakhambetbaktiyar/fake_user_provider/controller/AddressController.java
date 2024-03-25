package com.dosmakhambetbaktiyar.fake_user_provider.controller;

import com.dosmakhambetbaktiyar.fake_user_provider.mapper.AddressMapper;
import com.dosmakhambetbaktiyar.fake_user_provider.service.AddressService;
import com.dto.AddressDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.data.domain.Pageable;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class AddressController {
    private final AddressService service;
    private final AddressMapper mapper;

    @GetMapping("/all")
    public Flux<AddressDto> getAllAddresses() {
        Pageable pageable = PageRequest.of(0, 10);
        return service.findAll(pageable).map(mapper::toDto);
    }

    @PostMapping("/")
    public Mono<AddressDto> createAddress(@RequestBody AddressDto addressDto) {
        return service.save(mapper.toEntity(addressDto)).map(mapper::toDto);
    }

    @GetMapping("/{id}")
    public Mono<AddressDto> getAddressById(@PathVariable UUID id) {
        return service.findById(id).map(mapper::toDto);
    }

    @PutMapping("/{id}")
    public Mono<AddressDto> updateAddress(@PathVariable UUID id, @RequestBody AddressDto addressDto) {
        return service.update(id, mapper.toEntity(addressDto)).map(mapper::toDto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteAddress(@PathVariable UUID id) {
        return service.delete(id);
    }
}
