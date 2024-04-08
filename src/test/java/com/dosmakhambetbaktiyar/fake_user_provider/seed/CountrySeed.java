package com.dosmakhambetbaktiyar.fake_user_provider.seed;

import com.dosmakhambetbaktiyar.fake_user_provider.module.Country;


public class CountrySeed {

    public CountrySeed() {
    }
    public Country createCountry1() {
        return Country.builder()
                .name("Kazakhstan")
                .build();
    }

    public Country createCountry2() {
        return Country.builder()
                .name("USA")
                .build();
    }

}
