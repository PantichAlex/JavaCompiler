package pantich.compiler.LexAnalayse;

import java.util.ArrayList;

public class LiteralsPool implements IAnalyzerComponent {

    IAnalyzerComponent next=null;
    ArrayList<String> pool=new ArrayList<String>();
    public LiteralsPool() {


    }

    @Override
    public void setNext(IAnalyzerComponent next) {

    }

    @Override
    public void handle(String inputChain) {

    }

    @Override
    public String getResult() {
        return null;
    }
}
