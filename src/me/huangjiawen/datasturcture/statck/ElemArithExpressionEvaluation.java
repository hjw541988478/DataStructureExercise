package me.huangjiawen.datasturcture.statck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import me.huangjiawen.datasturcture.list.List;
import me.huangjiawen.datasturcture.list.linked.LinkedList;
import me.huangjiawen.datasturcture.statck.sequential.SequentialStack;

public class ElemArithExpressionEvaluation {

	private boolean isPrior(String opX, String opY) {
		return opX.equals("*") || opX.equals("/") ? true : false;
	}

	private float realEvaluate(float elementEnd, float element, String op) {
		float result = 0;
		switch (op) {
		case "+":
			result = elementEnd + element;
			break;
		case "-":
			result = elementEnd - element;
			break;
		case "*":
			result = elementEnd * element;
			break;
		case "/":
			result = elementEnd * 1.0f / element;
			break;
		default:
			break;
		}
		return result;
	}

	private boolean isNumber(String numberStr) {
		try {
			Integer.parseInt(numberStr);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public List<String> convertToRPN(String[] commonExpres) {
		List<String> rpnExpressList = new LinkedList<String>();
		Stack<String> stack = new SequentialStack<String>();
		int index = 0;
		for (int i = 0; i < commonExpres.length; i++) {
			String currentChar = commonExpres[i];
			if (isNumber(currentChar)) {
				rpnExpressList.add(index++, currentChar);
			} else if (currentChar.equals(")")) {
				while (!"(".equals(stack.top())) {
					rpnExpressList.add(index++, stack.pop());
				}
				if (stack.top().equals("(")) {
					stack.pop();
				}
			} else {
				if (stack.size() != 0 && isPrior(stack.top(), currentChar)) {
					rpnExpressList.add(index++, stack.pop());
					rpnExpressList.add(index++, currentChar);
				} else {
					stack.push(currentChar);
				}
			}
		}
		while (stack.size() != 0) {
			rpnExpressList.add(index++, stack.pop());
		}
		return rpnExpressList;
	}

	public String evaluate(List<String> rpnExpressList) {
		int index = 0;
		Stack<String> stack = new SequentialStack<String>();
		for (index = 0; index < rpnExpressList.size(); index++) {
			String currentChar = rpnExpressList.get(index);
			if (isNumber(currentChar)) {
				stack.push(currentChar);
			} else {
				if (stack.size() >= 2) {
					String element = stack.pop();
					String elementEnd = stack.pop();
					stack.push(String.valueOf(
							realEvaluate(Float.parseFloat(elementEnd), Float.parseFloat(element), currentChar)));
				}
			}
		}
		return stack.top();
	}
}
