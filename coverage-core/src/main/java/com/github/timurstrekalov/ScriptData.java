package com.github.timurstrekalov;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Set;

class ScriptData {

    private final String sourceName;
    private final String sourceCode;

    private final Map<Integer, Integer> statementsWithLengths = Maps.newTreeMap();

    ScriptData(final String sourceName, final String sourceCode) {
        this.sourceName = sourceName;
        this.sourceCode = sourceCode;
    }

    public void addExecutableLine(final Integer lineNr, final Integer length) {
        statementsWithLengths.put(lineNr, length);
    }

    public String getSourceName() {
        return sourceName;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public Set<Integer> getLineNumbersOfAllStatements() {
        return statementsWithLengths.keySet();
    }

    public int getNumberOfStatements() {
        return statementsWithLengths.size();
    }

    public boolean hasStatement(final int lineNr) {
        return statementsWithLengths.containsKey(lineNr);
    }

    public Integer getStatementLength(final int lineNr) {
        return statementsWithLengths.get(lineNr);
    }

    public Integer getLineNumberOfFirstStatement() {
        return getLineNumbersOfAllStatements().iterator().next();
    }
}
