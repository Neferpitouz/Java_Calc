public enum Ten_Roman
{
    X(10, "X"),IX(9,"IX"), VIII(8,"VIII"), VII(7,"VII"),
    VI(6,"VI"), V(5, "V"),IV(4,"IV"), III(3,"III"), II(2,"II"), I(1,"I");
    int value;
    String roman_value;
    Ten_Roman(int value, String roman_value){
        this.value = value;
        this.roman_value = roman_value;

    }
    int getValue(){
        return value;
    }
    String getRoman_value(){
        return roman_value;
    }
}

