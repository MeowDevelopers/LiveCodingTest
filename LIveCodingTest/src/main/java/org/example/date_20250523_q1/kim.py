'''
괄호 문자열이 주어졌을 때, 유효한 괄호인지 판별하세요.
예: "({[]})" → true, "({[})" → false

괄호 - brackets
'''

bracket_success_list = [
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
		"[{({[]})}]"
	]

bracket_fail_list = [
		"(",
		"({[})",
		"([)]",
		"{{{}",
		"[{)]}",
		"(()",
		"{([)]}",
		"}{",
		"[{({})]",
		"[({})]}}"
	]

def bracket_check(bracket):

    bracket_open = {')': '(',
                    '}': '{',
                    ']': '['}
    answer = []

    for item in bracket:
        if item in bracket_open.values():
            answer.append(item)

        else:
            # OPEN 괄호가 더이상 스택에 없는데, item이 아직 있을 때
            if len(answer) == 0 :
                return False

            # ClOSE 괄호와 스택의 마지막 값이 같을 때
            elif bracket_open[item] == answer[-1]:
                answer.pop()

    if len(answer) == 0:
        return True

    # 아직 스택이 다 비워지지 않았다면 False
    return False


for bracket in bracket_success_list:
    print(bracket_check(bracket))

for bracket in bracket_fail_list:
    print(bracket_check(bracket))

