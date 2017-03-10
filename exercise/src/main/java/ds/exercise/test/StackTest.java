package ds.exercise.test;

import ds.exercise.statck.ElemArithExpressionEvaluation;
import ds.exercise.statck.Stack;
import ds.exercise.statck.linked.LinkedStack;
import ds.exercise.statck.sequential.SequentialStack;

public class StackTest {

    public static void main(String[] args) {
        Stack<Integer> seqStack = new SequentialStack<Integer>();
        seqStack.push(1);
        seqStack.push(2);
        seqStack.push(3);
        seqStack.push(4);
        seqStack.push(5);
        seqStack.print();
        seqStack.pop();
        seqStack.push(8);
        seqStack.push(9);
        seqStack.print();
        System.out.println("--------------------------------");
        Stack<Integer> linkedStack = new LinkedStack<Integer>();
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);
        linkedStack.push(4);
        linkedStack.push(5);
        linkedStack.print();
        linkedStack.pop();
        linkedStack.push(8);
        linkedStack.push(9);
        linkedStack.print();
        System.out.println("---------------------------------");
        ElemArithExpressionEvaluation expEva = new ElemArithExpressionEvaluation();
        System.out.println(expEva.evaluate(
                expEva.convertToRPN(
                        expEva.sliceStringToArray("20+(3-1)*22+10/2"))));

        System.out.println(expEva.calculate("3-2+2"));
        System.out.println(expEva.calculate("(1+(4+5+2)-3)+(6+8)"));
    }

}
