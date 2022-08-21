package by.prus.forfesco.model.enums;

public enum Operation {

    CLN("Уборка вагонов"),
    CY("Перегруз"),
    DOC("Оформление документов"),
    SEA("Морской фрахт"),
    TRF("Тариф"),
    TRK("Автоперевозка");

    private final String opName;

    Operation(String opName) {
        this.opName = opName;
    }
}
