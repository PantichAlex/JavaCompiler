package pantich.compiler.StateMachineWithStore;

import java.util.ArrayList;
import java.util.Stack;

/*
* Класс DetermenisticStateMachine детерминированного описывает модель абстрактного конечного автомата с магазинной памятью
* */
public abstract class DetermenisticStateMachine extends AbstractStateMachineWithStore {

    //Текущее состояние автомата
    private IStateDetemenistic state;


    public DetermenisticStateMachine(Stack<Character> store, IStateDetemenistic initialState) {
        super(store);
        state=initialState;
    }



    @Override
    public boolean processLine() {
        boolean lineAccepted;
        char topOfStore=getTopOfStore();
        do{
            if(!isTerminal(topOfStore)){
                if(state.putChar(getNextChar(),topOfStore)){

                    state= (IStateDetemenistic) state.getNextState();
                    ArrayList<Character> nextCharacters=state.getNexSymbols();
                    removeTop();
                    for (char symbol:  nextCharacters) {
                        pushOnStore(symbol);
                    }
                    lineAccepted=true;
                }else{
                    return false;
                }
            }else {

                return false;
            }

        }while (!storeIsEmpty());

        return lineAccepted;

    }
}
