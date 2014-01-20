package org.yinwang.yin.ast;

import org.yinwang.yin.Scope;
import org.yinwang.yin.value.Value;

import java.util.ArrayList;
import java.util.List;

public abstract class Node {
    public String file;
    public int start;
    public int end;
    public int line;
    public int col;


    protected Node(String file, int start, int end, int line, int col) {
        this.file = file;
        this.start = start;
        this.end = end;
        this.line = line;
        this.col = col;
    }


    public abstract Value interp(Scope s);


    public static Value interp(Node node, Scope s) {
        return node.interp(s);
    }


    public static List<Value> interpList(List<Node> nodes, Scope s) {
        List<Value> values = new ArrayList<>();
        for (Node n : nodes) {
            values.add(n.interp(s));
        }
        return values;
    }


    public String getFileLineCol() {
        return file + ":" + line + ":" + col;
    }


    public static String printList(List<? extends Node> nodes) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Node e : nodes) {
            if (!first) {
                sb.append(" ");
            }
            sb.append(e);
            first = false;
        }
        return sb.toString();
    }

}
