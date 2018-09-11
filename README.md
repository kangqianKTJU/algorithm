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

</hr>
<h2>SA</h2>
<pre>
%% 双谷最优值——模拟退火算法
% 函数形式：f(x) = (x-2)*(x+3)*(x+8)*(x-9)
% 算法思想：模拟退火，顾名思义，模拟金属退火的过程
% 金属在加热到温度很高时，分子的能量很高，状态很乱，但是在每一个特定的温度
% 只要有足够的时间，它都会到达所在温度下能量最低的状态，这是系统的特性，可以
% 近似看成一个准静态过程。每个温度下经行多次迭代运算，如果能更新最优解，则将
% 解更新为最优解，否则一定的概率接受劣解，以逃出局部最优解。
initTemp = 1000;    % 初始温度
minTemp = 1;        % 温度下限
iterL = 1000;       % 等温下迭代次数
alpha = 0.95;       % 冷却系数
%  authour :kkq
%  time : 2018/9/1
%  email : 18902171131@189.cn
%  githup: kangqianKTJU
</pre>

