package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }

    public List<Address> collectDistinct(List<Profile> profiles) {
        return profiles.stream()
                .sorted(
                        Comparator.comparing(s -> s.getAddress().getCity())
                )
                .distinct()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }
}
