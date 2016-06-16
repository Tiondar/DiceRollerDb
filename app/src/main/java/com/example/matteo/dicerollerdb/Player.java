package com.example.matteo.dicerollerdb;



public class Player {

    String playerName;

    int d4Number;

    int d6Number;

    int d8Number;

    int d10Number;

    int d12Number;

    int d20Number;

    int d100Number;

    int modifierDb;


    public Player(){
    }

    public int getD4Number() {
        return d4Number;
    }

    public void setD4Number(int d4Number) {
        this.d4Number = d4Number;
    }

    public int getD6Number() {
        return d6Number;
    }

    public void setD6Number(int d6Number) {
        this.d6Number = d6Number;
    }

    public int getD8Number() {
        return d8Number;
    }

    public void setD8Number(int d8Number) {
        this.d8Number = d8Number;
    }

    public int getD10Number() {
        return d10Number;
    }

    public void setD10Number(int d10Number) {
        this.d10Number = d10Number;
    }

    public int getD12Number() {
        return d12Number;
    }

    public void setD12Number(int d12Number) {
        this.d12Number = d12Number;
    }

    public int getD20Number() {
        return d20Number;
    }

    public void setD20Number(int d20Number) {
        this.d20Number = d20Number;
    }

    public int getD100Number() {
        return d100Number;
    }

    public void setD100Number(int d100Number) {
        this.d100Number = d100Number;
    }

    public int getModifierDb() {
        return modifierDb;
    }

    public void setModifierDb(int modifierDb) {
        this.modifierDb = modifierDb;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
