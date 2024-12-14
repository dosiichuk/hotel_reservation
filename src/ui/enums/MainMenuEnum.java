package ui.enums;

public enum MainMenuEnum {
    FIND_AND_RESERVE_ROOM("1. Find and reserve room"),
    SEE_MY_RESERVATIONS("2. See my reservations"),
    CREATE_AN_ACCOUNT("3. Create an account"),
    ADMIN("4. Admin"),
    EXIT("5. Exit");

    private final String menuItemText;

    MainMenuEnum(String menuItemText) {
        this.menuItemText = menuItemText;
    }

    public String getMenuItemText() {
        return menuItemText;
    }
}
