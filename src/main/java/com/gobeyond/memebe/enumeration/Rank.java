package com.gobeyond.memebe.enumeration;

public enum Rank {
    ROOKIE(0),
    INTERMEDIATE(50),
    GOOD_ENOUGH(150),
    COOL(300),
    HARDCORE(600),
    MEME_LORD(1200);

    int requiredPoints;

    Rank(int requiredPoints) {
        this.requiredPoints = requiredPoints;
    }

}
