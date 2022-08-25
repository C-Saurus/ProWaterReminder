package com.example.prowaterreminder;


public class UserData {
    private float weight;
    private String gender;
    private String weather;
    private String status;
    private int hourAwake, hourSleep, minuteAwake, minuteSleep;
    public UserData() {
    }

    public UserData(float weight, String gender, int hourAwake, int hourSleep, int minuteAwake, int minuteSleep) {
        this.weight = weight;
        this.gender = gender;
        this.hourAwake = hourAwake;
        this.hourSleep = hourSleep;
        this.minuteAwake = minuteAwake;
        this.minuteSleep = minuteSleep;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHourAwake() {
        return hourAwake;
    }

    public void setHourAwake(int hourAwake) {
        this.hourAwake = hourAwake;
    }

    public int getHourSleep() {
        return hourSleep;
    }

    public void setHourSleep(int hourSleep) {
        this.hourSleep = hourSleep;
    }

    public int getMinuteAwake() {
        return minuteAwake;
    }

    public void setMinuteAwake(int minuteAwake) {
        this.minuteAwake = minuteAwake;
    }

    public int getMinuteSleep() {
        return minuteSleep;
    }

    public void setMinuteSleep(int minuteSleep) {
        this.minuteSleep = minuteSleep;
    }
}
