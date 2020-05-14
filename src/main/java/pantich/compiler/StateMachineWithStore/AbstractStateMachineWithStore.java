package pantich.compiler.StateMachineWithStore;

import com.sun.istack.internal.NotNull;

import java.util.ArrayDeque;
import java.util.Stack;

/*

@Класс описывает модель абстрактноого конечного
автомата с магазинной памятью
Поле <b>store</b> представляет собой магазин автомата
Поле <b>line</b> - входная лента
 */
public abstract class AbstractStateMachineWithStore {
    private Stack<Character> store;
    private ArrayDeque<Character> line;

    public AbstractStateMachineWithStore(Stack<Character> store) {
        this.store = store;
        this.line = new ArrayDeque<>();

    }

    //Абстрактный метод, который долен отвечать на вопрос, принадлежит ли входная цепочка автомату
    public abstract boolean processLine();


    //Абстрактный метод, который должен отвечать на вопрос, является ли символ терминалом грамматики
    public abstract boolean isTerminal(char inputChar);

    //Метод устанавливает новую линию
    public void setLine(String inputLine){

        for(char charecter: inputLine.toCharArray()){
            line.addLast(charecter);
        }
    }

    /*
        Добавляем новое состояние в магазин
        @param character - добавляемый символ в магазинн
     */

    public void pushOnStore(Character character){
        store.push(character);
    }

    public char getNextChar(){
        return line.pop();
    }

    /*
    * Возвращмет значение на вершине магазина
    * */
    public char getTopOfStore(){

        return store.peek();
    }

    /*
    * Удаляет вершину магазина
    *
    * */
    public void removeTop(){
        store.pop();
    }

    public boolean storeIsEmpty(){
        return store.isEmpty();
    }



}
