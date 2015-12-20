package org.jfas.nh.player;

public class Player
{
    private static final int DEFAULT_MIND = 4;
    private static final int DEFAULT_BODY = 4;

    private String name;

    private int mind;
    private int body;

    private Armor armor;

    public Player(String name)
    {
        this.name = name;

        this.mind = DEFAULT_MIND;
        this.body = DEFAULT_BODY;
    }
}
