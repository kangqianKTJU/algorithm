# algorithm
<h1>algorithm matlab code</h1>
<h2>appoint</h2>
<pre>
% function [optim, val] =  appoint(C)
% 本函数利于intlinprog实现指派问题的求解n*n的指派问题
%   -optiom 最优解
%   -val 最优值
%   -C 费用矩阵

%  authour :kkq
%  time : 2018/9/1
%  email : 18902171131@189.cn
%  githup: kangqianKTJU
</pre>
</hr>
<h2>chaos</h2>
<pre>
%  迭代模型 x(i+1) = a*x(i)*(1-x(i))
%  本函数用于演示震荡模型，产生蛛网模型的效果
%  初值x0 -(0,1)
%  增长系数a
%  迭代次数generation
%  说明：a - (1,3)时：x0从(0,1)出发都收敛至相同的周期1点（不动点）
%        a - (3,sqrt(6)+1) 时：x0从任意初值出发在周期2点之间震荡
%        a - (sqrt(6)+1,3.54409035)时：x0从任意初值出发在周期4点之间震荡
%        a - (3.54409035,4)时：开始进入混沌状态，对初值极其敏感
%        a - 4 时：混沌显的十分明显
%  authour :kkq
%  time : 2018/9/1
%  email : 18902171131@189.cn
%  githup: kangqianKTJU
</pre>

