package com.dosmakhambetbaktiyar.fake_user_provider.repository;

import com.dosmakhambetbaktiyar.fake_user_provider.config.PostgreContainerConfiguration;
import com.dosmakhambetbaktiyar.fake_user_provider.module.Address;
import com.dosmakhambetbaktiyar.fake_user_provider.module.Country;
import com.dosmakhambetbaktiyar.fake_user_provider.seed.AddressSeed;
import com.dosmakhambetbaktiyar.fake_user_provider.seed.CountrySeed;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.test.context.ActiveProfiles;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@DataR2dbcTest
@ActiveProfiles("test")
public class AddressRepositoryTest extends PostgreContainerConfiguration {

    @Autowired
    private  AddressRepository addressRepository;
    @Autowired
    private  CountryRepository countryRepository;

    private AddressSeed addressSeed = new AddressSeed();

    private CountrySeed countrySeed = new CountrySeed();

    private Address address1;
    private Address address2;
    private Country country1;
    private Country country2;

    @BeforeEach
    public void setup() {
        address1 = addressSeed.createAddress1();
        address2 = addressSeed.createAddress2();
        country1 = countrySeed.createCountry1();
        country2 = countrySeed.createCountry2();
        truncateTables();
    }

    @Test
    public void saveAddressShouldPersistData() {
        Country country = countryRepository.save(country1).block();
        address1.setCountryId(country.getId());

        Mono<Address> saved = addressRepository.save(address1);
        StepVerifier.create(saved)
                .assertNext(data -> {
                    assertNotNull(data.getId());
                    assertEquals(address1.getCountry(), data.getCountry());
                    assertEquals(address1.getCity(), data.getCity());
                    assertEquals(address1.getAddress(), data.getAddress());
                    assertEquals(address1.getZipCode(), data.getZipCode());
                })
                .verifyComplete();
    }

    @Test
    public void findAllShouldReturnAllAddresses() {
        Country country11 = countryRepository.save(country1).block();
        address1.setCountryId(country11.getId());
        Country country22 = countryRepository.save(country2).block();
        address2.setCountryId(country22.getId());
        addressRepository.save(address1).block();
        addressRepository.save(address2).block();

        Flux<Address> addresses = addressRepository.findAll(0, 2);
        StepVerifier.create(addresses)
                .assertNext(address -> {
                    assertEquals(address1.getCountry(), address.getCountry());
                    assertEquals(address1.getCity(), address.getCity());
                    assertEquals(address1.getAddress(), address.getAddress());
                    assertEquals(address1.getZipCode(), address.getZipCode());
                })
                .assertNext(address -> {
                    assertEquals(address2.getCountry(), address.getCountry());
                    assertEquals(address2.getCity(), address.getCity());
                    assertEquals(address2.getAddress(), address.getAddress());
                    assertEquals(address2.getZipCode(), address.getZipCode());
                })
                .verifyComplete();
    }

    @Test
    public void findAllShouldReturnEmptyWhenNoAddresses() {
        Flux<Address> addresses = addressRepository.findAll(0, 2);
        StepVerifier.create(addresses)
                .verifyComplete();
    }

    private void truncateTables() {
        addressRepository.deleteAll().block();
        countryRepository.deleteAll().block();
    }
}