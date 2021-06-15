package ru.job4j.stream;

public class Cup {
    private int capacity;
    private String model;
    private String material;
    private boolean hSticker;
    private byte code;

    @Override
    public String toString() {
        return "Cup{" +
                "capacity=" + capacity +
                ", model='" + model + '\'' +
                ", material='" + material + '\'' +
                ", hSticker=" + hSticker +
                ", code=" + code +
                '}';
    }

    static class Builder {
        private int capacity;
        private String model;
        private String material;
        private boolean hSticker;
        private byte code;

        Builder buildCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildMaterial(String material) {
            this.material = material;
            return this;
        }

        Builder buildSticker(boolean hSticker) {
            this.hSticker = hSticker;
            return this;
        }

        Builder buildCode(byte code) {
            this.code = code;
            return this;
        }

        Cup build() {
            Cup cup = new Cup();
            cup.capacity = capacity;
            cup.model = model;
            cup.material = material;
            cup.hSticker = hSticker;
            cup.code = code;
            return cup;
        }
    }

    public static void main(String[] args) {
        Cup cup = new Builder().buildCapacity(100)
                .buildModel("HP")
                .buildMaterial("Clay")
                .buildSticker(true)
                .buildCode((byte) 110)
                .build();
        System.out.println(cup);
    }
}