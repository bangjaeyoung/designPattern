package com.company.design.adapter;

public class Main {
    public static void main(String[] args) {

        HairDryer hairDryer = new HairDryer();
        conenct(hairDryer);

        Cleaner cleaner = new Cleaner();
        Electronic110V adapter = new SocketAdapter(cleaner);
        conenct(adapter);

        AirConditioner airConditioner = new AirConditioner();
        Electronic110V airAdapter = new SocketAdapter(airConditioner);
        conenct(airAdapter);
    }

    public static void conenct(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }
}
