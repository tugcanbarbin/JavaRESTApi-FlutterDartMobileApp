package com.can.spring.learnspringframework.game;

public class PacmanGame implements Game{

    @Override
    public void up() {
        System.out.println("Pacman Up");
    }

    @Override
    public void down() {
        System.out.println("Pacman down");
    }

    @Override
    public void left() {
        System.out.println("Pacman left");
    }

    @Override
    public void right() {
        System.out.println("Pacman right");
    }
}
