package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void whenFindAddress() {
        Profiles profilesAddress = new Profiles();
        Profile pr1 = new Profile(new Address("London", "Baker Street", 221, 0xB));
        Profile pr2 = new Profile(new Address("Moscow", "Korovinskoe", 41, 0));
        List<Profile> profiles = List.of(pr1, pr2);
        List<Address> addresses = profilesAddress.collect(profiles);
        assertThat(List.of(pr1.getAddress(), pr2.getAddress()), is(addresses));
    }
}