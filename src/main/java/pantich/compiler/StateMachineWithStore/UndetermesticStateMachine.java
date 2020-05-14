package pantich.compiler.StateMachineWithStore;

import java.util.HashSet;
import java.util.Stack;

//Абстрактный класс описывает модель недетерменированного кончного автомата с магазинной паматью
public abstract class UndetermesticStateMachine extends AbstractStateMachineWithStore{
    private HashSet<IStateUndetermenetic> states;

    public UndetermesticStateMachine(Stack<Character> store, IStateUndetermenetic initialState) {
        super(store);
        states=new HashSet<>();
        states.add(initialState);

    }

    @Override
    public boolean processLine() {
        char topOfStore=getTopOfStore();
        boolean lineAccepted=false;
        HashSet<IStateUndetermenetic> newStates=new HashSet<>();
        do{
            if(!isTerminal(topOfStore)){
                for (IStateUndetermenetic state: states) {
                    if(state.putChar(getNextChar(),topOfStore)){
                        removeTop();
                        for(char ch:state.getNexSymbols()){

                            pushOnStore(ch);
                        }
                        newStates.addAll(state.getNextStatesList());

                        lineAccepted=true;

                    }else{
                        return false;
                    }
                }
            }else {

                return false;
            }

        }while (!storeIsEmpty());

        return lineAccepted;

    }

}
