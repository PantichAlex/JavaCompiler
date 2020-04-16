package pantich.compiler.LexAnalayse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*Класс для удаления однострочных и многострочных комментариев.
*Является реализацией итерфейса IAnalizerComponent, которай служит для реализации цепочки от
 */
public class CommentDeleter implements IAnalyzerComponent {
    private IAnalyzerComponent nextComponent;
    private String result;
    @Override
    public void setNext(IAnalyzerComponent next) {
            nextComponent=next;
    }

    @Override
    public void handle(String inputChain) {
        Pattern oneLineCommentPattern=Pattern.compile("(\\/\\/.*\n)");
        Pattern manyLineCommentPattern=Pattern.compile("\\/\\*[\\W\\w]+\\*\\/");
        Matcher oneLineMatcher=oneLineCommentPattern.matcher(inputChain);
        String tmp=oneLineMatcher.replaceAll("");
        Matcher manyLineMatcher=manyLineCommentPattern.matcher(tmp);
        tmp=manyLineMatcher.replaceAll("");

        result=tmp;

    }

    @Override
    public String getResult() {

        if(nextComponent!=null){
            nextComponent.handle(result);
            return nextComponent.getResult();
        }
        return result;

    }
}
