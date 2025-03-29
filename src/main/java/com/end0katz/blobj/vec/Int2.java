package com.end0katz.blobj.vec;

public record Int2(Integer x, Integer y) implements Vec2<Integer, Int2> {

    @Override
    public Int2 _createNew(Integer x, Integer y) {
        return new Int2(x, y);
    }
}
