// 괄호 문자열이 주어졌을 때, 유효한 괄호인지 판별하세요.
// 예: "({[]})" → true, "({[})" → false
// "(){}[]" -> true

function isNotInclude(arr, str) {
  if (
    (str === "}" && arr[arr.length - 1] === "{") ||
    (str === ")" && arr[arr.length - 1] === "(") ||
    (str === "]" && arr[arr.length - 1] === "[")
  ) {
    return true;
  }
  return false;
}

function solution(input) {
  const openCase = ["[", "{", "("];
  const arr = [];

  input.split("").forEach((str) => {
    if (openCase.includes(str)) {
      arr.push(str);
    } else {
      isNotInclude(arr, str) ? arr.pop() : arr.push(str);
    }
  });

  console.log(arr.length ? false : true);
}

const success = [
  "",
  "()",
  "[]",
  "{}",
  "({})",
  "{[()]}",
  "([]{})",
  "[({})]",
  "((({[]})))",
  "{([])}",
  "[{({[]})}]",
  "(){}[]",
];

const fail = [
  "(",
  "({[})",
  "([)]",
  "{{{}",
  "[{)]}",
  "(()",
  "{([)]}",
  "}{",
  "[{({})]",
  "[({})]}}",
];

success.forEach((input) => solution(input));
fail.forEach((input) => solution(input));
