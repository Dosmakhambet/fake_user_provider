package com.dosmakhambetbaktiyar.fake_user_provider.controller;

import com.dosmakhambetbaktiyar.fake_user_provider.mapper.MerchantMemberInvitationMapper;
import com.dosmakhambetbaktiyar.fake_user_provider.mapper.MerchantMemberMapper;
import com.dosmakhambetbaktiyar.fake_user_provider.mapper.UserMapper;
import com.dosmakhambetbaktiyar.fake_user_provider.service.MerchantMemberService;
import com.dto.MerchantMemberDto;
import com.dto.MerchantMemberInvitationDto;
import com.dto.RegisterMerchantMemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/merchant-member")
public class MerchantMemberController {
    private final MerchantMemberService service;
    private final MerchantMemberMapper mapper;
    private final MerchantMemberInvitationMapper invitationMapper;
    private final UserMapper userMapper;

    @PostMapping("/merchant")
    public Mono<MerchantMemberDto> create(@RequestBody MerchantMemberInvitationDto invitationDto) {
        return service.save(invitationMapper.toEntity(invitationDto)).map(mapper::toDto);
    }

    @PostMapping("{individualId}/individual")
    public Mono<MerchantMemberDto> create(@PathVariable UUID individualId, @RequestBody RegisterMerchantMemberDto registerMerchantMemberDto) {
        return service.saveIndividual(individualId, userMapper.toEntity(registerMerchantMemberDto)).map(mapper::toDto);
    }

    @GetMapping("/{id}")
    public Mono<MerchantMemberDto> getById(@PathVariable UUID id) {
        return service.findById(id).map(mapper::toDto);
    }

    @PutMapping("/{id}")
    public Mono<MerchantMemberDto> update(@PathVariable UUID id, @RequestBody MerchantMemberDto memberDto) {
        return service.update(id, mapper.toEntity(memberDto)).map(mapper::toDto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}
