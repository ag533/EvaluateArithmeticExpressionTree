# EvaluateArithmeticExpressionTree
This repository holds the refactored code for the Arithmetic expression tree ask.

## Problem Statement :
Apply your knowledge of good software design principles to refactor and improve the design of this code. Feel free to change anything in the file as part of your refactoring, apart from the final assertions that consume the tree.

```
const assert = require("assert");

const Node = (operator, value, left, right) => {
  const result = function () {
    switch (this.operator) {
      case "+":
        return left.result() + right.result();
      case "-":
        return left.result() - right.result();
      case "x":
        return left.result() * right.result();
      case "÷":
        return left.result() / right.result();
      default:
        return value;
    }
  };

  const toString = function () {
    switch (this.operator) {
      case "+":
        return `(${left.toString()} + ${right.toString()})`;
      case "-":
        return `(${left.toString()} - ${right.toString()})`;
      case "x":
        return `(${left.toString()} x ${right.toString()})`;
      case "÷":
        return `(${left.toString()} ÷ ${right.toString()})`;
      default:
        return value.toString();
    }
  };

  return {
    operator,
    value,
    left,
    right,
    result,
    toString
  };
};

const tree = Node(
  "÷",
  null,
  Node(
    "+",
    null,
    Node("", 7, null, null),
    Node(
      "x",
      null,
      Node("-", null, Node("", 3, null, null), Node("", 2, null, null)),
      Node("", 5, null, null)
    )
  ),
  Node("", 6, null, null)
);

assert.strictEqual("((7 + ((3 - 2) x 5)) ÷ 6)", tree.toString());
assert.strictEqual(2, tree.result());
```

## Approach:
I will use Java in this task as JS is not strictly typed and I dont want to install TS in the repository to make my JS class strictly typed.


1. First of all I will create a class to handle structure of the tree rather than just calling a class with functions with no types. This will help us to do effecient error checks and type checks which will be helpful in case of wrong input or errored input. I have also added getter and setter function for retrieving and 
updating data of the variable.

2. Now I will try to create a function class to perfrom functions like evauate tree or print expression for the given tree.
```
Note I am creating spaerate classes so that they can be used independently in other class anad can be maintained and extended if necessary.
```
