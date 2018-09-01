function [optim, val] =  appoint(C)
% function [optim, val] =  appoint(C)
% 本函数利于intlinprog实现指派问题的求解n*n的指派问题
%   -optiom 最优解
%   -val 最优值
%   -C 费用矩阵

n = length(C);
% 费用矩阵转化为向量形式
c = C(:);

%生成约束矩阵
Aeq = zeros(2*n,n*n);
for i=1:n
    Aeq(i,1+n*(i-1):n*i)=ones(1,n); % 行和为1的约束
    Aeq(1+n:2*n,1+n*(i-1):n*i) = eye(n,n); % 列和为1的约束
end
beq = ones(2*n,1);
lb = zeros(n*n,1);
ub = ones(n*n,1);

intcon = 1:n*n;
[optim, val] = intlinprog(c,intcon,[],[],Aeq,beq,lb,ub);
optim = reshape(optim,n,n);





