package words;

import javax.script.ScriptEngine;

import scripting.Python;

/**
 * Words example: Python implementation with map/filter/reduce.
 */
public class Words2 {
    public static void main(String[] args) {
        ScriptEngine engine = Python.makeScriptEngine();
        Python.runScriptFile(engine, "src/words/Words2.py");
        // Python.readEvalPrintLoop(engine);
    }
}
