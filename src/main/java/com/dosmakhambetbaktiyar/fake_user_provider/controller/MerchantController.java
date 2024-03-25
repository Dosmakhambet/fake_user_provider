package com.dosmakhambetbaktiyar.fake_user_provider.controller;

import com.dosmakhambetbaktiyar.fake_user_provider.mapper.MerchantMapper;
import com.dosmakhambetbaktiyar.fake_user_provider.mapper.MerchantMemberInvitationMapper;
import com.dosmakhambetbaktiyar.fake_user_provider.mapper.MerchantMemberMapper;
import com.dosmakhambetbaktiyar.fake_user_provider.service.MerchantService;
import com.dto.MerchantDto;
import com.dto.MerchantMemberDto;
import com.dto.MerchantMemberInvitationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/merchant")
public class MerchantController {
    private final MerchantService service;
    private final MerchantMapper mapper;
    private final MerchantMemberInvitationMapper invitationMapper;
    private final MerchantMemberMapper memberMapper;

    @GetMapping("/all")
    public Flux<MerchantDto> getAll() {
        Pageable pageable = PageRequest.of(0, 10);
        return service.findAll(pageable).map(mapper::toDto);
    }

    @PostMapping("/")
    public Mono<MerchantDto> create(@RequestBody MerchantDto merchantDto) {
        return service.save(mapper.toEntity(merchantDto)).map(mapper::toDto);
    }

    @GetMapping("/{id}")
    public Mono<MerchantDto> getById(@PathVariable UUID id) {
        return service.findById(id).map(mapper::toDto);
    }

    @PutMapping("/{id}")
    public Mono<MerchantDto> update(@PathVariable UUID id, @RequestBody MerchantDto merchantDto) {
        return service.update(id, mapper.toEntity(merchantDto)).map(mapper::toDto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable UUID id) {
        return service.delete(id);
    }

    @GetMapping("/{merchantId}/invitation/all")
    public Flux<MerchantMemberInvitationDto> getAllInvitations(@PathVariable UUID merchantId) {
        Pageable pageable = PageRequest.of(0, 10);
        return service.findAllInvitations(merchantId,pageable).map(invitationMapper::toDto);
    }

    @GetMapping("/{merchantId}/member/all")
    public Flux<MerchantMemberDto> getAllMembers(@PathVariable UUID merchantId) {
        Pageable pageable = PageRequest.of(0, 10);
        return service.findAllMembers(merchantId,pageable).map(memberMapper::toDto);
    }
}
