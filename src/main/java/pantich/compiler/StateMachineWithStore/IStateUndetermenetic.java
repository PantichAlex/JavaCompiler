package pantich.compiler.StateMachineWithStore;

import java.util.HashSet;


//Интерфейс для состояний детерменированного автомата
public interface IStateUndetermenetic extends IState {

    HashSet<IStateUndetermenetic> getNextStatesList();
}
