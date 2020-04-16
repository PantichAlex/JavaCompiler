package pantich.compiler.decDigits;
import java.util.List;
import java.util.stream.Collectors;


//Класс DecGrammatic реализует конечный автоматр  разбора десятичного числа с плавающей точкой
public class DecGrammatic {
    /*
    * Автомат имеет следующие состояния:
    *   BEFORE_DOT - Состояние считывания числа до точки
    *
    *   AFTER_DOT - Состояние считивания числа после точки
    *   WRONG_CHAR - Состояние при ошибочном символе
    *   READED_NUMBER - Число считано
    *   PARSED - число разобрано
    *
    * */
    private enum grammaState{
        BEFORE_DOT, AFTER_DOT, WRONG_CHAR, READED_NUMBER, PARSED
    }
    private String inputGrammatic;
    private double mantis;
    private int order=0;
    private grammaState state=grammaState.BEFORE_DOT;
    private String integerPart="";
    private String fractionalPart="";
    private List<Character> alph = "1234567890.".chars().mapToObj(c -> (char) c).collect(Collectors.toList());

    public DecGrammatic(String input) {

        inputGrammatic=input;

    }

    public void parseNumber(){
        parseChain();
        if(state != grammaState.WRONG_CHAR) makeMantisAndOrder();

    }
    //Метод реализует разбор цепочки с переданным в конструктор десятичным числом
    private void parseChain(){


        for(char ch: inputGrammatic.toCharArray()) {

            if (!alph.contains(ch)) {

                System.out.println("Входной символ не входит в алфавит");
                state = grammaState.WRONG_CHAR;
                return;
            } else {

                switch (state) {
                    case BEFORE_DOT:

                        if (ch=='.') {
                            state = grammaState.AFTER_DOT;

                            break;
                        }
                        integerPart += ch;

                        break;
                    case AFTER_DOT:
                        if(ch=='.'){
                            state=grammaState.WRONG_CHAR;
                            return;
                        }

                        fractionalPart+=ch;
                        break;

                } //end switch

            } //end else

        }//end for

        state=grammaState.READED_NUMBER;

        } //end method makeNumber

    //Внутренний метод класса
    //
    private void makeMantisAndOrder(){

        String intPartValue=Integer.toString(Integer.parseInt(integerPart));

        char firstNumber=intPartValue.charAt(0);

        String stringMantis=firstNumber+"."+integerPart.substring(1)+fractionalPart;
        mantis=Double.parseDouble(stringMantis);
        order=integerPart.substring(1).length();
    }
    public double getMantis() {
        return mantis;
    }

    public int getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return state!=grammaState.WRONG_CHAR? Double.toString(mantis)+"*10^"+Integer.toString(order): "Число не разобрано";
    }

    } //end class






