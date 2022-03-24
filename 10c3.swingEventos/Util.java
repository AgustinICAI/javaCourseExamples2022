import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Util {

    static String evaluateExpressionUsingJS(String foo){
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        try {
            return engine.eval(foo).toString();
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return "ERROR";
    }
    public static String evaluateExpressionUsingExternalLIB(String foo) {
        Expression expression = new ExpressionBuilder(foo).build();
        double result = expression.evaluate();
        return String.valueOf(result);
    }

}

