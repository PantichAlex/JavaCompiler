package pantich.compiler.LexAnalayse;

public class SpaceDeleter implements IAnalyzerComponent {

    IAnalyzerComponent next=null;
    String result;
    @Override
    public void setNext(IAnalyzerComponent next) {
        this.next=next;

    }

    @Override
    public void handle(String inputChain){

        result=inputChain.replaceAll("\\s","");
    }

    @Override
    public String getResult() {
        if(next!=null){

            next.handle(result);
            return next.getResult();
        }
        return result;
    }
}
