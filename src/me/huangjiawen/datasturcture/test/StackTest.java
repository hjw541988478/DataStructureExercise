package me.huangjiawen.datasturcture.test;

import me.huangjiawen.datasturcture.list.List;
import me.huangjiawen.datasturcture.statck.ElemArithExpressionEvaluation;
import me.huangjiawen.datasturcture.statck.Stack;
import me.huangjiawen.datasturcture.statck.linked.LinkedStack;
import me.huangjiawen.datasturcture.statck.sequential.SequentialStack;

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
		StringBuffer buffer = new StringBuffer();
		String[] rawStrArry = { "20", "+", "(", "3", "-", "1", ")", "*", "22", "+", "10", "/", "2" };
		for (String rawStr : rawStrArry) {
			buffer.append(rawStr);
		}
		ElemArithExpressionEvaluation expEva = new ElemArithExpressionEvaluation();
		List<String> rpnStrList = expEva.convertToRPN(rawStrArry);
		rpnStrList.print();
		buffer.append("=").append(expEva.evaluate(rpnStrList));
		System.out.println(buffer.toString());
	}

}