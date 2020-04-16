package pantich.compiler.LexAnalayse;

public interface IAnalyzerComponent {

    void setNext(IAnalyzerComponent next);
    void handle(String inputChain);
    String getResult();
}
