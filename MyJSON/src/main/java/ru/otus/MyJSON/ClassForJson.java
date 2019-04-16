package ru.otus.MyJSON;

import java.util.Arrays;
import java.util.Objects;

public class ClassForJson {
    private final int value1;
    private final String value2;
    public final int value3;
    public int[] ints = {1,2,3,4,5};
    public ClassForJson(int value1, String value2, int value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassForJson that = (ClassForJson) o;

        if (value1 != that.value1) return false;
        if (value3 != that.value3) return false;
        return value2 != null ? value2.equals(that.value2) : that.value2 == null;
    }

    @Override
    public String toString() {
        return "ClassForJson{" +
                "value1=" + value1 +
                ", value2='" + value2 + '\'' +
                ", value3=" + value3 +
                '}';
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(value1, value2, value3);
        result = 31 * result + Arrays.hashCode(ints);
        return result;
    }
}
