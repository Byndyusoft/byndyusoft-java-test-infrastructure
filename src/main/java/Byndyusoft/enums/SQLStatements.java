package Byndyusoft.enums;

public enum SQLStatements {
  selectAllFromDB("SELECT * FROM ORDERS");

    private String value;

    SQLStatements(String value) { this.value=value; }

    public String getValue() { return value; }
}

