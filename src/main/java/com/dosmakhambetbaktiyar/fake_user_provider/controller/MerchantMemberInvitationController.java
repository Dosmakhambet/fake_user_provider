package com.dosmakhambetbaktiyar.fake_user_provider.controller;

import com.dosmakhambetbaktiyar.fake_user_provider.mapper.MerchantMemberInvitationMapper;
import com.dosmakhambetbaktiyar.fake_user_provider.service.MerchantMemberInvitationService;
import com.dto.MerchantMemberInvitationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/merchant-member-invitation")
public class MerchantMemberInvitationController {
    private final MerchantMemberInvitationService service;
    private final MerchantMemberInvitationMapper mapper;

    @PostMapping("/")
    public Mono<MerchantMemberInvitationDto> create(@RequestBody MerchantMemberInvitationDto invitationDto) {
        return service.save(mapper.toEntity(invitationDto)).map(mapper::toDto);
    }

    @GetMapping("/{id}")
    public Mono<MerchantMemberInvitationDto> getById(@PathVariable UUID id) {
        return service.findById(id).map(mapper::toDto);
    }

    @PutMapping("/{id}")
    public Mono<MerchantMemberInvitationDto> update(@PathVariable UUID id, @RequestBody MerchantMemberInvitationDto invitationDto) {
        return service.update(id, mapper.toEntity(invitationDto)).map(mapper::toDto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}
