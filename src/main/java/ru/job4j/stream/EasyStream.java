package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> list;

    private EasyStream() {

    }

    public static EasyStream of(List<Integer> source) {
        return new Builder().buildList(source).build();
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        return new Builder().buildList(list).mapItem(fun).build();

    }

    public EasyStream filter(Predicate<Integer> fun) {
        return new Builder().buildList(list).filterList(fun).build();
    }

    public List<Integer> collect() {
       return new ArrayList<>(list);
    }

    static class Builder {
        private List<Integer> list;

        EasyStream build() {
            EasyStream easyStream = new EasyStream();
            easyStream.list = list;
            return easyStream;
        }

        Builder buildList(List<Integer> list) {
            this.list = list;
            return this;
        }

        Builder filterList(Predicate<Integer> fun) {
            List<Integer> nList = new ArrayList<>();
            for (Integer in : list) {
                if (fun.test(in)) {
                    nList.add(in);
                }
            }
            list = nList;
            return this;
        }

        Builder mapItem(Function<Integer, Integer> fun) {
            List<Integer> nList = new ArrayList<>();
            for (Integer in: list) {
                nList.add(fun.apply(in));
            }
            list = nList;
            return this;
        }
    }
}