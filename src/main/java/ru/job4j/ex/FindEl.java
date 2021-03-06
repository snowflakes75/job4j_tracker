package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("not found key");
        }
        return rsl;
    }

    public static void sent(String value, String[] abuses) {
        for (String abus : abuses) {
            if (abus.equals(value)) {
                throw new AbstractMethodError("don't send this " + abus);
            }
        }
    }

    public static void process(String[] values, String key, String[] abuses) {
        try {
            if (indexOf(values, key) != -1) {
                sent(key, abuses);
            }
        } catch (Exception ea) {
            ea.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            FindEl.indexOf(new String[]{"some", "key"}, "om");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
