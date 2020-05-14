package pantich.compiler.StateMachineWithStore;

import java.util.ArrayList;
import java.util.HashSet;

//Интерфейс состоянния конечного автомата
public interface IState {

    /*Метод должен отвечать на вопрос: "Допускает ли данное
    состояние текущий символ на ленте и
    текущую вершину магазина?"  */
    boolean putChar(char lineChar, char StoreChar);

    /*
    * Возвращает цепочку, которая соответствует правилу вывода грамматики
    * */
    ArrayList<Character> getNexSymbols();
}
