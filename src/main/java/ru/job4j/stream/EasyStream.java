package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EasyStream {
    private List<Integer> list;
/*
    public EasyStream(List<Integer> list) {
        this.list = list;
    }*/

    public static EasyStream of(List<Integer> source) {
        return new Builder().buildList(source).build();
      //  return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        return new Builder().buildList(list).mapItem(fun).build();
        //return new Builder().buildList(list).build();
     //   return new EasyStream(list.stream().map(fun).collect(Collectors.toList()));
    }

    public EasyStream filter(Predicate<Integer> fun) {
        return new Builder().buildList(list).filterList(fun).build();
        //return new Builder().buildList(list).build();
   //     return new EasyStream(list.stream().filter(fun).collect(Collectors.toList()));
    }

    public List<Integer> collect() {
//        return new ArrayList<>(list);
        return new Builder().buildList(list).build().getList();
    }

    private List<Integer> getList() {
        return list;
    }

    static class Builder {
        private List<Integer> list;

        EasyStream build() {
            EasyStream easyStream = new EasyStream();
            easyStream.list = list;
            return easyStream;
        }

        public List<Integer> getList() {
            return list;
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