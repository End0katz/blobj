package com.end0katz.blobj.vec;

public record Int4(Integer x, Integer y, Integer z, Integer w) implements Vec4<Integer, Int2, Int3, Int4> {

    @Override
    public Int2 _createNew(Integer x, Integer y) {
        return new Int2(x, y);
    }

    @Override
    public Int3 _createNew(Integer x, Integer y, Integer z) {
        return new Int3(x, y, z);
    }

    @Override
    public Int4 _createNew(Integer x, Integer y, Integer z, Integer w) {
        return new Int4(x, y, z, w);
    }
}
