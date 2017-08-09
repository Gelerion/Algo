package com.denis.shuvalov.complex.string_calculator;

import java.util.Objects;
import java.util.Stack;

public class DijkstraEvaluator {
	private Stack<String> ops = new Stack<>();
	private Stack<Double> vals = new Stack<>();

	public static void main(String[] args) {
		System.out.println(new DijkstraEvaluator().evaluate("( ( ( 13 + 25 ) * ( 18 / 2 ) ) + 15 )"));
	}

	double evaluate(String expression) {
		for (String item : expression.split("\\s")) {
			if (Objects.equals(item, "("))
				; // ignore
			else if (Objects.equals(item, "+"))
				ops.push(item);
			else if (Objects.equals(item, "-"))
				ops.push(item);
			else if (Objects.equals(item, "/"))
				ops.push(item);
			else if (Objects.equals(item, "*"))
				ops.push(item);
			else if (Objects.equals(item, "sqrt"))
				ops.push(item);
			else if (Objects.equals(item, ")")) {
				// evaluate last two
				String op = ops.pop();
				double val = vals.pop();

				if (Objects.equals(op, "+"))
					val = vals.pop() + val;
				else if (Objects.equals(op, "-"))
					val = vals.pop() - val;
				else if (Objects.equals(op, "/"))
					val = vals.pop() / val;
				else if (Objects.equals(op, "*"))
					val = vals.pop() * val;
				else if (Objects.equals(op, "sqrt"))
					val = Math.sqrt(val);

				vals.push(val);
			} else
				vals.push(Double.parseDouble(item)); // value
		}

		return vals.pop();
	}

}
