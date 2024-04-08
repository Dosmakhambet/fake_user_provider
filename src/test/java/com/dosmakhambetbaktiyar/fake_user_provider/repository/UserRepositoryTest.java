package com.dosmakhambetbaktiyar.fake_user_provider.repository;

import com.dosmakhambetbaktiyar.fake_user_provider.config.PostgreContainerConfiguration;
import com.dosmakhambetbaktiyar.fake_user_provider.module.Address;
import com.dosmakhambetbaktiyar.fake_user_provider.module.Country;
import com.dosmakhambetbaktiyar.fake_user_provider.module.User;
import com.dosmakhambetbaktiyar.fake_user_provider.seed.AddressSeed;
import com.dosmakhambetbaktiyar.fake_user_provider.seed.CountrySeed;
import com.dosmakhambetbaktiyar.fake_user_provider.seed.UserSeed;
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
public class UserRepositoryTest extends PostgreContainerConfiguration {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CountryRepository countryRepository;

    private AddressSeed addressSeed = new AddressSeed();
    private CountrySeed countrySeed = new CountrySeed();
    private UserSeed userSeed = new UserSeed();

    private User user1;
    private User user2;

    @BeforeEach
    public void setup() {
        user1 = userSeed.createUser1();
        user2 = userSeed.createUser2();
        truncateTables();
    }

    @Test
    public void saveUserShouldPersistData() {
        setAddressIdToUser(countrySeed.createCountry1(), addressSeed.createAddress1(), user1);

        Mono<User> saved = userRepository.save(user1);
        StepVerifier.create(saved)
                .assertNext(user -> {
                    assertNotNull(user.getId());
                    assertEquals(user1.getLastName(), user.getLastName());
                    assertEquals(user1.getFirstName(), user.getFirstName());
                    assertEquals(user1.getSecretKey(), user.getSecretKey());
                })
                .verifyComplete();
    }

    @Test
    public void findAllShouldReturnAllUsers() {
        setAddressIdToUser(countrySeed.createCountry1(), addressSeed.createAddress1(), user1);
        setAddressIdToUser(countrySeed.createCountry2(), addressSeed.createAddress2(), user2);
        userRepository.save(user1).block();
        userRepository.save(user2).block();

        Flux<User> users = userRepository.findAll();
        StepVerifier.create(users)
                .assertNext(user -> {
                    assertEquals(user1.getLastName(), user.getLastName());
                    assertEquals(user1.getFirstName(), user.getFirstName());
                    assertEquals(user1.getSecretKey(), user.getSecretKey());
                })
                .assertNext(user -> {
                    assertEquals(user2.getLastName(), user.getLastName());
                    assertEquals(user2.getFirstName(), user.getFirstName());
                    assertEquals(user2.getSecretKey(), user.getSecretKey());
                })
                .verifyComplete();
    }

    @Test
    public void findAllShouldReturnEmptyWhenNoUsers() {

        Flux<User> users = userRepository.findAll();
        StepVerifier.create(users)
                .verifyComplete();
    }

    private void truncateTables() {
        userRepository.deleteAll().block();
        addressRepository.deleteAll().block();
        countryRepository.deleteAll().block();

    }

    private void setAddressIdToUser(Country country, Address address, User user) {
        Country savedCountry = countryRepository.save(country).block();
        address.setCountryId(savedCountry.getId());
        Address savedAddress = addressRepository.save(address).block();
        user.setAddressId(savedAddress.getId());
    }
}
