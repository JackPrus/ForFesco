package by.prus.forfesco.model.enums;

public enum ErrorReason {
    OBJECT_BY_ID_NOT_FOUND("Объект с таким ID не найден"),
    WRONG_DATA("Некорректные данные для поискового запроса"),
    EMPTY_OBJECT("Сохраняемый объект пуст. Введите корректные данные"),
    LINKS_CREATION_FAILURE("Ошибка при создании связей");

    private final String descriprtion;

    ErrorReason(String descriprtion) {
        this.descriprtion = descriprtion;
    }

    public String getDescriprtion() {
        return descriprtion;
    }
}
