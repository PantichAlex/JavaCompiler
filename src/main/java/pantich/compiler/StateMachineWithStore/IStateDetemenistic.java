package pantich.compiler.StateMachineWithStore;

import java.util.HashSet;

public interface IStateDetemenistic extends IState {

    //Возвращает следующее состояние, согласно условиям грамматики
    IState getNextState();



}
