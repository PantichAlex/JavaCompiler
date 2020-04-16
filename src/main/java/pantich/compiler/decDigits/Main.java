package pantich.compiler.decDigits;

public class Main {
    public static void main(String[] args) {
        String input="97354.72740172";
        DecGrammatic grammatic=new DecGrammatic(input);
        grammatic.parseNumber();
        System.out.println("Ввденное число: "+input);
        System.out.println("Результат: "+grammatic);
        System.out.println("Мантиса: "+grammatic.getMantis());
        System.out.println("Порядок: "+grammatic.getOrder());
    }
}
